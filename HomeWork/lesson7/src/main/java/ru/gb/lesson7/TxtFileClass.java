package ru.gb.lesson7;

/*
* Класс для создания и редактирования txt файлов
*
* */

import java.io.*;

class TxtFileClass {

    private final String dirPath;
    private final String fileName;
    private final String absolutePath;


    public TxtFileClass(String dirPath, String fileName){
        this.dirPath = dirPath;
        this.fileName = fileName;
        this.absolutePath = dirPath + fileName;
        createTxtFile(dirPath, fileName);
    }

    public String getDirPath() {
        return dirPath;
    }
    public String getFileName() {
        return fileName;
    }
    public String getAbsolutePath() {
        return absolutePath;
    }

    //метод создает путой txt файл
    private static void createTxtFile (String dirPath, String fileName){
        String absoluteFilePath = dirPath + fileName;
        File file = new File(absoluteFilePath);
        try {
            if (file.createNewFile()) System.out.println("File was created");
            else System.out.println("File \"" + fileName + "\" wasn't created. File exists");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    //метод извлекает текст из файла по абсолютной ссылке
    public String getTextFromFile (){
        StringBuilder sOut = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(absolutePath));
            String s;

            while((s = reader.readLine()) != null){
                sOut.append(s);
                sOut.append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sOut.toString();
    }

    //метод перезаписывает текст в файл по абсолютной ссылке
    public void writeTextToFile (String text){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(absolutePath));

            writer.write(text);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTextToFile (String text){
        StringBuilder strB = new StringBuilder();
        strB.append(getTextFromFile());
        strB.append(text);
        writeTextToFile(strB.toString());
    }

    public boolean isContainWord (String word){
        String s = getTextFromFile();
        int index = s.lastIndexOf(word);
        return index != -1;
    }

}
