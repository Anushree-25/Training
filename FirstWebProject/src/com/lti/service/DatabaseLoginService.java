package com.lti.service;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Set;

public class DatabaseLoginService {
	
	public boolean isValidUser(String username, String password) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "HR", "Newuser123");	
			String sql = ("select count(1) from TBL_USER WHERE username = ? and password = ? and active = 'Y'");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);		//	setting parameters for prepared statement
			stmt.setString(2, password);
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
	
	public String getFullName(String username) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String fullname = "Test";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "HR", "Newuser123");	
			String sql = ("select fullname from TBL_USER WHERE username = ?");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);		//	setting parameters for prepared statement
			rs = stmt.executeQuery();
			if(rs.next()) {
			fullname = rs.getString("fullname");
			}
			return fullname;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return fullname;
		} finally {
			try { rs.close(); } catch (Exception e) {}
			try { stmt.close(); } catch (Exception e) {}
			try { conn.close(); } catch (Exception e) {}
		}
	}
}
