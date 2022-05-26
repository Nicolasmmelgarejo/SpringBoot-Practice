package com.practice.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.practice.springboot.model.Person;
import com.practice.springboot.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{
	
	private static final Log LOG = LogFactory.getLog(ExampleService.class);
	
	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Jon",23));
		people.add(new Person("Mikel",30));
		people.add(new Person("Eva",50));
		people.add(new Person("Yami",33));
		LOG.info("HELLO FROM SERVICE");
		return people;
	}
	
}
