package br.com.cbpoo.controller;

import br.com.cbpoo.model.entities.*;
import br.com.cbpoo.service.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static br.com.cbpoo.util.Validator.onlyDigits;

public class MenuController {
    private final Scanner scan;
    private final IParticipantService participantService;
    private final IArticleService articleService;
    private final IReviewService reviewService;
    private final IProgramChairService programChairService;
    private final IGeneralChairService generalChairService;
    private final IAuthorService authorService;
    private final IReviewerService reviewerService;

    public MenuController(
            Scanner scan,
            IParticipantService participantService,
            IArticleService articleService,
            IReviewService reviewService,
            IProgramChairService programChairService,
            IGeneralChairService generalChairService,
            IAuthorService authorService,
            IReviewerService reviewerService
        ) {
        this.scan = scan;
        this.participantService = participantService;
        this.articleService = articleService;
        this.reviewService = reviewService;
        this.programChairService = programChairService;
        this.generalChairService = generalChairService;
        this.authorService = authorService;
        this.reviewerService = reviewerService;
    }


    public void run() {
        int op = 0;
        do {
            try {
                System.out.println("OLÁ, SEJA BEM VINDA(O) AO CBPOO!");
                System.out.println("ESCOLHA UMA DAS OPCOES A SEGUIR: ");
                System.out.println("1 - LOGIN");
                System.out.println("2 - INSCRICAO");
                System.out.println("3 - ENCERRAR");

                op = Integer.parseInt(scan.nextLine());

                switch (op) {
                    case 1:
                        login();
                        break;
                    case 2:
                        //TODO implementar
                        break;

                    case 3:
                        break;

                    default:
                        System.out.println("Digite uma opcao valida");
                        break;
                }
            }catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }while (op != 3);
    }

    private void login() {
        System.out.println("CPF: ");
        String cpf = onlyDigits(scan.nextLine());
        System.out.println("Senha: ");
        String password = scan.nextLine();

        System.out.println("Informe a sua categoria:");
        System.out.println("1 - Participante");
        System.out.println("2 - Program chair");
        System.out.println("3 - General chair");
        System.out.println("4 - Autor");
        System.out.println("5 - Revisor");

        switch (Integer.parseInt(scan.nextLine())) {
            case 1 -> {
                Participant participant = participantService.loginParticipant(cpf, password);
                participantMenu(participant);
            }
            case 2 -> {
                ProgramChair programChair = programChairService.loginProgramChair(cpf, password);
                programChairMenu(programChair);
            }
            case 3 -> {
                GeneralChair generalChair = generalChairService.loginGeneralChair(cpf, password);
                generalChairMenu(generalChair);
            }
            case 4 -> {
                Author author = authorService.loginAuthor(cpf, password);
                authorMenu(author);
            }
            case 5 -> {
                Reviewer reviewer = reviewerService.loginReviewer(cpf, password);
                reviewerMenu(reviewer);
            }
            default -> System.out.println("Digite uma opcao valida");
        }

    }

    private void listAcceptedsArticles() {
        ArrayList<Article> acceptedsArticles = articleService.findAcceptedsArticles();
        AtomicInteger i1 = new AtomicInteger(1);
        acceptedsArticles.sort(Comparator.comparing(Article::getTitle));
        acceptedsArticles.forEach(
                it -> System.out.println(i1.getAndIncrement() +" - ID: "+it.getId()+", Título: "+it.getTitle())
        );
    }

    private void  listRejectedsArticles() {
        ArrayList<Article> rejectedsArticles = articleService.findRejectedsArticles();
        AtomicInteger i = new AtomicInteger(1);
        rejectedsArticles.sort(Comparator.comparing(Article::getTitle));
        rejectedsArticles.forEach(
                it -> System.out.println(i.getAndIncrement() +" - ID: "+it.getId()+", Título: "+it.getTitle())
        );
    }

    private void detailArticle() {
        System.out.println("Informe o ID do artigo: ");
        Article article = articleService.findById(scan.nextLine());
        System.out.println(article);
    }

    private void listParticipants() {
        ArrayList<Participant> participants = participantService.findAll();
        participants.sort(Comparator.comparing(Participant::getName));
        System.out.println(participants);
    }

