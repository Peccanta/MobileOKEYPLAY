package com.example.okeyplay.model;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ShopDao {

    @Query("SELECT * FROM shop")
    List<Shop> getAll();

    @Insert
    void insert(Shop shop);

    @Query("DELETE FROM shop WHERE uid = :uid")
    void delete(int uid);

    @Query("SELECT COUNT(*) FROM shop")
    int getRowCount();

    @Update
    void updateItem(Shop item);

}
