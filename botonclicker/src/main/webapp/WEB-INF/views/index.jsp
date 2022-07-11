<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Click</title>
</head>
<body>
 <a href="index"><button type="button">Click Me</button></a>
 
 <h1> Haz hecho click <c:out value="${click}"/> veces </h1>
</body>
</html>