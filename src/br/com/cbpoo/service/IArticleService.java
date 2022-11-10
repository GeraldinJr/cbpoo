package br.com.cbpoo.service;

import br.com.cbpoo.model.entities.Article;

import java.util.ArrayList;

public interface IArticleService {
    public ArrayList<Article> findAll();
    public ArrayList<Article> findAcceptedsArticles();
    public ArrayList<Article> findRejectedsArticles();
    public Article findById(String id);
    public void approveById(String id);
     public ArrayList<Article> findAllWithPendingReview();
     public void save(Article article);
}
