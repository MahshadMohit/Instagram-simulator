package com.example.instagramproj.Controller;

import com.example.instagramproj.model.Account;
import com.example.instagramproj.model.Post;

public class PostController {





    public static void addPost(Account a, Post post) {
        a.getPosts().add(post);
    }

    public static void setPostArchieve(Account a, Post p) {
        a.getArchivePost().add(p);
        a.getPosts().remove(p);
    }

    public static void editCaption(Account a, StringBuilder sb, Post p) {

        for (Post post : a.getPosts()) {
            if (post.equals(p)) {
                post.setCaption(sb);
            }
        }


    }

    public static void savePost(Account a, Post p) {
        if (!a.getSaved().contains(p)) {
            a.getSaved().add(p);
        }
    }



}
