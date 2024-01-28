package prac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import prac.Grade;
import prac.Grader;

import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(Lifecycle.PER_CLASS)     
class Grader2Test {

	   double midScore;
	   double finalScore;     
	   double hwScore;


	   @Test                  
	   public void should_GiveGradeOfA_ForStudentsWithMoreThan90pts() {
		    midScore = 92;
		    finalScore = 90;
		    hwScore = 95;
			
		    Grader grader = new Grader();
		    Grade actual = grader.computeGrade(midScore, finalScore, hwScore);
			
		    assertEquals(Grade.A, actual, "Should be A");
	   }
		
	   @Test          
	   public void should_GiveGradeOfB_ForStudentsWithMoreThan80pts() {
		    midScore = 60;
			
		    Grader grader = new Grader();
		    Grade actual = grader.computeGrade(midScore, finalScore, hwScore);
			
		    assertEquals(Grade.B, actual, "Should be B");
	   }
		
	   @Test
	   @Order(3)                     
	   public void should_GiveGradeOfC_ForStudentsWithMoreThan70pts() {
		    midScore = 50;
			
		    Grader grader = new Grader();
		    Grade actual = grader.computeGrade(midScore, finalScore, hwScore);
			
		    assertEquals(Grade.C, actual, "Should be C");
	   }
		
	   @Test             
	   public void should_GiveGradeOfD_ForStudentsWithMoreThan60pts() {
		   midScore = 45;
	           finalScore = 60;
			
	           Grader grader = new Grader();
		   Grade actual = grader.computeGrade(midScore, finalScore, hwScore);
			
		   assertEquals(Grade.D, actual, "Should be D");
	   }
		
	   @Test                  
	   public void should_GiveGradeOfF_ForStudentsWithLessThan60pts() {
		    hwScore = 30;
		    finalScore = 53;

		    Grader grader = new Grader();
		    Grade actual = grader.computeGrade(midScore, finalScore, hwScore);
			
		    assertEquals(Grade.F, actual, "Should be F");
	   }

}
