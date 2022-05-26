package com.practice.springboot.service;

import java.util.List;

import com.practice.springboot.model.Person;

public interface ExampleService {
	
	public abstract List<Person> getListPeople();
}
