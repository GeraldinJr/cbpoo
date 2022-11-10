package br.com.cbpoo.service;

import br.com.cbpoo.model.entities.ProgramChair;

public interface IProgramChairService {
    public ProgramChair loginProgramChair(String cpf, String password);
}
