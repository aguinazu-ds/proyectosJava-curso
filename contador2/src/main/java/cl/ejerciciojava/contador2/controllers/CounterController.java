package cl.ejerciciojava.contador2.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @RequestMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("counter") == null) {
            session.setAttribute("counter", 0);
        }
        session.setAttribute("counter", (int) session.getAttribute("counter") + 1);
        return "index";
    }

    @RequestMapping("/counter")
    public String counter(Model model, HttpSession session) {
        model.addAttribute("counter", session.getAttribute("counter"));
        return "contadorvisitas";
    }
}
