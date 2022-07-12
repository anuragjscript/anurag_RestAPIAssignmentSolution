package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.exception.ResourceNotFoundException;
import com.ems.model.Employee;
import com.ems.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		return employeeDao.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "employeeId", employeeId));
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		List<Employee> listOfEmployeeByFirstName = employeeDao.findEmployeeByFirstName(firstName);
		if(listOfEmployeeByFirstName == null) {
			throw new ResourceNotFoundException("First Name", "firstName", firstName);
		}
		return listOfEmployeeByFirstName;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeDao.save(employee);
		return savedEmployee;
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		Employee employeeFromDB = getEmployeeById(employeeId);
		if(employeeFromDB == null) {
			throw new ResourceNotFoundException("Employee", "employeeId", employeeId);
		}
		employeeDao.deleteById(employeeId);
	}
	
	@Override
	public Employee editEmployeeById(Integer employeeId, Employee employee) {
		Employee employeeFromDB = getEmployeeById(employeeId);
		employeeFromDB.setFirstName( employee.getFirstName() );
		employeeFromDB.setLastName( employee.getLastName() );
		employeeFromDB.setEmail( employee.getEmail() );
		return saveEmployee(employeeFromDB);
	}

}
