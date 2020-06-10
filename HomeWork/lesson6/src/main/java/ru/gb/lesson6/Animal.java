package ru.gb.lesson6;

//2. Животные могут выполнять действия: бежать, плыть и прыгать.
//   В качестве параметра каждому методу передается величина, обозначающая или длину (для бега и плавания), или высоту (для прыжков)


public abstract class Animal {

    private static int count;

    public String name;

    public Animal(String name) {
        this.name = name;
        count++;
    }
    public abstract void run(int len);
    public abstract void swim(int len);
    public abstract void jump(double height);

    public static int getCount() {
        return count;
    }
}
