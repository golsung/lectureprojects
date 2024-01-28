import java.time.LocalTime;

public class BurgerShop1 {
    public int getPrice(BurgerKind bugerType, LocalTime orderTime, boolean couponApplied) {
        int totalPrice = 0;
        if (bugerType == BurgerKind.SHRIMP) totalPrice = 4000;
        if (bugerType == BurgerKind.CHICKEN) totalPrice = 4000;
        if (bugerType == BurgerKind.BEEF) totalPrice = 5000;
        LocalTime startTime = LocalTime.of(11, 0, 0);
        LocalTime endTime = LocalTime.of(13, 59, 59);
        if (orderTime.isBefore(startTime) || orderTime.isAfter(endTime)) totalPrice -= 500;
        if (couponApplied) totalPrice -= 1000;
        return totalPrice;
    }
}
