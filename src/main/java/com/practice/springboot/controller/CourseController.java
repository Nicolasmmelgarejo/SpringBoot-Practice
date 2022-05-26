package com.practice.springboot.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.practice.springboot.entity.Course;
import com.practice.springboot.model.CourseModel;
import com.practice.springboot.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static final String COURSES_VIEW = "courses";
	
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourse() {
		LOG.info("CALL: " + "listAllCourse()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("courseModel", new Course());
		mav.addObject("courseModels", courseService.listAllCourse());
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("courseModel") CourseModel courseModel) {
		LOG.info("Call: " + "addCourse()" + " -- Param: " + courseModel.toString());
		courseService.addCourse(courseModel);
		return "redirect:/courses/listcourses";
	}
	
	@PostMapping("/deletecourse")
	public String deleteCourse(int id) {
		courseService.removeCourse(id);
		return "redirect:/courses/listcourses";
	}
	
}
