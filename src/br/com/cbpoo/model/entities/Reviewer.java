package br.com.cbpoo.model.entities;

import br.com.cbpoo.exceptions.InvalidCPFException;
import br.com.cbpoo.model.enuns.AcademicDegree;
import br.com.cbpoo.model.enuns.SpecialistTypes;
import br.com.cbpoo.model.enuns.Specialities;

import java.util.Date;

public class Reviewer extends Specialist {
    public Reviewer(
            String CPF,
            String name,
            Date birthDate,
            AcademicDegree academicDegree,
            String institution,
            String password,
            Specialities specialty
    ) throws InvalidCPFException {
        super(CPF, name, birthDate, academicDegree, institution, password, SpecialistTypes.REVIEWER, specialty);
    }
}
