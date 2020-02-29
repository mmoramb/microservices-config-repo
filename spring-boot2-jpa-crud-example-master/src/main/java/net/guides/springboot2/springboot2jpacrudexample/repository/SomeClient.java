package net.guides.springboot2.springboot2jpacrudexample.repository;

import java.util.List;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

public class SomeClient {
	private final EmployeeRepository2 employeeRepository;
	
	SomeClient(EmployeeRepository2 employeeRepository){
		this.employeeRepository = employeeRepository;
	}
	
	void doSomething() {
		List<Employee> persons = employeeRepository.findByLastname("John");
	}
}
