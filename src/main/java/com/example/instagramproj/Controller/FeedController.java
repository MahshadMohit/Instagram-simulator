package com.example.instagramproj.Controller;

import com.example.instagramproj.model.Account;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class FeedController {


    private void setProfile(ImageView view, Account ac) {
        if (ac.getProfile() == null) {
            view.setImage(new Image("img.png"));
        } else {
            view.setImage(ac.getProfile());
        }
    }

    public VBox getRecentFollowers(Account account) {
        VBox vBox = new VBox();
        for (Account ac : getFollowerList(account)) {
            Text text = new Text(ac.getUsername() + " started following you");

            ImageView view = new ImageView();

            setProfile(view, ac);

            HBox hBox = new HBox(view, text);
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setSpacing(5);
            vBox.getChildren().add(hBox);
        }

        return vBox;

    }

    public List<Account> getFollowerList(Account ac) {
        return ac.getFeed().recentFollows;
    }

    public VBox getRecentLikes(Account account) {
        VBox vBox = new VBox();
        for (Account ac : getLikes(account)) {
            Text text = new Text(ac.getUsername() + " liked this post");
            ImageView view = new ImageView();
            setProfile(view, ac);
            ImageView postView = new ImageView(account.getFeed().recentLikes.get(ac).getImg());

            HBox hBox = new HBox(view, text, postView);
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setSpacing(5);

            vBox.getChildren().add(hBox);

        }

        return vBox;

    }

    public List<Account> getLikes(Account ac) {
        return new ArrayList<>(ac.getFeed().recentLikes.keySet());
    }

    public VBox getRcentComments(Account account) {
        VBox vBox = new VBox();

        for (Account ac : getComments(account)) {
            Text text = new Text(ac.getUsername() + " commented : " + account.getFeed().recentComments.get(ac).getText());
            ImageView view = new ImageView();
            setProfile(view, ac);
            ImageView postView = new ImageView();
            postView.setImage(account.getFeed().recentComments.get(ac).getPost().getImg());

            HBox hBox = new HBox(view , text , postView);
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setSpacing(5);

            vBox.getChildren().add(hBox);

        }

        return vBox;
    }

    public List<Account> getComments(Account ac){
        return new ArrayList<>(ac.getFeed().recentComments.keySet());
    }


}