    private Author newAuthor() {
        //TODO implementar
        return null;
    }
    private Article newSubmission(Author author) {
        System.out.println("Informe o titulo: ");
        String title = scan.nextLine();

        System.out.println("Informe o abstract:");
        String anAnbstract = scan.nextLine();

        System.out.println("Informe a quantidade de palavras-chaves");
        int qnt = Integer.parseInt(scan.nextLine());
        ArrayList<String> keyWords = new ArrayList<String>();

        for (int i = 1; i <= qnt; i++) {
            System.out.println("Informe a "+i+"ª palavra-chave");
             keyWords.add(scan.nextLine());
        }

        System.out.println("Informe o numero de paginas");
        int numPags = Integer.parseInt(scan.nextLine());

        System.out.println("Infome a quantidade de autores (alem de voce): ");
        int qtdAuthors = Integer.parseInt(scan.nextLine());

        ArrayList<Author> authors = new ArrayList<Author>();
        authors.add(author);

        for (int i = 0; i < qtdAuthors; i++) {
            authors.add(newAuthor());
        }

        return new Article(
                title,
                anAnbstract,
                keyWords,
                numPags,
                new Date(),
                authors
        );
    }
    private void participantMenu(Participant participant) {
        int op = 0;

        do {
           try {
               System.out.println("ÁREA DO PARTICIPANTE");
               System.out.println("1 - Listar artigos aceitos");
               System.out.println("2 - Listar artigos negados");
               System.out.println("3 - Ver detalhes do artigo");
               System.out.println("4 - Listar parcipantes do evento");
               System.out.println("5 - Sair");

               op = Integer.parseInt(scan.nextLine());

               switch (op) {
                   case 1:
                       listAcceptedsArticles();
                       break;

                   case 2:
                       listRejectedsArticles();
                       break;

                   case 3:
                       detailArticle();
                       break;

                   case 4:
                       listParticipants();
                       break;

                   case 5:
                       break;

                   default:
                       System.out.println("Informe uma opcao valida");
                       break;
               }
           }catch (Exception e) {
               System.err.println(e.getMessage());
           }
        }while (op != 5);

    }

    private void programChairMenu(ProgramChair programChair) {
        int op = 0;

        do {
            try {
                System.out.println("PROGRAM CHAIR - PORTAL");
                System.out.println("1 - Listar avaliações de artigos");
                System.out.println("2 - Aprovar artigo");
                System.out.println("3 - Rejeitar artigo");
                System.out.println("4 - Listar artigos aceitos");
                System.out.println("5 - Listar artigos negados");
                System.out.println("6 - Ver detalhes do artigo");
                System.out.println("7 - Listar parcipantes do evento");
                System.out.println("8 - Sair");

                op = Integer.parseInt(scan.nextLine());

                switch (op) {
                    case 1:
                        System.out.println(reviewService.findAll());
                        break;

                    case 2:
                        System.out.println("Informe o ID do artigo a ser aprovado:");
                        String id = scan.nextLine();
                        articleService.approveById(id);
                        System.out.println("Artigo aprovado com sucesso!!");
                        break;

                    case 3:
                        System.out.println("Informe o ID do artigo a ser rejeitado:");
                        String id3 = scan.nextLine();
                        articleService.approveById(id3);
                        System.out.println("Artigo rejeitado com sucesso!!");
                        break;

                    case 4:
                        listAcceptedsArticles();
                        break;

                    case 5:
                        listRejectedsArticles();
                        break;

                    case 6:
                        detailArticle();
                        break;

                    case 7:
                        listParticipants();
                        break;

                    case 8:
                        break;

                    default:
                        System.out.println("Digite uma opcao válida");
                        break;
                }
            }catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }while (op != 8);

    }

