package com.payroll;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personee")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;

	private String firstname;

	private String lastname;

	public String getFirstName() {
		return firstname;
	}
	
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}
	
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

}
