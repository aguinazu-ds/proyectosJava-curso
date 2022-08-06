package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Team;

@WebServlet("/addPlayer")
public class Players extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        if (request.getParameter("delete") != null) {
            Team.getTeams().get(Integer.parseInt(request.getParameter("team_id"))).getPlayers()
                    .remove(Integer.parseInt(request.getParameter("player_id")));
            response.sendRedirect("/equipos2/teams?id=" + request.getParameter("team_id"));
        } else {
            request.getRequestDispatcher("WEB-INF/views/newPlayer.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
