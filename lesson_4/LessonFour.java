package lesson_4;

import java.util.Random;
import java.util.Scanner;

public class LessonFour {
    // Создание игрового поля.
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static char[][] map;
    // Ячейки поля
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    // Тест программы.
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
        sc.close();
    }
    // Инициализация поля
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    // Вывод поля в консоль.
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
    // Ход человека.
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }
    // Проверка ячеек.
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }
    // Ход компьютера.
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
            for (int i = 0; i < SIZE; i++) {
                for (int j = 1; j < SIZE; j++) {
                      if (map[i][j - 1] == DOT_X && map[i][j] == DOT_X &&
                              (isCellValid(j - 2, i) || (isCellValid(j + 1, i)))) {
                        // блок по горизонтали
                        y = i;
                        x = rand.nextInt(4) + j - 2;

                    } else if (map[j - 1][i] == DOT_X && map[j][i] == DOT_X &&
                              (isCellValid(i, j -2) || (isCellValid(i, j + 1)))) {
                        // блок по вертикали
                        y = rand.nextInt(4) + j - 2;
                        x = i;

                    }
                }
            }
            for (int i = 1; i < SIZE; i++) {
                // блок по диагонали
                if ((map[i][i] == DOT_X && map[i - 1][i - 1] == DOT_X &&
                        (isCellValid(i - 2, i - 2) || (isCellValid(i + 1, i + 1))))){
                    y = rand.nextInt(4) + i - 2;
                    x = y;

                } else if (map[i][SIZE - i - 1] == DOT_X && map[i - 1][SIZE - i] == DOT_X &&
                        (isCellValid(SIZE - i + 1, i - 2) || (isCellValid(SIZE - i - 2, i + 1)))) {
                    // блок по обратной диагонали
                   y = rand.nextInt(4) + i - 2;
                   x = SIZE - y - 1;

                }
            }
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;

    }
    // Проверка победы.
    public static boolean checkWin(char symb) {
        int countD = 0;
        int countDRev = 0;
        for (int i = 0; i < SIZE; i++) {
            int countX = 0;
            int countY = 0;
            for (int j = 1; j < SIZE; j++) {
                if (map[i][j - 1] == symb && map[i][j] == symb) // проверка комбинации по горизонтали
                    countX++;
                if (countX == DOTS_TO_WIN - 1) return true;
                if (map[j - 1][i] == symb && map[j][i] == symb) // проверка комбинации по вертикали
                    countY++;
                if (countY == DOTS_TO_WIN - 1) return true;
            }
        }
        for (int i = 1; i < SIZE; i++) {
            if(map[i][i]  == symb && map[i - 1][i - 1] == symb) // проверка комбинации по диагонали
                countD ++;
            if(countD == DOTS_TO_WIN - 1) return true;
            if(map[i][SIZE - i - 1]  == symb && map[i - 1][SIZE - i] == symb) // проверка комбинации по обратной диагонали
                countDRev ++;
            if(countDRev == DOTS_TO_WIN - 1) return true;
        }
        return false;
    }

    // Проверка на заполненность поля
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}



