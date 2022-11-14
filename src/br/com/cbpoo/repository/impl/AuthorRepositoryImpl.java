package br.com.cbpoo.repository.impl;

import br.com.cbpoo.model.entities.Author;
import br.com.cbpoo.repository.DataLoad;
import br.com.cbpoo.repository.IAuthorRepository;

import java.util.ArrayList;

public class AuthorRepositoryImpl implements IAuthorRepository {

    private ArrayList<Author> data = DataLoad.getInstance().getAuthors();

    @Override
    public Author findByCPF(String cpf) {
        return data.stream().filter(
                it -> it.getCPF().equals(cpf)
        ).findFirst().orElseThrow();
    }
}
