package net.fofanaconsulting.eLogistic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.fofanaconsulting.eLogistic.model.Article;
import net.fofanaconsulting.eLogistic.model.Quantity;
import net.fofanaconsulting.eLogistic.model.QuantityUnit;
import net.fofanaconsulting.eLogistic.service.ArticleService;

@SpringBootApplication
public class ELogisticApplication implements CommandLineRunner {

  @Autowired
  private ArticleService articleService;

  public static void main(String[] args) {
    SpringApplication.run(ELogisticApplication.class, args);
  }

  @Override
  public void run(String... arg0) throws Exception {
    articleService.removeAll();
    articleService.saveListOfArticles(
        Arrays.asList(new Article("descript", new Quantity(10, QuantityUnit.CARTON, 5)),
            new Article("description rouge", new Quantity(20, QuantityUnit.COLIS, 10))));
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
