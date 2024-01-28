import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("버거 주문 테스트")
class BurgerShop3WithPairwiseTest {
    @DisplayName("Each choice 테스트")
    @ParameterizedTest(name = "버거 종류: {1} 주문 시간: {2} 쿠폰 적용: {3} 주문에 대하여 가격은 {0}이어야 한다")
    @MethodSource("genBurgerOrderWithPairwise")
    void shoud_GiveDiscount_ForNonPeakTimeOrder(int expected, BurgerKind burgerType, LocalTime orderTime, boolean couponApplied) {
        BurgerShop3 shop = new BurgerShop3();
        int actual = shop.getPrice(burgerType, orderTime, couponApplied);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> genBurgerOrderWithPairwise() {
        return Stream.of(
                Arguments.of(3000, BurgerKind.SHRIMP, LocalTime.of(10, 30, 32), true),
                Arguments.of(4000, BurgerKind.SHRIMP, LocalTime.of(12, 20, 15), false),
                Arguments.of(3000, BurgerKind.CHICKEN, LocalTime.of(17, 5, 55), true),
                Arguments.of(4000, BurgerKind.CHICKEN, LocalTime.of(11, 15, 20), false),
                Arguments.of(4500, BurgerKind.BEEF, LocalTime.of(14, 0, 33), false),
                Arguments.of(5000, BurgerKind.BEEF, LocalTime.of(13, 40, 55), true)
                );
    }
}

