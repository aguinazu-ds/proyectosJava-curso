package cl.ejerciciojava.enrutamiento2.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
    @RequestMapping("{bootcamp}")
    public String dojo(@PathVariable("bootcamp") String bootcamp) {
        if (bootcamp.equals("dojo")) {
            return "El dojo es increible";
        }
        if (bootcamp.equals("burbank-dojo")) {
            return "El dojo Burbank esta localizado al sur de California";
        }
        if (bootcamp.equals("san-jose")) {
            return "El Dojo SJ es el cuartel general";
        }
        return "";
    }
}
