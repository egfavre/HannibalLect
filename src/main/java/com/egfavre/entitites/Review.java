package com.egfavre.entitites;



import javax.persistence.*;

/**
 * Created by user on 7/1/16.
 */
@Entity
@Table(name="reviews")
public class Review {
    @GeneratedValue
    @Id
    int id;

    @Column(nullable = false)
    String author;

    @Column(nullable = false)
    String comment;

    @Column(nullable = false)
    Boolean isGood;

    @ManyToOne
    Lecturer lecturer;

    public Review() {
    }

    public Review(String author, String comment, Boolean isGood, Lecturer lecturer) {
        this.author = author;
        this.comment = comment;
        this.isGood = isGood;
        this.lecturer = lecturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getGood() {
        return isGood;
    }

    public void setGood(Boolean good) {
        isGood = good;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
}
