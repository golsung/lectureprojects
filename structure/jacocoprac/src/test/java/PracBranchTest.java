import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PracBranchTest {
    @ParameterizedTest(name = "분기테스팅")
    @CsvSource({"0, 70, 30, FAIL", "50, 70, 30, PASS"})
    void fooTest(int e, int x, int y, C3Score s) {
        Prac p = new Prac();
        int a = p.foo(x, y, s);
        assertEquals(e, a);
    }
}