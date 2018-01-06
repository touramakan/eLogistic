package net.fofanaconsulting.eLogistic.data;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.fofanaconsulting.eLogistic.model.Article;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {

  List<Article> findByDescription(String description);

  List<Article> findByDescriptionStartsWith(String partOfDesc, Pageable page);
}
