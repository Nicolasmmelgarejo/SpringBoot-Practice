package com.practice.springboot.service.impl;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.practice.springboot.converter.CourseConverter;
import com.practice.springboot.entity.Course;
import com.practice.springboot.model.CourseModel;
import com.practice.springboot.repository.CourseJpaRepository;
import com.practice.springboot.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{
	
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;
	
	@Override
	public List<Course> listAllCourse() {
		LOG.info("Call: " + "listAllCourse()");
		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(CourseModel courseModel) {
		LOG.info("Call: " + "addCourse()");
		return courseJpaRepository.save(courseConverter.model2entity(courseModel));
	}

	@Override
	public int removeCourse(int id) {
		LOG.info("Call: " + "removeCourse()");
		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Course updateCourse(CourseModel courseModel) {
		LOG.info("Call: " + "updateCourse()");
		return courseJpaRepository.save(courseConverter.model2entity(courseModel));
	}

}
