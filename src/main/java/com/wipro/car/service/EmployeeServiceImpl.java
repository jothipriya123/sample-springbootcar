package com.wipro.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.car.model.Employee;
import com.wipro.car.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAllCarModels(String brandemail) {
		// TODO Auto-generated method stub

		return employeeRepository.findByBrand(brandemail);
	}
	@Override
	public List<Employee> getAllEmployees() {		
		return employeeRepository.findAll();		
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);		
	}

}
