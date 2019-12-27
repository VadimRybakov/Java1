package lesson_6;

public class LessonSix {
    public static void main(String[] args) {
        //создаем животное и проверяем его способности
        Animals animal = new Animals();
        animal.run(400);
        animal.swim(20);
        animal.jump(1.5f);
        //создаем кота и проверяем его способности
        Cat cat = new Cat();
        cat.run(200);
        cat.swim(2);
        cat.jump(1.3f);
        //создаем собаку и проверяем ее способности
        Dog dog = new Dog();
        dog.run(450);
        dog.swim(20);
        dog.jump(2.3f);
        //Создаем еще одну собаку и сравниваем ее бег с первой
        Dog anotherDog = new Dog();
        dog.run(500);
        anotherDog.run(500);
    }
}
