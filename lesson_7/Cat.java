package lesson_7;

public class Cat {

    public String getName() {
        return name;
    }

    private String name;
    private int appetite;

    public boolean isSatiety() {
        return satiety;
    }

    private boolean satiety;

    public Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate plate) {
        if(plate.getFood() >= appetite)
            satiety = true;
        plate.decreaseFood(appetite);
    }
}

class Plate {
    public int getFood() {
        return food;
    }

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int minus) {
        if (food - minus >= 0) {
            food -= minus;
        } else
            System.out.println("There is not enough food in this plate.");
    }
    public void increaseFood(int anotherFood){
        food += anotherFood;
    }

    public void info() {
        System.out.println("Plate: " + food);
    }
}