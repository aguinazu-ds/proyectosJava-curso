package cl.ejerciciojava.lenguaje.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.ejerciciojava.lenguaje.models.Language;
import cl.ejerciciojava.lenguaje.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping("/")
    public String reroute() {
        return "redirect:/languages";
    }

    @RequestMapping("")
    public String index(Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/index";
    }

    @RequestMapping(value = "/languages", method = RequestMethod.POST)
    public String newLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }

    



}
