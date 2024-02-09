package com.example.instagramproj.model;

import java.util.*;

public class Account {

    public Account() {

    }
    public Account(String username){
        this.username = username;
    }

    private String username;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;


    private final List<Account> followers = new ArrayList<>();
    private final List<Account> following = new ArrayList<>();
    private final List<Account> closeFriends = new ArrayList<>();
    private final List<Post> posts = new ArrayList<>();
    private final List<Post> archive = new ArrayList<>();
    private final List<Post> saved = new ArrayList<>();


    private final Map<Post,List<Comment>> allComments = new HashMap<>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Account> getFollowers() {
        return followers;
    }

    public List<Account> getFollowing() {
        return following;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Account> getCloseFriends() {
        return closeFriends;
    }

    public List<Post> getArchive() {
        return archive;
    }

    public List<Post> getSaved() {
        return saved;
    }

    public Map<Post, List<Comment>> getAllComments() {
        return allComments;
    }

    // just to know who is this account :)

    @Override
    public String toString() {
        return username;
    }
}
