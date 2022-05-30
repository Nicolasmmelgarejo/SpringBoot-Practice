package com.practice.springboot.model;

public class ContactModel {

	private int id;

	private String firstname;

	private String lastname;

	private String telephome;

	private String city;

	public ContactModel() {
	}

	public ContactModel(int id, String firstname, String lastname, String telephome, String city) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephome = telephome;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lasttname) {
		this.lastname = lasttname;
	}

	public String getTelephome() {
		return telephome;
	}

	public void setTelephome(String telephome) {
		this.telephome = telephome;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "ContactModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", telephome="
				+ telephome + ", city=" + city + "]";
	}
	
	
}
