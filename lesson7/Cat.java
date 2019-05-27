package lesson7;

public class Cat {
    private String name;
    private boolean feelingFull;

    public Cat(String name) {
        this.name = name;
        this.feelingFull = false;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate, int portion) {
        if (plate.getFood() >= portion) {
            plate.decreaseFood(portion);
            System.out.println(name + " eat...");
            feelingFull = true;
        } else
            System.out.println(name + " Can't eat " + portion + " from this plate...");
    }

  //  public void fear(Dog dog) {
  //      System.out.println(name + " fear..." + dog.getName());
  //  }

    public boolean getfeelingFull()
    {
    return feelingFull;
    }
}