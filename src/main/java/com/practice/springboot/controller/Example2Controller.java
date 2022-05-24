package com.practice.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {
	
	private static final String EXAMPLE2_VIW="example2";
	
	//localhost:8080/example2/request1?nm=name
	//localhost:8080/example2/request1	
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name="nm",required=false, defaultValue="No Name") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE2_VIW);
		mav.addObject("nm_in_model",name);
		return mav;
	}
	
	//localhost:8080/example2/request2/name
	//localhost:8080/example2/request2	
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE2_VIW);
		mav.addObject("nm_in_model",name);
		return mav;
	}
}
