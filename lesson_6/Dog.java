package lesson_6;
import java.util.Random;

public class Dog extends Animals{
    Random random = new Random();
    //у разных собак будут разные возможности по бегу от 400 до 600
    @Override
    public void run (int length) {
        int amount = random.nextInt(600 - 400 + 1) + 400;
        System.out.println("Dog can run " + amount);
        if (length <= amount)
            System.out.println("run: true");
        else
            System.out.println("run: false");
    }
    @Override
    public void swim(int length) {
        if (length <= 10)
            System.out.println("swim: true");
        else
            System.out.println("swim: false");
    }
    @Override
    public void jump (float height) {
        if (height <= 0.5f)
            System.out.println("jump: true");
        else
            System.out.println("jump: false");
    }
}