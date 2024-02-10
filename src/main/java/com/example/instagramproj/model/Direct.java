package com.example.instagramproj.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;


public class Direct {


    private Account toAccount;
    private Account fromAccount;

    // when , who send what ? !
    private final Map<LocalTime, Map<Account,  String>> chats = new HashMap<>();


    public Map<LocalTime, Map<Account, String>> getChats() {
        return chats;
    }

    public Direct(Account from , Account to){
        this.toAccount = to;
        this.fromAccount = from;
    }
    public Direct(){

    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }
}
