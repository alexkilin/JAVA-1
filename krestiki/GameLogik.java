package com.company;

import java.util.Random;
import java.util.Scanner;

public class GameLogik {


        public static int SIZE = 3;
        public static int DOTS_TO_WIN = 3;
        public static final char DOT_EMPTY = '•';
        public static final char DOT_X = 'X';
        public static final char DOT_O = 'O';
        public static int ai_X = 0;
        public static int ai_Y =0;
        public static boolean BestTurn=false;
        public static char[][] map;
        public static Scanner sc = new Scanner(System.in);
        public static Random rand = new Random();
        public static void main(String[] args) {
            //   initMap();
            //    printMap();
            //     while (true) {
            //         humanTurn();
            //         printMap();
            //         if (checkWin(DOT_X)) {
            //              System.out.println("Победил человек");
            //             break;
            //          }
            //           if (isMapFull()) {
            //               System.out.println("Ничья");
            //               break;
           /*     }

                BestTurn = false;
                for (int i = 0; i < SIZE; i++) { //подбор хода искусственным интеллектом для целей победы
                    for (int j = 0; j < SIZE; j++) { // следующим ходом
                        if (map[i][j]==DOT_EMPTY) {
                            map[i][j]=DOT_O;
                            if (checkWin(DOT_O)) {
                                ai_X = j;
                                ai_Y = i;
                                BestTurn = true;
                                //   System.out.println("aiход победа" + (i+1)+(j+1));}
                            }
                            map [i][j]=DOT_EMPTY;
                        }
                        if (BestTurn) break;   }

                    if (BestTurn) break;  }


                if (!BestTurn) {
                    for (int i = 0; i < SIZE; i++) { //подбор хода искусственным интеллектом для целей блокировки...
                        for (int j = 0; j < SIZE; j++) {// если нет хода для победы
                            if (map[i][j] == DOT_EMPTY) {
                                map[i][j] = DOT_X;
                                if (checkWin(DOT_X)) {
                                    ai_X = j;
                                    ai_Y = i;
                                    BestTurn = true;
                                }//  System.out.println("aiход блокирование" + (i+1)+(j+1));}
                                map[i][j] = DOT_EMPTY;
                            }
                            if (BestTurn) break;
                        }
                        if (BestTurn) break;
                    }
                }
                if (!BestTurn) {
                    for (int i = 0; i < SIZE; i++) { //подбор хода искусственным интеллектом для целей победы
                        for (int j = 0; j < SIZE; j++) {// через 2 хода
                            if (map[i][j] == DOT_EMPTY) {
                                map[i][j] = DOT_O;
                                for (int k = 0; k < SIZE; k++) {
                                    for (int m = 0; m < SIZE; m++) {
                                        if (map[k][m] == DOT_EMPTY) {
                                            map[k][m] = DOT_O;
                                            if (checkWin(DOT_O)) {
                                                ai_X = j;
                                                ai_Y = i;
                                                BestTurn = true;
                                                // System.out.println("aiход по алгоритму на два хода вперед " + (i + 1) + (j + 1));
                                            }
                                            map[k][m] = DOT_EMPTY;
                                        }
                                        if (BestTurn) break; }
                                    if (BestTurn) break;
                                }
                                map[i][j] = DOT_EMPTY;}
                            if (BestTurn) break;}
                        if (BestTurn) break; }
                }
                aiTurn();
                BestTurn=false;
                printMap();
                if (checkWin(DOT_O)) {
                    System.out.println("Победил Искуственный Интеллект");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
            }
            System.out.println("Игра закончена");


*/
        }
        public static boolean checkWin(char symb) {
            //if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
            //if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
            //if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
            //if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
            //if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
            //if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
            //if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
            //if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
            int win=0;
            for (int i=0;i<SIZE;i++) { //1 проверка основной диагонали
                if (map[i][i]==symb)
                {win++;                         }
                else
                if (win<DOTS_TO_WIN)
                {win=0;}}
            if (win>=DOTS_TO_WIN) return true;
            win=0;
            for (int i=0;i<SIZE;i++) { // проверка вспомогательной диагонали
                if (map[i][SIZE-1-i]==symb)
                {win++;
                }
                else
                if (win<DOTS_TO_WIN)
                {win=0;}}
            if (win>=DOTS_TO_WIN) return true;

            for (int i=0;i<SIZE;i++) { //проверка горизонталей
                win=0;
                for (int j=0;j<SIZE;j++) {
                    if (map[i][j]==symb)
                    {win++;}
                    else
                    if (win<DOTS_TO_WIN)
                    {win=0;}}
                if (win>=DOTS_TO_WIN) return true;}

            for (int i=0;i<SIZE;i++) { //проверка вертикалей
                win=0;
                for (int j=0;j<SIZE;j++) {
                    if (map[j][i]==symb)
                    {win++;}
                    else
                    if (win<DOTS_TO_WIN)
                    {win=0;}}
                if (win>=DOTS_TO_WIN) return true;
            }

            return false;
        }
        public static boolean isMapFull() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) return false;
                }
            }
            return true;
        }
        public static void aiTurn() {
            int x, y;
            if (BestTurn) {y=ai_Y;x=ai_X;}
            else {
                do {
                    x = rand.nextInt(SIZE);
                    y = rand.nextInt(SIZE);
                } while (!isCellValid(x, y));}

            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
        }
        public static void humanTurn() {
            int x, y;
            do {
                System.out.println("Введите координаты в формате X Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
            map[y][x] = DOT_X;
        }
        public static boolean isCellValid(int x, int y) {
            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
            if (map[y][x] == DOT_EMPTY) return true;
            return false;
        }
        public static void initMap() {
            map = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        public static void printMap() {
            for (int i = 0; i <= SIZE; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < SIZE; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }






