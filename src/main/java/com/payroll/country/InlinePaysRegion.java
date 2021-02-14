package com.payroll.country;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlinePaysRegion", types = {PaysRegion.class})
public interface InlinePaysRegion {

	String getRegion_name();
	String getRegion_code();
	CountryRegion getPays_code();

}