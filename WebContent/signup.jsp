<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
</head>
<body>
	<form  method="post">
		<table>
			<tr>
				<td>First Name:&nbsp;</td>
				<td><input type="text" name="firstName">
			</tr>
			<tr>
				<td>Last Name:&nbsp;</td>
				<td><input type="text" name="lastName">
			</tr>
			<tr>
				<td>Email Id:&nbsp;</td>
				<td><input type="text" name="emailId">
			</tr>
			<tr>
				<td>Mobile Number:&nbsp;</td>
				<td><input type="text" name="mobile">
			</tr>

			<tr>
				<td>DOB:&nbsp;</td>
				<td><input type="text" name="dob">
			</tr>
			<tr>
				<td>Passowrd:&nbsp;</td>
				<td><input type="password" name="password">
			</tr>
			<tr>
				<td>Re-enter Passowrd:&nbsp;</td>
				<td><input type="password" name="rpassword">
			
			</tr>
		</table>
		<input type="hidden" name="action" value="signup">
		<input type="submit" value="Signup"> <input type="reset"
			value="Reset">
	</form>
</body>
</html>