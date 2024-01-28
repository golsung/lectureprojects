import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChargerTest {
    @ParameterizedTest(name = "문장테스팅")
    @CsvSource({"44000, 180", "63000, 400"})
    void fooTest(int e, int x) {
        Charger p = new Charger();
        int a = p.phone_charge(x);
        assertEquals(e, a);
    }
}
