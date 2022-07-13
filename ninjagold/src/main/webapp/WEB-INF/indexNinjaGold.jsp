<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>Ninja Gold</title>
</head>
<body>
    <div class="container">

        <div class="row d-flex justify-content-center">
            <h1>Ninja Gold</h1>
        </div>

        <div class="row score mb-2">
            <h3>Oro: <span> <c:out value="${gold}"></c:out></span></h3>
        </div>

        <div class="row">
            <div class="place border col-md-3 pt-2 pb-4">
                <h3 class="d-flex justify-content-center">Granja</h3>
                <p class="d-flex justify-content-center">(gana 10-20 oro)</p>
                <form action="/gold" method="post" class="d-flex justify-content-center">
                    <input type="hidden" name="lugarNinja" value="farm" />
                    <input type="submit" value="Entrar!" class="btn btn-warning" />
                </form>
            </div>
            <div class="place border col-md-3 pt-2 pb-4">
                <h3 class="d-flex justify-content-center">Cueva</h3>
                <p class="d-flex justify-content-center">(gana 5-10 oro)</p>
                <form action="/gold" method="post" class="d-flex justify-content-center">
                    <input type="hidden" name="lugarNinja" value="cave" />
                    <input type="submit" value="Entrar!" class="btn btn-warning" />
                </form>
            </div>
            <div class="place border col-md-3 pt-2 pb-4">
                <h3 class="d-flex justify-content-center">Casa</h3>
                <p class="d-flex justify-content-center">(gana 2-5 oro)</p>
                <form action="/gold" method="post" class="d-flex justify-content-center">
                    <input type="hidden" name="lugarNinja" value="house" />
                    <input type="submit" value="Entrar!" class="btn btn-warning" />
                </form>
            </div>
            <div class="place border col-md-3 pt-2 pb-4">
                <h3 class="d-flex justify-content-center">Casino</h3>
                <p class="d-flex justify-content-center"> (gana/pierde 0-50 oro)</p>
                <form action="/gold" method="post" class="d-flex justify-content-center">
                    <input type="hidden" name="lugarNinja" value="casino" />
                    <input type="submit" value="Entrar!" class="btn btn-warning" />
                </form>
            </div>
        </div>

        <div class="row mt-2">
            <h5><u>Registro Actividades</u>:</h5>
            <div class="activities border pl-3 mb-2">
                <c:forEach var="actividades" items="${registroActividades}">
                    <p style="margin: 0px;"><c:out value="${actividades}" /></p>
                </c:forEach>
            </div>

        </div>
     
    </div>
    
</body>
</html>