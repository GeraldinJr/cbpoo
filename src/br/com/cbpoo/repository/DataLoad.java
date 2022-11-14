package br.com.cbpoo.repository;

import br.com.cbpoo.model.entities.*;
import br.com.cbpoo.model.enuns.AcademicDegree;
import br.com.cbpoo.model.enuns.Specialities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataLoad {

    private static DataLoad instance;

    private DataLoad() {
    }

    public static synchronized DataLoad getInstance() {
        if (instance == null) {
            instance = new DataLoad();
        }

        return instance;
    }

    private ArrayList<GeneralChair> generalChairs = new ArrayList<GeneralChair>(List.of(new GeneralChair[]{
            new GeneralChair(
                    "11111111111",
                    "General admin",
                    new Date(1999, 6, 2),
                    AcademicDegree.GRADUCACAO,
                    "UFBA",
                    "admin"
            ),
            new GeneralChair(
                    "22222222222",
                    "General Admin2",
                    new Date(1999, 6, 2),
                    AcademicDegree.GRADUCACAO,
                    "UFBA",
                    "admin"
            )
    }));

    private ArrayList<ProgramChair> programChairs = new ArrayList<ProgramChair>(List.of(new ProgramChair[]{
            new ProgramChair(
                    "33333333333",
                    "Program Chair1",
                    new Date(1999, 6, 2),
                    AcademicDegree.GRADUCACAO,
                    "UFBA",
                    "admin"
            ),
            new ProgramChair(
                    "44444444444",
                    "Program Chair2",
                    new Date(1999, 6, 2),
                    AcademicDegree.GRADUCACAO,
                    "UFBA",
                    "admin"
            )
    }));

    private ArrayList<Author> authors = new ArrayList<Author>(List.of(new Author[]{
            new Author(
                    "55555555555",
                    "Autor1",
                    new Date(1999, 6, 2),
                    AcademicDegree.GRADUCACAO,
                    "UFBA",
                    "admin",
                    Specialities.JAVA
            ),
            new Author(
                    "66666666666",
                    "Autor2",
                    new Date(1999, 6, 2),
                    AcademicDegree.GRADUCACAO,
                    "UFBA",
                    "admin",
                    Specialities.KOTLIN
            )
    }));

    private ArrayList<Reviewer> reviewers = new ArrayList<Reviewer>(List.of(new Reviewer[]{
            new Reviewer(
                    "99999999999",
                    "Revisor1",
                    new Date(1999, 6, 2),
                    AcademicDegree.GRADUCACAO,
                    "UFBA",
                    "admin",
                    Specialities.JAVA
            ),
            new Reviewer(
                    "00000000000",
                    "Revisor2",
                    new Date(1999, 6, 2),
                    AcademicDegree.GRADUCACAO,
                    "UFBA",
                    "admin",
                    Specialities.KOTLIN
            )
    }));



    private ArrayList<Participant> participants = new ArrayList<Participant>(List.of(new Participant[]{
            new Participant(
                    "77777777777",
                    "Participant1",
                    new Date(1999, 6, 2),
                    AcademicDegree.GRADUCACAO,
                    "UFBA",
                    "admin"
            ),
            new Participant(
                    "88888888888",
                    "Participant2",
                    new Date(1999, 6, 2),
                    AcademicDegree.GRADUCACAO,
                    "UFBA",
                    "admin"
            )
    }));


    private ArrayList<Article> articles = new ArrayList<Article>(List.of(new Article[]{
            new Article(
                    "Artigo 1",
                    "abstract 1",
                    new ArrayList<String>(List.of(new String[]{"Teste", "artigo1"})),
                    100,
                    new Date(1999, 6, 2),
                    authors
            ),
            new Article(
                    "Artigo 1",
                    "abstract 1",
                    new ArrayList<String>(List.of(new String[]{"Teste", "artigo1"})),
                    100,
                    new Date(1999, 6, 2),
                    authors
            )
    }));

    private ArrayList<Review> reviews = new ArrayList<Review>(List.of(new Review[]{
            new Review(
                    articles.get(0),
                    reviewers.get(0),
                    8,
                    "Explorou muito bem os resultados"
            ),
            new Review(
                    articles.get(1),
                    reviewers.get(0),
                    7,
                    "Boa pesquisa"
            ),
            new Review(
                    articles.get(0),
                    reviewers.get(1),
                    5,
                    "Resultados sem confianca"
            ),
            new Review(
                    articles.get(1),
                    reviewers.get(1),
                    6,
                    "Poderia explorar melhor o tema"
            )
    }));

    public ArrayList<GeneralChair> getGeneralChairs() {
        return generalChairs;
    }

    public ArrayList<ProgramChair> getProgramChairs() {
        return programChairs;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public ArrayList<Reviewer> getReviewers() {
        return reviewers;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }
}
