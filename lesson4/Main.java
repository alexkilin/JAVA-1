package lesson4;
import java.util.Random;
import java.util.Scanner;
public class Main {


        public static int SIZE = 5;
        public static int DOTS_TO_WIN = 4;
        public static final char DOT_EMPTY = '•';
        public static final char DOT_X = 'X';
        public static final char DOT_O = 'O';
        public static int ai_X = 0;
        public static int ai_Y =0;
        public static char[][] map;
        public static Scanner sc = new Scanner(System.in);
        public static Random rand = new Random();
        public static void main(String[] args) {
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (checkWin(DOT_X)) {
                    System.out.println("Победил человек");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
                aiTurn();
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
                        {win++;
                        if (win>=(DOTS_TO_WIN-1)) {ai_X=i+1;ai_Y=i+1;} }
                            else
                            if (win<DOTS_TO_WIN)
                                {win=0;}}
                           if (win>=DOTS_TO_WIN) return true;
            win=0;
            for (int i=0;i<SIZE;i++) { // проверка вспомогательной диагонали
                if (map[i][SIZE-1-i]==symb)
                {win++;
                    if (win>=(DOTS_TO_WIN-1)) {ai_X=i+1;ai_Y=SIZE-i+1;} }
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
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
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


