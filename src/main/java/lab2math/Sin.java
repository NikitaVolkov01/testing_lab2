package lab2math;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

import static java.lang.Double.*;

public class Sin {
    public double sin(double x, double precision) {
        if (isNaN(x) || isInfinite(x))
            return NaN;

        double res = 0;
        double prevRes;
        int i = 1, sign = 1;
        double fact = 1, pow;

        if (x >= 0) {
            while (x > Math.PI * 2)
                x -= Math.PI * 2;
        } else if (x < 0) {
            while (x < Math.PI * 2)
                x += Math.PI * 2;
        }

        pow = x;

        do {
            prevRes = res;
            fact /= i;
            res += sign * pow * fact;
            sign = -sign;
            fact /= (i + 1);
            pow *= (Math.pow(x, 2));
            i += 2;
        } while (Math.abs(res - prevRes) > precision);

        if (Math.abs(res) < precision) return 0;

        return res;
    }

    public void toCSV(double x, double precision, Writer out) {
        double res = sin(x, precision);
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Sin CSV writing failed");
        }
    }
}
