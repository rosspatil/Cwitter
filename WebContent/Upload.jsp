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
	%>
	<form action="/Cwitter/Controller"   method="post"  enctype="multipart/form-data">
		<table>

			<tr>
				<td><img
					src="/Cwitter/PhotoServlet?userId=<%=URLEncoder.encode(userId, "UTF-8")%>"
					height="100" width="90" /></td>
				<td><input type="file" name="upload" accept="image/*">
					<input type="hidden" name="action" value="upload"> <input
					type="submit" value="Upload"></td>

			</tr>
		</table>

	</form>

</body>
</html>