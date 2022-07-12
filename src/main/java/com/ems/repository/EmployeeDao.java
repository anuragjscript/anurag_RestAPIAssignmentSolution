package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	List<Employee> findEmployeeByFirstName(String firstName);

}
