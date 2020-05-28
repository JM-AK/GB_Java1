package ru.gb.l1;

public class MainClass {
    public static void main(String[] args) {
        System.out.println(task3(1.2f,2.0f,3.2f,4.0f));
        System.out.println(task4(5,10));
        task5(-5);
        System.out.println(task6(-4));
        task7("Alex");
        task8TypeOfYear(1605);

    }

    public static float task3(float a, float b, float c, float d){
        return a * (b + (c/d));
    }

    public static boolean task4(int a, int b){
        int sum = a +b;
        return (sum>=10 && sum<=20);
    }

    public static void task5(int a){
        if (a<0) System.out.println("Число отрицательное");
        else System.out.println("Числов >=0");
    }

    public static boolean task6(int a){
        boolean b = a<0;
        return b;
    }

    public static void task7(String name){
        System.out.println("Привет, " + name + "!" );
    }

    public static void task8TypeOfYear(int year){
        boolean a = false;
        if ((year % 400) == 0) a = true;
        else if ((year % 100) == 0) a = false;
        else if ((year % 4) == 0) a = true;
        System.out.println(year + " это високосный год:"+ a);
    }



}
