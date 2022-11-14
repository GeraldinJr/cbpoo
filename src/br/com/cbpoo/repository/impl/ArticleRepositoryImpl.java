package br.com.cbpoo.repository.impl;

import br.com.cbpoo.model.entities.Article;
import br.com.cbpoo.model.enuns.ArticleStatus;
import br.com.cbpoo.repository.DataLoad;
import br.com.cbpoo.repository.IArticleRepository;

import java.util.ArrayList;

public class ArticleRepositoryImpl implements IArticleRepository {
    private ArrayList<Article> data = DataLoad.getInstance().getArticles();

    @Override
    public ArrayList<Article> findAll() {
        return data;
    }

    @Override
    public ArrayList<Article> findByStatus(ArticleStatus articleStatus) {

        return new ArrayList<Article>(
                data.stream().filter(it -> it.getStatus() == articleStatus).toList()
        );
    }

    @Override
    public Article findByID(String id) {
        return data.stream().filter(
                it -> it.getId().equals(id)
        ).findFirst().orElseThrow();
    }

    @Override
    public void setStatusById(String id, ArticleStatus status) {
        Article article = data.stream().filter(
                it -> it.getId().equals(id)
        ).findFirst().orElseThrow();

        article.setStatus(status);
    }

    @Override
    public void save(Article article) {
        data.add(article);
    }
}
