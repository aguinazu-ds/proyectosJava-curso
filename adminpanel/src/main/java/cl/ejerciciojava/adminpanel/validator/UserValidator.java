package cl.ejerciciojava.adminpanel.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cl.ejerciciojava.adminpanel.models.User;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        if (!user.getConfirm().equals(user.getPassword())) {
            errors.rejectValue("confirm", "Match");
        }
    }
}
