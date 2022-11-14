package br.com.cbpoo.factory;

import br.com.cbpoo.repository.*;
import br.com.cbpoo.repository.impl.*;

public class RepositoryFactory {
    private final IArticleRepository articleRepository = new ArticleRepositoryImpl();
    private final IAuthorRepository authorRepository = new AuthorRepositoryImpl();
    private final IGeneralChairRepository generalChairRepository = new GeneralChairRepositoryImpl();
    private final IParticipantRepository participantRepository = new ParticipantRepositoryImpl();
    private final IProgramChairRepository programChairRepository = new ProgramChairRepositoryImpl();
    private final IReviewerRepository reviewerRepository = new ReviewerRepositoryImpl();
    private final IReviewRepository reviewRepository = new ReviewRepositoryImpl();


    public IArticleRepository newArticleRepository() {
        return articleRepository;
    }

    public IAuthorRepository newAuthorRepository() {
        return authorRepository;
    }

    public IGeneralChairRepository newGeneralChairRepository() {
        return generalChairRepository;
    }

    public IParticipantRepository newParticipantRepository() {
        return participantRepository;
    }

    public IProgramChairRepository newProgramChairRepository() {
        return programChairRepository;
    }

    public IReviewerRepository newReviewerRepository() {
        return reviewerRepository;
    }

    public IReviewRepository newReviewRepository() {
        return reviewRepository;
    }
}
