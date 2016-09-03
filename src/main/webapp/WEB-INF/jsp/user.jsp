<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>

	<form action="/edit/${user.userId}">
		Username: <input type="text" name="userName" value="${user.userName}" />
		<input type="submit" value="Update" />
	</form>

</body>

</html>