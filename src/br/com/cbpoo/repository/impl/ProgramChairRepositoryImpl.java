package br.com.cbpoo.repository.impl;

import br.com.cbpoo.model.entities.ProgramChair;
import br.com.cbpoo.repository.DataLoad;
import br.com.cbpoo.repository.IProgramChairRepository;

import java.util.ArrayList;

public class ProgramChairRepositoryImpl implements IProgramChairRepository {
    private ArrayList<ProgramChair> data = DataLoad.getInstance().getProgramChairs();

    @Override
    public ProgramChair findByCPF(String cpf) {
        return data.stream().filter(
                it -> it.getCPF().equals(cpf)
        ).findFirst().orElseThrow();
    }
}
