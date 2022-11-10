package br.com.cbpoo.repository;

import br.com.cbpoo.model.entities.ProgramChair;

public interface IProgramChairRepository {
    public ProgramChair findByCPF(String cpf);
}
