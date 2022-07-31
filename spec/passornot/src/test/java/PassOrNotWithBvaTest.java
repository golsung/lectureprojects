import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("BVA 테스트")
class PassOrNotWithBVATest {
    @Nested
    @DisplayName("통과한 경우")
    class WhenPassed {
        @ParameterizedTest(name = "A 과목 성적 {0}과 B 과목 성적 {1}은 통과이다")
        @CsvSource({"99, 60", "100, 60", "60, 100", "60, 60"})
        void should_Pass(int score1, int score2) {
            PassOrNot p = new PassOrNot();
            String actual = p.ckScore(score1, score2);
            assertEquals("통과", actual);
        }
        @Nested
        @DisplayName("실패한 경우")
        class WhenFailed {
            @ParameterizedTest(name="A 과목 성적 {0}과 B 과목 성적 {1}은 실패이다")
            @CsvSource({"50, 60", "60, 50", "60, 59"})
            void should_Fail(int score1, int score2) {
                PassOrNot p = new PassOrNot();
                String actual = p.ckScore(score1, score2);
                assertEquals("실패", actual);
            }
        }

        @Nested @DisplayName("과락한 경우")
        class WhenMissedCutScore {
            @ParameterizedTest(name="A 과목 성적 {0}과 B 과목 성적 {1}은 과락이다")
            @CsvSource({"0, 60", "60, 0", "49, 60", "60, 49"})
            void should_FailACourse(int score1, int score2) {
                PassOrNot p = new PassOrNot();
                String actual = p.ckScore(score1, score2);
                assertEquals("과락", actual);
            }
        }

        @ParameterizedTest(name = "A 과목 성적 {0} 또는 B 과목 성적 {1}이 유효하지 못하다")
        @CsvSource({"-1, 60", "60, -1", "60, 101"})
        void should_ThrowInvalidRangeException(int score1, int score2) {
            assertThrows(InvalidRangeException.class, () -> {
                PassOrNot p = new PassOrNot();
                String actual = p.ckScore(score1, score2);
            });
        }
    }
}