package com.main.profiletower.models;

import javax.persistence.*;

@Entity
public class Inbox {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="inbox_id")
    private Long Id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
