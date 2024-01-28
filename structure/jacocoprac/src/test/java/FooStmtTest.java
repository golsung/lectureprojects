import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FooStmtTest {
    @ParameterizedTest(name = "문장테스팅")
    @CsvSource({"100, 20, 15"})
    void fooStmtTest(int e, int x, int y) {
        Foo p = new Foo();
        int a = p.foo(x, y);
        assertEquals(e, a);
    }

    @ParameterizedTest(name = "instruction 테스팅")
    @CsvSource({"100, 20, 15", "0, 5, 5"})
    void fooInstructionTest(int e, int x, int y) {
        Foo p = new Foo();
        int a = p.foo(x, y);
        assertEquals(e, a);
    }
}