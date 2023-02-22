package com.emp.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.emp.dto.Employee;
import com.emp.factory.EmployeeServiceFactory;
import com.emp.services.EmployeeService;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int choice,id;
		String name="",address="",status="";
		double salary;
		
		Employee employee=new Employee();
		
		EmployeeService employeeService=EmployeeServiceFactory.getEmployeeService();
		
		System.out.println("***WELCOME TO EMPLOYEE MANAGEMENT SYSTEM***");
		
		
		while(true) {
			System.out.println("Enter any choice");
			
			System.out.println("1. INSERT");
			System.out.println("2. UPDATE");
			System.out.println("3. DELETE");
			System.out.println("4. SEARCH BY ID");
			System.out.println("5. SEARCH");
			
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("*** Insert Employee module ***");
				System.out.println("Name: ");
				name=sc.next();
				
				System.out.println("Address: ");
				address=sc.next();
				
				System.out.println("Salary: ");
				salary=sc.nextDouble();
				
				employee.setName(name);
				employee.setAddress(address);
				employee.setSalary(salary);
				
				status=employeeService.addEmployee(employee);
				System.out.println(status);
				
				break;
				
			case 2:
				System.out.println("*** Update Employee module ***");
				
				System.out.println("Enter emp id: ");
				id=sc.nextInt();
				employee=employeeService.searchById(id);
				
				if(employee==null) {
					
					System.out.println("Record not found");
					
				}
				else {
					System.out.println("Enter name: ");
					name=sc.next();
					
					System.out.println("Enter address: ");
					address=sc.next();
					
					System.out.println("Enter salary: ");
					salary=sc.nextDouble();
					
					employee.setName(name);
					employee.setAddress(address);
					employee.setSalary(salary);
					
					status=employeeService.updateEmployee(employee);
					System.out.println(status);
				}

				break;
				
			case 3:
				System.out.println("*** Delete Employee module ***");
				
				System.out.println("Enter emp id: ");
				id=sc.nextInt();
				
				employee=employeeService.searchById(id);
				
				if(employee==null) {
					System.out.println("Record not found");
				}else {
					status=employeeService.deleteEmployee(id);
					System.out.println(status);
				}

				break;
			
			case 4:
				System.out.println("*** Search Employee by id module ***");
				
				System.out.println("Enter employee id: ");
				id=sc.nextInt();
				
				employee=employeeService.searchById(id);
				
				if(employee==null) {
					System.out.println("Record not found");
				}
				else {
					System.out.println("Employee id: "+employee.getId());
					System.out.println("Employee name: "+employee.getName());
					System.out.println("Employee address: "+employee.getSalary());
					System.out.println("Employee salary: "+employee.getSalary()+"\n");
				}

				break;
				
			case 5:
				System.out.println("*** Search All Employee module ***");
				
				List<Employee> employees=employeeService.Search();
				
				for(Employee e:employees) {
					System.out.println("Id : "+e.getId());
					System.out.println("Name : "+e.getName());
					System.out.println("Address : "+e.getAddress());
					System.out.println("Salary : "+e.getSalary()+"\n");
				}

				break;
				
			default:
				System.out.println("Please enter valid choice");
			break;

			}
			
		}

	}

}
