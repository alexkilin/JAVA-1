package lesson6;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Murzik", 200, 2.0, 0);
        Cat cat2=new Cat("Vasiliy", 180,1.7,0);
        Dog dog1 = new Dog ("Sharik", 500,0.5,10 );
        Dog dog2=new Dog("Bobik",400,0.4,9);

        cat1.info();
        cat1.jump(1.9);
        cat2.info();
        cat2.run(190);
        dog1.info();
        dog1.swim(11);
        dog2.info();
        dog1.jump(0.3);

    }
}
