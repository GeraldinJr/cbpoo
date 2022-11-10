package br.com.cbpoo.model.entities;

public class Review {
    private Article article;
    private Reviewer reviewer;
    private int rating;
    private String comment;

    public Review(Article article, Reviewer reviewer, int rating, String comment) {
        this.article = article;
        this.reviewer = reviewer;
        this.rating = rating;
        this.comment = comment;
    }
}
