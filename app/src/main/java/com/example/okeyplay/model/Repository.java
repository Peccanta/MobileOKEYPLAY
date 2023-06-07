package com.example.okeyplay.model;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class Repository {
    public ShopRoomDatabase bd_shop = null;

    public ShopDao shopDao = null;

    public List<Shop> shopList = null;


    public Repository(Context context) {

        bd_shop = Room.databaseBuilder(context.getApplicationContext(), ShopRoomDatabase.class,
                        "List_Shop")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        shopDao = bd_shop.shopDao();
    }



    public void insert_shop(Shop shop){
        shopDao.insert(shop);
    }

    public void delete_element_shop(int id){
        shopDao.delete(id);
    }

    public void update_shop(Shop shop){
        shopDao.updateItem(shop);
    }

    public List<Shop> getAll_shop(){
        return shopDao.getAll();
    }

    public int getCountRow_shop(){
        return shopDao.getRowCount();
    }
}
