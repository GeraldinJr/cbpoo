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

    public Article getArticle() {
        return article;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Review{\n" +
                "article=" + article + "\n" +
                "reviewer=" + reviewer + "\n"+
                "rating=" + rating + "\n"+
                "comment='" + comment + "\n" +
                '}';
    }
}
