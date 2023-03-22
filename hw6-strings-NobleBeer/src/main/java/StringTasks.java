import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.String.format;

public class StringTasks {
    public static boolean isLowerCase(String input) {
        if (input == null) {
            return false;
        }
        String regex = "[a-z]+";
        return input.matches(regex);
    }

    public static boolean isUpperCase(String input) {
        if (input == null) {
            return false;
        }
        String regex = "[A-Z]+";
        return input.matches(regex);
    }

    public static boolean isCamelCase(String input) {
        if (input == null) {
            return false;
        }
        String regex = "^[A-Z][^A-Z]*$";
        return input.matches(regex);
    }

    public static boolean isMixedCase(String input) {
        if (input == null) {
            return false;
        }
        String regex1 = "[a-z]([A-Z][a-z])*[A-Z]?";
        String regex2 = "[A-Z]([a-z][A-Z])*[a-z]?";
        return input.matches(regex1) || input.matches(regex2);
    }

    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String ref = input.replaceAll("\\W", "");

        return ref.length() > 0 && ref.equalsIgnoreCase(new StringBuilder(ref).reverse().toString());
    }

    public static boolean isStrictPalindrome(String input, boolean isStrict) {
        if (input == null) {
            return false;
        }
        if (!isStrict) {
            return isPalindrome(input);
        } else {
            String ref = input.replaceAll("\\W", "");
            return ref.length() > 0 && ref.equals(new StringBuilder(ref).reverse().toString());
        }
    }

    public static boolean isAllCharactersPaired(String input) {
        if (input == null) {
            return false;
        }

        String regex = "(.)+(\\1)";

        return input.matches(regex);
    }

    // ура, джава тянет тернарные операторы, стримы и лямбды
    public static String replaceBinaryNumbers(String input) {
        if (input == null) {
            return null;
        }

        return Stream.iterate(0, i -> i + 1).limit(input.length())
                .map(x -> input.charAt(x) == '0' ? '1' : (input.charAt(x) == '1' ? '0' : input.charAt(x)))
                .map(x -> x.toString()).collect(Collectors.joining());
    }

    public static String replace(String input, char from, char to) {
        if (input == null) {
            return null;
        }

        return Stream.iterate(0, i -> i + 1).limit(input.length())
                .map(x -> input.charAt(x) == from ? to : input.charAt(x))
                .map(x -> x.toString()).collect(Collectors.joining());
    }

    public static String makeDragonCurve(int n) {
        String s = "";

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                s += "R";
            } else {
                String reverse = new StringBuilder(s).reverse().toString();
                String ref = Stream.iterate(0, j -> j + 1).limit(s.length())
                        .map(x -> reverse.charAt(x) == 'R' ? 'L' : (reverse.charAt(x) == 'L' ? 'R' : reverse.charAt(x)))
                        .map(x -> x.toString()).collect(Collectors.joining());

                s += "R" + ref;
            }
        }
        return s;
    }

    public static String makeGrayCode(int n) {
        String s = "";

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                s += "0";
            } else {
                s = format("%s %s %s", s, i, s);
            }
        }
        return s;
    }
}
