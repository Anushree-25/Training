package com.lti.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.lti.model.Customer;

//data access object
public class CustomerDao {
	
	public void addCustomer(Customer customer) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			Properties dbProps = new Properties();
			dbProps.load(this.getClass().getClassLoader().getResourceAsStream("prod-db.properties"));
			
			Class.forName(dbProps.getProperty("driverClassName"));
			conn = DriverManager.getConnection(dbProps.getProperty("url"), dbProps.getProperty("username"), dbProps.getProperty("password"));	
			
			String sql = ("insert into customerH values (?, ?, ?)");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, customer.getId());
			stmt.setString(2, customer.getName());
			stmt.setString(3, customer.getEmail());
			
			stmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}  finally {
			try { 
				stmt.close();
				conn.close();} 
			catch (SQLException e) { e.printStackTrace(); }
		}
		
	}
}
