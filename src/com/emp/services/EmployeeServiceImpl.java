package com.emp.services;

import java.util.List;

import com.emp.dao.EmployeeDao;
import com.emp.dto.Employee;
import com.emp.factory.EmployeeDaoFactory;


public class EmployeeServiceImpl implements EmployeeService {
	
	String status="";
	EmployeeDao employeeDao=null;
	
	@Override
	public String addEmployee(Employee employee) {
		
		employeeDao=EmployeeDaoFactory.getEmployeeDao();
		status=employeeDao.add(employee);
		return status;
	}

	@Override
	public String updateEmployee(Employee employee) {
		
		employeeDao=EmployeeDaoFactory.getEmployeeDao();
		status=employeeDao.update(employee);
		
		return status;
	}

	@Override
	public String deleteEmployee(int id) {
		
		employeeDao=EmployeeDaoFactory.getEmployeeDao();
		status=employeeDao.delete(id);
		
		return status;
	}

	@Override
	public Employee searchById(int id) {
		
		employeeDao=EmployeeDaoFactory.getEmployeeDao();
		Employee emp=employeeDao.search(id);
		return emp;
	}

//	@Override
//	public Employee Search() {
//
//		employeeDao=EmployeeDaoFactory.getEmployeeDao();
//		Employee emp=employeeDao.searchAll();
//		return emp;
//	}
	
	@Override
	public List<Employee> Search(){
		employeeDao=EmployeeDaoFactory.getEmployeeDao();
		//<Employee> emp=employeeDao.searchAll();
		List<Employee> emp= employeeDao.searchAll();
		return emp;
	}
	

}
