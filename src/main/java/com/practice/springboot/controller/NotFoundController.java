package com.practice.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotFoundController {
	
	@RequestMapping("/404.html")
    public String render404(Model model) {
        return "404";
	}
	@RequestMapping("/500.html")
    public String render500(Model model) {
        return "500";
	}
}
