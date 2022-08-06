package cl.ejerciciojava.eventos.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.ejerciciojava.eventos.models.Comment;
import cl.ejerciciojava.eventos.models.Event;
import cl.ejerciciojava.eventos.models.User;
import cl.ejerciciojava.eventos.models.UserEvent;
import cl.ejerciciojava.eventos.services.EventProjectService;
import cl.ejerciciojava.eventos.validator.UserValidator;

@Controller
public class EventProjectController {
    private final EventProjectService eventProjectService;
    private final UserValidator userValidator;

    public EventProjectController(EventProjectService eventProjectService, UserValidator userValidator) {
        this.eventProjectService = eventProjectService;
        this.userValidator = userValidator;
    }

    @GetMapping("/")
    public String loginReg(@ModelAttribute("userRegister") User userRegister, HttpSession session) {
        if (session.isNew()) {
            session.setAttribute("login", false);
        }
        return "loginRegister";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userRegister") User userRegister, BindingResult result,
            RedirectAttributes redirectAttributes) {
        userValidator.validate(userRegister, result);
        if (result.hasErrors()) {
            return "loginRegister";
        }
        eventProjectService.registerUser(userRegister);
        redirectAttributes.addFlashAttribute("Registro Completado.",
                "<p class=\"alert alert-success\" role=\"alert\"> Registro Exitoso. </p>");
        return "redirect:/";
    }

    @PostMapping("/Login")
    public String loginProcess(@RequestParam("email") String email, @RequestParam("password") String password,
            HttpSession session, RedirectAttributes redirectAttributes) {
        if (eventProjectService.checkLogin(email, password) == false) {
            redirectAttributes.addFlashAttribute("error",
                    "<p class=\"alert alert-danger text-center\" role=\"alert\"> Usuario o Contrasena incorrecta </p>");
            return "redirect:/";
        }
        session.setAttribute("login", true);
        session.setAttribute("user", eventProjectService.findByEmail(email).getId());
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String homePage(HttpSession session, Model model, @ModelAttribute("eventForm") Event event) {
        if ((boolean) session.getAttribute("login") == true) {
            User user = eventProjectService.getUserById((Long) session.getAttribute("user"));
            model.addAttribute("user", eventProjectService.getUserById((Long) session.getAttribute("user")));
            model.addAttribute("inRegion", eventProjectService.sameRegionEvents(user.getRegion()));
            model.addAttribute("outRegion", eventProjectService.outSideRegionEvents(user.getRegion()));
            model.addAttribute("joinsEvent", eventProjectService.joinedEvents());
            return "home";
        }
        return "redirect:/";
    }

    @PostMapping("/home")
    public String createEvent(@Valid @ModelAttribute("eventForm") Event event, BindingResult result,
            HttpSession session, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", eventProjectService.getUserById((Long) session.getAttribute("user")));
            User user = eventProjectService.getUserById((Long) session.getAttribute("user"));
            model.addAttribute("user", eventProjectService.getUserById((Long) session.getAttribute("user")));
            model.addAttribute("inRegion", eventProjectService.sameRegionEvents(user.getRegion()));
            model.addAttribute("outRegion", eventProjectService.outSideRegionEvents(user.getRegion()));
            return "home";
        }
        Event newEvent = eventProjectService.createEvent(event, (Long) session.getAttribute("user"));
        return "redirect:/events/" + newEvent.getId();
    }

    @GetMapping("/events/{eventId}")
    public String eventInfo(@PathVariable("eventId") Long eventId, Model model, HttpSession session,
            @ModelAttribute("addComment") Comment comment) {
        if ((boolean) session.getAttribute("login") == true) {
            model.addAttribute("event", eventProjectService.eventById(eventId));
            model.addAttribute("user", eventProjectService.getUserById((Long) session.getAttribute("user")));
            return "eventInformation";
        }
        return "redirect:/";
    }

    @PostMapping("/events/{eventId}")
    public String addComment(@PathVariable("eventId") Long eventId, HttpSession session,
            @Valid @ModelAttribute("addComment") Comment comment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            if ((boolean) session.getAttribute("login") == true) {
                model.addAttribute("event", eventProjectService.eventById(eventId));
                model.addAttribute("user", eventProjectService.getUserById((Long) session.getAttribute("user")));
                return "eventInformation";
            }
            return "redirect:/";
        }
        User user = eventProjectService.getUserById((Long) session.getAttribute("user"));
        comment.setUser(user);
        comment.setEvent(eventProjectService.eventById(eventId));
        eventProjectService.addComment(comment);
        return "redirect:/events/" + eventId;
    }

    @DeleteMapping("/home/{eventId}")
    public String deleteEvent(@PathVariable("eventId") Long eventId, @RequestParam("userId") Long userId) {
        Event event = eventProjectService.eventById(eventId);
        User user = eventProjectService.getUserById(userId);

        if (event.getUser().getId() == user.getId()) {
            eventProjectService.deleteEventById(eventId);
            return "redirect:/home";
        }
        return "redirect:/logout";
    }

    @GetMapping("home/edit/{eventId}")
    public String editEvent(@ModelAttribute("event") Event event, @PathVariable("eventId") Long eventId, Model model,
            HttpSession session) {

        if ((boolean) session.getAttribute("login") == true) {
            model.addAttribute("event", eventProjectService.eventById(eventId));
            return "edit";
        }
        return "redirect:/";
    }

    @PutMapping("home/{eventId}")
    public String updateEvent(@Valid @ModelAttribute("event") Event event, BindingResult result,
            @PathVariable("eventId") Long eventId, Model model, HttpSession session) {
        User user = eventProjectService.getUserById((Long) session.getAttribute("user"));
        if (eventProjectService.eventById(eventId).getUser().getId() == user.getId()) {
            if (result.hasErrors()) {
                model.addAttribute("event", eventProjectService.eventById(eventId));
                return "edit";
            }
            event.setId(eventId);
            event.setUser(user);
            eventProjectService.updateEvent(event);
            return "redirect:/home";
        }
        return "redirect:/";
    }

    @PostMapping("/home/join")
    public String joinEvent(@Valid @ModelAttribute("userEvent") UserEvent join, BindingResult result,
            @RequestParam("event") Long event, @RequestParam("user") Long user) {
        if (result.hasErrors()) {
            return "home";
        }
        join.setUser(eventProjectService.getUserById(user));
        join.setEvent(eventProjectService.eventById(event));
        eventProjectService.userJoinEvent(join);
        return "redirect:/home";
    }

    @DeleteMapping("/home/cancel")
    public String cancelJoin(@RequestParam("userId") Long userId, @RequestParam("eventId") Long eventId) {
        User user = eventProjectService.getUserById(userId);
        Event event = eventProjectService.eventById(eventId);
        UserEvent cancel = eventProjectService.findJoinedEvent(event, user);
        eventProjectService.cancelJoin(cancel);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
