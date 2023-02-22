package com.emp.services;

import java.util.List;

import com.emp.dto.Employee;

public interface EmployeeService {
	
	public String addEmployee(Employee employee);
	
	public String updateEmployee(Employee employee);
	
	public String deleteEmployee(int id);
	
	public Employee searchById(int id);
	
	//public Employee Search();
	
	public List<Employee> Search();

}
