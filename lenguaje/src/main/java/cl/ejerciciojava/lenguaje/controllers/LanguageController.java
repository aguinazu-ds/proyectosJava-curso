package cl.ejerciciojava.lenguaje.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.ejerciciojava.lenguaje.models.Language;
import cl.ejerciciojava.lenguaje.services.LanguageService;

@Controller
// @RequestMapping("/languages")
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping("/")
    public String reroute() {
        return "redirect:/languages";
    }

    @RequestMapping("/languages")
    public String index(Model model, @ModelAttribute("language") Language language) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/index";
    }

    @RequestMapping(value = "/languages", method = RequestMethod.POST)
    public String newLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Language> languages = languageService.allLanguages();
            model.addAttribute("languages", languages);
            return "/languages";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }

    @RequestMapping("/{id}")
    public String languageInfoById(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/show";
    }

    @RequestMapping("/{id}/edit")
    public String editLanguage(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languagues/edit";
        } else {
            Long id = language.getId();
            String name = language.getName();
            String creator = language.getCreator();
            String version = language.getVersion();
            languageService.updateLanguage(id, name, creator, version);
            return "redirect:/languages";
        }
    }

    @RequestMapping(value = "/{id}/delete")
    public String deleteLanguage(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }

}
