package net.fofanaconsulting.eLogistic.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.fofanaconsulting.eLogistic.service.ArticleService;

@Controller
public class ItemListController {

  private static final String USER_ITEM_LIST = "user/itemList";
  private final ArticleService articleService;

  @Autowired
  public ItemListController(ArticleService articleService) {
    this.articleService = articleService;
  }

  @RequestMapping(value = "/user/itemList", method = {POST, GET})
  public String useritemList(Model model) {
    model.addAttribute("articles", articleService.getAll());
    return USER_ITEM_LIST;
  }

  @RequestMapping(value = "/article/{id}.html", method = RequestMethod.PUT)
  public String bookArticle(@PathVariable String id, Model model) {
    if (StringUtils.isNotEmpty(id)) {
      model.addAttribute("articles", articleService.getAll());
    }
    return "view/bookArticle";
  }
}
