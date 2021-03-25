<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
<script>
	function back(){
		window.location = "http://localhost:8080/WebApplicationDemo/";
	}
</script>
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
	h2{
		margin-left: -257px;
		text-align: center;
	}
	
</style>
</head>
<body>
	<c:if test="${user == null}">
		<h2>User Registration Form</h2>
		<form action="insertUser" method="post">
	</c:if>
	<c:if test="${user != null}">
		<h2>Edit User Form</h2>
		<form action="updateUser" method="post">
		<input type="hidden" name="id" value="${user.id}"/>
	</c:if>
		<table class="marginLeft">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${user.name}" required="required"/></td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><input type="text" name="emailId" value="${user.emailId}" required="required"/></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><input type="text" name="country" value="${user.country}"/></td>
			</tr>
			<tr>
				<td><button type="submit">Save</button></td>
				<td><button type="button" onclick="back();">Cancel</button></td>
			</tr>
		</table>
	</form>
</body>
</html>