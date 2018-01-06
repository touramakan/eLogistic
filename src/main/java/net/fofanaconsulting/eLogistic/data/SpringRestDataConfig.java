package net.fofanaconsulting.eLogistic.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.fofanaconsulting.eLogistic.model.Article;

@Configuration
public class SpringRestDataConfig extends RepositoryRestMvcConfiguration {

  // @Override
  protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Article.class);
  }

  @Override
  @ConfigurationProperties(prefix = "spring.data.rest")
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
