package com.company;

public class Main {

    public static void main(String[] args) { //ex.1

        // ex.2

        byte by = 1;
        short s = 1;
        int i = 1;
        long l = 1234567891011L;
        float f = 1.1234f;
        double dou = 1.123456789;
        char ch = 'C';
        boolean bo = true;
        System.out.println(myM1(5,3,4,2));
        System.out.println(myM2 (7,7));
        myM3(5);
        System.out.println(myM4(-20));
        myM5("Василий");

        myM6GetTrueYear(99);
        myM6GetTrueYear(100);
        myM6GetTrueYear(400);
        myM6GetTrueYear(200);
        myM6GetTrueYear(4);
    }

    public static double myM1(int a, int b, int c, int d) { //ex.3
        return a * (b + (c / d));
    }
    public static boolean myM2(int a, int b) { //ex.4
        if (((a+b)>=10) && ((a+b)<=20)) {return true;}
        else {return false;}
    }
    public static void myM3(int a) { //ex.5
        if (a <0) {System.out.println(a + " - отрицательное число");}
        else {System.out.println(a + " - положительное число");}
    }
    public static boolean myM4(int a) { //ex.6
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void myM5(String name) {//ex.7
        System.out.println("Привет, "+ name + "!" );
    }
    public static void  myM6GetTrueYear (int a) {//ex.8
        if ((((a%4)!= 0) || ((a%100)== 0)) && ((a%400)!=0)){
            System.out.println( a + " год - не высокосный");}
        else System.out.println( a + " год - высокосный");

    }
}


