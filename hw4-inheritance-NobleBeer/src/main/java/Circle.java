public class Circle implements Figure {
    double r;

    Circle(double r) {
        this.r = r;
    }

    public double area() {
        if (r > 0) {
            return Math.PI * r * r;
        }
        else {
            return 0;
        }
    }

    public double perimiter() {
        if (r > 0) {
        return 2 * Math.PI * r;
        }
        else {
            return 0;
        }
    }

    public String info() {
        if (r > 0) {
            String textCircle = String.format("Круг радиуса %s \n", r);
            return textCircle;
        }
        else {
            return "произошла ошибка";
        }
    }


}
