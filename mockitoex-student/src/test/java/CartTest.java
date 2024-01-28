import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CartTest {
    @DisplayName("단품 구매")
    @Test
    public void testTotalPrice1() {
        Cart ct = new Cart();
        PriceManager pm = mock(PriceManager.class);

        when(pm.getPrice("1234")).thenReturn(1000);
        when(pm.getPrice("7896")).thenReturn(800);
        ct.setPriceManager(pm);
        ct.put("1234");
        ct.put("7896");
        int total = ct.totalPrice();
        assertEquals(1800, total);
    }


//
//    @DisplayName("2+1 할인")
//    @Test
//    public void testTotalPriceForOnePlusOneItems() {
//
//        Cart ct = new Cart();
//        PriceManager pm = mock(PriceManager.class);
//        when(pm.getPrice("1234")).thenReturn(1000);
//        when(pm.getPrice("4567")).thenReturn(2500);
//        when(pm.getPrice("7890")).thenReturn(800);
//        when(pm.getPrice("5678")).thenReturn(500);
//        when(pm.isTwoPlusOneApplicable("1234")).thenReturn(true);
//        when(pm.isTwoPlusOneApplicable("4567")).thenReturn(true);
//        when(pm.isTwoPlusOneApplicable("7890")).thenReturn(true);
//        when(pm.isTwoPlusOneApplicable("5678")).thenReturn(false);
//        ct.setPriceManager(pm);
//        ct.put("1234");
//        ct.put("1234");
//        ct.put("1234");
//        ct.put("4567");
//        ct.put("4567");
//        ct.put("4567");
//        ct.put("7890");
//        ct.put("5678");
//        ct.put("5678");
//        ct.put("5678");
//        int total = ct.totalPrice();
//        assertEquals(9300, total);
//    }
}
