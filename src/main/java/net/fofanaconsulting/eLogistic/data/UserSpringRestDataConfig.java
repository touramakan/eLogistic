package net.fofanaconsulting.eLogistic.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.fofanaconsulting.eLogistic.model.User;


@Configuration
public class UserSpringRestDataConfig extends RepositoryRestMvcConfiguration {

  // @Override
  protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(User.class);
  }

  @Override
  public RepositoryRestConfiguration config() {
    return super.config();
  }

  @Override
  @Bean
  @Primary
  public ObjectMapper objectMapper() {
    return super.objectMapper();
  }
}
