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
    <title>Home</title>
</head>
<body>
    <table>
        <thead>
          <tr>
            <th >Evento</th>
            <th >Fecha</th>
            <th >Ciudad</th>
            <th >Anfitrion</th>
            <th >Accion</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${inRegion}" var="event">
              <tr>
                <td ><a href="events/${event.id }">${event.name}</a></td>
                <td><fmt:formatDate type = "date" dateStyle = "long" timeStyle = "long" value = "${event.date}" /></td>
                <td>${event.city}</td>
                <td>
                     ${fn:toUpperCase(fn:substring(event.user.firstName, 0, 1))}${fn:toLowerCase(fn:substring(event.user.firstName, 1,fn:length(event.user.firstName)))} ${fn:toUpperCase(fn:substring(event.user.lastName, 0, 1))}${fn:toLowerCase(fn:substring(event.user.lastName, 1,fn:length(event.user.lastName)))}
                </td>
                <td >
                    <c:choose>
                        <c:when test= "${event.user.id == user.id}">
                            <a href="home/edit/${event.id}"><button >Editar</button></a>
                            <form action="/home/${event.id}<c:out value="${language.id}"/>" method="post">
                                <input type="hidden" name="_method" value="delete">
                                <input type="hidden" name="userId" value="${user.id}">
                                <input type="submit" value="Borrar">
                            </form>
                            
                            
                        </c:when>
                        <c:when test="${event.user.id != user.id}">
                           <c:set var = "attending" value = "${false}"/>
                           <c:forEach items="${event.joinedUsers}" var="joinedUser">
                               <c:if test ="${joinedUser == user}">
                                   <c:set var="attending" value="${true}"/>
                               </c:if>
                               
                           </c:forEach>
                           <c:choose>
                               <c:when test="${attending == false}">
                                   <form:form action="/home/join" method="POST" modelAttribute="userEvent">
                                        <input type="hidden" value="${event.id}" name="event">
                                        <input type="hidden" value="${user.id}" name="user">
                                        <button  type="submit">Unirse</button>
                                    </form:form>
                                   
                               </c:when>
                               <c:otherwise>
                                   <Button disabled>Ya te uniste!</Button>
                                   <form action="/home/cancel<c:out value="${language.id}"/>" method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <input type="hidden" name="userId" value="${user.id}">
                                        <input type="hidden" name="eventId" value="${event.id}">
                                        <input type="submit"  value="Cancelar">
                                    </form>
                               </c:otherwise>
                           </c:choose>
                           
                        </c:when>
                        
                    </c:choose>
                </td>
              </tr>
          </c:forEach>
        </tbody>
      </table>
      <h4 >Aqui hay otros eventos en otras Regiones:</h4>
		<br>
		<br>
		<table >
		  <thead>
		    <tr>
		      <th scope="col" >Event0o/th>
		      <th scope="col" >Fecha</th>
		      <th scope="col" >Ciudad</th>
		      <th scope="col" >Region</th>
		      <th scope="col" >Anfitrion</th>
		      <th scope="col" >Accion</th>
		     
		    </tr>
		  </thead>
		  <tbody class="border border-warning">
		  	<c:forEach items="${outRegion}" var="event">
			    <tr>
			      <td ><a href="events/${event.id }">${event.name}</a></td>
			      <td><fmt:formatDate type = "date" dateStyle = "long" timeStyle = "long" value = "${event.date}" /></td>
			      <td>${event.city}</td>
			      <td>${event.region}</td>
			      <td>
			      	 ${fn:toUpperCase(fn:substring(event.user.firstName, 0, 1))}${fn:toLowerCase(fn:substring(event.user.firstName, 1,fn:length(event.user.firstName)))} ${fn:toUpperCase(fn:substring(event.user.lastName, 0, 1))}${fn:toLowerCase(fn:substring(event.user.lastName, 1,fn:length(event.user.lastName)))}
			      </td>
			      <td class="text-center">
			      	<c:choose>
			      		<c:when test= "${event.user.id == user.id}">
			      			<a href="home/edit/${event.id}"><button>Editar</button></a>
			      			<form action="/home/${event.id}<c:out value="${language.id}"/>" method="post" >
			      				<input type="hidden" name="_method" value="delete">
			      				<input type="hidden" name="userId" value="${user.id}">
			      				<input type="submit"  value="Borrar">
			      			</form>
			      			
			      		</c:when>
			      		<c:when test="${event.user.id != user.id}">
			     			<c:set var = "attending" value = "${false}"/>
			     			<c:forEach items="${event.joinedUsers}" var="joinedUser">
			     				<c:if test ="${joinedUser == user}">
			     					<c:set var="attending" value="${true}"/>
			     				</c:if>
			     				
			     			</c:forEach>
			     			<c:choose>
			     				<c:when test="${attending == false}">
			     					<form:form action="/home/join" method="POST" modelAttribute="userEvent">
					      				<input type="hidden" value="${event.id}" name="event">
					      				<input type="hidden" value="${user.id}" name="user">
					      				<button  type="submit">Unirse</button>
					      			</form:form>
			     					
			     				</c:when>
			     				<c:otherwise>
				     				<Button disabled>Ya te uniste!</Button>
				     				<form action="/home/cancel<c:out value="${language.id}"/>" method="post" class="d-inline-block">
					      				<input type="hidden" name="_method" value="delete">
					      				<input type="hidden" name="userId" value="${user.id}">
					      				<input type="hidden" name="eventId" value="${event.id}">
					      				<input type="submit"  value="Cancelar">
					      			</form>
			     				</c:otherwise>
			     			</c:choose>
			 
			      		</c:when>
			      	</c:choose>
			      </td>
			    
			      
			    </tr>
			</c:forEach>
		   </tbody>
		  </table>
          <h4 >Crear un evento!!</h4>
		<form:errors path="eventForm.*" element="p" />
		<form:form action="/home" method="POST" modelAttribute="eventForm">
			
			<p>
				<form:label path="name" >Nombre evento</form:label>
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
				<form:label path="region">Region</form:label>
                <form:input path="region"/>
						
			</p>
			<br>
			<div class="text-center pr-5">
				<Button type="submit" class="btn btn-info">Crear Evento</Button>
			</div>
		</form:form>
</body>
</html>