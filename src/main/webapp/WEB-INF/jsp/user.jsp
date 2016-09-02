<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>

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
					<td><c:out value="${user.userId}" /></td>
					<td><c:out value="${user.userName}" /></td>
					<td><c:out value="${user.isDeleted}" /></td>
					<td><c:out value="${user.created}" /></td>
					<td><c:out value="${user.updated}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<%-- 	Name: ${userName} --%>
<%-- 	<br> Id: ${userId} --%>
<%-- 	<br> Created Date: ${created} --%>
<%-- 	<br> Updated Date: ${lastUpdated} --%>
<%-- 	<br> Status: ${status} --%>
</body>

</html>