package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Iservices.EmployeeIservice;
import com.example.demo.entity.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	///Aplicamos inyección de dependencia de nuestro IService
	@Autowired
	private EmployeeIservice employeeIservice;
	
	@PostMapping
	public ResponseEntity<?> creat(@RequestBody Employee employee){
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeIservice.Save(employee));
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long id){
		Optional<Employee> oEmployee = employeeIservice.findById(id);
		
		if(oEmployee.isPresent()) {
			return ResponseEntity.ok(oEmployee);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		if(employeeIservice.findById(id).isPresent()) {
			employeeIservice.deleteEmployee(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	///read all Employees
	@GetMapping
	public List<Employee> readAll(){
		List<Employee> employee = StreamSupport
				.stream(employeeIservice.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return employee;
	}
}
