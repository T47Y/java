<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="pkg.GreetingService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Greeting</title>
</head>
<body>
<h2>Greeting</h2>
<form action="" method="post">
Enter your name: <input type="text" name="username"><br>
Enter your password: <input type="password" name="password"><br>
<input type="submit" value="Submit">
</form>
<%
request.setCharacterEncoding("UTF-8");
String username = request.getParameter("username");
String password = request.getParameter("password");
// Check if username and password are not null or empty
if(username != null && !username.isEmpty() && password != null &&
!password.isEmpty()) {
String greeting = GreetingService.getGreeting(username);
out.println("<p>" + greeting + "</p>");
}
%>
</body>
</html>
