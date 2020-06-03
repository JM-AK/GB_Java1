package ru.gb.l3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class TicTaeToe {

    // Заведение констант на допустимый ввод
    // Какими символами (фигками) играет игрок
    private static final char DOT_HUMAN = 'X';
    // Что вводит компьютер
    private static final char DOT_AI = 'O';
    // Символ пустой клетка
    private static final char DOT_EMPTY = ' ';
    // Условие выигрыша
    private static final int WINNERSIZE = 4;
    // Упрощения вместо использования field.length
    private static int fieldSizeX;
    private static int fieldSizeY;

    // Игровое поля
    private static char[][] field;

    // Для записи статуса игры. Массивы с количеством проставленных полей игроками Y+X+d1+d2
    private static int[] userCount;
    private static int[] aiCount;
    // Для записис последнего хода игрока;
    private static int userLastX, userLastY;

    // Для ввода
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    //main
    public static void main(String[] args) {
        int fieldSize = 5;

        while (true) {
            init(fieldSize);
            printField();
            playOnce(WINNERSIZE);
            System.out.println("Играть сначала? Для выхода из игры укажите - no");
            if (SCANNER.next().equals("no")) {
                break;
            }
        }
    }

    //Партия
    private static void playOnce(int fieldSize) {
        while (true) {
            humanTurn(field);
            printField();
            if (IsWinnerExistsPerCycle (field, DOT_HUMAN, fieldSize)) {
                System.out.println("Победил Игрок! Выигрышный ход Х: "+(userLastX+1) + " Y: "+(userLastY+1) );
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }

            aiTurn(field);
            printField();
            if (IsWinnerExistsPerCycle (field, DOT_AI, fieldSize)) {
                System.out.println("Победил Компьютер!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }

        }
    }

    //initField
    private static void init(int fieldSize) {
        fieldSizeX = fieldSize;
        fieldSizeY = fieldSize;

        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    //printField
    private static void printField() {
        System.out.println("=============");

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print("| ");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + " | ");
            }
            System.out.println();
        }
    }

    //isValidField
    // Проврека, что координаты находятся в допустимом диапазоне
    private static boolean isValidField(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    //isNotEmptyField
    // Проврека, что поле занято (знак в поле не соответствует DOT_EMPTY);
    private static boolean isNotEmptyField(char[][] field, int x, int y) {
        return field[y][x] != DOT_EMPTY;
    }

    //humanTurn
    // Проврека, что поле занято (знак в поле не соответствует DOT_EMPTY);
    private static void humanTurn(char [][] field) {
        // 3 1
        int x;
        int y;
        do {
            System.out.print("Введите координаты хода X и Y (от 1 до " + fieldSizeY + ") через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidField(x, y) || isNotEmptyField(field, x, y));
        field[y][x] = DOT_HUMAN;
        userLastX = x;
        userLastY = y;
    }

    //aiTurn
    private static void aiTurn(char [][] field) {
        int x;
        int y;
        if(defenciveXY(field)[2] == 1){
            x = defenciveXY(field)[0];
            y = defenciveXY(field)[1];
        } else {
            do {
                x = RANDOM.nextInt(fieldSizeX);
                y = RANDOM.nextInt(fieldSizeY);
            } while (isNotEmptyField(field, x, y));
        }

        field[y][x] = DOT_AI;
    }

    //isDraw
    private static boolean isDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    //checkWin
        // Альтернативный способ через цикл
    private static boolean IsWinnerExistsPerCycle (char[][] map, char s, int size){
        for (int y = 0; y < fieldSizeY-size+1; y++) {
            for (int x = 0; x < fieldSizeX-size+1; x++){
                if(checkDiagonals(map, s, size, y, x) || checkLines(map, s, size, y, x)) return true;
            }
        }
        return false;
    }
        // вспомогательный цикл для диагоналей
    private static boolean checkDiagonals (char[][] map, char s, int size, int offsetY, int offsetX){
        boolean toright=true, toleft = true;
        for (int i = 0; i < size ; i++) {
            toright = toright && (map[i+offsetY][i+offsetX] == s);
            toleft = toleft && (map[size-i-1+offsetY][i+offsetX] == s);
        }
        return toright || toleft;
    }
        // вспомогательный цикл для вертикалей и горизонталей
    private static boolean checkLines (char[][] map, char s, int size, int offsetY, int offsetX){
        boolean columns, rows;
        for (int x = offsetX; x < size + offsetX; x++) {
            columns = true;
            rows = true;
            for (int y = offsetY; y < size + offsetY; y++){
                columns = columns && (map[x][y] == s);
                rows = rows && (map[y][x] == s);
            }
            if (columns || rows) return true;
        }
        return false;
    }

    //Логика хода компьютера
    //Вариант №1 (Итерации). Смоделировать будущий ход игрока на копии прогнав по пустым клеткам
    //Если приводит какой-нибудь к выигрышу игрока, то запомнить ход и поставить туда
    private static int[] defenciveXY(char[][] field){
        int[] result = new int [3]; //0 - X, 1 - Y, 2 - есть выигрыш или нет
        char[][] copyField = new char[fieldSizeY][fieldSizeX];
//        System.arraycopy(field,0,copyField,0,fieldSizeX); // не сработало копирование
        copyOfCharArray(field, copyField);



        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(copyField[y][x] == DOT_EMPTY) {
                    copyField[y][x] = DOT_HUMAN;
                    if(IsWinnerExistsPerCycle(copyField,DOT_HUMAN , WINNERSIZE)){
                        result[0] = x;
                        result[1] = y;
                        result[2] = 1;
                        return result;
                    }
                    copyField[y][x] = DOT_EMPTY;
                }
            }
        }
        return result;
    }

    private static void copyOfCharArray(char[][] source, char[][] result){
        for (int y = 0; y < source.length; y++){
            for (int x =0; x < source.length; x++){
                result[y][x] = source[y][x];
            }
        }

    }

    //Вариант №2 (Анализ поля). В счетчик игрока искать квадрат с максимальным числом полей игрока
    // и ставить в любой из минимальных.


    // запись счета (для стратегии ИИ)
//    private static void updateCount(){
//
//        for (int i = 0; i < fieldSizeY; i++){
//
//            for (int j = 0; j < fieldSizeX; j++){
//
//
//
//            }
//
//
//        }
//
//
//    }


}
