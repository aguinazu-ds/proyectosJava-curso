<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Preguntas</title>
</head>
<body>
    <table class="table">
		<tr>
			<td>Pregunta</td>
			<td>Tags</td>
		<tr>
		<c:forEach items="${questions}" var="question" >
			<tr>
			<td> <a href="/questions/${question.id}"><c:out value="${question.question}"/></a> </td>
			<td>
				<c:forEach items="${ question.tags }" var="tag" >
					<span> <c:out value="${ tag.subject }"/> </span>
				</c:forEach>
			  </td>
			</tr>
		</c:forEach>
	</table>
	<a href="/questions/new">Nueva Pregunta</a>
</body>
</html>