package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/employee.xls")
public class EmpServlet extends HttpServlet {
	//	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel");
		PrintWriter out = response.getWriter();
		
		out.println("Empno\tName\tSalary");
		out.println("1001\tSomeone1\t1000");
		out.println("1002\tSomeone2\t2000");
		out.println("1003\tSomeone3\t3000");
	}
}
