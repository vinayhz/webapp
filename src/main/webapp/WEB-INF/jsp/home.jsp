<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	

	<form action="/user" method="post">
		Create New User: <input type="text" name="username" /> <input
			type="submit" value="Create">
	</form>
	<a href="/home">Home</a>
	<table border="1">
		<thead>
			<tr>
				<th>User Id</th>
				<th>User Name</th>
				<th>Status</th>
				<th>Created Date</th>
				<th>Last Updated Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td><a href="/user/getUser/${user.userId}"><c:out value="${user.userId}" /></a></td>
					<td><c:out value="${user.userName}" /></td>
					<td><c:out value="${user.isDeleted}" /></td>
					<td><c:out value="${user.created}" /></td>
					<td><c:out value="${user.updated}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>