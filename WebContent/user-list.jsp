<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Users</title>
<style>
	table, td, th {
	  border: 1px solid black;
	}
	h1 {
		text-align: center;
	}
	h3{
		margin-left: -370px;
		text-align: center;
	}
	table {
	  border-collapse: collapse;
	}
	.marginLeft {
		margin-left: 388px
	}
	
</style>
</head>
<body>
	<h1>List Of Users</h1>
	<h3><a href="/WebApplicationDemo/newUser">Add New User </a></h3>
	<table class="marginLeft">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email ID</th>
			<th>Country</th>
			<th>Action</th>
		</tr>
		<c:forEach var="user" items="${listOfUsers}">
			<tr>
				<td><c:out value="${user.id}"/></td>
				<td><c:out value="${user.name}"/></td>
				<td><c:out value="${user.emailId}"/></td>
				<td><c:out value="${user.country}"/></td>
				<td>
					<a href="/WebApplicationDemo/editUser?id=<c:out value='${user.id}'/>">EDIT</a> &nbsp&nbsp
				 	<a href="/WebApplicationDemo/deleteUser?id=<c:out value='${user.id}'/>">DELETE</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>