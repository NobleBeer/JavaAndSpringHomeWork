public class Square extends Parallelogram {
    Square(double a) {
        super(a, a);
    }

    @Override
    public double area() {
        if (a > 0) {
            return a * a;
        }
        else {
            return 0;
        }
    }

    @Override
    public String info() {
        if (a > 0) {
            String textSquare = String.format("Квадрат со стороной %s \n", a);
            return textSquare;
        }
        else {
            return "произошла ошибка";
        }
    }
}
