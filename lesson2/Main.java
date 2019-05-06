package lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[]arrEx1 = {1,1,0,0,1,0,1,1,0,0}; //ex.1
        int i=0;
        for (int value : arrEx1) {
            if (value==0) {arrEx1[i]=1;} else {arrEx1[i] = 0;}
            System.out.println(arrEx1[i]);
            i+=1;
        }
    //ex.2
        int [] arrEx2 = new int[8];
        i=0;
        for (int value : arrEx2) {
        arrEx2[i]=i*3;
        System.out.println(arrEx2[i]);
        i+=1;
        }

        //ex3.
        int[]arrEx3 = {1,5,3,2,11,4,5,2,4,8,9};
        i=0;
        for (int value : arrEx3) {
            if (value < 6) {
                arrEx3[i] = value * 2;
            }
            System.out.println(arrEx3[i]);
            i += 1;
        }
        //ex.4
        int arrEx4 [][]=new int[9][9];
        fillArr (arrEx4);
        printArr2D(arrEx4);

        // ex.5

        int [] arrEx5 = {6,7,3,5,200,9,11,234,0,-7};
        System.out.println("максимальное значение в массиве - " + maxItemArr(arrEx5));
        System.out.println("минимальное значение в массиве - " + minItemArr(arrEx5));

        //ex. 6

        int[] arrEx6 = {1,2,3,4,5,6,7,8};
        System.out.println(chekArrBalance(arrEx6));

        //ex. 7
        for (i=0; i<arrEx6.length; i++)
        System.out.println(arrEx6[i]);
        changeArr(arrEx6,-9);
        for (i=0; i<arrEx6.length; i++)
            System.out.println(arrEx6[i]);

    }
    public static void fillArr ( int [][] arrEx4) {
        for (int i = 0; i < arrEx4.length; i++) {
            arrEx4[i][i] = 1;
            }
        for (int i = 0; i < arrEx4.length; i++) {
            arrEx4[i][(arrEx4.length-1-i)] = 1;
            }

        }

    public static void printArr2D (int [][] arrEx4) {
        for ( int i = 0; i < arrEx4.length; i++) {
            for (int j = 0; j < arrEx4[i].length; j++) {
                System.out.print((arrEx4[i][j])+" ");
            }
            System.out.println();}
        }
    public static Integer maxItemArr (int [] arrEx5) {
        int maxItem = arrEx5[0];
        for (int i = 0; i < arrEx5.length; i++) {
            if (maxItem < arrEx5[i]) maxItem=arrEx5[i];
        }
        return maxItem;
    }
    public static Integer minItemArr (int[] arrEx5) {
        int minItem = arrEx5[0];
        for (int i = 0; i < arrEx5.length; i++) {
            if (minItem > arrEx5[i])  minItem = arrEx5[i];
        }
        return minItem;
    }
    public static boolean chekArrBalance (int[] arrEx6) {
        int sum1=0;
        int sum2=0;
        boolean balance=false;
        for  (int i = 1; i < (arrEx6.length); i++) {
            for (int j = 0; j < i; j++) {
                sum1 = sum1 + arrEx6[j];
            }
            for (int n = i; n < (arrEx6.length); n++) {
                sum2 = sum2 + arrEx6[n];
            }
           // System.out.println(sum1+" "+sum2);
        if (sum1==sum2)
            {balance = true;
            break;}
            sum1=0;
            sum2=0;
        }
        return balance;
    }
    public static void changeArr (int arrEx6[],int m) {
        int temp=0;
        int newtemp=0;
        if (m>0)
        {for (int n=0; n<m; n++) {
            for (int i =0; i<arrEx6.length ; i++) {
                    if (i==(arrEx6.length-1))
                    {arrEx6[0]=arrEx6[i];arrEx6[i]=newtemp;}
                    else
                    {temp=arrEx6[i];
                    arrEx6[i]=newtemp;
                    newtemp=temp;
                    }
                }
            }
        }
            else if (m<0)
        {for (int n=0; n>m; n--) {
            for (int i =(arrEx6.length-1); i>-1; i--) {
                if (i==0)
                    {arrEx6[arrEx6.length-1]=arrEx6[i];arrEx6[i]=newtemp;}
                else
                        {temp=arrEx6[i];
                        arrEx6[i]=newtemp;
                        newtemp=temp;}}}}


            }

        }


