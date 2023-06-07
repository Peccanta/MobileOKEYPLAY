package com.example.okeyplay.ui;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.example.okeyplay.model.Repository;
import com.example.okeyplay.model.Shop;
import com.example.okeyplay.model.ShopDao;
import com.example.okeyplay.model.ShopRoomDatabase;

import java.util.List;

public class BdViewModel extends ViewModel {
    Repository repository;


    public void createMV(Context context){
        repository = new Repository(context);
    }



    public void insert_shop(Shop shop){
        repository.insert_shop(shop);
    }

    public void delete_element_shop(int id){
        repository.delete_element_shop(id);
    }

    public List<Shop> getAll_shop(){
        return repository.getAll_shop();
    }

    public int getCountRow_shop(){
        return repository.getCountRow_shop();
    }

    public void update_shop(Shop shop){
        repository.update_shop(shop);
    }
}
