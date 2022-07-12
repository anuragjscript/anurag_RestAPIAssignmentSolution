package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> allEmployees = employeeService.getAllEmployees();
		return ResponseEntity.ok().body(allEmployees);
	}
	
	@GetMapping("/getEmployeeById/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok().body(employee);
	}
	
	@GetMapping("/search/{firstName}")
	public ResponseEntity<List<Employee>> getEmployeeByFirstName(@PathVariable String firstName) {
		List<Employee> listOfmployeeByFirstName = employeeService.getEmployeeByFirstName(firstName);
		return ResponseEntity.ok().body(listOfmployeeByFirstName);
	}
	
	@PostMapping("/addNewEmployee")
	public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	@PutMapping("/editEmployeeById/{employeeId}")
	public ResponseEntity<Employee> editEmployeeById(@PathVariable Integer employeeId, 
			@RequestBody Employee employee) {
		Employee editedEmployee = employeeService.editEmployeeById(employeeId, employee);
		return ResponseEntity.ok().body(editedEmployee);
	}
	
	@DeleteMapping("/deleteEmployee/{employeeId}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Integer employeeId) {
		employeeService.deleteEmployeeById(employeeId);
		return ResponseEntity.noContent().build();
	}

}
