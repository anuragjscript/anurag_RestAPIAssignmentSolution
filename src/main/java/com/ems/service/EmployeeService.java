package com.ems.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.ems.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	List<Employee> getAllEmployeeSortedByFirstName(Direction direction);
	Employee getEmployeeById(Integer employeeId);
	List<Employee> getEmployeeByFirstName(String firstName);
	Employee saveEmployee(Employee employee);
	void deleteEmployeeById(Integer employeeId);
	Employee editEmployeeById(Integer employeeId, Employee employee);

}
