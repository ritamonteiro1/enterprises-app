package com.example.ioasys.domains;

import android.widget.ImageView;

public class Companies {
    private final int image;
    private final String name;
    private final String title;
    private final String country;

    public Companies(int image, String name, String title, String country) {
        this.image = image;
        this.name = name;
        this.title = title;
        this.country = country;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getCountry() {
        return country;
    }
}
