public class Triangle implements Figure {
    double a, b, c;
    double p = a + b + c;
    double p2 = p / 2;
    double s = Math.sqrt(p2 * (p2 - a) * (p2 - b) * (p2 - c));

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimiter() {
        if ((a > 0) && (b > 0) && (c > 0)) {
            return p;
        }
        else {
            return 0;
        }
    }

    public double area() {
        if ((a > 0) && (b > 0) && (c > 0)) {
            return s;
        }
        else {
            return 0;
        }
    }

    public String info() {
        String textTriangle = String.format("Треугольник со сторонами %s, %s и %s \n", a, b, c);
        return textTriangle;
    }
}
