package net.fofanaconsulting.eLogistic.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController implements ErrorController {

  private static final String PATH = "/error";

  @RequestMapping(value = {"/", "/index"})
  public String index() {
    return "index";
  }

  @RequestMapping("/login-error")
  public String loginError(Model model) {
    model.addAttribute("loginError", true);
    return "login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(Model model, String error, String logout) {
    if (error != null)
      model.addAttribute("error", "Your username and password is invalid.");

    if (logout != null)
      model.addAttribute("message", "You have been logged out successfully.");

    return "login";
  }

  @RequestMapping("/logout")
  public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
    SecurityContextLogoutHandler scl = new SecurityContextLogoutHandler();
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    scl.logout(request, response, authentication);
    return "index";
  }


  @RequestMapping(value = PATH)
  public String error() {
    return "Error handling";
  }

  @Override
  public String getErrorPath() {
    return PATH;
  }
}
