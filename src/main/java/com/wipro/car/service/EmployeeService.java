package com.wipro.car.service;

import java.util.List;
import com.wipro.car.model.Employee;


public interface EmployeeService {

	
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	public List<Employee> findAllCarModels(String brandemail);
	
}
