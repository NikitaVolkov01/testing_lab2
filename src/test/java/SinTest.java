import lab2math.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class SinTest {

    static double functionEps = 0.1;
    static double eps = 0.1;

    static Ln lnMock;
    static Log logMock;

    static Reader lnIn;
    static Reader log2In;
    static Reader log5In;
    static Reader log10In;

    @BeforeAll
    static void init() {
        lnMock = Mockito.mock(Ln.class);
        logMock = Mockito.mock(Log.class);

        try {
            lnIn = new FileReader("src/main/resources/Inputs/LnIn.csv");
            log2In = new FileReader("src/main/resources/Inputs/Log2In.csv");
            log5In = new FileReader("src/main/resources/Inputs/Log5In.csv");
            log10In = new FileReader("src/main/resources/Inputs/Log10In.csv");

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(lnIn);

            records = CSVFormat.DEFAULT.parse(lnIn);
            for (CSVRecord record : records) {
                Mockito.when(lnMock.ln(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log2In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(2, Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log5In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(5, Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log10In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(10, Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
        } catch (IOException ex) {}

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/SystemIn.csv")
    void testSin(double value, double expected) {
        FuncSystem f = new FuncSystem(new Sin(), new Cot(new Cos(new Sin()), new Sin()), logMock, lnMock);
        Assertions.assertEquals(expected, f.solve(value, functionEps), eps);
    }
}
