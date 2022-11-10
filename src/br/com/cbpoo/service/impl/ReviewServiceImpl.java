package br.com.cbpoo.service.impl;

import br.com.cbpoo.model.entities.Author;
import br.com.cbpoo.model.entities.Review;
import br.com.cbpoo.model.entities.Reviewer;
import br.com.cbpoo.repository.IReviewRepository;
import br.com.cbpoo.service.IReviewService;

import java.util.ArrayList;

public class ReviewServiceImpl implements IReviewService {

    private IReviewRepository repository;

    public ReviewServiceImpl(IReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public ArrayList<Review> findAll() {
        return repository.findAll();
    }

    @Override
    public ArrayList<Review> findByReviewer(Reviewer reviewer) {
        return repository.findByReviewer(reviewer);
    }

    @Override
    public void save(Review review) {
        repository.save(review);
    }

    @Override
    public ArrayList<Review> findAllByAuthor(Author author) {
        return repository.findByAuthor(author);
    }
}
