package com.payroll;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
class EmployeeController {

	private final EmployeeRepository repository;
	private final EmployeeModelAssembler assembler;

	EmployeeController(EmployeeRepository repository, EmployeeModelAssembler assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	
	// @GetMapping("/employees")
	// List<Employee> all() {
	// 	return repository.findAll();
	// }

	// @GetMapping("/employees")
	// CollectionModel<EntityModel<Employee>> all() {
	// 	List<EntityModel<Employee>> employees = repository.findAll().stream()
	// 		.map(employee -> EntityModel.of(employee,
	// 			linkTo(methodOn(EmployeeController.class).one(employee.getId()))
	// 				.withSelfRel(),
	// 			linkTo(methodOn(EmployeeController.class).all()).withRel("employees")))
	// 				.collect(Collectors.toList());
			
	// 	return CollectionModel.of(employees,
	// 		linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
			
	// }


	@GetMapping("/employees")
	CollectionModel<EntityModel<Employee>> all() {
		List<EntityModel<Employee>> employees = repository.findAll().stream()
			.map(assembler::toModel)
			.collect(Collectors.toList());

		return CollectionModel.of(employees,
			linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
		
	}

	// end::get-aggregate-root[]

	// @PostMapping("/employees")
	// Employee newEmployee(@RequestBody Employee newEmployee) {
	// 	return repository.save(newEmployee);
	// }

	@PostMapping("/employees")
	ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee) {
		EntityModel<Employee> entityModel = assembler.toModel(repository.save(newEmployee));

		return ResponseEntity
			.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
			.body(entityModel);
	}

	@GetMapping("/yoplait")
	Employee e() {
		Employee e = new Employee("alfred", "pazanboa", "voleur de poule");
		return repository.save(e);
	}

	@GetMapping("/yolangoa")
	String a() {
		return "Des Iguanes ? Ou ca des Ignuanes ??? o_O";
	}

	@GetMapping("/employees/{id}")
	EntityModel<Employee> one(@PathVariable Long id) {

		Employee employee = repository.findById(id)
			.orElseThrow(() -> new EmployeeNotFoundException(id));

		return assembler.toModel(employee);
	}

	// @GetMapping("/employees/{id}")
	// EntityModel<Employee> one(@PathVariable Long id) {

	// 	Employee employee = repository.findById(id)
	// 		.orElseThrow(() -> new EmployeeNotFoundException(id));

	// 	return EntityModel.of(employee,
	// 		linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
	// 		linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));

	// }

	// @PutMapping("/employees/{id}")
	// Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
	// 	return repository.findById(id).map(employee -> {
	// 		employee.setName(newEmployee.getName());
	// 		employee.setRole(newEmployee.getRole());
	// 		return repository.save(employee);
	// 	}).orElseGet(() -> {
	// 		newEmployee.setId(id);
	// 		return repository.save(newEmployee);
	// 	});
	// }

	@PutMapping("/employees/{id}")
	ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		Employee updatedEmployee = repository.findById(id)
			.map(employee -> {
				employee.setName(newEmployee.getName());
				employee.setRole(newEmployee.getRole());
				return repository.save(employee);
			}) //
			.orElseGet(() -> {
				newEmployee.setId(id);
				return repository.save(newEmployee);
			});

		EntityModel<Employee> entityModel = assembler.toModel(updatedEmployee);

		return ResponseEntity //
			.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
			.body(entityModel);
	}

	// @DeleteMapping("/employees/{id}")
	// void DeleteMapping(@PathVariable Long id) {
	// 	repository.deleteById(id);
	// }

	ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

}
