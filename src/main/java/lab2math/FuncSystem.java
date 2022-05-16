package lab2math;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class FuncSystem {
    Sin sin;
    Cot cot;
    Log log;
    Ln ln;

    public FuncSystem() {
        this.sin = new Sin();
        this.cot = new Cot();
        this.log = new Log();
        this.ln = new Ln();
    }

    public FuncSystem(Sin sin, Cot cot, Log log, Ln ln) {
        this.sin = sin;
        this.cot = cot;
        this.log = log;
        this.ln = ln;
    }

    public double solve(double x, double precision) {
        if (x <= 0) {
            return cot.cot(x, precision) + sin.sin(x, precision);
        } else {
            return Math.pow(
                        (log.log(10, x, precision) - ln.ln(x, precision))
                        / log.log(5, x, precision)
                        + log.log(2, x, precision),
                    6);
        }
    }

    public void toCSV(double x, double precision, Writer out) {
        double res = solve(x, precision);
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("System solution CSV writing failed");
        }
    }
}
