<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<script src="jquery-3.4.1.min.js">
jQuery(document).ready(function(e) {
	$("#email").blur(function(event) {
	$("#dupEmail").html("");
	var emailId = $(#email).val();
	$.ajax({ 
		url:'validateEmail?email='+email, success : function(abc){
			if(abc=='Duplicate'){ 
				$("#dupEmail").html("Email already registered")
			}
	$("#email").focus();
	}
	}
	});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<title>Registration Form</title>
</head>
<body>
	<form:form action="registeredBtn" method="post"
		modelAttribute="registationBean">
		<h1>${successMsg}</h1>
		<h1>${failMsg}</h1>
		<table>
			<thead>
				<tr>
					<td>Name :</td>
					<td><form:input path="name" /></td>
				</tr>

				<tr>
					<td>Address :</td>
					<td><form:input path="addrs" /></td>
				</tr>

				<tr>
					<td>Mobile No :</td>
					<td><form:input path="mobNo" /></td>
				</tr>

				<tr>
					<td>Email :</td>
					<td><form:input path="email" /></td>
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