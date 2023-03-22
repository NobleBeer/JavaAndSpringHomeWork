public class Rhomb extends Parallelogram {
    String text = "Ромб с диагоналями";

    // @param a, b DIAGONALLY
    Rhomb(double a, double b) {
        super(a, b);
    }

    @Override
    public double perimiter() {
        if (a > 0 && b > 0) {
            return 2 * Math.sqrt(a * a + b * b);
        }
        else {
            return 0;
        }
    }

    @Override
    public double area() {
        if (a > 0 && b > 0) {
            return a * b / 2;
        }
        else {
            return 0;
        }
    }

    @Override
    public String info() {
        if (a > 0 && b > 0) {
            String textRhomb = String.format("%s %s и %s \n", text, a, b);
            return textRhomb;
        }
        else {
            return "произошла ошибка";
        }
    }
}
