<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.dusty.teamroster.models.Team" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/TeamRoster/newTeam">Nuevo Equipo</a>
<table>
<tr><th>Equipo</th><th>Jugadores</th><th>Accion</th></tr>

<%for(int i = 0; i < Team.getTeams().size();i++){ %>
<tr>
<td><%= Team.getTeams().get(i).getTeam_name() %></td><td><%= Team.getTeams().get(i).getPlayers().size() %></td><td><a href="/TeamRoster/teams?id=<%=i%>">Detalles</a> <a href="/TeamRoster/teams?id=<%=i%>&delete=true">Borrar</a></td>
</tr>
<%} %>

</table>

</body>
</html>