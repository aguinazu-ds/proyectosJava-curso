<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mascotas</title>
</head>
<body>
    <h3>Perro</h3>
	<div class="dogbox">
		
		<form action="dogController" method=get >
			<input name="name" placeholder="Nombre">
			<br>
			<input name="breed" placeholder="Raza">
			<br>
			<input name="weight" placeholder="Peso">
			<br>
			<button type="submit">Crear un perro</button>
			 
		</form>
	</div>
	
	<h3>Gato</h3>
	<div class="dogbox">
		
		<form action="catController" method=get >
			<input name="name" placeholder="Nombre">
			<br>
			<input name="breed" placeholder="Raza">
			<br>
			<input name="weight" placeholder="Peso">
			<br>
			<button type="submit">Crear un gato</button>
			 
		</form>
	</div>
</body>
</html>