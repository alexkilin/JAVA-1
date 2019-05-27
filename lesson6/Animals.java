package lesson6;

public class Animals {
    String name;
    int run_limit;
    double jump_limit;
    int swim_limit;
    public Animals() {
    }

    public Animals (String name, int run_limit, double jump_limit, int swim_limit) {
        this.name=name;
        this.run_limit=run_limit;
        this.jump_limit=jump_limit;
        this.swim_limit=swim_limit;
    }
    public void info() {
        System.out.println(name+ " "+" run_limit " + run_limit +" jump_limit "+jump_limit +" swim_limit " +swim_limit);
    }
    public void run (int distance) {
            System.out.println("run "+distance+" "+((run_limit)>=(distance)));
        }
    public void jump (double distance) {
        System.out.println("jump "+distance+" "+((jump_limit)>=(distance)));
    }
    public void swim (int distance) {
        System.out.println("swim "+distance+" "+((swim_limit)>=(distance)));
    }
}
