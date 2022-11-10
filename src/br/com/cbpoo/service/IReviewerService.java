package br.com.cbpoo.service;

import br.com.cbpoo.model.entities.Reviewer;

public interface IReviewerService {
    public Reviewer loginReviewer(String cpf, String password);
}
