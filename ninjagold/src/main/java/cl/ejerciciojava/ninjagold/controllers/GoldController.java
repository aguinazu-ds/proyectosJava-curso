package cl.ejerciciojava.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {

    @RequestMapping("/gold")
    public String index(HttpSession session) {
        if (session.getAttribute("gold") == null) {
            ArrayList<String> registroActividades = new ArrayList<String>();
            session.setAttribute("gold", 0);
            session.setAttribute("registroActividades", registroActividades);
        }
        return "indexNinjaGold";
    }

    @RequestMapping(path = "/gold", method = RequestMethod.POST)
    public String updateGold(HttpSession session, @RequestParam(value = "lugarNinja") String lugarNinja) {

        String diaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        Integer gold = (Integer) session.getAttribute("gold");
        ArrayList<String> registroActividades = (ArrayList<String>) session.getAttribute("registroActividades");

        if (lugarNinja.equals("farm")) {

            int randomNumber = ThreadLocalRandom.current().nextInt(10, 21);
            session.setAttribute("gold", gold + randomNumber);
            registroActividades.add(0,
                    "Entraste a una granja y obtuviste " + randomNumber + " de oro. (" + diaHora + ")");
            session.setAttribute("registroActividades", registroActividades);

        } else if (lugarNinja.equals("cave")) {

            int randomNumber = ThreadLocalRandom.current().nextInt(5, 11);
            session.setAttribute("gold", gold + randomNumber);
            registroActividades.add(0,
                    "Entraste a una cueva y obtuviste " + randomNumber + " de oro. (" + diaHora + ")");
            session.setAttribute("registroActividades", registroActividades);

        } else if (lugarNinja.equals("house")) {

            int randomNumber = ThreadLocalRandom.current().nextInt(2, 6);
            session.setAttribute("gold", gold + randomNumber);
            registroActividades.add(0,
                    "Entraste a una casa y obtuviste " + randomNumber + " de oro. (" + diaHora + ")");
            session.setAttribute("registroActividades", registroActividades);

        } else if (lugarNinja.equals("casino")) {

            if (gold.equals(0)) {
                registroActividades
                        .add(0, "Entraste al casino, pero no tienes oro que apostar. Vuelve cuando tengas algo de oro. ("
                                + diaHora + ")");
                session.setAttribute("registroActividades", registroActividades);
                return "redirect:/gold";
            }

            int randomNumber = ThreadLocalRandom.current().nextInt(-50, 51);

            if (gold + (randomNumber) < 0) {

                session.setAttribute("gold", 0);
                registroActividades.add(0, "Entraste al casino y perdiste todo tu oro. (" + diaHora + ")");
                session.setAttribute("registroActividades", registroActividades);

            } else if (gold + (randomNumber) >= 0) {

                session.setAttribute("gold", gold + randomNumber);
                registroActividades
                        .add(0, "Entraste al casino y obtuviste " + randomNumber + " de oro. (" + diaHora + ")");
                session.setAttribute("registroActividades", registroActividades);

            }
        }

        return "redirect:/gold";
    }
}
