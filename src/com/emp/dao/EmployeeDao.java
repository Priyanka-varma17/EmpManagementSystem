package com.emp.dao;

import java.util.List;

import com.emp.dto.Employee;

public interface EmployeeDao {
	
	public String add(Employee employee);
	
	public String update(Employee employee);
	
	public String delete(int id);
	
	public Employee search(int id);

	public List<Employee> searchAll();
}
