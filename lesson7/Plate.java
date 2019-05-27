package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
    public void decreaseFood(int amount) {
        food -= amount;
    }

    public void increaseFood (int amount) {
        food+=amount;
        System.out.println("В тарелку добавлено "+amount+" единиц еды");
    }
}