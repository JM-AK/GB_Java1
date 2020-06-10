package ru.gb.lesson6;

class Bird extends Animal {

    private static final int MAX_RUN = 5;
    private static final double MAX_JUMP = 0.1d;

    private static int count;

    private int maxRun;

    private double maxJump;

    public Bird(String name, int maxRun, double maxJump) {
        super(name);
        this.maxRun = (maxRun > MAX_RUN)? MAX_RUN : maxRun ;
        this.maxJump = (maxJump > MAX_JUMP)? MAX_JUMP : maxJump;
        count++;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public double getMaxJump() {
        return maxJump;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(int len) {
        if (len <= maxRun) System.out.println(name + " пробежал!");
        else System.out.println(name + " не пробежит! Предел: " + getMaxRun());
    }

    @Override
    public void swim(int len) {
        System.out.println("Птицы не умеют плавать!");
    }

    @Override
    public void jump(double height) {
        if (height <= maxJump) System.out.println(name + " взял высоту!");
        else System.out.println(name + " не прыгнет! Предел: " + getMaxJump());
    }
}
