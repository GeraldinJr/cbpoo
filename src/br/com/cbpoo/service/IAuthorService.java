package br.com.cbpoo.service;

import br.com.cbpoo.model.entities.Author;

public interface IAuthorService {
    public Author loginAuthor(String cpf, String password);
}
