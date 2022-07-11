package cl.ejerciciojava.enrutamiento2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
    @RequestMapping("")
    public String hello() {
        return "Hola codigo dojo!!!";
    }

    @RequestMapping("/python")
    public String python() {
        return "Python/Django fue increible";
    }

    @RequestMapping("/java")
    public String java() {
        return "Java/Spring es mejor!!!";
    }
}
