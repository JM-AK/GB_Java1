package ru.gb.lesson7;

/*
Рекомендуемое ДЗ:
1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго в новый файл.
3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
4. ** Написать метод, проверяющий, есть ли указанное слово в файлах в папке
5. *** Написать метод, добавляющий, указанное слово в файлы в папке
 */


public class MainClass {

    public static void main(String[] args) {

//      [---Ввод данных для проверки методов---]
        String dirPath = "C:\\Users\\komle\\Рабочий стол\\test for java\\";
        String t1 = "text_1.txt";
        String t2 = "text_2.txt";
        String t3 = "text_3.txt";
//      [---Проверка методов---]
        concatTwoFilesToNew (dirPath, t1, t2, t3);
        System.out.println(isFileContainWord(dirPath, "text_1.txt", "Dollar"));


    }

    public static void concatTwoFilesToNew (String dirPath, String firstFile, String secondFile, String outFileName){
        TxtFileClass t1 = new TxtFileClass(dirPath, firstFile);
        TxtFileClass t2 = new TxtFileClass(dirPath, secondFile);
        TxtFileClass t3 = new TxtFileClass(dirPath, outFileName);

        if (t3.getTextFromFile().length() > 0) {
            System.out.println("File \"" + outFileName + "\" exists, choose another name ");
        } else {
            t3.addTextToFile(t1.getTextFromFile());
            t3.addTextToFile(t2.getTextFromFile());
            System.out.println("Files were concatenated");
        }

    }

    public static boolean isFileContainWord (String dirPath, String fileName, String word){
        TxtFileClass t = new TxtFileClass(dirPath, fileName);
        return t.isContainWord(word);
    }

}
