package lesson7;

public class Main {
    public static void main(String[] args) {
        Cat[] cat=new Cat [5];
        cat[0]= new Cat("Murzik");
        cat[1]= new Cat ("Belka");
        cat[2]= new Cat ("Boy");
        cat[3]= new Cat ("Buka");
        cat[4]= new Cat ("Velikan");

        Plate plate = new Plate(100);
        System.out.println(plate);
        plate.increaseFood(50);
        System.out.println(plate);
        for (int i=0; i<5;i++) {
          cat[i].eat(plate,40);
        }
        for (int i=0; i<5;i++) {
            System.out.println(cat[i].getName()+ " успешно поел и сыт --->" + cat[i].getfeelingFull());
        }

//        Cat cat = new Cat("Murzik", false);





       // plate.increaseFood(50);
       // System.out.println(plate);
       // cat.eat(plate,110);
       // System.out.println(cat.getName()+ " успешно поел и сыт --->" + cat.getfeelingFull());
       // System.out.println(plate);
       // cat.eat(plate,20);
       // System.out.println(plate);
       // System.out.println(cat.getName()+ " успешно поел и сыт --->" + cat.getfeelingFull());

      //  Dog dog = new Dog("Tuzik");
      //  dog.voice(cat);

     //   Dog dog1 = new Dog("Vulkan");
     //   dog1.voice(cat);
    }
}

