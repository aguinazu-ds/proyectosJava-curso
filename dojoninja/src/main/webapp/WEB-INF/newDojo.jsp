<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nuevo Dojo</title>
</head>
<body>
    <h1>Crear nuevo Dojo</h1>
<form:form method="POST" action="/dojos/new" modelAttribute="dojo">
	<form:label path="name">Nombre:
    <form:errors path="name" />
    <form:input path="name" /></form:label>
    
	<input type="submit" value="Crear" />
</form:form>
</body>
</html>