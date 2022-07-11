package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/check")
public class Check extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Check() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer randomNumber = (Integer) session.getAttribute("randomNumber");
        Integer number = Integer.valueOf(req.getParameter("number"));
        String mensaje = "";

        if (Integer.compare(number, randomNumber) == 0) {
            mensaje = "Muy bien, "+randomNumber+"era la respuesta correcta!!!";
        } else if ((int)number > (int)randomNumber) {
            mensaje = "Muy grande, elige un número menor!!!";
        } else if ((int)number < (int)randomNumber) {
            mensaje = "Muy pequeño, elige un número mayor!!!";
        }

        req.setAttribute("mensaje", mensaje);
        req.setAttribute("number", number);

        RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/home.jsp");
        view.forward(req, resp);
    }
}
