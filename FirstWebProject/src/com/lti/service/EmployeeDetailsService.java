package com.lti.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDetailsService {
	
	public boolean isValidEmployee(String empId) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "HR", "Newuser123");	
			String sql = ("select count(1) from employees where employee_id = ?");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, empId);		//	setting parameters for prepared statement
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int count = rs.getInt(1);		//	returns result of count(1) from select query as int
				if(count == 1)
					return true;
				return false;
			}
			else 
				return false;	
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			try { rs.close(); } catch (Exception e) {}
			try { stmt.close(); } catch (Exception e) {}
			try { conn.close(); } catch (Exception e) {}
		}		
	}
	
	public EmployeeRecord getEmployeeDetails(String empId) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		EmployeeRecord emp = new EmployeeRecord();
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "HR", "Newuser123");	
			String sql = ("select first_name, last_name, email, phone_number, hire_date, salary from employees WHERE employee_id = ?");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, empId);		//	setting parameters for prepared statement
			rs = stmt.executeQuery();
			if(rs.next()) {
				emp.setEmpid(Integer.parseInt(empId));
				emp.setFirstname(rs.getString(1));
				emp.setLastname(rs.getString(2));
				emp.setEmail(rs.getString(3));
				emp.setPhoneNumber(rs.getString(4));
				emp.setHireDate(rs.getString(5));
				emp.setSalary(rs.getDouble(6));
				
				return emp;
			}
			else
				return null;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			try { rs.close(); } catch (Exception e) {}
			try { stmt.close(); } catch (Exception e) {}
			try { conn.close(); } catch (Exception e) {}

			}
		}
}
