package prac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("CsvSource와 ArgumentProvider를 이용한 테스트")
class Grader4Test {

	Grader grader;

	   @BeforeEach
	   public void setUp() {
		grader = new Grader();	
	   }
		
	   @DisplayName("유효한 입력을 입력")
	   @Nested
	   class WhenValidScoresAreEntered {

		   @DisplayName("Csv source 유효한 입력")
		   @ParameterizedTest        
		   @CsvSource({"A,92,90,95", "B,85,80,90", "C,77,70,75","D,66,60,65", "F,40,53,35"}) 
		   public void should_ComputeGrade(Grade e, double m, double f, double h) {
			   Grade actual = grader.computeGrade(m, f, h);
			   assertEquals(e, actual);
		   }

	   }

	   @DisplayName("유효하지 못한 입력")
	   @Nested
	   class WhenInvalidScoresAreEntered {		
		   @DisplayName("ArgumentsSource를 이용한 유혀하지 못한 입력")
		   @ParameterizedTest      
		   @ArgumentsSource(MyArgumentsProvier.class)  
		   public void should_RaiseInvalidRangeException(double m, double f, double h) {
			   assertThrows(InvalidRangeException.class, ()->{
				   grader.computeGrade(m, f, h);
			   });	
		   }
	   }
}
