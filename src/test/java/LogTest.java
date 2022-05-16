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

public class LogTest {

    static double functionEps = 0.1;
    static double eps = 0.1;

    static Sin sinMock;
    static Cot cotMock;
    static Ln lnMock;

    static Reader cotIn;
    static Reader sinIn;
    static Reader lnIn;

    @BeforeAll
    static void init() {
        sinMock = Mockito.mock(Sin.class);
        cotMock = Mockito.mock(Cot.class);
        lnMock = Mockito.mock(Ln.class);

        try {
            cotIn = new FileReader("src/main/resources/Inputs/CotIn.csv");
            sinIn = new FileReader("src/main/resources/Inputs/SinIn.csv");
            lnIn = new FileReader("src/main/resources/Inputs/LnIn.csv");

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(cotIn);

            records = CSVFormat.DEFAULT.parse(cotIn);
            for (CSVRecord record : records) {
                Mockito.when(cotMock.cot(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(sinIn);
            for (CSVRecord record : records) {
                Mockito.when(sinMock.sin(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(lnIn);
            for (CSVRecord record : records) {
                Mockito.when(lnMock.ln(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
        } catch (IOException ex) {}

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/SystemIn.csv")
    void testLog(double value, double expected) {
        FuncSystem f = new FuncSystem(sinMock, cotMock, new Log(lnMock), lnMock);
        Assertions.assertEquals(expected, f.solve(value, functionEps), eps);
    }

}
