package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.emp.dto.Employee;
import com.emp.factory.ConnectionFactory;


public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String add(Employee employee) {
		
		String status="";
		
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement("INSERT INTO EMP (NAME,ADDRESS,SALARY) VALUES(?,?,?);");
			pst.setString(1, employee.getName());
			pst.setString(2, employee.getAddress());
			pst.setDouble(3, employee.getSalary());
			
			int rowCount=pst.executeUpdate();
			
			if(rowCount==1) {
				status="Employee Record inserted Successfully";
			}
			else {
				status="Employee Record Insertion Failed";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String update(Employee employee) {

		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement("UPDATE EMP SET NAME=?,ADDRESS=?,SALARY=? WHERE ID=?;");
			pst.setString(1, employee.getName());
			pst.setString(2, employee.getAddress());
			pst.setDouble(3, employee.getSalary());
			pst.setInt(4, employee.getId());
			
			int rowCount=pst.executeUpdate();
			if(rowCount==1) {
				status="Employee Record Updated Successfully";
			}
			else {
				status="Employee Record Updation Failed";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(int id) {
		
		String status="";
		
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement("DELETE FROM EMP WHERE ID=?;");
			pst.setInt(1, id);
			
			int rowCount=pst.executeUpdate();
			
			if(rowCount==1) {
				status="Employee Record Deleted Successfully ";
			}
			else {
				status="Employee Record Deletion Failed ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Employee search(int id) {
		
		Employee employee=null;
		
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement("SELECT * FROM EMP WHERE ID=?;");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				employee=new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setAddress(rs.getString("address"));
				employee.setSalary(rs.getDouble("salary"));
			}
			else {
				employee=null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	@Override
	public List<Employee> searchAll(){
		
		List<Employee> emp=new ArrayList<Employee>();

		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement("SELECT * FROM EMP;");
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				Employee employee=new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setAddress(rs.getString(3));
				employee.setSalary(rs.getDouble(4));
			
				emp.add(employee);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return emp;
	}


}
