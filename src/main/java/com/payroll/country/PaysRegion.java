package com.payroll.country;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PaysRegion {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	@OneToOne
	@JoinColumn(name="countryregioncode")
	private CountryRegion pays_code;
	private String region_code;
	private String region_name;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegion_code() {
		return this.region_code;
	}

	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}

	public String getRegion_name() {
		return this.region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public CountryRegion getPays_code() {
		return this.pays_code;
	}

	public void setPays_code(CountryRegion pays_code) {
		this.pays_code = pays_code;
	}


}
