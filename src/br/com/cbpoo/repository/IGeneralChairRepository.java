package br.com.cbpoo.repository;

import br.com.cbpoo.model.entities.GeneralChair;

public interface IGeneralChairRepository {
    public GeneralChair findByCPF(String cpf);
}
