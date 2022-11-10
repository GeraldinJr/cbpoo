package br.com.cbpoo.model.entities;

import br.com.cbpoo.exceptions.InvalidCPFException;
import br.com.cbpoo.model.enuns.AcademicDegree;
import br.com.cbpoo.model.enuns.PeopleTypes;
import br.com.cbpoo.model.enuns.SpecialistTypes;
import br.com.cbpoo.model.enuns.Specialities;

import java.util.Date;

public abstract class Specialist extends People {
    protected SpecialistTypes SpecialistType;
    protected Specialities Specialty;

    protected Specialist(
            String CPF,
            String name,
            Date birthDate,
            AcademicDegree academicDegree,
            String institution,
            String password,
            SpecialistTypes specialistType,
            Specialities specialty
    ) throws InvalidCPFException {
        super(CPF, name, birthDate, academicDegree, institution, password, PeopleTypes.SPECIALIST);
    }
}
