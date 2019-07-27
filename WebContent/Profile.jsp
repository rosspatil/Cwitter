
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.OutputStream"%>
<%@page import="com.rosspatil.UserInfo"%>
<%@page import="com.rosspatil.DbBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
	<jsp:useBean id="dbBean" scope="application"
		class="com.rosspatil.DbBean" />

	<%
		String userId = session.getAttribute("UserId").toString();
		UserInfo info = dbBean.getUser(userId);
	%>
	
		<table>
			<tr>
				<td>First Name:&nbsp;<%=info.getFirstName()%></td>
			</tr>
			<tr>
				<td>Last Name:&nbsp;<%=info.getLastName()%></td>
			</tr>
			<tr>
				<td>Email Id:&nbsp;<%=info.getEmailId()%></td>
			</tr>
			<tr>
				<td>Mobile Number:&nbsp;<%=info.getMobile()%></td>
			</tr>

			<tr>
				<td>DOB:&nbsp;<%=info.getDob()%></td>
			</tr>
			<tr>
			<jsp:include page="Upload.jsp"/>
			</tr>
		</table>
	
</body>
</html>