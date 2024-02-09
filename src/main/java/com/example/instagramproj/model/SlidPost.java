package com.example.instagramproj.model;

import javafx.scene.image.Image;

import java.util.*;


public class SlidPost extends Post{

    private ArrayList<Image> list = new ArrayList<>();

    public SlidPost(Account a) {
        super(a);
    }

    public ArrayList<Image> getList() {
        return list;
    }

    public void setList(ArrayList<Image> list) {
        this.list = list;
    }
}
