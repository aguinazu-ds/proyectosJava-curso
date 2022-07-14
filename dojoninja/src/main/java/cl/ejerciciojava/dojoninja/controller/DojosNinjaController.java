package cl.ejerciciojava.dojoninja.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ejerciciojava.dojoninja.models.Dojo;
import cl.ejerciciojava.dojoninja.models.Ninja;
import cl.ejerciciojava.dojoninja.services.DojoService;
import cl.ejerciciojava.dojoninja.services.NinjaService;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DojosNinjaController {
    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public DojosNinjaController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @RequestMapping("/dojos/new")
    public String dojos(@Validated @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        return "newDojo";
    }

    @RequestMapping(value = "/dojos/new", method = RequestMethod.POST)
    public String newDojo(@Validated @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "newDojo";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/ninjas/new";
        }
    }

    @RequestMapping("/ninjas/new")
    public String newNinjaForm(Model model, @Validated @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "newNinja";
    }

    @RequestMapping(value = "/ninjas/new", method = RequestMethod.POST)
    public String createNinja(Model model, @Validated @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            List<Dojo> dojos = dojoService.allDojos();
            model.addAttribute("dojos", dojos);
            return "newNinja";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/dojos/" + ninja.getDojo().getId();
        }
    }

    @RequestMapping("/dojos/{id}")
    public String showNinjasDojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "showDojo";
    }
}
