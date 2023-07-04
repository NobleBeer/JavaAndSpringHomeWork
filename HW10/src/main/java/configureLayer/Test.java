package configureLayer;


public class Test {

    public static void main(String[] args) {
        MainServer mainServer = new MainServer();
        try {
            mainServer.start();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
