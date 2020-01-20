<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body background="/picture/Salet.PNG">
	<h1 style="color:red;text-align:left">${failureMsg}</h1>
	<h1 style="color: blue; text-align: center">User Login</h1>
	<br><br><br>
	<hr>
	<form:form action="Signin" method="POST" modelAttribute="login">
		<table align="center" border="1">
			<tr>
				<td style="color:cyan">Email Id:</td>
				<td><form:input path="email" /></td>
				<!-- disabled="true" -->
			</tr>
			<tr>
				<td style="color:cyan">Password:</td>
				<td><form:password path="Password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Sign In"></td>
			</tr>
			<tr>
				<td><a href="ForgotPassword" style="color:red">Forgot Password?</a></td>
				<td align="right"><a href="UserRegistration" style="color:red">Sign Up</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>