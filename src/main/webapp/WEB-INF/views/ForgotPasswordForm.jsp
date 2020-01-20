<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password Form</title>
</head>
<body background="/picture/Salet.PNG">
	<h1 style="color:red;text-align:left">${forgotMsg}</h1>
	<br><br>
	<h1 style="color: blue; text-align: center">Forgot Password</h1>
	<br>
	<hr>
	<form:form action="ForgotPasswordRequest" method="POST" modelAttribute="forgotPwd">
		<table align="center" border="1">
			<tr>
				<td style="color:cyan">Email Id:</td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Submit"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><a href="/" style="color:red">Sign In</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>