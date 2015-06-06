package com.test.example.employee.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class EmployeeTest {

	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/emp";
	static final String JDBC_USERNAME = "root";
	static final String JDBC_PASSWORD = "root";
	@Test
	public void test() throws ClassNotFoundException, SQLException {
		String empName = "Test";
		String designation = "Developer";
		int salary = 6000;
		String emailId = "testuser@attuneww.com";
		int empId = 0;
		
		Connection conn =  null;
		Statement stmt = null;
		
		System.out.println("Registering Driver........");
		Class.forName(JDBC_Driver);
		
		System.out.println("Connecting to a Database....");
		
		conn = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
		System.out.println("Connected Sucessfully.....");
		
		
		stmt = conn.createStatement();
			System.out.println("\n\nInserting Records.....");
		String sql = "Insert INTO employee (name,designation,salary,emailId) values('"+empName+"','"+designation+"',"+salary+",'"+emailId+"')";
		System.out.println(sql);
		stmt.executeUpdate(sql);
		System.out.println("Inserted Records into the table....");
		
		System.out.println("\n\nSelecting All Records......");
		
		sql = "Select * from employee";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			System.out.println("\nEmployee Id: " + rs.getInt("employeeId"));
			System.out.println("Employee Name: " + rs.getString("name"));
			System.out.println("Employee Designation: " + rs.getString("designation"));
			System.out.println("Employee Salary: " + rs.getInt("salary"));
			System.out.println("Employee emailId: " + rs.getString("emailId"));
			empId = rs.getInt("employeeId");
			
		}
		
		System.out.println("\n\nUpdating Records who have name Test......");
		sql  = "Update employee set name = 'Test User' where name = 'Test'";
		System.out.println(sql);
		stmt.executeUpdate(sql); 
		System.out.println("Record updated....");
		
System.out.println("\n\nAgain Selecting All Records......");
		
		sql = "Select * from employee";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			System.out.println("\nEmployee Id: " + rs.getInt("employeeId"));
			System.out.println("Employee Name: " + rs.getString("name"));
			System.out.println("Employee Designation: " + rs.getString("designation"));
			System.out.println("Employee Salary: " + rs.getInt("salary"));
			System.out.println("Employee emailId: " + rs.getString("emailId"));
			empId = rs.getInt("employeeId");
			
		}
		
		
		System.out.println("\n\nDeleting  Records with name Test User......");
		sql = "Delete from employee where name = 'Test User'";
		System.out.println(sql);
		stmt.executeUpdate(sql);
		System.out.println("Record Deleted....");
		
		System.out.println("\n\nAgain Selecting All Records......");
				
				sql = "Select * from employee";
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					System.out.println("\nEmployee Id: " + rs.getInt("employeeId"));
					System.out.println("Employee Name: " + rs.getString("name"));
					System.out.println("Employee Designation: " + rs.getString("designation"));
					System.out.println("Employee Salary: " + rs.getInt("salary"));
					System.out.println("Employee emailId: " + rs.getString("emailId"));
					empId = rs.getInt("employeeId");
					
				}
		
		
		
		/*
				System.out.println("\n\n\nInserting Records into the table....");
		
			String	sql1 = "Insert INTO employee (name,designation,salary,emailId) values('test's','"+designation+"',"+salary+",'"+emailId+"')";
				System.out.println(sql1);
				stmt.executeUpdate(sql1);
				System.out.println("Inserted Records into the table....");
		*/
	
		
	}

}
