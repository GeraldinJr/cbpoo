package br.com.cbpoo.repository.impl;

import br.com.cbpoo.model.entities.Article;
import br.com.cbpoo.model.entities.Author;
import br.com.cbpoo.model.entities.Review;
import br.com.cbpoo.model.entities.Reviewer;
import br.com.cbpoo.repository.DataLoad;
import br.com.cbpoo.repository.IReviewRepository;

import java.util.ArrayList;

public class ReviewRepositoryImpl implements IReviewRepository {

    private ArrayList<Review> data = DataLoad.getInstance().getReviews();

    @Override
    public ArrayList<Review> findByArticle(Article article) {
        return new ArrayList<Review>(
                data.stream().filter(
                        it -> it.getArticle().equals(article)
                ).toList()
        );
    }

    @Override
    public ArrayList<Review> findByReviewer(Reviewer reviewer) {
        return new ArrayList<Review>(
                data.stream().filter(
                        it -> it.getReviewer().equals(reviewer)
                ).toList()
        );
    }

    @Override
    public ArrayList<Review> findAll() {
        return data;
    }

    @Override
    public void save(Review review) {
        data.add(review);
    }

    @Override
    public ArrayList<Review> findByAuthor(Author author) {
        return new ArrayList<Review>(
                data.stream().filter(
                        it -> it.getArticle().getAuthors().contains(author)
                ).toList()
        );
    }
}
