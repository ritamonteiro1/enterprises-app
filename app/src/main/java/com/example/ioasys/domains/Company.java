package com.example.ioasys.domains;


import java.io.Serializable;

public class Company implements Serializable {
    private final int image;
    private final String name;
    private final String title;
    private final String country;
    private final String description;

    public Company(int image, String name, String title, String country, String description) {
        this.image = image;
        this.name = name;
        this.title = title;
        this.country = country;
        this.description = description;
    }

    public String getDescription() {
        return description;
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
