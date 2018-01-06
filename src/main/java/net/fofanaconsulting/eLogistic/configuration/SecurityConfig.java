package net.fofanaconsulting.eLogistic.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.fofanaconsulting.eLogistic.service.UserDetailsServiceImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


  private final UserDetailsServiceImpl userDetailsServiceImpl;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public SecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl,
      BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userDetailsServiceImpl = userDetailsServiceImpl;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/css/**", "/registration").permitAll()
        .antMatchers("/user/**").authenticated().antMatchers("/admin/**").hasAuthority("ADMIN")
        .and().formLogin().loginPage("/login").failureUrl("/login-error");
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
  }

}
