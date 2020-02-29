package net.guides.springboot2.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	long countByLastname(String lastname);
	
	long deleteByLastname(String lastname);
	List<Employee> removeByLastname(String lastname);
	
}