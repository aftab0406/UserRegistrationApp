<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>

</head>
<body background="/picture/Salet.PNG">
	<h1 style="color: lightgreen; text-align: left;">${successMsg}</h1>
	<h1 style="color: red; text-align: left;">${failureMsg}</h1>
	<br>
	<h1 style="color:blue;text-align:center">User Registration Form</h1>
	<br>	
	<hr/>
	<form:form action="saveUser" method="POST" modelAttribute="userRegistration">
		<table align="center" border="1">
			<tr>
				<td style="color:cyan">First Name: </td>
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td style="color:cyan">Last Name: </td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td style="color:cyan">Email: </td>
				<td><form:input path="email" id="validEmail"/>
				<div id="dupEmail" style="color: red"></div>
				</td>
			</tr>
			<tr>
				<td style="color:cyan">Phone Number: </td>
				<td><form:input path="phNo"/></td>
			</tr>
			<tr>
				<td style="color:cyan">Date Of Birth: </td>
				<td><form:input path="dob" id="datepicker"/></td>
			</tr>
			<tr>
				<td style="color:cyan">Gender: </td>
				<td>
					<form:radiobutton path="gender" value="Female"/>Female
					<form:radiobutton path="gender" value="Male"/>Male
				</td>
			</tr>
			<tr>
				<td style="color:cyan">Country: </td>
				<td><form:input path="country"/></td>
			</tr>
			<tr>
				<td style="color:cyan">State: </td>
				<td><form:input path="state"/></td>
			</tr>
			<tr>
				<td style="color:cyan">City: </td>
				<td><form:input path="city"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Register"/> 
					<input type="reset" value="reset"/>					
				</td>
			</tr>
		</table>
	</form:form>
</body>
<script>
  $(function() {
    $("#datepicker").datepicker();
  });
  
</script>
<script type="text/javascript">
	
	$(document).ready(function(){
		$('#validEmail').blur(function(){
			$('#dupEmail').html('');
			var mailId = $('#validEmail').val();
			$.ajax({
				type:'GET',
				url:'findDupEmail?email='+mailId,
				success:function(data){
					if(data == 'Duplicate'){
						$('#dupEmail').html('Email Already Registered');
						$('#validEmail').focus();
					}
				}
			});
		});
	});
</script>
</html>