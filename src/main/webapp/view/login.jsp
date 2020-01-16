<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login Form</title>
</head>
<body>
	<form:form action="login" method="post" modelAttribute="loginBean">
		<table>
			<tr>
				<td>Email Id</td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><form:input path="pazzword" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
			
			<tr>
			<td><a href="/registered">SignUp</a></td>
			<td><a href="/forgetPage">Forget Password</a></td>
			</tr>
		</table>

	</form:form>
</body>
</html>