package com.emp.factory;

import com.emp.dao.EmployeeDao;
import com.emp.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {

	private static EmployeeDao employeeDao=null;
	
	static {
		employeeDao=new EmployeeDaoImpl();
	}
	
	public static EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
	
}
