package br.com.cbpoo.factory;

import br.com.cbpoo.service.*;
import br.com.cbpoo.service.impl.*;

public class ServiceFactory {
    private RepositoryFactory repositoryFactory = new RepositoryFactory();

    public IArticleService newArticleService() {
        return new ArticleServiceImpl(
                repositoryFactory.newArticleRepository(),
                repositoryFactory.newReviewRepository()
        );
    }

    public IAuthorService newAuthorService() {
        return new AuthorServiceImpl(
                repositoryFactory.newAuthorRepository()
        );
    }

    public IGeneralChairService newGeneralchairService() {
        return new GeneralChairServiceImpl(
                repositoryFactory.newGeneralChairRepository()
        );
    }

    public IParticipantService newParticipantService() {
        return new ParticipantServiceImpl(
                repositoryFactory.newParticipantRepository()
        );
    }

    public IProgramChairService newProgramChairService() {
        return new ProgramChairServiceImpl(
                repositoryFactory.newProgramChairRepository()
        );
    }

    public IReviewerService newReviewerService() {
        return new ReviewerServiceImpl(
                repositoryFactory.newReviewerRepository()
        );
    }

    public IReviewService newReviewService() {
        return new ReviewServiceImpl(
                repositoryFactory.newReviewRepository()
        );
    }
}
