public class RightTriangle extends Triangle {
    RightTriangle(double a, double b) {
        super(a, b, 0);
    }

    @Override
    public double perimiter() {
        if ((a > 0) && (b > 0)) {
            return Math.sqrt(a * a + b * b) + a + b;
        }
        else {
            return 0;
        }
    }

    @Override
    public double area() {
        if ((a > 0) && (b > 0)) {
            return a * b / 2;
        }
        else {
            return 0;
        }
    }

    @Override
    public String info() {
        if (a > 0 && b > 0) {
            String textRightTriangle = String.format("Прямоугольный треугольник со сторонами %s и %s \n", a, b);
            return textRightTriangle;
        }
        else {
            return "произошла ошибка";
        }
    }
}
