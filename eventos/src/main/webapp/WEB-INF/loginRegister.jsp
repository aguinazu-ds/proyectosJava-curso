<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eventos</title>
</head>
<body>
    <form:form action="/register" method="POST" modelAttribute="userRegister">
        <h2>Registro</h2>
        	
		<p>
			<form:label path="firstName" >Nombre</form:label>
			<form:input path="firstName"/>
		</p>
		<p>
		    <form:label path="lastName" >Apellido</form:label>
		    <form:input path="lastName" />
		</p>
		<p>
			<form:label path="email" >E-Mail</form:label>
			<form:input path="email" />
		</p>
		<p>
			<form:label path="city" >Ciudad</form:label>
			<form:input path="city"/>
		</p>
		<p>
			<form:label path="region">Region</form:label>
			<form:input path="region"/>
		</p>
		<p>
			<form:label path="password" >Contraseña</form:label>
			<form:input path="password" type="password"/>
		</p>
		<p>
			<form:label path="passwordConfirmation" >Confirmar contraseña</form:label>
			<form:input path="passwordConfirmation" type="password" />
		</p>
		<br>
		<div >
		<Button type="submit">Registrar</Button>
		</div>
        <h2>Login</h2>
            </form:form>
            <form method="POST" action="/Login">
            <p>
                <label>Email</label>
                <input type="text" name="email">
            </p>
            <p>
                <label >Password</label>
                <input type="password" name="password">
            </p>
		<div >
			<Button type="submit">Login</Button>
		</div>
		</form>
</body>
</html>