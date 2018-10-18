package com.main.profiletower.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Image {

    //TODO: add user id so the image belongs to a user.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="image_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @NotEmpty
    private String fileName;

    @NotEmpty
    private String fileNameServer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileNameServer() {
        return fileNameServer;
    }

    public void setFileNameServer(String fileNameServer) {
        this.fileNameServer = fileNameServer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
