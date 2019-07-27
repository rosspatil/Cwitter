<%@page import="com.rosspatil.UserInfo"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dbBean" scope="application"
		class="com.rosspatil.DbBean" />
	<%
		String userId = session.getAttribute("UserId").toString();
		UserInfo info = dbBean.getUser(userId);
	%>
	<form>
		<table>
			<tr>

				<td><img
					src="/Cwitter/PhotoServlet?userId=<%=URLEncoder.encode(userId, "UTF-8")%>"
					height="70" width="60" /></td>
				<td><textarea rows="4" cols="60" name="tweet"></textarea></td>
				<td><input type="submit" value="Post"><input
					type="hidden" name="action" value="post"></td>

			</tr>

		</table>
	</form>
</body>
</html>