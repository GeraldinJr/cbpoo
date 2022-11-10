package br.com.cbpoo.repository;

import br.com.cbpoo.model.entities.Reviewer;

public interface IReviewerRepository {
    public Reviewer findByCPF(String cpf);
}
