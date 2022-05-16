package lab2math;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class Cot {
    private final Cos cos;
    private final Sin sin;

    public Cot(Cos cos, Sin sin) {
        this.cos = cos;
        this.sin = sin;
    }
    public Cot() {
        this.cos = new Cos();
        this.sin = new Sin();
    }

    public double cot(double x, double precision) {
        double cosVal = cos.cos(x, precision);
        double sinVal = sin.sin(x, precision);

        if (sinVal == 0 || Double.isNaN(cosVal) || Double.isNaN(sinVal))
            return Double.NaN;

        return cosVal / sinVal;
    }

    public void toCSV(double x, double precision, Writer out) {
        double res = cot(x, precision);
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Cot CSV writing failed");
        }
    }
}
