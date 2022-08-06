<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Informacion Evento</title>
</head>
<body>
    <h1 >${event.name}</h1>
				<div class="mt-4 ">
					<h5>Anfitrion: ${fn:toUpperCase(fn:substring(event.user.firstName, 0, 1))}${fn:toLowerCase(fn:substring(event.user.firstName, 1,fn:length(event.user.firstName)))} ${fn:toUpperCase(fn:substring(event.user.lastName, 0, 1))}${fn:toLowerCase(fn:substring(event.user.lastName, 1,fn:length(event.user.lastName)))}</h5>
					<h5>Fecha: <fmt:formatDate type = "date" dateStyle = "long" timeStyle = "long" value = "${event.date}" /></h5>
					<h5>Ubicacion: ${event.city}, ${event.region}</h5>
					<br>
					<div>
						<h4 >Asistentes</h4>
						<table >
							<thead>
							<tr>
								<th >Nombre</th>
								<th >Ubicacion</th>
							</tr>
							</thead>
							<tbody >
								<c:forEach items="${event.joinedUsers}" var="j">
								
										<tr>
											<td>${j.firstName } ${j.lastName} </td>
											<td>${j. city }, ${j.region }</td>
										</tr>				
								</c:forEach>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<br>
			<div >
				<h4 ><small>Mensajes</small></h4>
				<div >
					<c:forEach items="${event.comments}" var="comment">
						<c:choose>
							<c:when test="${comment.user.id == user.id}">
								<p><u >${fn:toUpperCase(fn:substring(comment.user.firstName, 0, 1))}${fn:toLowerCase(fn:substring(comment.user.firstName, 1,fn:length(comment.user.firstName)))} ${fn:toUpperCase(fn:substring(comment.user.lastName, 0, 1))}${fn:toLowerCase(fn:substring(comment.user.lastName, 1,fn:length(comment.user.lastName)))}</u> - ${comment.content} </p>
								<p ></p>
							</c:when>
							<c:otherwise>
								<p ><u >${fn:toUpperCase(fn:substring(comment.user.firstName, 0, 1))}${fn:toLowerCase(fn:substring(comment.user.firstName, 1,fn:length(comment.user.firstName)))} ${fn:toUpperCase(fn:substring(comment.user.lastName, 0, 1))}${fn:toLowerCase(fn:substring(comment.user.lastName, 1,fn:length(comment.user.lastName)))}</u> - ${comment.content}</p>
								<p ></p>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
				<br>
				<form:form action="/events/${event.id}" method="POST" modelAttribute="addComment">
					<form:input path="content"  placeholder="Comment here"/>
					<p><form:errors path="content"/></p>
					<br>
					<div>
						<Button type="submit" >Add Comment</Button>
					</div>
				</form:form>
</body>
</html>