package com.thoughtworks.aceleradora.domain;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "net_promoter_score")
public class NetPromoterScore {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private int score;
    private String comments;

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId(){
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getComments() {
        return comments;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean hasMinimalAcceptableScore() {
        return this.score > 0;
    }
}
