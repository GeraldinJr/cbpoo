package br.com.cbpoo.model.entities;

import br.com.cbpoo.exceptions.InvalidCPFException;
import br.com.cbpoo.model.enuns.AcademicDegree;
import br.com.cbpoo.model.enuns.InscriptionStatus;
import br.com.cbpoo.model.enuns.PeopleTypes;

import java.util.Date;

public class Participant extends People {
    private InscriptionStatus status = InscriptionStatus.PENDING;

    public Participant(
            String CPF,
            String name,
            Date birthDate,
            AcademicDegree academicDegree,
            String institution,
            String password
    ) throws InvalidCPFException {
        super(CPF, name, birthDate, academicDegree, institution, password, PeopleTypes.PARTICIPANT);
    }

    public InscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(InscriptionStatus status) {
        this.status = status;
    }
}
