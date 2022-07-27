<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Questiont</title>
</head>
<body>
    <form:form method="POST" action="/questions/new" modelAttribute="newQuestion">
		<form:hidden path="id"/>
		
     <form:label path="question">Name
     	<form:errors path="question"/>
     	<form:textarea path="question"/>
     </form:label><br>
     
     
     
     Tags: <input type="text" name="tagList"><br>
    
      <input type="submit" name="" value="Submit">
    </form:form>
</body>
</html>