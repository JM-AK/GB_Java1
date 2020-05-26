package ru.gb.l1;

public class MainClass {
    public static void main(String[] args) {
        System.out.println(task3());
        System.out.println(task4(5,10));
        task5(-5);
        System.out.println(task6(-4));
        task7("Alex");
        task8TypeOfYear(1605);

    }

    public static float task3(){
        float a = 1.1f, b =2.2f, c = 3.3f, d = 4.4f;
        float result = a * (b + (c/d));
        return result;
    }

    public static boolean task4(int a, int b){
        int sum = a +b;
        boolean check = (sum>=10 && sum<=20);
        return check;
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
