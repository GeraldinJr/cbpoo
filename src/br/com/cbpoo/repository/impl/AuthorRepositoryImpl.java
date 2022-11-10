package br.com.cbpoo.repository.impl;

import br.com.cbpoo.model.entities.Author;
import br.com.cbpoo.repository.IAuthorRepository;

import java.util.ArrayList;

public class AuthorRepositoryImpl implements IAuthorRepository {

    private ArrayList<Author> data = new ArrayList<Author>();

    @Override
    public Author findByCPF(String cpf) {
        return data.stream().filter(
                it -> it.getCPF().equals(cpf)
        ).findFirst().orElseThrow();
    }
}
