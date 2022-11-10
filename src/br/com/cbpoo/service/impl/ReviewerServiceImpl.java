package br.com.cbpoo.service.impl;

import br.com.cbpoo.exceptions.LoginException;
import br.com.cbpoo.model.entities.Reviewer;
import br.com.cbpoo.repository.IReviewerRepository;
import br.com.cbpoo.service.IReviewerService;

public class ReviewerServiceImpl implements IReviewerService {

    private IReviewerRepository repository;

    public ReviewerServiceImpl(IReviewerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Reviewer loginReviewer(String cpf, String password) {
        Reviewer reviewer = repository.findByCPF(cpf);
        if (!reviewer.validatePassword(password)) throw new LoginException();
        return reviewer;
    }
}
