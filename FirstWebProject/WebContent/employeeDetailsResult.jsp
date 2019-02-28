<%@page import="com.lti.service.EmployeeRecord"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%	EmployeeRecord emp = (EmployeeRecord) session.getAttribute("employeeData"); %>
 
		Employee ID:	<%= emp.getEmpid() %><br/>
		First Name : <%= emp.getFirstname() %><br/>
		Last Name: <%= emp.getLastname() %><br/>
		Phone Number: <%= emp.getPhoneNumber() %><br/>
		Email: <%= emp.getEmail() %><br/>
		Hire Date: <%= emp.getHireDate() %><br/>
		Salary: <%= emp.getSalary() %><br/>
</body>
</html>