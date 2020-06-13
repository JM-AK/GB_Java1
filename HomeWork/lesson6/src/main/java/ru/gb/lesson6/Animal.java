package ru.gb.lesson6;

//2. Животные могут выполнять действия: бежать, плыть и прыгать.
//   В качестве параметра каждому методу передается величина, обозначающая или длину (для бега и плавания), или высоту (для прыжков)


public abstract class Animal {

    private String name;
    private int maxRun;
    private double maxJump;
    private int maxSwim;

    public Animal(String name, int maxRun, double maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public Animal(String name, int maxRun, double maxJump, int maxSwim) {
        this (name, maxRun, maxJump);
        this.maxSwim = maxSwim;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public double getMaxJump() {
        return maxJump;
    }

    public int getMaxSwim() {
        return maxSwim;
    }

    public boolean isRun(int len){
        return maxRun >= len;
    };
    public boolean isSwim(int len){
        return maxSwim >= len;
    };
    public boolean isJump(double height){
        return maxJump >= height;
    };


}
