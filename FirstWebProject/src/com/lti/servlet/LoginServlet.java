package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.service.DatabaseLoginService;
import com.lti.service.InMemoryLoginService;

/**
 * Servlet implementation class LoginServlet 
 */
@WebServlet("/login.check")
public class LoginServlet extends HttpServlet {       
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//	String referingUrl = request.getHeader("referer");
		
		request.getSession().setAttribute("name", username);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//	InMemoryLoginService loginService = new InMemoryLoginService();
		
		DatabaseLoginService loginService = new DatabaseLoginService();
		boolean isValid = loginService.isValidUser(username, password);
		
		HttpSession session = request.getSession();
		
		if(isValid) {
			String fullName = loginService.getFullName(username);
			//System.out.println(fullName);
			session.setAttribute("loggedInUser", username);
			session.setAttribute("userFullName", fullName);
			response.sendRedirect("welcome.jsp");
		}
		else {
			session.setAttribute("invalidMessage", "Invalid username/password");
			response.sendRedirect("login.jsp");
		}
		/*if(username.equals("USER") && password.equals("Newuser123")) {
			response.sendRedirect("welcome.html");
		}
		else
			response.sendRedirect("login.html");*/
	}

}
