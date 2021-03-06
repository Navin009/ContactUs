<!DOCTYPE html>
<%@page import="com.model.Request"%>
<%@page import="com.dao.RequestDao"%>
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
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");

boolean isLoggedIn = false;

if (session.getAttribute("email") != null && session.getAttribute("password") != null) {
	isLoggedIn = true;
}

if(!isLoggedIn){
	response.sendRedirect("./login");
}

%>
<body>
	<button class="signout-btn"
		onclick="window.location.href = './signout';">Sign Out</button>
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
			
			List<Request> activeRequests = (List<Request>) request.getAttribute("activeRequests");
			if (activeRequests != null) {
				for (Request requestRow : activeRequests) {
			%>
			<tr>
				<td><%=requestRow.getName()%></td>
				<td><%=requestRow.getEmail()%></td>
				<td>
					<div class="message"><%=requestRow.getMessage()%></div>
				</td>
				<td><input type="checkbox" name="" id=""
					onclick="makeRequestArchive(<%=requestRow.getId()%>)" checked></td>
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
			
			List<Request> archiveRequests = (List<Request>) request.getAttribute("archiveRequests");
			if (archiveRequests != null) {
				for (Request requestRow : archiveRequests) {
			%>
			<tr>
				<td><%=requestRow.getName()%></td>
				<td><%=requestRow.getEmail()%></td>
				<td>
					<div class="message"><%=requestRow.getMessage()%></div>
				</td>
				<td><input type="checkbox" name="" id=""
					onclick="makeRequestActive(<%=requestRow.getId()%>)" checked></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
	<script type="text/javascript">
	function makeRequestArchive(id){
		let xhr = new XMLHttpRequest();
		xhr.open("POST" , "./dashboard");
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		let body = "id="+id + "&status=active";
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				window.location.reload();
			}
		}
		xhr.send(body);
	}
	
	function makeRequestActive(id){
		let xhr = new XMLHttpRequest();
		xhr.open("POST" , "./dashboard");
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		let body = "id="+id + "&status=archive";
		xhr.onreadystatechange = function () {
			if (xhr.readyState == 4 && xhr.status == 200) {
				window.location.reload();
			}
		}
		xhr.send(body);
	}
	</script>
</body>

</html>