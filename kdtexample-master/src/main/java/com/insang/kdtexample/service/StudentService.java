package com.insang.kdtexample.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insang.kdtexample.domain.Grade;
import com.insang.kdtexample.domain.Student;
import com.insang.kdtexample.repository.StudentRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public Student addStudentGrade(Student student) {
		computeGrade(student);
		Student created = studentRepository.saveAndFlush(student);
		return created;
	}

	private void computeGrade(Student student) {
		double m = student.getMidScore()*0.35;
		double f = student.getFinalScore()*0.35;
		double h = student.getHwScore()*0.3;
		
		double totalScore = m+f+h;
		
		student.setTotalScore(totalScore);
		if (totalScore>=90.0)
			student.setGrade(Grade.A);
		else if (totalScore>=80.0)
			student.setGrade(Grade.B);
		else if (totalScore>=70.0)
			student.setGrade(Grade.C);
		else if (totalScore>=60.0)
			student.setGrade(Grade.D);
		else 
			student.setGrade(Grade.F);
		
	}

	@Transactional
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Transactional
	public Student find(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		Student s;
		if (student.isPresent())
			s = student.get();
		else s = null;
			
		return s;
	}

	@Transactional
	public void deleteStudentGrade(Long id) {
		Student student = find(id);
		if (student != null)
			studentRepository.deleteById(id);
	}

	public void deleteAll() {
		studentRepository.deleteAll();
		
	}
}