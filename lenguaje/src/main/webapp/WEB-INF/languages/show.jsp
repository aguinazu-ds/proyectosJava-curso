<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lenguaje Programacion</title>
</head>
<body>
    <div class="container m-5">
        <h1><c:out value="${language.name}"/></h1>
        <p>Creador: <c:out value="${language.creator}"/></p>
        <p>Version: <c:out value="${language.version}"/></p>
        <p>
            <a href="/${language.id}/edit">Editar</a>
            <a href="/${language.id}/delete">Borrar</a>  
        </p>
    </div>
</body>
</html>