package com.example.instagramproj.model;

import javafx.scene.image.Image;

import java.time.LocalDateTime;

public class Story {

    private LocalDateTime time;
    private final Account account;
    private Image image;


    public Story(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
