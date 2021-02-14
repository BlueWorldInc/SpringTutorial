package com.payroll.country;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Region {
	
	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) long id;
	private String region_code;
	private String country_code;
	private String region_name;


	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegion_code() {
		return this.region_code;
	}

	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}

	public String getCountry_code() {
		return this.country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getRegion_name() {
		return this.region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}


}
