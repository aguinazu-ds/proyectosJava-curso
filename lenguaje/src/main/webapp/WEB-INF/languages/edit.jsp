<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>Editar</title>
</head>
<body>
    <div class=container>
        <div class=row>
        
            <div class=col-sm-4></div>
            <div class="col-sm-4 text-center">
            
                <form:form method="PUT" action="/${id}" modelAttribute="language">
                    <p>
                    <form:label path="name">Language<br>
                    <form:input path="name"/><br>
                    <form:errors path="name"/>
                    </form:label>
                    </p>
                    <p>
                    <form:label path="creator">Creator<br>
                    <form:input path="creator"/><br>
                    <form:errors path="creator"/>
                    </form:label>
                    </p>
                    <p>
                    <form:label path="version">Version<br>
                    <form:input path="version"/><br>
                    <form:errors path="version"/>
                    </form:label>
                    </p>
                    <p><input class="btn" type="submit" value="Enviar"/></p>
                    
                </form:form>
        
            </div>
</body>
</html>