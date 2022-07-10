package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cat;

@WebServlet("/catController")
public class catController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public catController(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        Double weight = Double.parseDouble(req.getParameter("weight"));

        Cat cat = new Cat(name, breed, weight);

        req.setAttribute("cat", cat);
        RequestDispatcher view = req.getRequestDispatcher("WEB-INF/views/cat.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
