package com.example.instagramproj.model;

import javafx.scene.image.Image;

import java.time.LocalDateTime;
import java.util.*;

public class Post {

    private LocalDateTime time;
    private StringBuilder caption = new StringBuilder();
    private final int likes;
    private final Map<Account, Comment> commentMap = new HashMap<>();
    private final Account account;
    private Image img;


    public Post(Account a) {
        account = a;
        likes = 0;

    }

    public LocalDateTime getTime() {
        return time;
    }


    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public StringBuilder getCaption() {
        return caption;
    }
    public void setCaption(StringBuilder sb){
        this.caption = sb;
    }

    public int getLikes() {
        return likes;
    }

    public Map<Account, Comment> getCommentMap() {
        return commentMap;
    }

    public Account getAccount() {
        return account;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
