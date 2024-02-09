package com.example.instagramproj.model;

import java.util.*;

public class Feed {

    public List<Account> recentFollows = new ArrayList<>();
    public Map<Account, List<Post>> recentLikes = new HashMap<>();
    public Map<Account, List<Comment>> recentComments = new HashMap<>();
    public final Account account;


    public Feed(Account account) {
        this.account = account;
    }
}
