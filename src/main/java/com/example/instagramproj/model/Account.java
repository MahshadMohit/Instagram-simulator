package com.example.instagramproj.model;

import javafx.scene.image.Image;

import java.util.*;

public class Account  {

    public Account() {

    }

    public Account(String username) {
        this.username = username;
    }

    public Account(String username, String password, String name, int phonenumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = String.valueOf(phonenumber);
    }

    public Account(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }


    private String username;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private Image profile;



    private final List<Account> followers = new ArrayList<>();
    private final List<Account> following = new ArrayList<>();
    private final List<Account> closeFriends = new ArrayList<>();
    private final Map<Account, Boolean> requests = new HashMap<>();
    private final List<Post> posts = new ArrayList<>();
    private final List<Post> archivePost = new ArrayList<>();
    private final List<Post> saved = new ArrayList<>();
    private final List<Direct> directs = new ArrayList<>();
    private String bio;

    private Story story;


    private final Map<Post, List<Comment>> allComments = new HashMap<>();
    private final List<Story> archiveStory = new ArrayList<>();
    private final List<String> links = new ArrayList<>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }
    public String getBio(){
        return this.bio;
    }
    public void setBio(String bio){
        this.bio = bio;
    }
    public List<String> getLinks(){
        return this.links;
    }
    public Image getProfile(){
        return this.profile;
    }
    public void setProfile(Image profile){
        this.profile = profile;
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


    public String getPhoneNumber() {
        return phoneNumber;
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

    public List<Post> getArchivePost() {
        return archivePost;
    }

    public List<Story> getArchiveStory() {
        return archiveStory;
    }

    public List<Post> getSaved() {
        return saved;
    }

    public Map<Post, List<Comment>> getAllComments() {
        return allComments;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public Map<Account, Boolean> getRequests() {
        return this.requests;
    }

    // just to know who is this account :)

    @Override
    public String toString() {
        return username;
    }


    public void archiveStory() {
        if (this.story.getTime().getHour() == 23) {
            archiveStory.add(this.story);
        }

    }

    public List<Direct> getDirects() {
        return directs;
    }
}
