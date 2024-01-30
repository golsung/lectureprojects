public class Grader2Test {
    @DisplayName("총점이 90점이상이면 A")
    @Test
    public void should_GiveGradeOfA_ForStudentsWithMoreThan90pts() {
        double midScore = 92;
        double finalScore = 90;
        double hwScore = 95;

        Grader grader = new Grader();
        Grade actual = grader.computeGrade(midScore, finalScore, hwScore);

        assertEquals(Grade.A, actual, "Should be A");
    }

    @DisplayName("총점이 80점이상 90점 미만 B")
    @Test
    public void should_GiveGradeOfB_ForStudentsWithMoreThan80pts() {
        double midScore = 85;
        double finalScore = 80;
        double hwScore = 90;

        Grader grader = new Grader();
        Grade actual = grader.computeGrade(midScore, finalScore, hwScore);

        assertEquals(Grade.B, actual, "Should be B");
    }

    @DisplayName("총점이 70점이상 80점 미만 C")
    @Test
    public void should_GiveGradeOfC_ForStudentsWithMoreThan70pts() {
        double midScore = 77;
        double finalScore = 70;
        double hwScore = 75;

        Grader grader = new Grader();
        Grade actual = grader.computeGrade(midScore, finalScore, hwScore);

        assertEquals(Grade.C, actual, "Should be C");
    }

    @DisplayName("총점이 60점이상 70점 미만 D")
    @Test
    public void should_GiveGradeOfD_ForStudentsWithMoreThan60pts() {
        double midScore = 66;
        double finalScore = 60;
        double hwScore = 65;

        Grader grader = new Grader();
        Grade actual = grader.computeGrade(midScore, finalScore, hwScore);

        assertEquals(Grade.D, actual, "Should be D");
    }

    @DisplayName("총점이 60점미만 F")
    @Test
    public void should_GiveGradeOfF_ForStudentsWithLessThan60pts() {
        double midScore = 40;
        double finalScore = 53;
        double hwScore = 35;

        Grader grader = new Grader();
        Grade actual = grader.computeGrade(midScore, finalScore, hwScore);

        assertEquals(Grade.F, actual, "Should be F");
    }
}
