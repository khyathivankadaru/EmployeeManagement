package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="employee")
@Data
public class Employee {
	@Id
	private int employeeId;
	private String employeeName;
	private String employeePhoneNumber;
	private String address;
}
