package prac;

public class Student {
	private String name;
	   private double middleScore;
	   private double finalScore;
	   private double hwScore;
		
	   public Student(String name, double middleScore, double finalScore, double hwScore) {
		this.name = name;
		this.middleScore = middleScore;
		this.finalScore = finalScore;
		this.hwScore = hwScore;
	   }
		
	   public String toString() {   
		return "중간점수: "+middleScore+" 기말점수: "+finalScore+" 과제점수: "+hwScore;
	   }
	   public double getMiddleScore() { return middleScore; }
	   public double getFinalScore() { return finalScore; }
	   public double getHwScore() { return hwScore; }
}
