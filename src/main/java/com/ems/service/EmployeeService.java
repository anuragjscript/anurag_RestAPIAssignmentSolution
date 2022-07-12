package com.ems.service;

import java.util.List;

import com.ems.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Integer employeeId);
	List<Employee> getEmployeeByFirstName(String firstName);
	Employee saveEmployee(Employee employee);
	void deleteEmployeeById(Integer employeeId);
	Employee editEmployeeById(Integer employeeId, Employee employee);

}
