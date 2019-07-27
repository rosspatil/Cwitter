<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cwitter</title>
</head>
<body>
	<form>
		<table>
			<tr>
				<td><jsp:include page="SimpleHeader.jsp"></jsp:include>
			</tr>
			<tr>
				<td><jsp:include page="WriteTwit.jsp"></jsp:include></td>
			</tr>

			<tr>
				<td><jsp:include page="Twit.jsp"></jsp:include>
			</tr>



		</table>
	</form>
</body>
</html>