package net.fofanaconsulting.eLogistic.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.fofanaconsulting.eLogistic.model.User;
import net.fofanaconsulting.eLogistic.service.UserService;

@Component
public class UserValidator implements Validator {


  private final UserService userService;

  @Autowired
  public UserValidator(UserService userService) {
    this.userService = userService;
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return User.class.equals(aClass);
  }

  @Override
  public void validate(Object o, Errors errors) {
    User user = (User) o;

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required.field");
    ValidationUtils.rejectIfEmpty(errors, "firstname", "required.field");
    ValidationUtils.rejectIfEmpty(errors, "lastname", "required.field");
    if (user.getUsername().length() < 3 || user.getUsername().length() > 32) {
      errors.rejectValue("username", "registration.username.size");
    }
    if (userService.findByUsername(user.getUsername()) != null) {
      errors.rejectValue("username", "registration.duplicate.username");
    }

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.field");
    if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
      errors.rejectValue("password", "registration.password.size");
    }

    if (!user.getPasswordConfirm().equals(user.getPassword())) {
      errors.rejectValue("passwordConfirm", "registation.passwordConfirm.dontMatch");
    }
  }

}
