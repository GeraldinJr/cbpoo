package br.com.cbpoo.repository;

import br.com.cbpoo.model.entities.Article;
import br.com.cbpoo.model.entities.Author;
import br.com.cbpoo.model.entities.Review;
import br.com.cbpoo.model.entities.Reviewer;

import java.util.ArrayList;

public interface IReviewRepository {
    public ArrayList<Review> findByArticle(Article article);
    public ArrayList<Review> findByReviewer(Reviewer reviewer);
    public ArrayList<Review> findAll();
    public void save(Review review);
    public ArrayList<Review> findByAuthor(Author author);
}
