package com.practice.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.practice.springboot.model.Person;

@Controller
@RequestMapping("/example")

public class ExampleController {
	
	public static final String EXAMPLE_VIEW="example";
	
	//Primera forma
	@GetMapping("/exampleString")
	public String exampleString(Model model){
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}
	
	//Segunda forma
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV(){
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", getPeople());
		return mav;
	}
	
	private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("Jon",23));
		people.add(new Person("Mikel",30));
		people.add(new Person("Eva",50));
		people.add(new Person("Yami",33));
		return people;

	}
}
