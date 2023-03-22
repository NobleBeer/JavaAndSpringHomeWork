import java.util.Formatter;

public interface Figure {
    double area();
    double perimiter();
    String info();
    default double capacity() {
        return area() / perimiter();
    }

    static double capacity(Figure f) {
        return f.area() / f.perimiter();
    }
}
