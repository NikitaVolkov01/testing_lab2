import lab2math.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;

import static java.lang.Double.*;

public class Supporting {


    double log_func(double x){
        return Math.pow ( (Math.log10(x) - Math.log(x)) / (Math.log(x)/Math.log(5)) + Math.log(x)/Math.log(2) , 6);
    }

    double trig_func(double x) {
        return Math.cos(x) / Math.sin(x) + Math.sin(x);
    }


    /* Ничего не проверяют, просто заполняют файлы с ожидаемыми значениями */

    @Test
    void fillSolutionSystem() throws IOException {
        Writer out = new FileWriter("src/main/resources/Inputs/SystemIn.csv");
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {

            printer.printRecord(0, NaN);
            printer.printRecord(-Math.PI/6, trig_func(-Math.PI/6));
            printer.printRecord(-Math.PI/4, trig_func(-Math.PI/4));
            printer.printRecord(-Math.PI/3, trig_func(-Math.PI/3));
            printer.printRecord(-Math.PI/2, trig_func(-Math.PI/2));

            printer.printRecord(-2*Math.PI, NaN);
            printer.printRecord(-Math.PI/6 - 2*Math.PI, trig_func(-Math.PI/6 - 2*Math.PI));
            printer.printRecord(-Math.PI/4 - 2*Math.PI, trig_func(-Math.PI/4 - 2*Math.PI));
            printer.printRecord(-Math.PI/3 - 2*Math.PI, trig_func(-Math.PI/3 - 2*Math.PI));
            printer.printRecord(-Math.PI/2 - 2*Math.PI, trig_func(-Math.PI/2 - 2*Math.PI));

            printer.printRecord(-4*Math.PI, NaN);
            printer.printRecord(-Math.PI/6 - 4*Math.PI, trig_func(-Math.PI/6 - 4*Math.PI));
            printer.printRecord(-Math.PI/4 - 4*Math.PI, trig_func(-Math.PI/4 - 4*Math.PI));
            printer.printRecord(-Math.PI/3 - 4*Math.PI, trig_func(-Math.PI/3 - 4*Math.PI));
            printer.printRecord(-Math.PI/2 - 4*Math.PI, trig_func(-Math.PI/2 - 4*Math.PI));

            printer.printRecord(NEGATIVE_INFINITY, NaN);
            printer.printRecord(NaN, NaN);

            printer.printRecord(0.25, log_func(0.25));
            printer.printRecord(0.6, log_func(0.6));
            printer.printRecord(1, log_func(1));
            printer.printRecord(1.5, log_func(1.5));
            printer.printRecord(3.0, log_func(3.0));
            printer.printRecord(10.0, log_func(10.0));
            printer.printRecord(100, log_func(100));
            printer.printRecord(123, log_func(123));
            printer.printRecord(777, log_func(777));

            printer.printRecord(POSITIVE_INFINITY, NaN);

        } catch (IOException e) {
            System.out.println("System solution CSV writing failed");
        }
    }

