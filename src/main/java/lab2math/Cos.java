package lab2math;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

import static java.lang.Double.*;

public class Cos {
    private final Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }

    public Cos() {
        this.sin = new Sin();
    }

    public double cos(double x, double precision) {
        if (isNaN(x) || isInfinite(x))
            return NaN;

        double result;
        double x_init = x;

        x %= Math.PI * 2;
        if (x < -Math.PI) {
            while (x < -Math.PI)
                x += 2 * Math.PI;
        }
        if (x > Math.PI) {
            while (x > Math.PI)
                x -= 2 * Math.PI;
        }

        if (Math.abs(x - Math.PI/2) < 0.1 || Math.abs(x - (-Math.PI/2)) < 0.1) {
            return 0;
        } else if (x > Math.PI / 2 || x < -Math.PI / 2) {
            result = -1 * Math.sqrt(1 - sin.sin(x_init, precision) * sin.sin(x_init, precision));
        } else result = Math.sqrt(1 - sin.sin(x_init, precision) * sin.sin(x_init, precision));

        if (Math.abs(result) <= precision) return 0;
        return result;
    }

    public void toCSV(double x, double precision, Writer out) {
        double res = cos(x, precision);
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Cos CSV writing failed");
        }
    }
}
