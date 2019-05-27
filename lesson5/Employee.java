package lesson5;

public class Employee {
    String name;
    String email;
    String position;
    String phone;
    int salary;
    int age;

    public Employee(String name, String email, String position, String phone, int salary, int age) {
        this.name = name;
        this.email = email;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info (){
        System.out.println("Employee "+name+" "+age +" " +email+" "+position+" "+phone+" "+salary);
    }

}
