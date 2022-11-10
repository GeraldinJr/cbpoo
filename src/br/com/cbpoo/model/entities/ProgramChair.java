package br.com.cbpoo.model.entities;

import br.com.cbpoo.exceptions.InvalidCPFException;
import br.com.cbpoo.model.enuns.AcademicDegree;
import br.com.cbpoo.model.enuns.OrganizerTypes;

import java.util.Date;

public class ProgramChair extends Organizer{
    public ProgramChair(
            String CPF,
            String name,
            Date birthDate,
            AcademicDegree academicDegree,
            String institution,
            String password
    ) throws InvalidCPFException {
        super(CPF, name, birthDate, academicDegree, institution, password, OrganizerTypes.PROGRAM_CHAIR);
    }
}
