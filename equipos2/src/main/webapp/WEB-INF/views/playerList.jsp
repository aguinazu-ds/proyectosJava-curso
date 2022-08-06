<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="models.Team" %>
 <%@ page import="models.Player" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jugadores</title>
</head>
<body>
<% Team team = Team.getTeams().get(Integer.parseInt(request.getParameter("id"))); %>
<p>test</p>
<p><%=team.getTeam_name() %></p>
<p><a href="/TeamRoster/addPlayer?id=<%=request.getParameter("id") %>">Nuevo Jugador</a></p>

<table>
<tr><th>Nombre</th><th>Apellido</th><th>Edad</th><th>Acciones</th></tr>
<%for(int i = 0; i < team.getPlayers().size(); i++ ){ %>
<tr><td><%= team.getPlayers().get(i).getFirst_name() %></td><td><%=team.getPlayers().get(i).getLast_name() %></td><td><%=team.getPlayers().get(i).getAge() %></td><td><a href="/equipos2/addPlayer?team_id=<%= request.getParameter("id")%>&player_id=<%=i%>&delete=true">Borrar</a></td></tr>
<%} %>
</table>
</body>
</html>