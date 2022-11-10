package br.com.cbpoo.service;

import br.com.cbpoo.model.entities.Participant;

import java.util.ArrayList;

public interface IParticipantService {
    public Participant loginParticipant(String cpf, String password);
    public ArrayList<Participant> findAll();
    public ArrayList<Participant> findAllWithStatusPending();
    public void validateInscriptionByCPF(String cpf);
    public void invalidateInscriptionByCPF(String cpf);
}
