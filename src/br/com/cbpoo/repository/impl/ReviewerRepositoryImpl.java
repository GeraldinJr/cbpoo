package br.com.cbpoo.repository.impl;

import br.com.cbpoo.model.entities.Reviewer;
import br.com.cbpoo.repository.DataLoad;
import br.com.cbpoo.repository.IReviewerRepository;

import java.util.ArrayList;

public class ReviewerRepositoryImpl implements IReviewerRepository {
    private ArrayList<Reviewer> data = DataLoad.getInstance().getReviewers();
    @Override
    public Reviewer findByCPF(String cpf) {
        return data.stream().filter(
                it -> it.getCPF().equals(cpf)
        ).findFirst().orElseThrow();
    }
}
