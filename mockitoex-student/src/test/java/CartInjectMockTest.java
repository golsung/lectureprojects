import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class CartInjectMockTest {
    @Mock
    PriceManager pm;

    @InjectMocks
    Cart ct;

    @DisplayName("단품 구매")
    @Test
    public void testTotalPrice1() {
//        Cart ct = new Cart();
//        PriceManager pm = mock(PriceManager.class);
        initMocks(this);
        when(pm.getPrice("1234")).thenReturn(1000);
        when(pm.getPrice("7896")).thenReturn(800);
     //    ct.setPriceManager(pm);
        ct.put("1234");
        ct.put("7896");
        int total = ct.totalPrice();
        assertEquals(1800, total);
    }

}
