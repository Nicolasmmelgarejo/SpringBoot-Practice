package com.practice.springboot.service;

import java.util.List;

import com.practice.springboot.entity.Course;
import com.practice.springboot.model.CourseModel;

public interface CourseService {
	
	public abstract List<Course> listAllCourse();
		
	public abstract Course addCourse(CourseModel courseModel);
	
	public abstract int removeCourse(int id);
	
	public abstract Course updateCourse(CourseModel courseModel);
}
