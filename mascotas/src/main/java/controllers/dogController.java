package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Dog;

@WebServlet("/dogController")
public class dogController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public dogController(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        Double weight = Double.parseDouble(req.getParameter("weight"));

        Dog dog = new Dog(name, breed, weight);

        req.setAttribute("dog", dog);
        RequestDispatcher view = req.getRequestDispatcher("WEB-INF/views/dog.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