    private void generalChairMenu(GeneralChair generalChair){
       int op = 0;

       do {
           try {
               System.out.println("GENERAL CHAIR - PORTAL");
               System.out.println("1 - Listar inscricoes pendentes");
               System.out.println("2 - Validar inscricao");
               System.out.println("3 - Invalidar inscrição");
               System.out.println("4 - Emitir certificado para participante");
               System.out.println("5 - Listar artigos aceitos");
               System.out.println("6 - Listar artigos negados");
               System.out.println("7 - Ver detalhes do artigo");
               System.out.println("8 - Listar parcipantes do evento");
               System.out.println("9 - Sair");

               op = Integer.parseInt(scan.nextLine());

               switch (op) {
                   case 1:
                       ArrayList<Participant> participants = participantService.findAllWithStatusPending();
                       System.out.println(participants);
                       break;

                   case 2:
                       System.out.println("Informe o CPF do participante: ");
                       participantService.validateInscriptionByCPF(scan.nextLine());
                       System.out.println("Inscrição deferida com sucesso!");
                       break;

                   case 3:
                       System.out.println("Informe o CPF do participante: ");
                       participantService.invalidateInscriptionByCPF(scan.nextLine());
                       System.out.println("Inscrição indeferida com sucesso!");
                       break;

                   case 4:
                       System.out.println("Infome o CPF do participante: ");
                       scan.nextLine();
                       System.out.println("Certificado emitido com sucesso!!");
                       break;

                   case 5:
                       listAcceptedsArticles();
                       break;

                   case 6:
                       listRejectedsArticles();
                       break;

                   case 7:
                       detailArticle();
                       break;

                   case 8:
                       listParticipants();
                       break;

                   case 9:
                       break;

                   default:
                       System.out.println("Digite uma opcao válida");
                       break;
               }
           }catch (Exception e) {
               System.err.println(e.getMessage());
           }
       }while (op != 9);
    }

    private void reviewerMenu(Reviewer reviewer) {
        int op = 0;

        do {
            try {
                System.out.println("REVISOR - PORTAL");
                System.out.println("1 - Listar suas avaliações");
                System.out.println("2 - Nova avaliacao");
                System.out.println("3 - Listar artigos pendentes de avaliacao");
                System.out.println("4 - Listar artigos aceitos");
                System.out.println("5 - Listar artigos negados");
                System.out.println("6 - Ver detalhes do artigo");
                System.out.println("7 - Listar parcipantes do evento");
                System.out.println("8 - Sair");

                op = Integer.parseInt(scan.nextLine());

                switch (op) {
                    case 1:
                        ArrayList<Review> reviews = reviewService.findByReviewer(reviewer);
                        System.out.println(reviews);
                        break;

                    case 2:
                        System.out.println("Informe o ID do artigo: ");
                        Article article = articleService.findById(scan.nextLine());

                        System.out.println("Inique a sua nota (inteiro de 0 a 10): ");
                        int rating = Integer.parseInt(scan.nextLine());

                        System.out.println("Insira seu comentario: ");
                        String comment = scan.nextLine();

                        Review review = new Review(article, reviewer, rating, comment);
                        reviewService.save(review);

                        System.out.println("Avaliacao realizada com sucesso!!");
                        break;

                    case 3:
                        System.out.println(articleService.findAllWithPendingReview());
                        break;

                    case 4:
                        listAcceptedsArticles();
                        break;

                    case 5:
                        listRejectedsArticles();
                        break;

                    case 6:
                        detailArticle();
                        break;

                    case 7:
                        listParticipants();
                        break;

                    case 8:
                        break;

                    default:
                        System.out.println("Digite uma opcao válida");
                        break;
                }
            }catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }while (op != 8);
    }

    private void authorMenu(Author author) {
        int op = 0;

        do {
            try {
                System.out.println("AUTOR - PORTAL");
                System.out.println("1 - Submeter artigo");
                System.out.println("2 - Listar avaliacoes dos meus artigos");
                System.out.println("3 - Listar artigos aceitos");
                System.out.println("4 - Listar artigos negados");
                System.out.println("5 - Ver detalhes do artigo");
                System.out.println("6 - Listar parcipantes do evento");
                System.out.println("7 - Sair");

                op = Integer.parseInt(scan.nextLine());

                switch (op) {
                    case 1:
                        Article article = newSubmission(author);
                        articleService.save(article);
                        System.out.println("Subimissão realizada com sucesso!");
                        break;

                    case 2:
                        ArrayList<Review> reviews = reviewService.findAllByAuthor(author);
                        System.out.println(reviews);
                        break;

                    case 3:
                        listAcceptedsArticles();
                        break;

                    case 4:
                        listRejectedsArticles();
                        break;

                    case 5:
                        detailArticle();
                        break;

                    case 6:
                        listParticipants();
                        break;

                    case 7:
                        break;

                    default:
                        System.out.println("Digite uma opcao válida");
                        break;
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }while (op != 7);
    }
}
