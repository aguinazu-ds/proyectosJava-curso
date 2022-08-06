package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Team;

@WebServlet("/newTeam")
public class NewTeam extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NewTeam() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.getRequestDispatcher("/WEB-INF/views/newTeam.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("team_name") != null) {
            Team.addTeam(request.getParameter("team_name"));
            response.sendRedirect("/equipos2");
        } else {
            doGet(request, response);
        }

    }

}
