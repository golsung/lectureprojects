import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {
    @Test
    public void testAddMoney() {
        Money money1 = new Money(50);
        Money money2 = new Money(30);
        Money sum = money1.add(money2);
        assertEquals(80, sum.getValue());
        assertEquals(50, money1.getValue());
        assertEquals(30, money2.getValue());


    }
}
