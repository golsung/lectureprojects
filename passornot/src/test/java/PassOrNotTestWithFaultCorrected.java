import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("성적 평가 테스트") class PassOrNotTestWithFaultCorrected {
    @Nested
    @DisplayName("입력된 성적이 유효한 경우")
    class WhenValidScoresAreEntered {
        @ParameterizedTest(name="A 과목 성적 {1}과 B 과목 성적 {2}은 {0}이다")
        @CsvSource({"통과, 70, 60", "과락, 30, 40", "실패, 55, 60"})
        void should_GivePassOrFail(String expected, int score1, int score2) {
            PassOrNotWithFault p = new PassOrNotWithFault();
            String actual = p.ckScore(score1, score2);
            assertEquals(expected, actual);
        } }
    @Nested
    @DisplayName("입력된 성적이 유효하지 않은 경우")
    class WhenInvalidScoresAreEntered {
        @ParameterizedTest(name="A 과목 성적 {0} 또는 B 과목 성적 {1}이 유효하지 못하다")
        @CsvSource({"-10, 60", "60, -30", "150, 60", "60, 110"})
        void should_ThrowInvalidRangeException(int score1, int score2) { assertThrows(InvalidRangeException.class,
                ()->{
                    PassOrNotWithFault p = new PassOrNotWithFault();
                    String actual = p.ckScore(score1, score2);
                }); }
    } }