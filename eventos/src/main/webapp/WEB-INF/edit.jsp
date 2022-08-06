<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar</title>
</head>
<body>
    <h1 >${event.name}</h1>
    <h4 >Editar Evento</h4>
    <form:form action="/home/${event.id}" method="POST" modelAttribute="event" >
							<input type="hidden" name="_method" value="put">
							<p>
								<form:label path="name" >Nombre Evento</form:label>
								<form:input path="name" />
							</p>
							<p>
								<form:label path="date" >Fecha</form:label>
								<form:input path="date" type="date" />
							</p>
							<p>
								<form:label path="city" >Ciudad</form:label>
								<form:input path="city" />
							</p>
							<p>
								<form:label path="region" >Region</form:label>
                                <form:input path="region" />
											
										
							</p>
							<br>
							<div class="text-center pr-5">
								<input class="btn btn-warning " type="submit" value="Update Event"/>
							</div>
						</form:form>
			</div>
</body>
</html>