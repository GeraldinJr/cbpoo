package br.com.cbpoo.model.entities;

import br.com.cbpoo.model.enuns.ArticleStatus;

import java.util.ArrayList;
import java.util.Date;

import static br.com.cbpoo.util.Id.randomId;

public class Article {
    private String id;
    private String title;
    private String abstractArticle;
    private ArrayList<String> Keywords;
    private int NumberOfPages;
    private Date SubmissionDate;
    private ArrayList<Author> Authors;
    private ArticleStatus articleStatus = ArticleStatus.REVISION;

    public Article(
            String title,
            String anAbstractArticle,
            ArrayList<String> keywords,
            int numberOfPages,
            Date submissionDate,
            ArrayList<Author> authors
    ) {
        this.id = randomId();
        this.title = title;
        abstractArticle = anAbstractArticle;
        Keywords = keywords;
        NumberOfPages = numberOfPages;
        SubmissionDate = submissionDate;
        Authors = authors;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstractArticle() {
        return abstractArticle;
    }

    public ArrayList<String> getKeywords() {
        return Keywords;
    }

    public int getNumberOfPages() {
        return NumberOfPages;
    }

    public Date getSubmissionDate() {
        return SubmissionDate;
    }

    public ArrayList<Author> getAuthors() {
        return Authors;
    }

    public ArticleStatus getStatus() {
        return articleStatus;
    }

    public void setStatus(ArticleStatus articleStatus) {
        this.articleStatus = articleStatus;
    }

}


