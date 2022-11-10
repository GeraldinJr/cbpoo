package br.com.cbpoo.service.impl;

import br.com.cbpoo.model.entities.Article;
import br.com.cbpoo.model.enuns.ArticleStatus;
import br.com.cbpoo.repository.IArticleRepository;
import br.com.cbpoo.repository.IReviewRepository;
import br.com.cbpoo.service.IArticleService;

import java.util.ArrayList;

public class ArticleServiceImpl implements IArticleService {
    private IArticleRepository repository;
    private IReviewRepository reviewRepository;

    public ArticleServiceImpl(
            IArticleRepository repository,
            IReviewRepository reviewRepository
            ) {
        this.repository = repository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public ArrayList<Article> findAll() {
        return repository.findAll();
    }

    @Override
    public ArrayList<Article> findAcceptedsArticles() {
        return repository.findByStatus(ArticleStatus.ACCEPTED);
    }

    @Override
    public ArrayList<Article> findRejectedsArticles() {
        return repository.findByStatus(ArticleStatus.REJECTED);
    }

    @Override
    public Article findById(String id) {
        return repository.findByID(id);
    }

    @Override
    public void approveById(String id) {
        repository.setStatusById(id, ArticleStatus.ACCEPTED);
    }

    @Override
    public ArrayList<Article> findAllWithPendingReview() {
        ArrayList<Article> articles = repository.findByStatus(ArticleStatus.REVISION);

        return new ArrayList<Article>(
                articles.stream().filter(
                        it -> reviewRepository.findByArticle(it).size() < 2
                ).toList()
        );
    }

    @Override
    public void save(Article article) {
        repository.save(article );
    }
}
