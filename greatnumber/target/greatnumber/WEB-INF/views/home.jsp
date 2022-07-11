<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Great Number</title>
</head>
<body>
    <h1> Bienvenido al juego del Gran Número</h1>
    <h2> Estoy pensando en un número entre 1 y 100</h2>
    <h2> Adivina cual es!</h2>
    <form action="/greatnumber/check" method='POST'>

    <input type="number" name="number">

    <input type="submit" name="" value="Enviar">
    </form>
    <form action='/greatnumber/reset'>
    <input type="submit" name="" value="Volver a Jugar!">
    </form>
    <h1><c:out value="${mensaje}"/> </h1>
</body>
</html>