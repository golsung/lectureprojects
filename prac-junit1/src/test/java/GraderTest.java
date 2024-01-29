import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraderTest {


    @Test
    public void should_GiveGradeOfB_ForStudentsWithMoreThan80pts() {
        double midScore = 85;
        double finalScore = 85;
        double hwScore = 90;

        Grader1 grader = new Grader1();
        Grade actual = grader.computeGrade(midScore, finalScore, hwScore);

        assertEquals(Grade.B, actual, "Should be B");
    }


}
