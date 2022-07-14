<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>Lenguajes Programacion</title>
</head>
<body>
    <div class="container m-5">
        <table class="table">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Creador</th>
                    <th>Version</th>
                    <th>Editar/Borrar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${languages}" var="language">
                    <tr>    
                    <td><a href="/${language.id}"><c:out value="${language.name}"/></a></td>
                    <td><c:out value="${language.creator}"/></td>
                    <td><c:out value="${language.version}"/></td>
                    <td><a href="/${language.id}/edit">Editar</a></td>
                    <td><a href="/${language.id}/delete">Borrar</a></td>
                    </tr>
		        </c:forEach>
            </tbody>
        </table>
        <h1>Agregar un nuevo lenguaje de programacion</h1>
        <form:form action="/languages" method="post" modelAttribute="language">
            <p>
                <form:label path="name">Nombre</form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </p>
            <p>
                <form:label path="creator">Creador</form:label>
                <form:errors path="creator"/>
                <form:input path="creator"/>
            </p>
            <p>
                <form:label path="version">Version</form:label>
                <form:errors path="version"/>
                <form:input path="version"/>
            </p>   
            <input type="submit" value="Enviar"/>
        </form:form>

    </div>
</body>
</html>

