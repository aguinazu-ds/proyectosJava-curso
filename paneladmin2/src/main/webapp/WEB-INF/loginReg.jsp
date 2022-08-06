<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login/Registration</title>
</head>
<body>
<div class="wrapper">
	<c:if test="${logoutMessage != null}">
        <p style="color:red">${logoutMessage}"</p>
    </c:if>
	<fieldset>
	    <legend>Login</legend>
	    <c:if test="${errorMessage != null}">
	        <p style="color:red">${errorMessage}</p>
	    </c:if>
	    <form method="POST" action="/login">
		<table>
		    <tr>
		        <td><label for="username">Email</label></td>
		        <td><input type="text" id="username" name="username" /></td>
		    </tr>
		    <tr>
		        <td><label for="password">Password</label></td>
		        <td><input type="password" id="password" name="password" /></td>
		    </tr>
		    <tr>
		        <td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
		        <td><input type="submit" value="Login!" /></td>
		    </tr>
		</table>
		</form>
    </fieldset>
    <fieldset>
	    <legend>Register</legend>
	    <p><form:errors path="user.*"/></p>

	    <form:form method="POST" action="/registration" modelAttribute="user">
		<table>
		    <tr>
		        <td><form:label path="email">Email:</form:label></td>
		        <td></td>
		        <td><form:input path="email"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="firstName">First Name:</form:label></td>
		        <td></td>
		        <td><form:input path="firstName"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="lastName">Last Name:</form:label></td>
		        <td></td>
		        <td><form:input path="lastName"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="password">Password:</form:label></td>
		        <td></td>
		        <td><form:password path="password"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="passwordConfirmation">Password Confirm:</form:label></td>
		        <td></td>
		        <td><form:password path="passwordConfirmation"/></td>
		    </tr>
		    <tr>
		        <td></td>
		        <td></td>
		        <td><input type="submit" value="Register!" /></td>
		    </tr>

		</table>
		</form:form>
    </fieldset>
</div>
</body>
</html>