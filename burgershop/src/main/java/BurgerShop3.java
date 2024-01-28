import java.time.LocalTime;

public class BurgerShop3 {
    public int getPrice(BurgerKind burgerType, LocalTime orderTime, boolean couponApplied) {
        int totalPrice = 0;
        if (burgerType == BurgerKind.SHRIMP) totalPrice = 4000;
        if (burgerType == BurgerKind.CHICKEN) totalPrice = 4000;
        if (burgerType == BurgerKind.BEEF) totalPrice = 5000;
        LocalTime startTime = LocalTime.of(11, 0, 0);
        LocalTime endTime = LocalTime.of(13, 59, 59);
        if (orderTime.isBefore(startTime) || orderTime.isAfter(endTime)) {
            if (couponApplied) {
                totalPrice -= 1000;
                if (burgerType == BurgerKind.BEEF)
                    totalPrice -= 500; //결함
            } else
                totalPrice -= 500;
        }
        return totalPrice;
    }
}
