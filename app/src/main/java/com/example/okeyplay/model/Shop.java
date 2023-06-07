package com.example.okeyplay.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Shop {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    private Integer mPicture;
    private String mTitle;

    private String mGenre;

    private String mPageDev;
    private int mPrice;
    private int mCount;

    public Shop(Integer mPicture, String mTitle, String mGenre, String mPageDev, int mPrice, int mCount) {
        this.mPicture = mPicture;
        this.mTitle = mTitle;
        this.mGenre = mGenre;
        this.mPageDev = mPageDev;
        this.mPrice = mPrice;
        this.mCount = mCount;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int mCount) {
        this.mCount = mCount;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Integer getPicture() {
        return mPicture;
    }

    public void setPicture(Integer mPicture) {
        this.mPicture = mPicture;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String mGenre) {
        this.mGenre = mGenre;
    }


    public String getPageDev() {
        return mPageDev;
    }

    public void setPageDev(String mnewGamePageDev) {
        this.mPageDev = mnewGamePageDev;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int mPrice) {
        this.mPrice = mPrice;
    }
}


