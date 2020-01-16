<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<form:form action="unlockSubmit" method="post"
		modelAttribute="unllockAccBean">

		<table>
			<thead>
				<tr>
					<td>Email :</td>
					<td><form:input path="email" readonly="true" /></td>
				</tr>

				<tr>
					<td>Temporary Password :</td>
					<td><form:input path="tempPwd" /></td>
				</tr>

				<tr>
					<td>New Password :</td>
					<td><form:input path="newPwd" /></td>
				</tr>

				<tr>
					<td>Confirm Password :</td>
					<td><form:input path="confirmPwd" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
			</thead>
		</table>

	</form:form>
</body>
</html>