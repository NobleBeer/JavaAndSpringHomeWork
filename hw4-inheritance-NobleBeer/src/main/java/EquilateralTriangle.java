public class EquilateralTriangle extends Triangle {
    double s = Math.sqrt(3) / 4;
    EquilateralTriangle(double a) {
        super(a, 0, 0);
    }

    @Override
    public double perimiter() {
        if (a > 0) {
            return 3 * a;
        }
        else {
            return 0;
        }
    }

    @Override
    public double area() {
        if (a > 0) {
            return a * a * s;
        }
        else {
            return 0;
        }
    }

    @Override
    public String info() {
        if (a > 0) {
            String textEquilateralTriangle = String.format("Равносторонний треугольник со стороной %s \n", a);
            return textEquilateralTriangle;
        }
        else {
            return "произошла ошибка";
        }
    }
}
