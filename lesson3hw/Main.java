package lesson3.lesson3hw;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);
    static boolean wingame = false;

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        String NewAnswer;
        String NewQwestion = getNewQwestion(words);
        System.out.println("Угадайте ка загаданное мною слово ");
        do {
            NewAnswer = getNewAnswer();
            gessTheWord(NewAnswer, NewQwestion);
        }
        while (!wingame);
        System.out.println("Да, было загадано слово " + NewQwestion);
    }


    public static int multiply(int n) {
        int i = rand.nextInt(n);
        return i;
    }

    public static String getNewQwestion(String[] words) {
        return words[multiply(words.length - 1)];
    }

    public static String getNewAnswer() {
        System.out.println("Ваша попытка?:");
        String NewAnswer = sc.nextLine();
        return NewAnswer;
    }

    public static void gessTheWord(String attemptWord, String NewQwestion) {
        wingame=true;
        for (int i = 0; i < Math.min(NewQwestion.length(), attemptWord.length()); i++) {
            if (attemptWord.charAt(i) == NewQwestion.charAt(i)) {
                System.out.print(NewQwestion.charAt(i));
                } else {
                    System.out.print("#");
                    wingame = false;
                }
            if (NewQwestion.length() != attemptWord.length()) {
                wingame = false;
            }}

            for (int i = Math.min(NewQwestion.length(), attemptWord.length()); i < 15; i++) {
                System.out.print("#");
            }

            System.out.println();

        }

    }



