package com.allnewspaper.allmordernnewspaper.Model;

import java.io.Serializable;

public class BengaliNewsTitle implements Serializable {
    int image;
    String link;

    public BengaliNewsTitle(int image, String link) {
        this.image = image;
        this.link = link;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
