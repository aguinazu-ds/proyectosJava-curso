package cl.ejerciciojava.eventos.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cl.ejerciciojava.eventos.models.User;
import cl.ejerciciojava.eventos.services.EventProjectService;

@Component
public class UserValidator implements Validator {
    private EventProjectService eventProjectService;

    public UserValidator(EventProjectService eventProjectService) {
        this.eventProjectService = eventProjectService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }
        if (eventProjectService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Registered");
        }
    }
}
