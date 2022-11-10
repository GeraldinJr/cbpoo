package br.com.cbpoo.service;

import br.com.cbpoo.model.entities.Author;
import br.com.cbpoo.model.entities.Review;
import br.com.cbpoo.model.entities.Reviewer;

import java.util.ArrayList;

public interface IReviewService {
    public ArrayList<Review> findAll();
    public ArrayList<Review> findByReviewer(Reviewer reviewer);
    public void save(Review review);
    public ArrayList<Review> findAllByAuthor(Author author);
}
