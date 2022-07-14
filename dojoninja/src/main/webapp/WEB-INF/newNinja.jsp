<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Ninja</title>
</head>
<body>
<h1>Crear Nuevo Ninja</h1>
<form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
    <form:label path="dojo">Dojo:
        <form:errors path="dojo" />
        <form:select path="dojo">
            <c:forEach items="${dojos}" var="dojo">
                <form:option value="${dojo.id}">${dojo.name}</form:option>
            </c:forEach>
        </form:select>
    </form:label>
    
    <form:label path="firstName">Nombre:
    <form:errors path="firstName" />
    <form:input path="firstName" /></form:label>

	<form:label path="lastName">Apellido:
	<form:errors path="lastName" />
    <form:input path="lastName" /></form:label>
    
    <form:label path="age">Edad:
    <form:errors path="age" />
    <form:input path="age" /></form:label>
    
    <input type="submit" value="Crear" />
</form:form>
</body>
</html>