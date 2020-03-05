import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 3;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final String EMPTY_COLUMN_FIRST = "  ";
    public static final String EMPTY = " ";

    public static char[][] map = new char[SIZE][SIZE];
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    static int count1 = 0;
    static int count2 = 0;
    static int count3 = 0;
    static int count4 = 0;
    static int count01 = 0;
    static int count02 = 0;
    static int count03 = 0;
    static int count04 = 0;

    public static void main(String[] args) {

        initMap();

        printMap();

        playGame();

    }

    private static void playGame() {

        while (true) {
            //ход человека
            humanTurn();
            printMap();
            if (checkEnd(DOT_X, "Вы победили!")) {
                System.exit(0);
            }

            //ход ИИ
            if (tryToWin()) {
            } else if (checkDanger()) {
            } else {
                aiTurn();
            }
            printMap();
            if (checkEnd(DOT_O, "Компуктер победил!")) {
                System.exit(0);
            }
        }
    }

    private static boolean tryToWin() {

        // победа по столбцам
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if (map[j][i] == DOT_O & map[j + 1][i] == DOT_O & map[j + 2][i] == DOT_O & map[j + 3][i] == DOT_EMPTY) {
                    map[j + 3][i] = DOT_O;
                    return true;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if (map[j][i] == DOT_O & map[j + 1][i] == DOT_O & map[j + 2][i] == DOT_EMPTY & map[j + 3][i] == DOT_O) {
                    map[j + 2][i] = DOT_O;
                    return true;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if (map[j][i] == DOT_O & map[j + 1][i] == DOT_EMPTY & map[j + 2][i] == DOT_O & map[j + 3][i] == DOT_O) {
                    map[j + 1][i] = DOT_O;
                    return true;
                }
            }
        }



        // победа по строкам
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if (map[i][j] == DOT_O & map[i][j + 1] == DOT_O & map[i][j + 2] == DOT_O & map[i][j + 3] == DOT_EMPTY) {
                    map[i][j + 3] = DOT_O;
                    return true;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if (map[i][j] == DOT_O & map[i][j + 1] == DOT_O & map[i][j + 2] == DOT_EMPTY & map[i][j + 3] == DOT_O) {
                    map[i][j + 2] = DOT_O;
                    return true;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if (map[i][j] == DOT_O & map[i][j + 1] == DOT_EMPTY & map[i][j + 2] == DOT_O & map[i][j + 3] == DOT_O) {
                    map[i][j + 1] = DOT_O;
                    return true;
                }
            }
        }


// победы по диагоналям

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (map[i][j] == DOT_O & map[i + 1][j + 1] == DOT_O & map[i + 2][j + 2] == DOT_O & map[i + 3][j + 3] == DOT_EMPTY) {
                    map[i + 3][j + 3] = DOT_O;
                    return true;
                }
            }
        }



        for (int i = 3; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if (map[i][j] == DOT_O & map[i - 1][j + 1] == DOT_O & map[i - 2][j + 2] == DOT_O & map[i - 3][j + 3] == DOT_EMPTY) {
                    map[i - 3][j + 3] = DOT_O;
                    return true;
                }
            }
        }


        return false;
    }


    private static boolean checkDanger() {

        if (count01 == 2) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((map[j][i] == DOT_X) & (map[j + 1][i] == DOT_X)) {
                        count1++;
                        if (j > 0 & j < 3) {
                            if
                            (count1 == 2 & map[j + 2][i] == DOT_EMPTY) {
                                map[j + 2][i] = DOT_O;
                                return true;
                            }
                        }

                        if (j > 1) {
                            if (count1 == 2 & map[j - 2][i] == DOT_EMPTY) {
                                map[j - 2][i] = DOT_O;
                                return true;
                            }
                        }
                    }
                }
                count1 = 0;
            }
            count1 = 0;
        }


        if (count02 == 2) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((map[i][j] == DOT_X) & (map[i][j + 1] == DOT_X)) {
                        count2++;
                        if (j > 0 & j < 3) {
                            if
                            (count2 == 2 & map[i][j + 2] == DOT_EMPTY) {
                                map[i][j + 2] = DOT_O;
                                return true;
                            }
                        }

                        if (j > 1) {
                            if (count2 == 2 & map[i][j - 2] == DOT_EMPTY) {
                                map[i][j - 2] = DOT_O;
                                return true;
                            }
                        }
                    }
                }
                count2 = 0;
            }
            count2 = 0;
        }


        if (count03 == 2) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j < 3 & i < 3) {
                        if ((map[i][j] == DOT_X) & (map[i + 1][j + 1] == DOT_X) & map[i + 2][j + 2] == DOT_EMPTY) {
                            map[i + 2][j + 2] = DOT_O;
                            return true;
                        }
                    }
                    if (j > 2 & i > 2) {
                        if ((map[i][j] == DOT_X) & (map[i + 1][j + 1] == DOT_X) & map[i - 2][j - 2] == DOT_EMPTY) {
                            map[i - 2][j - 2] = DOT_O;
                            return true;
                        }
                    }
                }
            }
        }


        if (count04 == 2) {
            for (int i = 4; i >= 1; i--) {
                for (int j = 0; j < 4; j++) {
                    if (i > 1 & j < 3) {
                        if ((map[i][j] == DOT_X) & (map[i - 1][j + 1] == DOT_X) & map[i - 2][j + 2] == DOT_EMPTY) {
                            map[i - 2][j + 2] = DOT_O;
                            return true;
                        }
                    }

                    if (i < 3 & j > 1) {
                        if ((map[i][j] == DOT_X) & (map[i - 1][j + 1] == DOT_X) & map[i + 1][j - 1] == DOT_EMPTY) {
                            map[i + 2][j - 2] = DOT_O;
                            return true;
                        }
                    }


                }
            }
        }


        return false;
    }


    private static boolean checkEnd(char symbol, String winMessage) {

        if (checkWin(symbol)) {
            System.out.println(winMessage);
            return true;
        }

        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }


        return false;
    }

    private static boolean isMapFull() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                if (aChar == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char symbol) {

        System.out.println(symbol);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if ((map[j][i] == symbol) & (map[j + 1][i] == symbol) & map[j + 2][i] == symbol) {
                    count01 = 2;
                    }
                if ((map[j][i] == symbol) & (map[j + 1][i] == symbol) & map[j + 2][i] == symbol & map[j + 3][i] == symbol) {
                    System.out.println("1 " + count1);
                    return true;
                }
            }
            count1 = 0;
        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if ((map[i][j] == symbol) & (map[i][j + 1] == symbol) & map[i][j + 2] == symbol) {
                    count01 = 2;
                }
                if ((map[i][j] == symbol) & (map[i][j + 1] == symbol) & map[i][j + 2] == symbol & map[i][j + 3] == symbol) {
                    System.out.println("1 " + count1);
                    return true;
                }
            }
            count1 = 0;
        }


        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                if ((map[i][j] == symbol) & (map[i + 1][j + 1] == symbol) & map[i + 2][j + 2] == symbol) {
                    count3 = 2;
                }

                if (count3 == 2 & symbol == DOT_X) {
                    count03 = count3;
                }

                if ((map[i][j] == symbol) & (map[i + 1][j + 1] == symbol) & map[i + 2][j + 2] == symbol & map[i + 3][j + 3] == symbol) {
                    System.out.println("3 " + count3);
                    return true;
                }
            }
            count3 = 0;
        }


        for (int i = 3; i <= 4; i++) {
            for (int j = 0; j <= 1; j++) {
                if ((map[i][j] == symbol) & (map[i - 1][j + 1] == symbol) & map[i - 2][j + 2] == symbol) {
                    count4 = 2;
                }

                if (count4 == 2 & symbol == DOT_X) {
                    count04 = count4;
                }

                if ((map[i][j] == symbol) & (map[i - 1][j + 1] == symbol) & map[i - 2][j + 2] == symbol & map[i - 3][j + 3] == symbol) {
                    System.out.println("4 " + count4);
                    return true;
                }
            }
            count4 = 0;
        }


        return false;
    }

    private static void humanTurn() {
        int rowNumber, colNumber;

        do {
            System.out.println("Ход пользователя! Введите номера строки и столбца");
            System.out.print("Строка = ");
            rowNumber = scanner.nextInt();
            System.out.print("Столбец = ");

            colNumber = scanner.nextInt();
        } while (!isCellValid(rowNumber, colNumber));

        map[rowNumber - 1][colNumber - 1] = DOT_X;
    }

    private static void aiTurn() {
        int rowNumber, colNumber;

        do {
            rowNumber = random.nextInt(SIZE) + 1;
            colNumber = random.nextInt(SIZE) + 1;
        } while (!isCellValid(rowNumber, colNumber));

        map[rowNumber - 1][colNumber - 1] = DOT_O;
    }

    private static boolean isCellValid(int rowNumber, int colNumber) {
        if ((rowNumber < 1 || rowNumber > SIZE) || (colNumber < 1 || colNumber > SIZE)) {
            System.out.println("\nПроверьте значения строки и столбца");
            return false;
        }

        if (map[rowNumber - 1][colNumber - 1] != DOT_EMPTY) {
            System.out.println("\nВы выбрали занятую ячейку");
            return false;
        }

        return true;
    }

    private static void printMap() {
        printMapHeader();

        printMapRows();
    }

    private static void printMapRows() {
        for (int i = 0; i < SIZE; i++) {
            printColumnNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + EMPTY);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printMapHeader() {
        System.out.print(EMPTY_COLUMN_FIRST);
        for (int i = 0; i < SIZE; i++) {
            printColumnNumber(i);
        }
        System.out.println();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printColumnNumber(int i) {
        int columnNumber = i + 1;
        System.out.print(columnNumber + EMPTY);
    }
}