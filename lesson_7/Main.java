package lesson_7;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 15);
        Plate plate = new Plate(14);
        plate.info();
        cat.eat(plate);
        System.out.println(cat.isSatiety());
        plate.info();
        Cat[] catsArray = {new Cat("Goscha", 13), new Cat("Snezok", 25),
        new Cat("Barsik", 25)};
        Plate newPlate = new Plate(55);
        newPlate.increaseFood(15);
        for (Cat value : catsArray) {
            value.eat(newPlate);
            System.out.println(value.isSatiety());
        }
        newPlate.info();
        newPlate.increaseFood(15);
        newPlate.info();
    }
}
