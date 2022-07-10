import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String favoriteLanguage = req.getParameter("favoriteLanguage");
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String homeTown = req.getParameter("homeTown");

        if (favoriteLanguage == null) {
            favoriteLanguage = "Unknown";
        }
        if (lastName == null) {
            lastName = "Unknown";
        }
        if (firstName == null) {
            firstName = "Unknown";
        }
        if (homeTown == null) {
            homeTown = "Unknown";
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<h1> Welcome, "+firstName+" "+lastName+"</h1>"
        +"<p> Your favorite language is: "+favoriteLanguage+"</p>"
        +"<p> Your hometown is: "+homeTown+"</p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}


