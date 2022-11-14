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

    @Override
    public String toString() {
        return "Specialist{\n" +
                "CPF='" + this.getCPF() + '\n' +
                "Name='" + getName() + '\n' +
                "BirthDate=" + getBirthDate() + '\n' +
                "AcademicDegree=" + getAcademicDegree() + '\n'+
                "Institution='" + getInstitution() + '\n' +
                "SpecialistType=" + SpecialistType + '\n' +
                "Specialty=" + Specialty + '\n' +
                '}';
    }
}
