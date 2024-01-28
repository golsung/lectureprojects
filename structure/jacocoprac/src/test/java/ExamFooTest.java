import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExamFooTest {
    @ParameterizedTest(name = "분기테스팅")
    @CsvSource({"9, 9, -3", "154, 9, 10", "500, 10, 0"})
    void fooBranchTest(int e, int x, int y) {
        Exam p = new Exam();
        int a = p.foo(x, y);
        assertEquals(e, a);
    }
}
