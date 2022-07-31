package prac;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@TestMethodOrder(Alphanumeric.class)
class GraderExceptionTest {

	@DisplayName("중간 점수가 0보다 작은 경우 InvalidRangeException 발생")
	@Test
	public void should_RaiseInvalidRangeException_ForLessThan0pts() {
		double midScore = -10;
		double finalScore = 90;
		double hwScore = 95;
		Grader grader = new Grader();
		assertThrows(InvalidRangeException.class, ()->{
			grader.computeGrade(midScore, finalScore, hwScore);
		});
	}
}

