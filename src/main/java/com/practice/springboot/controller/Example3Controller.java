package com.practice.springboot.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.practice.springboot.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	public static final String FORM_VIEW="form";
	public static final String RESULT_VIEW="result";
	
	/*@GetMapping("/")
	public String redirect() {
		return "redirect:/example3/showForm";
	}*/
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showForm");
	} 
	
	//localhost:8080/example3/showForm
	@GetMapping("/showForm")
	public String showForm(Model model) { 
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mav.setViewName(FORM_VIEW);
		}else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person",person);
		}
		return mav;
	}	
}
