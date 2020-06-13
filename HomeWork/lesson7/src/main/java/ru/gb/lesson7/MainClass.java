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

        String dirPath = "C:\\Users\\komle\\Рабочий стол\\test for java\\";
        concatTwoFilesToNew (dirPath, "text_1.txt", "text_2.txt", "text_3.txt");

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

}
