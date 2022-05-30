package com.practice.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.practice.springboot.converter.ContactConverter;
import com.practice.springboot.entity.Contact;
import com.practice.springboot.model.ContactModel;
import com.practice.springboot.repository.ContactRepository;
import com.practice.springboot.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.medel2entity(contactModel));
		return contactConverter.entity2model(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for(Contact contact : contacts) {
			contactsModel.add(contactConverter.entity2model(contact));
		}
		
		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
		 
	}
	
	@Override
	public ContactModel findContactModelById(int id) {
		return contactConverter.entity2model(findContactById(id));
	}
	
		

	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if(null != contact) {
			contactRepository.delete(contact);
		}	
	}

	

}
