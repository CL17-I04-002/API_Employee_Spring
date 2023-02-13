package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table (name="employee")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long Id;
	@Column(name = "Name")
	public String Name;
	@Column(name = "LastName")
	public String LastName;
	@Column(name = "HoursWorked")
	public int HoursWorked;
	@Column(name = "Job")
	public String Job;
	@Column(name = "Salary")
	public Double Salary;
	
	public long getId() {
		return Id;
	}
	public Employee(String Name, String LastName, int HoursWorked, String Job, Double Salaray) {
		super();
		this.Name = Name;
		this.LastName = LastName;
		this.HoursWorked = HoursWorked;
		this.Job = Job;
		this.Salary = Salaray;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getHoursWorked() {
		return HoursWorked;
	}
	public void setHoursWorked(int hoursWorked) {
		HoursWorked = hoursWorked;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public Double getSalary() {
		return Salary;
	}
	public void setSalary(Double salary) {
		Salary = salary;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
