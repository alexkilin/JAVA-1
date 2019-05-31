package lesson5;

public class Main {

    public static void main(String[] args) {
        Employee[] EmployeeAr =new Employee [5];
        EmployeeAr[0]= new Employee("Ivanov Ivan Ivanovich","ivanov@mail.ru","middle engineer",
                "+77777777",100000,33);
        EmployeeAr[1]= new Employee("Petrov Petr Petrovich","petrov@mail.ru","middle engineer",
                "+77777777",100000,43);
        EmployeeAr[2]= new Employee("Sidorov Sidr Sidorovich","sidorov@mail.ru","senior engineer",
                "+77777777",100000,41);
        EmployeeAr[3]= new Employee("Osin Oleg Anatolievich","osin@mail.ru","senior engineer",
                "+77777777",100000,53);
        EmployeeAr[4]= new Employee("Makarov Mark Stepanovich","makarov@mail.ru","junior engineer",
                "+77777777",100000,23);
        for (int i=0; i< 5;i++) {
            if (EmployeeAr[i].age > 40) EmployeeAr[i].info();
        }

    }
}
