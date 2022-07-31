package prac;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("CsvSource를 이용한 테스트")
class GraderCsvSourceInvalidTest {

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

	   @DisplayName("유효하지 못한 입력")
	   @Nested
	   class WhenInvalidScoresAreEntered {
		   @DisplayName("ArgumentsSource를 이용한 유효하지 못한 입력")
		   @ParameterizedTest(name="중간 점수 {1}, 기말 점수 {2}, 과제 {3}에 대해 InvalidRangeException 발생해야 한다")
		   @CsvSource({"-10,90,95", "110,80,90", "77,-20,75","66,105,65", "20, 30, -5", "50, 40, 101"})
		   public void should_RaiseInvalidRangeException(double m, double f, double h) {
			   assertThrows(InvalidRangeException.class, ()->{
				   grader.computeGrade(m, f, h);
			   });
		   }
	   }
}
