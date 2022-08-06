package cl.ejerciciojava.adminpanel.controllers;

import java.security.Principal;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.ejerciciojava.adminpanel.models.Role;
import cl.ejerciciojava.adminpanel.models.User;
import cl.ejerciciojava.adminpanel.repositories.RoleRepo;
import cl.ejerciciojava.adminpanel.services.UserService;
import cl.ejerciciojava.adminpanel.validator.UserValidator;

@Controller
public class UserController {
    private UserService uServ;
    private RoleRepo rRepo;
    private UserValidator uValid;

    private void makeRoles() {
        if (rRepo.findAll().size() == 0) {
            Role user = new Role();
            user.setType("ROLE_USER");
            rRepo.save(user);
            Role admin = new Role();
            user.setType("ROLE_ADMIN");
            rRepo.save(admin);
            Role superb = new Role();
            user.setType("ROLE_SUPER");
            rRepo.save(superb);
        }
    }

    public UserController(UserService uServ, UserValidator uValid, RoleRepo rRepo) {
        this.uServ = uServ;
        this.rRepo = rRepo;
        this.uValid = uValid;
        makeRoles();

    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, Model model,
            @Valid @ModelAttribute("user") User user) {
        if (logout != null) {
            model.addAttribute("logout", "Logout Successful!");
        }
        if (error != null) {
            model.addAttribute("logError", "Invalid credentials, please try again.");
        }
        return "index";
    }

    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        uValid.validate(user, result);
        if (result.hasErrors()) {
            return "index";
        }
        if (uServ.allUsers().size() == 0) {
            uServ.saveSuper(user);
            return "redirect:/login";
        } else {
            uServ.savePleb(user);
            return "redirect:/login";
        }
    }

    @RequestMapping(value = { "/", "/home" })
    public String user(Principal principal, Model model) {
        String email = principal.getName();
        model.addAttribute("user", uServ.findByEmail(email));
        User user = uServ.findByEmail(email);
        if (user.getRoles().size() > 1) {
            return "redirect:/admin";
        }
        return "userdash";
    }

    @RequestMapping("/admin")
    public String admin(Principal principal, Model model) {
        String email = principal.getName();
        model.addAttribute("user", uServ.findByEmail(email));
        model.addAttribute("allUsers", uServ.allUsers());
        User user = uServ.findByEmail(email);
        if (user.getRoles().size() > 2) {
            model.addAttribute("super", "this is a super admin user");
        }
        if (user.getRoles().size() > 1) {
            model.addAttribute("admin", "this is an admin user");
        }
        return "admindash";
    }

    // @RequestMapping("/make-admin/{id}")
    // public String makeAd(@PathVariable("id") Long id) {
    // Optional<User> user = uServ.findById(id);
    // uServ.updateAdmin(user);
    // return "redirect:/admin";
    // }

    // @PostMapping("/take-admin/{id}")
    // public String takeAd(@PathVariable("id") Long id) {
    // User user = uServ.findById(id);
    // uServ.updatePleb(user);
    // return "redirect:/admin";
    // }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        uServ.deleteUser(id);
        return "redirect:/admin";
    }

    @RequestMapping("/logout")
    public String logout(Principal principal) {
        String email = principal.getName();
        User user = uServ.findByEmail(email);
        uServ.updateSignIn(user);
        return "redirect:/login?logout";
    }
}
