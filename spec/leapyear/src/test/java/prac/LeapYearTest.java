package prac;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("윤년 테스트")
class LeapYearTest {
    @Nested
    @DisplayName("윤년인 경우 테스트")
    class WhenYearIsLeap {
        @ParameterizedTest(name = "{1}년은 윤년이다")
        @CsvSource({"LEAP, 1600", "LEAP, 2016", "LEAP, 2000"})
        void should_BeLeapYear(LeapValues expected, int year) {
            LeapYear leap = new LeapYear();
            LeapValues actual = leap.ckLeap(year);
            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("윤년이 아닌 경우 테스트")
    class WhenYearIsNotLeap {
        @ParameterizedTest(name = "{1}년은 윤년이 아니다")
        @CsvSource({"NO_LEAP, 2002", "NO_LEAP, 2001", "NO_LEAP, 2200"})
        void should_NotBeLeapYear(LeapValues expected, int year) {
            LeapYear leap = new LeapYear();
            LeapValues actual = leap.ckLeap(year);
            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("범위가 벗어난 년도가 입력된 경우 테스트")
    class WhenInvalidYearIsEntered {
        @ParameterizedTest(name = "{0}은 범위가 벗어났다")
        @ValueSource(ints = {-2000, 12000, 0, 10010})
        void should_ThrowInvalidRangeException(int year) {
            assertThrows(InvalidRangeException.class, () -> {
                LeapYear leap = new LeapYear();
                leap.ckLeap(year);
            });
        }
    }
}