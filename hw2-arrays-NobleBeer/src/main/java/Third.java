import java.util.Arrays;

public class Third {
    public static void main(String[] args) {
        char[][] c = createTable(20, '.');
        printTable(c);

        System.out.println("============ Заполним строки: ==========");
        fillFirstAndLastLines(c, '#');
        printTable(c);

        System.out.println("============ Заполним столбцы: =========");
        fillFirstAndLastColumns(c, '#');
        printTable(c);

    }

    public static char[][] createTable(int c, char ch) {
        char[][] a = new char[c][c];
        for (char i[]: a) {
            Arrays.fill(i, ch);
        }
        return a;
    }

    public static void printTable(char[][] a) {
        for (char i[]: a) {
            System.out.println(i);
        }
    }

    public static void fillFirstAndLastLines(char[][] a, char ch) {
        Arrays.fill(a[0], ch);
        Arrays.fill(a[a.length - 1], ch);
    }

    public static void fillFirstAndLastColumns(char[][] a, char ch) {
        for (char i[]: a) {
            i[0] = ch;
            i[i.length - 1] = ch;
        }
    }

}
