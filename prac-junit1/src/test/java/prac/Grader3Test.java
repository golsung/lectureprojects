package prac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import prac.Grade;
import prac.Grader;
import prac.InvalidRangeException;


class Grader3Test {

	Grader grader;

	@BeforeEach
	public void setUp() {
		grader = new Grader();	
	}

	@DisplayName("유효하지 않은 중간점수 입력")
	@Nested
	class WhenInvalidMiddleScoresAreEntered {
		@DisplayName("중간 점수가 0보다 작은 경우 InvalidRangeException 발생")
		@Test
		public void should_RaiseInvalidRangeException_ForLessThan0pts() {
			double midScore = -10;
			double finalScore = 90;
			double hwScore = 95;

			assertThrows(InvalidRangeException.class, ()->{
				grader.computeGrade(midScore, finalScore, hwScore);
			});	
		}

		@DisplayName("중간 점수가 100보다 큰 경우 InvalidRangeException 발생")
		@Test
		public void should_RaiseInvalidRangeException_ForWithMoreThan100pts() {
			double midScore = 110;
			double finalScore = 90;
			double hwScore = 70;

			assertThrows(InvalidRangeException.class, ()->{
				grader.computeGrade(midScore, finalScore, hwScore);
			});	
		}
	}

	@DisplayName("유효하지 않은 기말점수 입력")
	@Nested
	class WhenInvalidFinalScoresAreEntered {

		@DisplayName("기말 점수가 0보다 작은 경우 InvalidRangeException 발생")
		@Test
		public void should_RaiseInvalidRangeException_ForLessThan0pts() {
			double midScore = 80;
			double finalScore = -90;
			double hwScore = 95;

			assertThrows(InvalidRangeException.class, ()->{
				grader.computeGrade(midScore, finalScore, hwScore);
			});	
		}

	
		@DisplayName("기말 점수가 100보다 큰 경우 InvalidRangeException 발생")
		@Test
		public void should_RaiseInvalidRangeException_ForMoreThan100pts() {
			double midScore = 80;
			double finalScore = 120;
			double hwScore = 55;

			assertThrows(InvalidRangeException.class, ()->{
				grader.computeGrade(midScore, finalScore, hwScore);
			});	
		}
	}
	@DisplayName("유효하지 않은 과제 점수 입력")
	@Nested
	class WhenInvalidHomeworkeScoresAreEntered {

		@DisplayName("과제 점수가 0보다 작은 경우 InvalidRangeException 발생")
		@Test
		public void should_RaiseInvalidRangeException_ForLessThan0pts() {
			double midScore = 80;
			double finalScore = 90;
			double hwScore = -20;

			assertThrows(InvalidRangeException.class, ()->{
				grader.computeGrade(midScore, finalScore, hwScore);
			});	
		}

		@DisplayName("과제 점수가 100보다 큰 경우 InvalidRangeException 발생")
		@Test
		public void should_RaiseInvalidRangeException_ForMoreThan100pts() {
			double midScore = 80;
			double finalScore = 70;
			double hwScore = 150;

			assertThrows(InvalidRangeException.class, ()->{
				grader.computeGrade(midScore, finalScore, hwScore);
			});	
		}
	}

	@DisplayName("유효한 점수가 입력된 경우")
	@Nested
	class WhenValidScoresAreEntered {
		@DisplayName("총점이 90점보다 큰 경우 학점은 A")
		@Test
		public void should_GiveGradeOfA_ForStudentsWithMoreThan90pts() {
			double midScore = 92;
			double finalScore = 90;
			double hwScore = 95;


			Grade actual = grader.computeGrade(midScore, finalScore, hwScore);

			assertEquals(Grade.A, actual, "Should be A");
		}

		@DisplayName("총점이 80점보다 큰 경우 학점은 B")
		@Test
		public void should_GiveGradeOfB_ForStudentsWithMoreThan80pts() {
			double midScore = 85;
			double finalScore = 80;
			double hwScore = 90;

			Grader grader = new Grader();
			Grade actual = grader.computeGrade(midScore, finalScore, hwScore);

			assertEquals(Grade.B, actual, "Should be B");
		}

		@DisplayName("총점이 70점보다 큰 경우 학점은 C")
		@Test
		public void should_GiveGradeOfC_ForStudentsWithMoreThan70pts() {
			double midScore = 77;
			double finalScore = 70;
			double hwScore = 75;

			Grade actual = grader.computeGrade(midScore, finalScore, hwScore);

			assertEquals(Grade.C, actual, "Should be C");
		}

		@DisplayName("총점이 60점보다 큰 경우 학점은 D")
		@Test
		public void should_GiveGradeOfD_ForStudentsWithMoreThan60pts() {
			double midScore = 66;
			double finalScore = 60;
			double hwScore = 65;

			Grader grader = new Grader();
			Grade actual = grader.computeGrade(midScore, finalScore, hwScore);

			assertEquals(Grade.D, actual, "Should be D");
		}
		
		@Tag("smoke")
		@DisplayName("총점이 60점보다 작은 경우 학점은 F")
		@Test
		 void should_GiveGradeOfF_ForStudentsWithLessThan60pts() {
			double midScore = 40;
			double finalScore = 53;
			double hwScore = 35;

			Grade actual = grader.computeGrade(midScore, finalScore, hwScore);

			assertEquals(Grade.F, actual, "Should be F");
		}
	}
}
