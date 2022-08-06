<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<header>
	<h1>Welcome ${currentUser.firstName}!</h1>

    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</header>
<table class="profile">
    <tr>
        <td>First Name</td>
        <td>${currentUser.firstName}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${currentUser.lastName}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${currentUser.email}</td>
    </tr>
    <tr>
        <td>Sign up date:</td>
        <td><fmt:formatDate pattern="MMMMM dd, yyyy HH:mm:ss" value = "${currentUser.createdAt}" /></td>
    </tr>
    <tr>
        <td>Last sign in:</td>
        <td><fmt:formatDate pattern="MMMMM dd, yyyy HH:mm:ss" value = "${currentUser.updatedAt}" /></td>
    </tr>
</table>
</body>
</html>