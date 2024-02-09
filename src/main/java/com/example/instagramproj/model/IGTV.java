package com.example.instagramproj.model;

import javafx.scene.media.Media;

public class IGTV extends Post {


    private Media media;

    public IGTV(Account a) {
        super(a);
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
