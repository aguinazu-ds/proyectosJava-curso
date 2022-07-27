<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pregunta</title>
</head>
<body>
    <h1> <c:out value="${question.question}"/> </h1>
	<p>Tags: 
		<c:forEach items="${question.tags}" var="tag" >
					<span> <c:out value="${tag.subject}"/> </span>
		</c:forEach>
	</p>
	<table>
		<tr>
			<td>Respuestas</td>
		<tr>
		<c:forEach items="${question.answers}" var="answer" >
			<tr>
			<td> <c:out value="${answer.answer}"/> </td>
			</tr>
		</c:forEach>
	</table>
		<p>Responde a esta pregunta</p>
		
		<form:form method="POST" action="/questions/${question.id}" modelAttribute="newAnswer">
		
		
     <form:label path="answer">Respuesta:
     	<form:errors path="answer"/>
     	<form:textarea path="answer"/>
     </form:label><br>
 
    
      <input type="submit" name="" value="Responder">
    </form:form>
</body>
</html>