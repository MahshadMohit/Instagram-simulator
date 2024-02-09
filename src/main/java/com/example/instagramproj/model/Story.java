package com.example.instagramproj.model;

import java.time.LocalDateTime;

public class Story {

    private LocalDateTime time;
    private final Account account;
    


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
}
