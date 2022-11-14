package br.com.cbpoo.repository.impl;

import br.com.cbpoo.model.entities.GeneralChair;
import br.com.cbpoo.repository.DataLoad;
import br.com.cbpoo.repository.IGeneralChairRepository;

import java.util.ArrayList;

public class GeneralChairRepositoryImpl implements IGeneralChairRepository {

    private ArrayList<GeneralChair> data = DataLoad.getInstance().getGeneralChairs();

    @Override
    public GeneralChair findByCPF(String cpf) {
        return data.stream().filter(
                it -> it.getCPF().equals(cpf)
        ).findFirst().orElseThrow();
    }
}
