public class Rectangle extends Parallelogram {
    Rectangle(double a, double b) {
        super(a, b);
    }

    @Override
    public double area() {
        if (a > 0 && b > 0) {
            return a * b;
        }
        else {
            return 0;
        }
    }

    @Override
    public String info() {
        if (a > 0 && b > 0) {
            String textRectangle = String.format("Прямоугольник со сторонами %s и %s \n", a, b);
            return textRectangle;
        }
        else {
            return "произошла ошибка";
        }
    }
}
