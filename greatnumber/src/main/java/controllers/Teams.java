package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Team;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/teams")
public class Teams extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        if (request.getParameter("delete") != null) {
            Team.getTeams().remove(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect("/TeamRoster");
        } else {
            request.getRequestDispatcher("/WEB-INF/views/playerList.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        if (request.getParameter("id") != null) {
            Team.getTeams().get(Integer.parseInt(request.getParameter("id"))).addPlayer(
                    request.getParameter("first_name"), request.getParameter("last_name"),
                    Integer.parseInt(request.getParameter("age")));
            response.sendRedirect("/TeamRoster/teams?id=" + request.getParameter("id"));
        } else {
            doGet(request, response);
        }

    }

}
