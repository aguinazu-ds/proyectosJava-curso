package controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Index")
public class Index extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public Index() {
        super();
    }    

    public String generateString() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(7);

        for (int i = 0; i < 7; i++) {
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }

        return builder.toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.isNew()) {
            session.setAttribute("count", 0);
            session.setAttribute("word", " ");
            session.setAttribute("datetime", " ");
        } else {
            int count = (int) session.getAttribute("count");
            count+=1;
            session.setAttribute("count", count);
            req.setAttribute("count", count);

            LocalDateTime datetime = LocalDateTime.now();
            req.setAttribute("datetime", datetime.toString());

            String word = generateString();
            req.setAttribute("word", word);
        }
        RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/Index.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
