package ru.gb.lesson6;

class Dog extends Animal {

    private static final int MAX_RUN = 500;
    private static final double MAX_JUMP = 0.4d;
    private static final int MAX_SWIM = 10;

    private static int count;

    private int maxRun;
    private double maxJump;
    private int maxSwim;

    public Dog (String name, int maxRun, double maxJump, int maxSwim) {
        super(name);
        this.maxRun = (maxRun > MAX_RUN)? MAX_RUN : maxRun ;
        this.maxJump = (maxJump > MAX_JUMP)? MAX_JUMP : maxJump;
        this.maxSwim = (maxSwim > MAX_SWIM)? MAX_SWIM : maxSwim;
        count++;
    }

    public static int getCount() {
        return count;
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

    @Override
    public void run(int len) {
        if (len <= maxRun) System.out.println(name + " пробежал!");
        else System.out.println(name + " не пробежит! Предел: " + getMaxRun());
    }

    @Override
    public void swim(int len) {
        if (len <= maxSwim) System.out.println(name + " проплыл!");
        else System.out.println(name + " не проплывет! Предел: " + getMaxSwim());
    }

    @Override
    public void jump(double height) {
        if (height <= maxJump) System.out.println(name + " взял высоту!");
        else System.out.println(name + " не прыгнет! Предел: " + getMaxJump());
    }
}