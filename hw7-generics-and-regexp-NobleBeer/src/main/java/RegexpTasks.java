import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpTasks {

    public static boolean isTrueCat(String input) {
        if (input != null) {
            Pattern pattern = Pattern.compile("cat", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            return matcher.find();
        }
        return false;
    }

    public static int catculator(String input) {
        if (input != null) {
            int count = 0;
            Pattern pattern = Pattern.compile("(\\d*)(\\scat+)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                if (matcher.group(1) != "") {
                    count += Integer.parseInt(matcher.group(1));
                } else {
                    count++;
                }
            }
            return count;
        }
        return 0;
    }

    public static String skynet(String input) {
        if (input != null) {
            Pattern pattern = Pattern.compile("\\bhuman\\b");
            Matcher matcher = pattern.matcher(input);

            return matcher.replaceAll("computer");
        }
        return "";
    }

    public static String removeDuplicates(String input) {
        if (input != null) {
            return input.replaceAll("(\\w)\\1+", "$1");
        }
        return "";
    }

    public static boolean isEmail(String input) {
        if (input != null) {
            String regex = "^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9]+)*(\\.[a-z]{2,})$";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            return matcher.find();
        }
        return false;
    }

    public static String validateForDuplicates(String input) {
        if (input != null) {
            Pattern pattern = Pattern.compile("(\\b\\S+\\b)(\\s+)(\\1\\b)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            return matcher.replaceAll("$1$2<strong>$3</strong>");
        }
        return "";
    }
}
