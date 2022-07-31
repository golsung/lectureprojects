package com.insang.kdtexample.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String major;
	
	@Min(value=0)
	@Max(value=100)
	private int midScore;
	
	@Min(value=0)
	@Max(value=100)
	private int finalScore;
	
	@Min(value=0)
	@Max(value=100)
	private int hwScore;
	
	@Min(value=0)
	@Max(value=100)
	private double totalScore;
	
	private Grade grade;

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getMidScore() {
		return midScore;
	}

	public void setMidScore(int midScore) {
		this.midScore = midScore;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	public int getHwScore() {
		return hwScore;
	}

	public void setHwScore(int hwScore) {
		this.hwScore = hwScore;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
}

