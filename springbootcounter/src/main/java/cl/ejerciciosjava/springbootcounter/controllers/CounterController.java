package cl.ejerciciosjava.springbootcounter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CounterController {
    @RequestMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("counter") == null) {
            session.setAttribute("counter", 0);
        }
        session.setAttribute("counter", (int) session.getAttribute("counter") + 1);
        return "home.jsp";
    }
}
