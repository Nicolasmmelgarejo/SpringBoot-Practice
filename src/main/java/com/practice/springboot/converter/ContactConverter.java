package com.practice.springboot.converter;

import org.springframework.stereotype.Component;

import com.practice.springboot.entity.Contact;
import com.practice.springboot.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {
	
	public ContactModel entity2model(Contact contact) {
		ContactModel contactModel = new ContactModel();
		contactModel.setId(contact.getId());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setLastname(contact.getLastname());
		contactModel.setTelephome(contact.getTelephome());
		contactModel.setCity(contact.getCity());
		return contactModel;
	}
	
	public Contact medel2entity(ContactModel contactModel) {
		Contact contact = new Contact();
		contact.setId(contactModel.getId());
		contact.setFirstname(contactModel.getFirstname());
		contact.setLastname(contactModel.getLastname());
		contact.setTelephome(contactModel.getTelephome());
		contact.setCity(contactModel.getCity());
		return contact;
	}
	
}
