package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Iservices.EmployeeIservice;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import jakarta.transaction.TransactionScoped;

@Service
public class EmployeeService implements EmployeeIservice{

	///Aplicamos inyección de dependencia de Repository
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Employee> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	///Será de escritura
	@Transactional
	public Employee Save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}
	@Override
	@Transactional
	public Employee updateEmployee(long id, Employee employee) {
		Optional<Employee> employeeToUpdate = employeeRepository.findById(id);
		if(!employeeToUpdate.isPresent()) {
			return null;
		}
		else {
			employeeToUpdate.get().setName(employee.Name);
			employeeToUpdate.get().setLastName(employee.LastName);
			employeeToUpdate.get().setHoursWorked(employee.HoursWorked);
			employeeToUpdate.get().setJob(employee.Job);
			employeeToUpdate.get().setSalary(employee.Salary);
			
			return employeeRepository.save(employeeToUpdate.get());
		}	
	}
}
