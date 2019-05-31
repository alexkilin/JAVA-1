package lesson6;

public class Cat extends Animals {


    public Cat() {
    }

    public Cat(String name, int run_limit, double jump_limit, int swim_limit) {
        super(name, run_limit, jump_limit, swim_limit);
        this.name=name;
        this.run_limit=run_limit;
        this.jump_limit=jump_limit;
        this.swim_limit=swim_limit;
    }
}
