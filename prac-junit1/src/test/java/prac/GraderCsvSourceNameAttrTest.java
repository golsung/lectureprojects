package prac;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("CsvSource를 이용한 테스트")
class GraderCsvSourceNameAttrTest {

	Grader grader;

	   @BeforeEach
	   public void setUp() {
		grader = new Grader();
	   }

	   @DisplayName("유효한 입력을 입력")
	   @Nested
	   class WhenValidScoresAreEntered {

		   @DisplayName("Csv source 유효한 입력")
		   @ParameterizedTest(name="중간 점수 {1}, 기말 점수 {2}, 과제 {3}에 대해 {0} 학점이 이어야 한다")
		   @CsvSource({"A,92,90,95", "B,85,80,90", "C,77,70,75","D,66,60,65", "F,40,53,35"})
		   public void should_ComputeGrade(Grade e, double m, double f, double h) {
			   Grade actual = grader.computeGrade(m, f, h);
			   assertEquals(e, actual);
		   }

	   }
}
