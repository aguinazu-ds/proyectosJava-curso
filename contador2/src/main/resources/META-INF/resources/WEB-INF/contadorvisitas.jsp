<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contador</title>
</head>
<body>
    <h1>Has visitado <a href="http://localhost:8080/">http://localhost:8080/</a> <c:out value="${counter}"/> veces</h1>

    <h2><a href="http://localhost:8080/"></a> Quieres visitar la pagina otra vez?</h2>
</body>
</html>