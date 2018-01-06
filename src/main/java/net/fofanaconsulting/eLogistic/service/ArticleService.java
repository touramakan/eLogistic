package net.fofanaconsulting.eLogistic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fofanaconsulting.eLogistic.data.ArticleRepository;
import net.fofanaconsulting.eLogistic.model.Article;

@Service
public class ArticleService {

  private ArticleRepository articleRepository;

  @Autowired
  public ArticleService(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  public void saveArticle(Article article) {
    articleRepository.save(article);
  }

  public void saveListOfArticles(List<Article> articles) {
    articleRepository.save(articles);
  }

  public void deleteArticle(String articleId) {
    articleRepository.delete(articleId);
  }

  public void removeAll() {
    articleRepository.deleteAll();
  }

  public List<Article> getAll() {
    return articleRepository.findAll();
  }

  public void updateArticle(Article article, String id) {
    if (id != null) {
      articleRepository.save(article);
    }
  }
}
