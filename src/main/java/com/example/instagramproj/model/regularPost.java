package com.example.instagramproj.model;

import javafx.scene.image.*;

public class regularPost extends Post {

    private Image image;

    public regularPost(Account a) {
        super(a);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
