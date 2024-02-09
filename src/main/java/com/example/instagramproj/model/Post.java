package com.example.instagramproj.model;

import java.time.LocalDateTime;
import java.util.*;

public class Post {

    private  LocalDateTime time;
    private final List<String> caption = new ArrayList<>();
    private final int likes;
    private final Map<Account,Comment> commentMap = new HashMap<>();
    private final Account account;


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

    public List<String> getCaption() {
        return caption;
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
}
