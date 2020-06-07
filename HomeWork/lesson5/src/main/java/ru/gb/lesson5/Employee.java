package ru.gb.lesson5;


//1. Создать класс "Сотрудник" с полями:
// ФИО, должность, email, телефон, зарплата, возраст.
//2. Конструктор класса должен заполнять эти поля при создании объекта.
//3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
//4. Создать массив из 5 сотрудников.
//5. *С помощью цикла вывести информацию только о сотрудниках старше 40 лет.


import java.util.ArrayList;

public class Employee {

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;


    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public static void getInfoEmployee (Employee employee){
        System.out.printf("ФИО: %s \n Должность: %s \n email: %s \n Телефон: %s \n Зарплата: $ %s \n Возраст: %s лет",
                employee.getName(), employee.getPosition(), employee.getEmail(), employee.getPhone(), employee.getSalary(), employee.getAge());
    }

    public static void main(String[] args) {
        Employee[] staffArr = new Employee[5];

        staffArr[0] = new Employee("Igor", "CEO", "ceo@gb.com", "001", 30000, 41);
        staffArr[1] = new Employee("Ivan", "CTO", "cto@gb.com", "002", 20000, 35);
        staffArr[2] = new Employee("Helen", "CFO", "cfo@gb.com", "003", 20000, 35);
        staffArr[3] = new Employee("Jerry", "Chief Accountant", "chiefAcc@gb.com", "004", 15000, 25);
        staffArr[4] = new Employee("Basil", "Secretary", "basil@gb.com", "005", 10000, 50);

        for (Employee e : staffArr ){
            if (e.getAge() > 40){
                getInfoEmployee(e);
                System.out.println();
                System.out.println("-----------");
            }
        }

    }




}
