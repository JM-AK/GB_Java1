package ru.gb.lev1.lesson2;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(switchArrZeroToOne(new int[] {1,1,0,0,1,0,1,1,0,0})));
        System.out.println(Arrays.toString(createCopyArray(new int[] {0,3,6,9,12,15,18,21}, 8)));
        System.out.println(Arrays.toString(doubleArrLessSix(new int[] {1,5,3,2,11,4,5,2,4,8,9,1})));
        System.out.println(Arrays.deepToString(createUnitMatrix(4)));
        findMinMaxOfArray(new int[]{1,2,3,4,5,6,7,8,});
        System.out.println(checkBalanceOfArr(new int[] {2,2,1,2, 2, 9, 0}));
        System.out.println(Arrays.toString(offsetArrayWithCopyArr(new int[] {1,2,3,4,5}, -2)));
        System.out.println(Arrays.toString(offsetArrayHard(new int[] {1,2,3,4,5}, -2)));

    }

    /*1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
      С помощью цикла и условия заменить 0 на 1, 1 на 0;
       */
    public static int[] switchArrZeroToOne(int[] array){
        for(int i =0; i<array.length; i++){
            array[i] = (array[i]==1)? 0 : 1;
        }
        return array;
    }

    /*2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    public static int[] createCopyArray(int[] array, int n){
        int[] copyArr = new int [n];
        for (int i=0; i<copyArr.length; i++){
            copyArr[i] = array[i];
        }
        return copyArr;
    }

    /*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static int[] doubleArrLessSix(int[] array){
        for (int i=0; i < array.length; i++) array[i] = (array[i]<6)? array[i]*2 : array[i];
        return array;
    }

    /*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    */
    public static int[][] createUnitMatrix (int n){
        int [][] matrix = new int [n][n];
        for (int i=0; i<n; i++) matrix[i][i] = 1;
        return matrix;
    }

    /*5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */
    public static void findMinMaxOfArray (int[] array){
        int min = array[0];
        int max = array[0];

        for (int i=1; i<array.length; i++){
            if (min<array[i]) min = array[i];
            if (array[i]<max) max = array[i];
        }
        System.out.println("Max: " + max + " Min: "+ min);
    }

    /*6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны. П
    римеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    граница показана символами ||, эти символы в массив не входят.
     */
    public static boolean checkBalanceOfArr (int[] array) {
        boolean check = false;
        int left=0;
        for (int i=0; i<array.length-1;i++){
            left+=array[i];
            int right=0;
            for(int j = array.length-1;j-i>0;j--) right+=array[j];
            if(left==right) check =  true;
        }
        return check;
    }

    /*7. **** Написать метод, которому на вход подается одномерный массив и число n
    (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
    Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    public static int[] offsetArrayWithCopyArr(int[] array, int n){
        n = n % array.length;
        n = (n>0)? n: n+array.length;

        int [] copyArr = Arrays.copyOf(array,array.length );

        for (int i=0; i<array.length; i++) {
            if(i+n > array.length-1){
                array[(i+n) % array.length] = copyArr[i];
            } else array[i+n] = copyArr[i];

        }

        return array;
    }

    public static int[] offsetArrayHard(int[] array, int n){
        n = n % array.length;
        n = (n>0)? n: n+array.length;

        int val0 = array[0], val1;
        int num0 = 0, num1;
        int count=0;

        while (count<array.length){
            num1 = (num0+n > array.length-1)? (num0+n) % array.length : num0 + n;
            val1 = array[num1];

            array[num1] = val0;

            num0 = num1;
            val0 = val1;

            count++;
        }

        return array;
    }



}
