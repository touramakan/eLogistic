package net.fofanaconsulting.eLogistic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
  private static final Logger LOG = LoggerFactory.getLogger(AuthenticationService.class);

  private final UserDetailsServiceImpl userDetailsServiceImpl;
  private final AuthenticationManager authenticationManager;

  @Autowired
  public AuthenticationService(UserDetailsServiceImpl userDetailsServiceImpl,
      AuthenticationManager authenticationManager) {
    this.userDetailsServiceImpl = userDetailsServiceImpl;
    this.authenticationManager = authenticationManager;
  }

  public String findLoggedInUsername() {
    Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
    if (userDetails instanceof UserDetails) {
      return ((UserDetails) userDetails).getUsername();
    }
    return null;
  }

  public void autologin(String username, String password) {
    UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
    if (null != userDetails) {
      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
          new UsernamePasswordAuthenticationToken(userDetails, password,
              userDetails.getAuthorities());

      authenticationManager.authenticate(usernamePasswordAuthenticationToken);

      if (usernamePasswordAuthenticationToken.isAuthenticated()) {
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        LOG.debug(String.format("Auto login %s successfully!", username));
      }
    }
  }
}
