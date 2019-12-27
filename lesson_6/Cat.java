package lesson_6;

public class Cat extends Animals{
    @Override
    public void run (int length) {
        if (length <= 200)
            System.out.println("run: true");
        else
            System.out.println("run: false");
    }
    @Override
    public void swim(int length) {
        System.out.println("cat cannot swim");
    }
    @Override
    public void jump (float height) {
        if (height <= 2f)
            System.out.println("jump: true");
        else
            System.out.println("jump: false");
    }
}