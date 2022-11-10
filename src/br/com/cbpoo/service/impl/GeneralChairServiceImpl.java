package br.com.cbpoo.service.impl;

import br.com.cbpoo.exceptions.LoginException;
import br.com.cbpoo.model.entities.GeneralChair;
import br.com.cbpoo.repository.IGeneralChairRepository;
import br.com.cbpoo.service.IGeneralChairService;

public class GeneralChairServiceImpl implements IGeneralChairService {

    private IGeneralChairRepository repository;

    public GeneralChairServiceImpl(IGeneralChairRepository repository) {
        this.repository = repository;
    }

    @Override
    public GeneralChair loginGeneralChair(String cpf, String password) {
        GeneralChair generalChair = repository.findByCPF(cpf);
        if(!generalChair.validatePassword(password)) throw new LoginException();

        return generalChair;
    }
}
