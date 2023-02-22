package com.emp.factory;

import com.emp.services.EmployeeService;
import com.emp.services.EmployeeServiceImpl;

public class EmployeeServiceFactory {

	private static EmployeeService employeeService=null;
	
	static {
		employeeService=new EmployeeServiceImpl();
	}
	
	public static EmployeeService getEmployeeService() {
		return employeeService;
	}
	
}
