import org.junit.jupiter.api.*;

public class ExampleTest {
    @BeforeEach
    void testA(TestInfo info) {
        System.out.print("A");
    }

    @Test
    void testB() {
        System.out.print("B");
    }

    @BeforeAll
    static void testC() {
        System.out.print("C");
    }

    @AfterEach
    void testD() {
        System.out.print("D");
    }

    @AfterAll
    static void testE() {
        System.out.print("E");
    }

    @Test
    void testG() {
        System.out.print("F");
    }
}
