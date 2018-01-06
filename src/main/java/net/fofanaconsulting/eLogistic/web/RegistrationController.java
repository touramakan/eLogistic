package net.fofanaconsulting.eLogistic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.fofanaconsulting.eLogistic.model.Role;
import net.fofanaconsulting.eLogistic.model.User;
import net.fofanaconsulting.eLogistic.service.AuthenticationService;
import net.fofanaconsulting.eLogistic.service.UserService;
import net.fofanaconsulting.eLogistic.validator.UserValidator;

@Controller
public class RegistrationController {

  private final UserService userService;
  private final AuthenticationService authenticationService;
  private final UserValidator userValidator;


  @Autowired
  public RegistrationController(UserService userService,
      AuthenticationService authenticationService, UserValidator userValidator) {
    this.userService = userService;
    this.authenticationService = authenticationService;
    this.userValidator = userValidator;
  }

  @RequestMapping(value = "/registration", method = RequestMethod.GET)
  public String registration(Model model) {
    model.addAttribute("user", new User());
    model.addAttribute("allRoles", Role.values());
    return "registration";
  }

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  public String registration(@ModelAttribute("user") User user, BindingResult bindingResult,
      Model model) {
    userValidator.validate(user, bindingResult);
    if (bindingResult.hasErrors()) {
      return "registration";
    }
    userService.save(user);
    authenticationService.autologin(user.getUsername(), user.getPassword());
    return "redirect:/index";
  }

}
