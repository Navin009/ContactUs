<!DOCTYPE html>
<%@page import="com.company.Request"%>
<%@page import="com.company.RequestDao"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Requests</title>
<link rel="stylesheet" href="./css/dasboard.css">
</head>
<%
Cookie[] cookies = request.getCookies();
boolean isLoggedIn = false;
for (Cookie cookie : cookies) {
	if (cookie.getName().equals("UID")) {
		isLoggedIn = true;
	}
}

if (!isLoggedIn) {
	response.sendRedirect("/login");
}
%>
<body>
	<button class="signout-btn" onclick="signOutUser()">Sign Out</button>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Message</th>
				<th>Active</th>
			</tr>
		</thead>
		<tbody>
			<%
			RequestDao requestDao = new RequestDao();
			List<Request> activeRequests = requestDao.getAllActiveRequests();
			if (activeRequests != null) {
				for (Request requestRow : activeRequests) {
			%>
			<tr>
				<td><%=requestRow.getName()%></td>
				<td><%=requestRow.getEmail()%></td>
				<td>
					<div class="message"><%=requestRow.getMessage()%></div>
				</td>
				<td><input type="checkbox" name="" id="" checked></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Message</th>
				<th>Archive</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Request> archiveRequests = requestDao.getAllArchiveRequests();
			if (archiveRequests != null) {
				for (Request requestRow : archiveRequests) {
			%>
			<tr>
				<td><%=requestRow.getName()%></td>
				<td><%=requestRow.getEmail()%></td>
				<td>
					<div class="message"><%=requestRow.getMessage()%></div>
				</td>
				<td><input type="checkbox" name="" id="" checked></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
	<script src="./js/script.js"></script>
</body>

</html>