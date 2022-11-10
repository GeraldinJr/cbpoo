package br.com.cbpoo.factory;

import br.com.cbpoo.repository.*;

public interface IRepositoryFactory {
    public IArticleRepository newArticleRepository();
    public IAuthorRepository newAuthorRepository();
    public IGeneralChairRepository newGeneralChairRepository();
    public IParticipantRepository newParticipantRepository();
    public IProgramChairRepository newProgramChairRepository();
    public IReviewerRepository newReviewerRepository();
    public IReviewRepository newReviewRepository();
}
