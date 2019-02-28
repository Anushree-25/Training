package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.service.EmployeeDetailsService;
import com.lti.service.EmployeeRecord;

/**
 * Servlet implementation class EmployeeDetailsServlet
 */
@WebServlet("/employees.retrieve")
public class EmployeeDetailsServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		response.setContentType("text/html");
		
		EmployeeDetailsService empDetails = new EmployeeDetailsService();
		boolean isValid = empDetails.isValidEmployee(empId);
		HttpSession session = request.getSession();
		
		if(isValid) {
			EmployeeRecord emp = empDetails.getEmployeeDetails(empId);
			session.setAttribute("employeeData", emp);
			response.sendRedirect("employeeDetailsResult.jsp");
		}
		else {
			session.setAttribute("invalidMessage", "Invalid employee id");
			response.sendRedirect("getemployeedetails.jsp");
		}
		
	}

}
