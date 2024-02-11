package com.example.instagramproj.Controller;


import com.example.instagramproj.model.*;

import java.util.*;

public class CommentController {


    public final static List<Post> posts = new ArrayList<>();


    public void deleteComment(Comment cmnt, Post p) {
        for (Post post : posts) {
            if (post.equals(p)) {
                post.getCommentMap().values().remove(cmnt);
                p.getAccount().getFeed().recentComments.remove(cmnt.getAccount(),cmnt);
            }
        }
    }

    private void commentOnPost(Comment comment) {
        for (Post p : posts) {
            if (p.equals(comment.getPost())) {
                p.getCommentMap().put(comment.getAccount(), comment);
                p.getAccount().getFeed().recentComments.put(comment.getAccount(), comment);
            }
        }
    }

    public void comment(String text, Post post, Account account) {
        Comment comment = new Comment(text, account, post);
        commentOnPost(comment);

        for (Post p : account.getAllComments().keySet()) {
            if (p.equals(post)) {
                account.getAllComments().get(p).add(comment);
            } else {
                List<Comment> comments = new ArrayList<>();
                comments.add(comment);
                account.getAllComments().put(p, comments);
            }
        }


    }

    public int showLikes(Comment comment) {
        return comment.getLikes();
    }


}
