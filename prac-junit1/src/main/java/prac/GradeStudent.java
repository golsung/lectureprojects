package prac;

public class GradeStudent {
	public Grade computeGrade(Student s) {     
		double m = s.getMiddleScore();
		double f = s.getFinalScore();
		double h = s.getHwScore();
			
		checkRange(m, f, h);
			
		double tot = 0.35*m + 0.35*f + 0.3*h;

		if (tot>=90.0) return Grade.A;
		else if (tot>=80.0) return Grade.B;
		else if (tot>=70) return Grade.C;
		else if (tot>=60) return Grade.D;
		else return Grade.F;
	   }

	   private void checkRange(double m, double f, double h) {
		if (m<0 || f<0 || h<0) throw new InvalidRangeException("Negative score");
		if (m>100 || f>100 || h>100) throw new InvalidRangeException("Too big score");	
	   }
}
