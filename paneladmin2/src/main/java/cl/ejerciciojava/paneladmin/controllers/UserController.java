package cl.ejerciciojava.paneladmin.controllers;

import cl.ejerciciojava.paneladmin.models.User;
import cl.ejerciciojava.paneladmin.repositories.RoleRepo;
import cl.ejerciciojava.paneladmin.services.UserService;
import cl.ejerciciojava.paneladmin.validator.UserValidator;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private UserService uServ;
    private RoleRepo rRepo;
    private UserValidator uValid;

    public UserController(UserService uServ, UserValidator uValid, RoleRepo rRepo) {
        this.uServ = uServ;
        this.rRepo = rRepo;
        this.uValid = uValid;
    }

    @RequestMapping("/login")
    public String home() {
        return "loginReg";
    }
}
