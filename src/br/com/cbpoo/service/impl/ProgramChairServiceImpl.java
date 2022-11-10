package br.com.cbpoo.service.impl;

import br.com.cbpoo.exceptions.LoginException;
import br.com.cbpoo.model.entities.ProgramChair;
import br.com.cbpoo.repository.IProgramChairRepository;
import br.com.cbpoo.service.IProgramChairService;

public class ProgramChairServiceImpl implements IProgramChairService {

    private IProgramChairRepository repository;

    public ProgramChairServiceImpl(IProgramChairRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProgramChair loginProgramChair(String cpf, String password) {
        ProgramChair programChair = repository.findByCPF(cpf);
        if (!programChair.validatePassword(password)) throw new LoginException();

        return programChair;
    }
}
