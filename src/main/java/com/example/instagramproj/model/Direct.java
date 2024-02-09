package com.example.instagramproj.model;

import java.time.LocalDateTime;
import java.util.*;


public class Direct {


    private Account toAccount;

    // when , who send what ? !
    private final Map<LocalDateTime,Map<Account,List<String>>> chats = new HashMap<>();


    public Map<LocalDateTime, Map<Account, List<String>>> getChats() {
        return chats;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }
}
