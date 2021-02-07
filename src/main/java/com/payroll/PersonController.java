package com.payroll;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	private final PersonRepository repository;

	PersonController(PersonRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/persons")
	List<Person> all() {
		return repository.findAll();
	}

}
