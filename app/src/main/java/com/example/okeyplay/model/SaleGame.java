package com.example.okeyplay.model;

public class SaleGame {

    int id;
    String img, title, genre, dev, text, price;

    public SaleGame(int id, String img, String title, String genre, String dev, String text, String price) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.genre = genre;
        this.dev = dev;
        this.text = text;
        this.price = price;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDev() {
        return dev;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
