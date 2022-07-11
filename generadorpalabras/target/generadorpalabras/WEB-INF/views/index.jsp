<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Generador Palabras</title>
</head>
<body>
    <h1> Haz generado <c:out value="${count}"/> palabras </h1>
    <!-- <h1><c:out value="${word}"/></h1> -->
    <a href="Index"><button type="button">Generar</button></a>
    <!-- <h1><c:out value="${datetime}"/></h1> -->
</body>
</html>