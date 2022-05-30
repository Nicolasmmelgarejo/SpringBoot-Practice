package com.practice.springboot.service;

import java.util.List;

import com.practice.springboot.entity.Contact;
import com.practice.springboot.model.ContactModel;


public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();
	
	public abstract Contact findContactById(int id);
	
	public abstract void removeContact(int id);
	
	public abstract ContactModel findContactModelById(int id);
}
