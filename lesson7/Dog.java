package lesson7;


public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void voice(Cat cat){
        System.out.println(name+" gav- gav ==> "+ cat.getName());
        cat.fear(this);
    }

    public String getName() {
        return name;
    }
}