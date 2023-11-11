package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2

public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/insert")
	public void insertEmployee(@RequestBody Employee employee) {
	log.info("Entry :: In Employe Controller :: Insert the Employee ID: {} and Name:{} ", employee.getEmployeeId(),employee.getEmployeeName());
		employeeService.insertEmployee(employee);
	}
	
	
	@GetMapping("/getEmployee/{employeeId}")
	public Optional<Employee> getEmployee(@PathVariable Integer employeeId) {
		log.info("In Employee Controller: Getting Employee Details with ID {}", employeeId);
		return employeeService.getEmployee(employeeId);
	}
	
	
	@GetMapping("/findAll")
	public List<Employee> findAll(){
		log.info("Fetching all the Employee List");
		return employeeService.findAll();
	}
	
	
	@PutMapping("/put")
	public Employee updateEmployee(@RequestBody Employee employee) {
		log.info("{}", employee);
		Employee updatedEmployeeDetails= employeeService.updateEmployee(employee);
		log.info("Updated Employee Details with Employee ID {} and Employee Name {} ", updatedEmployeeDetails.getEmployeeId(), updatedEmployeeDetails.getEmployeeName());
	return updatedEmployeeDetails;	
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		log.info("Deleting employee with ID {}",id);
	return	employeeService.deleteEmployee(id);
	}
}