    @Test
    void fillSolutionSin() throws IOException {
        Writer out = new FileWriter("src/main/resources/Inputs/SinIn.csv");
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(0, 0);

            printer.printRecord(-Math.PI/6, -0.5);
            printer.printRecord(-Math.PI/4, -Math.sqrt(2)/2);
            printer.printRecord(-Math.PI/3, -Math.sqrt(3)/2);
            printer.printRecord(-Math.PI/2, -1);

            printer.printRecord(-Math.PI/6 - 2*Math.PI, -0.5);
            printer.printRecord(-Math.PI/4 - 2*Math.PI, -Math.sqrt(2)/2);
            printer.printRecord(-Math.PI/3 - 2*Math.PI, -Math.sqrt(3)/2);
            printer.printRecord(-Math.PI/2 - 2*Math.PI, -1);

            printer.printRecord(-Math.PI/6 - 4*Math.PI, -0.5);
            printer.printRecord(-Math.PI/4 - 4*Math.PI, -Math.sqrt(2)/2);
            printer.printRecord(-Math.PI/3 - 4*Math.PI, -Math.sqrt(3)/2);
            printer.printRecord(-Math.PI/2 - 4*Math.PI, -1);

            printer.printRecord(NEGATIVE_INFINITY, NaN);
            printer.printRecord(NaN, NaN);
        } catch (IOException e) {
            System.out.println("Sin solution CSV writing failed");
        }
    }

    @Test
    void fillSolutionCos() throws IOException {
        Writer out = new FileWriter("src/main/resources/Inputs/CosIn.csv");
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(0, 1);

            printer.printRecord(-Math.PI/6, Math.sqrt(3)/2);
            printer.printRecord(-Math.PI/4, Math.sqrt(2)/2);
            printer.printRecord(-Math.PI/3, 0.5);
            printer.printRecord(-Math.PI/2, 0);

            printer.printRecord(-Math.PI/6 - 2*Math.PI, Math.sqrt(3)/2);
            printer.printRecord(-Math.PI/4 - 2*Math.PI, Math.sqrt(2)/2);
            printer.printRecord(-Math.PI/3 - 2*Math.PI, 0.5);
            printer.printRecord(-Math.PI/2 - 2*Math.PI, 0);

            printer.printRecord(-Math.PI/6 - 4*Math.PI, Math.sqrt(3)/2);
            printer.printRecord(-Math.PI/4 - 4*Math.PI, Math.sqrt(2)/2);
            printer.printRecord(-Math.PI/3 - 4*Math.PI, 0.5);
            printer.printRecord(-Math.PI/2 - 4*Math.PI, 0);

            printer.printRecord(NEGATIVE_INFINITY, NaN);
            printer.printRecord(NaN, NaN);
        } catch (IOException e) {
            System.out.println("Cos solution CSV writing failed");
        }
    }

    @Test
    void fillSolutionCot() throws IOException {
        Writer out = new FileWriter("src/main/resources/Inputs/CotIn.csv");
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(0, NaN);

            printer.printRecord(-Math.PI/6, Math.cos(-Math.PI/6)/Math.sin(-Math.PI/6));
            printer.printRecord(-Math.PI/4, Math.cos(-Math.PI/4)/Math.sin(-Math.PI/4));
            printer.printRecord(-Math.PI/3, Math.cos(-Math.PI/3)/Math.sin(-Math.PI/3));
            printer.printRecord(-Math.PI/2, Math.cos(-Math.PI/2)/Math.sin(-Math.PI/2));

            printer.printRecord(0 - 2*Math.PI, NaN);
            printer.printRecord(-Math.PI/6 - 2*Math.PI, Math.cos(-Math.PI/6)/Math.sin(-Math.PI/6));
            printer.printRecord(-Math.PI/4 - 2*Math.PI, Math.cos(-Math.PI/4)/Math.sin(-Math.PI/4));
            printer.printRecord(-Math.PI/3 - 2*Math.PI, Math.cos(-Math.PI/3)/Math.sin(-Math.PI/3));
            printer.printRecord(-Math.PI/2 - 2*Math.PI, Math.cos(-Math.PI/2)/Math.sin(-Math.PI/2));

            printer.printRecord(0 - 4*Math.PI, NaN);
            printer.printRecord(-Math.PI/6 - 4*Math.PI, Math.cos(-Math.PI/6)/Math.sin(-Math.PI/6));
            printer.printRecord(-Math.PI/4 - 4*Math.PI, Math.cos(-Math.PI/4)/Math.sin(-Math.PI/4));
            printer.printRecord(-Math.PI/3 - 4*Math.PI, Math.cos(-Math.PI/3)/Math.sin(-Math.PI/3));
            printer.printRecord(-Math.PI/2 - 4*Math.PI, Math.cos(-Math.PI/2)/Math.sin(-Math.PI/2));

            printer.printRecord(NEGATIVE_INFINITY, NaN);
            printer.printRecord(NaN, NaN);
        } catch (IOException e) {
            System.out.println("Cot solution CSV writing failed");
        }
    }

    @Test
    void fillSolutionLn() throws IOException {
        Writer out = new FileWriter("src/main/resources/Inputs/LnIn.csv");
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {

            printer.printRecord(0.0625, Math.log(0.0625));
            printer.printRecord(0.25, Math.log(0.25));
            printer.printRecord(0.6, Math.log(0.6));
            printer.printRecord(1, Math.log(1));
            printer.printRecord(1.5, Math.log(1.5));
            printer.printRecord(2, Math.log(2));
            printer.printRecord(3, Math.log(3));
            printer.printRecord(5, Math.log(5));
            printer.printRecord(10, Math.log(10));
            printer.printRecord(100, Math.log(100));
            printer.printRecord(123, Math.log(123));
            printer.printRecord(777, Math.log(777));

            printer.printRecord(POSITIVE_INFINITY, NaN);
            printer.printRecord(NaN, NaN);
        } catch (IOException e) {
            System.out.println("Ln solution CSV writing failed");
        }
    }

    @Test
    void fillSolutionLog2() throws IOException {
        Writer out = new FileWriter("src/main/resources/Inputs/Log2In.csv");
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {

            printer.printRecord(0.0625, Math.log(0.0625)/Math.log(2));
            printer.printRecord(0.25, Math.log(0.25)/Math.log(2));
            printer.printRecord(0.6, Math.log(0.6)/Math.log(2));
            printer.printRecord(1, Math.log(1)/Math.log(2));
            printer.printRecord(1.5, Math.log(1.5)/Math.log(2));
            printer.printRecord(2, Math.log(2)/Math.log(2));
            printer.printRecord(3, Math.log(3)/Math.log(2));
            printer.printRecord(5, Math.log(5)/Math.log(2));
            printer.printRecord(10, Math.log(10)/Math.log(2));
            printer.printRecord(100, Math.log(100)/Math.log(2));
            printer.printRecord(123, Math.log(123)/Math.log(2));
            printer.printRecord(777, Math.log(777)/Math.log(2));

            printer.printRecord(POSITIVE_INFINITY, NaN);
            printer.printRecord(NaN, NaN);
        } catch (IOException e) {
            System.out.println("Log2 solution CSV writing failed");
        }
    }

    @Test
    void fillSolutionLog5() throws IOException {
        Writer out = new FileWriter("src/main/resources/Inputs/Log5In.csv");
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {

            printer.printRecord(0.0625, Math.log(0.0625)/Math.log(5));
            printer.printRecord(0.25, Math.log(0.25)/Math.log(5));
            printer.printRecord(0.6, Math.log(0.6)/Math.log(5));
            printer.printRecord(1, Math.log(1)/Math.log(5));
            printer.printRecord(1.5, Math.log(1.5)/Math.log(5));
            printer.printRecord(2, Math.log(2)/Math.log(5));
            printer.printRecord(3, Math.log(3)/Math.log(5));
            printer.printRecord(5, Math.log(5)/Math.log(5));
            printer.printRecord(10, Math.log(10)/Math.log(5));
            printer.printRecord(100, Math.log(100)/Math.log(5));
            printer.printRecord(123, Math.log(123)/Math.log(5));
            printer.printRecord(777, Math.log(777)/Math.log(5));

            printer.printRecord(POSITIVE_INFINITY, NaN);
            printer.printRecord(NaN, NaN);
        } catch (IOException e) {
            System.out.println("Log5 solution CSV writing failed");
        }
    }

    @Test
    void fillSolutionLog10() throws IOException {
        Writer out = new FileWriter("src/main/resources/Inputs/Log10In.csv");
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {

            printer.printRecord(0.0625, Math.log(0.0625)/Math.log(10));
            printer.printRecord(0.25, Math.log(0.25)/Math.log(10));
            printer.printRecord(0.6, Math.log(0.6)/Math.log(10));
            printer.printRecord(1, Math.log(1)/Math.log(10));
            printer.printRecord(1.5, Math.log(1.5)/Math.log(10));
            printer.printRecord(2, Math.log(2)/Math.log(10));
            printer.printRecord(3, Math.log(3)/Math.log(10));
            printer.printRecord(5, Math.log(5)/Math.log(10));
            printer.printRecord(10, Math.log(10)/Math.log(10));
            printer.printRecord(100, Math.log(100)/Math.log(10));
            printer.printRecord(123, Math.log(123)/Math.log(10));
            printer.printRecord(777, Math.log(777)/Math.log(10));

            printer.printRecord(POSITIVE_INFINITY, NaN);
            printer.printRecord(NaN, NaN);
        } catch (IOException e) {
            System.out.println("Log10 solution CSV writing failed");
        }
    }

    /* Тут можно напечатать в CSV файл данные в нужном диапазоне и потом в Excel вставить - графики четкие будут */
    @Test
    void printStats() throws IOException {

        double a = -4;
        double b = 10;
        double c = 0.5;
        double eps = 0.01;

        FuncSystem f = new FuncSystem();
        Writer out = new FileWriter("src/main/resources/Outputs/OUT.csv");
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {

            for (double x = a; x < b; x += c) {
                printer.printRecord(x, f.solve(x, eps));
            }

            printer.printRecord(NaN, NaN);
        } catch (IOException e) {
            System.out.println("System solution CSV writing failed");
        }
    }

}
