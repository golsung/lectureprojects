package prac;

public class Student {
	private final String name;
	private final double middleScore;
	private final double finalScore;
	private final double hwScore;

	public Student(String name, double middleScore, double finalScore, double hwScore) {
		this.name = name;
		this.middleScore = middleScore;
		this.finalScore = finalScore;
		this.hwScore = hwScore;
	}

	public String toString() {
		return "이름: " + name + " " + "중간점수: " + middleScore + " 기말점수: " + finalScore + " 과제점수: " + hwScore;
	}

	public double getMiddleScore() {
		return middleScore;
	}

	public double getFinalScore() {
		return finalScore;
	}

	public double getHwScore() {
		return hwScore;
	}
}
