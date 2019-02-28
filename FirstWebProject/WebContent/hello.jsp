<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Page</title>
</head>
<body>
<% //Scriptlet or server side element
	String str = "Hello Everyone";
%>
<h1><%= str.toUpperCase() %></h1> <!-- concat string called as expressions -->

<center>
<% 
	for(int i=1; i<=8; i++) {
%>
		<font size="<%= i %>">Hello World!!</font><br/>
<%
	}
%>
</center>

</body>
</html>