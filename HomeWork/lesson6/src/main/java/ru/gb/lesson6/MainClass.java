package ru.gb.lesson6;

/*
 + 1. Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
 + 2. Животные могут выполнять действия: бежать, плыть и прыгать.
 + В качестве параметра каждому методу передается величина, обозначающая или длину (для бега и плавания), или высоту (для прыжков)
 3. У каждого животного есть ограничения на действия:
    бег: кот = 200 м., собака = 500 м., лошадь = 1500 м, птица = 5 м;
    плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.
    прыжок: кот = 2 м., собака 0.4 м., лошадь 3 м., птица 0.1 м.
 4. При попытке выполнить одно из действий, оно должно сообщить результат: смогло или нет животное выполнить действие,
    например, dog.run(150); -> результат 'Пес пробежал!';
 5. * Добавить подсчет созданных котов, собак и животных.
 6. * Добавить животным разброс в ограничениях. То есть у одной собаки может быть ограничение на бег 400 м., у другой 600 м..
*/

public class MainClass {

    public static void main(String[] args) {
        Bird bird1 = new Bird("B1", 5, 0.1d);
        Cat cat1 = new Cat("C1", 5, 1d);
        Dog dog1 = new Dog("D1", 7, 1d, 3);
        Horse horse1 = new Horse("H1", 100, 10d, 40);

        checkRun(cat1, 3);
        checkJump(cat1, 3);
        checkSwim(cat1, 3);


    }

    public static void checkRun (Animal animal, int len){
        if (animal.isRun(len)) {
            System.out.println(animal.getClass().getSimpleName() + " пробежал");
        } else {
            System.out.println(animal.getClass().getSimpleName() + " не смог пробежать");
        }
    }
    public static void checkJump (Animal animal, double height){
        if (animal.isJump(height)) {
            System.out.println(animal.getClass().getSimpleName() + " прыгнул");
        } else {
            System.out.println(animal.getClass().getSimpleName() + " не смог прыгнуть");
        }
    }
    public static void checkSwim (Animal animal, int len) {
        if (animal.getMaxSwim() == 0) {
            System.out.println(animal.getClass().getSimpleName() + " не умеет плавать");
        } else {
            if (animal.isJump(len)) {
                System.out.println(animal.getClass().getSimpleName() + " проплыл");
            } else {
                System.out.println(animal.getClass().getSimpleName() + " не смог проплыть");
            }
        }
    }


}
