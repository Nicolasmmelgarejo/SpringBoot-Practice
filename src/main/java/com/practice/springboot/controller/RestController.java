package com.practice.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.practice.springboot.constant.ViewConstant;
import com.practice.springboot.service.ContactService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	@GetMapping("/checkrest")
	public ResponseEntity<ModelAndView> checkRest(){
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		mav.addObject("contacts", contactService.listAllContacts());
		return new ResponseEntity<ModelAndView>(mav,HttpStatus.OK);
	}
	@GetMapping("/removecontact")
	public ResponseEntity<ModelAndView> removeContact(@RequestParam(name="id",required=true) int id) {
		contactService.removeContact(id);
		return checkRest();
	}
}
