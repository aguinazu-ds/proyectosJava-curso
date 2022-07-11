package controllers;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/reset")
public class Reset extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Reset() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int randomNumber = ThreadLocalRandom.current().nextInt(1,101);
        String mensaje = "";

        req.setAttribute("mensaje", mensaje);
        req.setAttribute("randomNumber", randomNumber);
        session.setAttribute("randomNumber", randomNumber);

        RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/home.jsp");
        view.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
