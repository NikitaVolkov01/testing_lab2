import lab2math.FuncSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class FuncSystemTest {

    static double functionEps = 0.1;
    static double eps = 0.1;

    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/SystemIn.csv")
    void testFuncSystem(double value, double expected) {
        FuncSystem f = new FuncSystem();
        Assertions.assertEquals(expected, f.solve(value, functionEps), eps);
    }
}
