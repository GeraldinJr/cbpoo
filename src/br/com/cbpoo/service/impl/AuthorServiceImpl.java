package br.com.cbpoo.service.impl;

import br.com.cbpoo.exceptions.LoginException;
import br.com.cbpoo.model.entities.Author;
import br.com.cbpoo.repository.IAuthorRepository;
import br.com.cbpoo.service.IAuthorService;

public class AuthorServiceImpl implements IAuthorService {
    private IAuthorRepository repository;

    public AuthorServiceImpl(IAuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author loginAuthor(String cpf, String password) {
        Author author = repository.findByCPF(cpf);
        if (!author.validatePassword(password)) throw new LoginException();

        return author;
    }
}
