<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Success Message</title>
</head>
<body>
		<!--Unlock Account message  -->
	<h1 align="center" style="color: green;">${updateScsMsg}</h1>
	<h1 align="center" style="color: red;">${failMsg}</h1>
				<!--Forget Password Message  -->
	<h1 align="center" style="color: red;">${forgetEmailmsg}</h1>
	<h1 align="center" style="color: red;">${forgetEmailnot}</h1>
					<!--Login Message  -->
	<h1 align="center" style="color: red;">${loginMsg}</h1>
	<h1 align="center" style="color: red;">${loginFailMsg}</h1>


</body>
</html>