<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reverse String</title>
</head>
<body>
<h2>Enter a String:</h2>
<form action="" method="post">
<input type="text" name="inputString">
<input type="submit" value="Reverse">
</form>
<%
// Get the input string from the request parameter
String inputString = request.getParameter("inputString");
// Check if the input string is not null or empty
if (inputString != null && !inputString.isEmpty()) {
// Reverse the input string
StringBuilder reversedString = new
StringBuilder(inputString).reverse();
// Display the reversed string
%>
<h2>Reversed String:</h2>
<p><%= reversedString.toString() %></p>
<%
}
%>
</body>
</html>
