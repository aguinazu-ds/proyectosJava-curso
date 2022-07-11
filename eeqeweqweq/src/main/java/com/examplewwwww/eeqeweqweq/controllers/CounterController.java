package com.examplewwwww.eeqeweqweq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController extends HttpServlet {

    private static final long serialVersionUID = 1L; // this creates unique session IDs

    @RequestMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("counter") == null) { // if "counter" not in session, add attribute and set to 0;
            session.setAttribute("counter", 0);
        }
        session.setAttribute("counter", (int) session.getAttribute("counter") + 1); // increment session counter
        return "index";
    }

    @RequestMapping("/show")
    public String show(Model model, HttpSession session) {
        model.addAttribute("counter", session.getAttribute("counter")); // show session counts on page
        return "show";
    }

}
