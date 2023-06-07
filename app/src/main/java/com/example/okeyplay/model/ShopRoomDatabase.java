package com.example.okeyplay.model;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Shop.class}, version = 3, exportSchema = false)
public abstract class ShopRoomDatabase extends RoomDatabase {

    public abstract ShopDao shopDao();

}
