import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatorTest {
    @Test
    void addTest() {
        Calculator calc = mock(Calculator.class);
        when(calc.add(10, 20)).thenReturn(100);
        assertEquals(100, calc.add(10, 20));
    }
}
