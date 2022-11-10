package br.com.cbpoo.repository;

import br.com.cbpoo.model.entities.Article;
import br.com.cbpoo.model.enuns.ArticleStatus;

import java.util.ArrayList;

public interface IArticleRepository {
    public ArrayList<Article> findAll();
    public ArrayList<Article> findByStatus(ArticleStatus articleStatus);
    public Article findByID(String id);
    public void setStatusById(String id, ArticleStatus status);
    public void save(Article article);
}
