package br.com.cbpoo.model.entities;

import br.com.cbpoo.exceptions.InvalidCPFException;
import br.com.cbpoo.model.enuns.AcademicDegree;
import br.com.cbpoo.model.enuns.PeopleTypes;

import java.util.Date;

import static br.com.cbpoo.util.Validator.onlyDigits;
import static br.com.cbpoo.util.Validator.validateCpf;

public abstract class People {
    private String CPF;
    private String Name;
    private Date BirthDate;
    private AcademicDegree AcademicDegree;
    private String Institution;
    private String Password;
    private PeopleTypes PeopleType;

    public People(
            String CPF,
            String name,
            Date birthDate,
            AcademicDegree academicDegree,
            String institution,
            String password,
            PeopleTypes peopleType
    ) throws InvalidCPFException {
        if(!validateCpf(CPF)) throw new InvalidCPFException();
        this.CPF = onlyDigits(CPF);
        Name = name;
        BirthDate = birthDate;
        AcademicDegree = academicDegree;
        Institution = institution;
        Password = password;
    }

    public String getCPF() {
        return CPF;
    }

    public String getName() {
        return Name;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public AcademicDegree getAcademicDegree() {
        return AcademicDegree;
    }

    public String getInstitution() {
        return Institution;
    }

    public PeopleTypes getPeopleType() {
        return PeopleType;
    }

    public boolean validatePassword(String str) {
        return str.equals(Password);
    }
}
