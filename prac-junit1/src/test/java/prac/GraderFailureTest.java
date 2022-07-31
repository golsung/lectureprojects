package prac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GraderFailureTest {

	@Test
	public void should_GiveGradeOfB_ForStudentsWithMoreThan80pts() {
		double midScore = 85;
		double finalScore = 85;
		double hwScore = 90;

		Grader grader = new Grader();
		Grade actual = grader.computeGrade(midScore, finalScore, hwScore);

		assertEquals(Grade.B, actual, "Should be B");
	}

}

