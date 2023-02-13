package com.example.demo.Iservices;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;

@Component
public interface EmployeeIservice {
	public Iterable<Employee> findAll();
	public Page<Employee> findAll(Pageable pageable);
	///Con este evitaremos el NullPointerException
	public Optional<Employee> findById(long id);
	public Employee Save(Employee employee);
	public void deleteEmployee(long id);
}
