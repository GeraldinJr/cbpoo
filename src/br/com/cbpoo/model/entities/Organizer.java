package br.com.cbpoo.model.entities;

import br.com.cbpoo.exceptions.InvalidCPFException;
import br.com.cbpoo.model.enuns.AcademicDegree;
import br.com.cbpoo.model.enuns.OrganizerTypes;
import br.com.cbpoo.model.enuns.PeopleTypes;

import java.util.Date;

public abstract class Organizer extends People {
    protected OrganizerTypes OrganizerType;
    protected Organizer(
            String CPF,
            String name,
            Date birthDate,
            AcademicDegree academicDegree,
            String institution,
            String password,
            OrganizerTypes organizerType
    ) throws InvalidCPFException {
        super(CPF, name, birthDate, academicDegree, institution, password, PeopleTypes.ORGANIZER);
    }
}
