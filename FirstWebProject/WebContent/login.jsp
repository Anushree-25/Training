<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<form method="post" action="login.check">
    Username: <input  type="text" name="username"/> <br/>
    Password: <input  type="password" name="password"/> <br/>
    <button type="submit">Login</button>
    <% String message = (String) session.getAttribute("invalidMessage");
				 if (message != null)
					out.println("<b>" + message + "</b>");
				session.removeAttribute("invalidMessage");
	%>
</form>
</body>
</html>