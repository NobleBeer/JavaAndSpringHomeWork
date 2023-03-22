import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


public class FilesTasks {

    public static int readInt(String message) {
        System.out.println(message);
        while (true) {
            Scanner in = new Scanner(System.in);
            try {
                return in.nextInt();
            } catch (NumberFormatException e) {
                System.err.println("it is not a number, try again");
            }
        }
    }

    public static void renameFiles(List<String> filePaths) {
        if (filePaths == null) {
            throw new RuntimeException("List is empty");
        }
        ListIterator<String> listIterator = filePaths.listIterator();
        while (listIterator.hasNext()) {
            listIterator.set(String.format("%s_%s",
                    listIterator.nextIndex() + 1, listIterator.next()));
        }
    }
}
