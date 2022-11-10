package br.com.cbpoo.service.impl;

import br.com.cbpoo.exceptions.LoginException;
import br.com.cbpoo.model.entities.Participant;
import br.com.cbpoo.model.enuns.InscriptionStatus;
import br.com.cbpoo.repository.IParticipantRepository;
import br.com.cbpoo.service.IParticipantService;

import java.util.ArrayList;

public class ParticipantServiceImpl implements IParticipantService {

    private IParticipantRepository repository;

    public ParticipantServiceImpl(IParticipantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Participant loginParticipant(String cpf, String password) {
        Participant participant = repository.findByCPF(cpf);
        if(!participant.validatePassword(password)) throw new LoginException();

        return participant;
    }

    @Override
    public ArrayList<Participant> findAll() {
        return repository.findByStatus(InscriptionStatus.ACCEPTED);
    }

    @Override
    public ArrayList<Participant> findAllWithStatusPending() {
        return repository.findByStatus(InscriptionStatus.PENDING);
    }

    @Override
    public void validateInscriptionByCPF(String cpf) {
        repository.setStatusByCPF(cpf, InscriptionStatus.ACCEPTED);
    }

    @Override
    public void invalidateInscriptionByCPF(String cpf) {
        repository.setStatusByCPF(cpf, InscriptionStatus.REJECTED);
    }
}
