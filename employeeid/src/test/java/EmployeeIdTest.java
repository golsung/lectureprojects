import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("신택스 테스트")
class EmployeeIdTest {
    @DisplayName("유효한 id가 입력된 경우")
    @Nested
    class WhenValidIdIsEntered {
        @ParameterizedTest(name = "{0}은 유효하다")
        @CsvFileSource(resources = "/validId.csv")
        void should_ReturnTrue(String empId) {
            EmployeeId eid = new EmployeeId();
            boolean actual = eid.checkId(empId);
            assertTrue(actual);
        }
    }

    @DisplayName("유효하지 않은 id가 입력된 경우")
    @Nested
    class WhenInValidIdIsEntered {
        @ParameterizedTest(name = "{0}은 유효하지 않다")
        @CsvFileSource(resources = "/invalidid.csv")
        void should_ReturnTrue(String empId) {
            EmployeeId eid = new EmployeeId();
            boolean actual = eid.checkId(empId);
            assertFalse(actual);
        }
    }
}
