<%@page import="java.sql.ResultSet"%>
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
<center>
	<table>
		<jsp:useBean id="dbBean" scope="application"
			class="com.rosspatil.DbBean" />
		<%
			ResultSet rs = dbBean.getTweets();

			while (rs.next()) {
		%>

		<tr>


			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><img
				src="/Cwitter/PhotoServlet?userId=<%=URLEncoder.encode(rs.getString(1), "UTF-8")%>"
				height="50" width="40" /></td>
			<td><%=dbBean.getUser(rs.getString(1)).getFirstName()+" "+dbBean.getUser(rs.getString(1)).getLastName() %></td>

		</tr>
		<tr>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><jsp:include page="Blank.jsp"></jsp:include></td>
			<td><%=rs.getString(2)%></td>
		</tr>
		<%
			}
		%>
	</table>
	</center>
</body>
</html>