public class IntroTasks {
    public static boolean is3Digit(int a) {
        return 1000 > a && a > 99;
    }

    public static boolean isLast5(int a) {
        return a % 10 == 5;
    }

    public static boolean isSameDigits(int a) {
        return (a % 10 == (a % 100 / 10)) && a > 10;
    }

    public static boolean isLeapYear(int a) {
        return a % 4 == 0 && a % 100 != 0 || a % 400 == 0;
    }

    public static String cat(int a) {
        String[] arr = {"кот", "кота", "котов"};
        int b = Math.abs(a);
        String result;
        if (b >= 11 && b < 15) {
            result = arr[2];
        }
        else if (b % 10 == 1) {
            result = arr[0];
        }
        else if (b % 10 > 1 && b % 10 < 5) {
            result = arr[1];
        }
        else {
            result = arr[2];
        }
        return String.format("%s %s", a, result);
    }

    public static String getQuadraticEquationSolution(int a, int b, int c) {
        double D;
        if (a == 0) {
            return "there are infinitely many solutions";
        } else {
            D = b * b - 4 * a * c;
            if (D > 0) {
                double x1, x2;
                x1 = (-b - Math.sqrt(D)) / (2 * a);
                x2 = (-b + Math.sqrt(D)) / (2 * a);
                return String.format("two solutions x1 = %.0f, x2 = %.0f", x1, x2);
            } else if (D == 0) {
                double x;
                x = -b / (2 * a);
                return String.format("one solution x = %.0f", x);
            } else {
                return String.format("no solution");
            }
        }

    }

    public static boolean isPrimality(int a) {
        int temp;
        if (a < 0) {
            a = -a;
        }

        for (int i = 2; i <= a / 2; i++) {
            temp = a % i;
            if (temp == 0) {
                return false;
            }
        }
        return true;
    }
}
