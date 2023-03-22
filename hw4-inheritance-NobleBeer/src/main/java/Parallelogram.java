abstract class Parallelogram implements Figure {
    double a, b;

    Parallelogram(double a, double b) {
        this.a = a;
        this.b = b;
    }
    public double perimiter() {
        if (a > 0 && b > 0) {
            return 2 * (a + b);
        }
        else {
            return 0;
        }
    }
}
