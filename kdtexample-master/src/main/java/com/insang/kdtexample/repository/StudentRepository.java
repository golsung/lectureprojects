package com.insang.kdtexample.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insang.kdtexample.domain.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	public Optional<Student> findById(String id);
}