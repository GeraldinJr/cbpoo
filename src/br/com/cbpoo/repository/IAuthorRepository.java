package br.com.cbpoo.repository;

import br.com.cbpoo.model.entities.Author;

public interface IAuthorRepository {
    public Author findByCPF(String cpf);
}
