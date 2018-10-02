<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Hola Mundo!!</title>
	</head>
	<body>
		<h1>Hola Mundo Virtual!!</h1>
		<% out.print("Helou desde JAVA!"); %>
		<%= (String) session.getAttribute("contador") %>
	</body>
</html>