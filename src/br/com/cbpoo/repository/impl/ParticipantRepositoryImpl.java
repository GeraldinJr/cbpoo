package br.com.cbpoo.repository.impl;

import br.com.cbpoo.model.entities.Participant;
import br.com.cbpoo.model.enuns.InscriptionStatus;
import br.com.cbpoo.repository.IParticipantRepository;

import java.util.ArrayList;

public class ParticipantRepositoryImpl implements IParticipantRepository {
    private ArrayList<Participant> data = new ArrayList<Participant>();

    @Override
    public Participant findByCPF(String CPF) {
        return data.stream().filter(
                it -> it.getCPF().equals(CPF)
        ).findFirst().orElseThrow();
    }

    @Override
    public ArrayList<Participant> findAll() {
        return data;
    }

    @Override
    public ArrayList<Participant> findByStatus(InscriptionStatus status) {
        return new ArrayList<Participant>(
                data.stream().filter(
                        it -> it.getStatus().equals(status)
                ).toList()
        );
    }

    @Override
    public void setStatusByCPF(String cpf, InscriptionStatus status) {
        Participant participant = data.stream().filter(
                it -> it.getCPF().equals(cpf)
        ).findFirst().orElseThrow();

        participant.setStatus(status);
    }
}
