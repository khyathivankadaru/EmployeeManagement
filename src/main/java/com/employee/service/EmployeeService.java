package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

import lombok.extern.log4j.Log4j2;

@Service

@Log4j2
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void insertEmployee(Employee employee) {
		log.info("Entry :: In Employe Service :: Insert the Employee {} and {} ", employee.getEmployeeId(),employee.getEmployeeName());
		log.info("Employee is Inserted Successfully with Employee ID: {} ", employee.getEmployeeId());
		employeeRepository.save(employee);
	}

	public Optional<Employee> getEmployee(Integer employeeId) {
	return employeeRepository.findById(employeeId);
	}

	public List<Employee> findAll() {
		
return employeeRepository.findAll();
	}

	public Employee updateEmployee(Employee employee) {
	
		return employeeRepository.save(employee);
	}

	public String deleteEmployee(Integer id) {
		 employeeRepository.deleteById(id);
		 return "Employee is deleted";
	}
	
	
}
