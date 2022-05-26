package com.practice.springboot.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.springboot.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course,Serializable>{
	
}
