package com.payroll;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerDelegate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
public class WebConfigREST implements RepositoryRestConfigurer {


	// @Override
	// public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	// 	config.getCorsRegistry().addMapping("/**")
	// 			.allowedOrigins("http://localhost:8080");
	// 	System.out.println("HEYEHESAA");
	// }

	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry c) {
        // config.forDomainType(WebsiteUser.class).withItemExposure((metadata, httpMethods) ->
        //   httpMethods.disable(HttpMethod.PATCH));
		// c.addMapping("/**").allowedOrigins("http://localhost:8080");
		c.addMapping("/**").allowedOrigins("*").allowedHeaders("*");
    }

}
