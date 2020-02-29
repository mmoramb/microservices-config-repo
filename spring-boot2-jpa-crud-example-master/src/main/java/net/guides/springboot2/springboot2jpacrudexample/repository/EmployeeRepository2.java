package net.guides.springboot2.springboot2jpacrudexample.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

public interface EmployeeRepository2 extends MyBaseRepository<Employee, Long> {
	List<Employee> findByLastname(String lastname);
	List<Employee> findByEmailid(String lastname);
	List<Employee> findByEmailidAndLastname(String emailid, String lastname);
	List<Employee> findDistinctEmployeeByLastnameOrFirstname(String lastname, String firstname);
	List<Employee> findByEmailidAndLastnameIgnoreCase(String lastname);
	List<Employee> findByEmailidAndLastnameAllIgnoreCase(String emailid, String lastname);
	List<Employee> findByEmailidOrderByLastnameAsc(String lastname);
	List<Employee> findByEmailidOrderByLastnameDesc(String lastname);
	List<Employee> findByAddress_ZipCode(String lastname);//Address is not there
	Sort sort = Sort.by("lastname").ascending()
			.and(Sort.by("emailid").descending());
	List<Employee> findByLastname(String lastname, Sort sort);
	List<Employee> findByLastname(String lastname, Pageable sort);
	Employee findFirstByOrderByLastnameAsc();
	Employee findTopByOrderByAgeDesc();//age
	Page<Employee> queryFirst10ByLastname(String lastname, Pageable pageable);
	Slice<Employee> findTop3ByLastname(String lastname, Pageable pageable);
	List<Employee> findFirst10ByLastName(String lastname, Sort sort);
	List<Employee> findTop10ByLastname(String lastname, Pageable pageable);
	Streamable<Employee> findByFirstnameContaining(String firstname);
	Streamable<Employee> findByLastnameContaining(String lastname);
	
	
	
}
