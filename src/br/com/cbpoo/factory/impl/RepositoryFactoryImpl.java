package br.com.cbpoo.factory.impl;


import br.com.cbpoo.factory.IRepositoryFactory;
import br.com.cbpoo.repository.*;

public class RepositoryFactoryImpl implements IRepositoryFactory {
    private IArticleRepository articleRepository;
    private IAuthorRepository authorRepository;
    private IGeneralChairRepository generalChairRepository;
    private IParticipantRepository participantRepository;
    private IProgramChairRepository programChairRepository;
    private IReviewerRepository reviewerRepository;
    private IReviewRepository reviewRepository;

    @Override
    public IArticleRepository newArticleRepository() {
        return articleRepository;
    }

    @Override
    public IAuthorRepository newAuthorRepository() {
        return authorRepository;
    }

    @Override
    public IGeneralChairRepository newGeneralChairRepository() {
        return generalChairRepository;
    }

    @Override
    public IParticipantRepository newParticipantRepository() {
        return participantRepository;
    }

    @Override
    public IProgramChairRepository newProgramChairRepository() {
        return programChairRepository;
    }

    @Override
    public IReviewerRepository newReviewerRepository() {
        return reviewerRepository;
    }

    @Override
    public IReviewRepository newReviewRepository() {
        return reviewRepository;
    }
}
