<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body background="/picture/Salet.PNG">
	<h1 style="color: green; text-align: left">${successMsg}</h1>
	<h1 style="color: green; text-align: left">${failureMsg}</h1>
	<br>
	<br>
	<h1 style="color: blue; text-align: center">Update Password</h1>
	<hr>
	<br>
	<br>
	<form:form action="UpdatePassword" method="POST"
		modelAttribute="unlockAccount">
		<table align="center" border="1">
			<tr>
				<td style="color:cyan">Email Id:</td>
				<td><form:input path="email" readonly="true" /></td>
				<!-- disabled="true" -->
			</tr>
			<tr>
				<td style="color:cyan">Temporary Password:</td>
				<td><form:password path="Password" /></td>
			</tr>
			<tr>
				<td style="color:cyan">New Password:</td>
				<td><form:password path="newPassword" /></td>
			</tr>
			<tr>
				<td style="color:cyan">Confirm Password:</td>
				<td><form:password path="confirmPassword" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Update Password" onclick="return Validate()"></td>
			</tr>
			<tr>
				<td><a href="ForgotPassword" style="color:red">Forgot Password?</a></td>
				<td align="right"><a href="/" style="color:red">Sign Up</a></td>

			</tr>
		</table>
		<br>
		<br>

	</form:form>
	<c:choose>
		<c:when test="${UnlockFlag == true}">
        	<a href="/">Sign In</a> 
        <br />
		</c:when>
		<%-- <c:otherwise>
        	
        <br />
		</c:otherwise> --%>
	</c:choose>
</body>
<script type="text/javascript">
	function Validate() {
		var password = document.getElementById("newPassword").value;
		var confirmPassword = document.getElementById("confirmPassword").value;
		if (password != confirmPassword) {
			alert("Passwords do not match.");
			return false;
		}
		return true;
	}
</script>
</html>