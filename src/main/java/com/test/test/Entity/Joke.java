package com.test.test.Entity;

import javax.persistence.*;

@Entity
@Table(name = "joke")
public class Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "content")
    private String content;
    @Column(name = "likes")
    private int likes = 0;
    @Column(name = "dislikes")
    private int dislikes = 0;

    public Joke(String content, int likes, int dislikes) {
        this.content = content;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Joke() {
    }

    public Joke setLikeInc() {
        setLikes(this.getLikes() + 1);
        return this;
    }

    public Joke setDislikeInc() {
        setDislikes((this.getDislikes() + 1));
        return this;
    }

    public int getDifference(){return this.getLikes()-this.getDislikes();}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getContent() { return content;}

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
}
