package br.com.cbpoo;

import br.com.cbpoo.controller.MenuController;
import br.com.cbpoo.factory.ServiceFactory;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ServiceFactory serviceFactory = new ServiceFactory();

        MenuController menu = new MenuController(
                new Scanner(System.in),
                serviceFactory.newParticipantService(),
                serviceFactory.newArticleService(),
                serviceFactory.newReviewService(),
                serviceFactory.newProgramChairService(),
                serviceFactory.newGeneralchairService(),
                serviceFactory.newAuthorService(),
                serviceFactory.newReviewerService()
        );

        menu.run();

    }
}


