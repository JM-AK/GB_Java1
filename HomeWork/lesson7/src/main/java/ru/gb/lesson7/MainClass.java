package ru.gb.lesson7;

/*
Рекомендуемое ДЗ:
1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго в новый файл.
3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
4. ** Написать метод, проверяющий, есть ли указанное слово в файлах в папке
5. *** Написать метод, добавляющий, указанное слово в файлы в папке
 */

import java.io.File;
import java.io.FilenameFilter;

public class MainClass {

    public static void main(String[] args) {

//      [---Ввод данных для проверки методов---]
        String dirPath = "C:\\Users\\komle\\Рабочий стол\\test for java\\";
        String t1 = "text_1.txt";
        String t2 = "text_2.txt";
        String t3 = "text_3.txt";
//      [---Проверка методов---]
        concatTwoFilesToNew (dirPath, t1, t2, t3);
        System.out.println(isFileContainWord(dirPath, t1, "Dollar"));
        System.out.println(isDirContainWord(dirPath, "Dollar"));
        addWordToFiles(dirPath, "Dollar");

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

    public static String[] dirFileList (String dirPath) {
        File files = new File(dirPath);
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File files, String name) {
                return name.endsWith("txt");
            }
        };
        return files.list(filter);
    }

    public static boolean isDirContainWord (String dirPath, String word){
        String [] arrS = dirFileList(dirPath);
        for (int i = 0; i < arrS.length; i ++){
            if(isFileContainWord(dirPath, arrS[i], word)) return true;
        }
        return false;
    }

    public static void addWordToFiles(String dirPath, String word){
        String [] arrS = dirFileList(dirPath);
        for (int i = 0; i < arrS.length; i ++){
            TxtFileClass t = new TxtFileClass(dirPath, arrS[i]);
            t.addTextToFile(word);
        }
    }

}
