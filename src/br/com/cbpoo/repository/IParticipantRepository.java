package br.com.cbpoo.repository;

import br.com.cbpoo.model.entities.Participant;
import br.com.cbpoo.model.enuns.InscriptionStatus;

import java.util.ArrayList;

public interface IParticipantRepository {
    public Participant findByCPF(String CPF);
    public ArrayList<Participant> findAll();
    public ArrayList<Participant> findByStatus(InscriptionStatus status);
    public void setStatusByCPF(String cpf, InscriptionStatus status);
}
