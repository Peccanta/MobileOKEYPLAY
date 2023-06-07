package com.example.okeyplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.okeyplay.model.Order;
import com.example.okeyplay.model.Shop;
import com.example.okeyplay.ui.BdViewModel;
import com.example.okeyplay.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;
import java.util.Objects;

public class NewGamePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_page);

        getSupportActionBar().hide();

        ImageView newGamePageImage = findViewById(R.id.newGamePageImage);
        TextView newGamePageTitle = findViewById(R.id.newGamePageTitle);
        TextView newGamePageGenre = findViewById(R.id.newGamePageGenre);
        TextView newGamePageDev = findViewById(R.id.newGamePageDev);
        TextView newGamePageText = findViewById(R.id.newGamePageText);
        TextView newGamePagePrice = findViewById(R.id.newGamePagePrice);

        BdViewModel viewModel = new ViewModelProvider(NewGamePage.this).get(BdViewModel.class);
        viewModel.createMV(getApplicationContext());

        Button bt_add_shop = findViewById(R.id.addToCart);

        newGamePageImage.setImageResource(getIntent().getIntExtra("newGamePageImage",0));
        newGamePageTitle.setText(getIntent().getStringExtra("newGamePageTitle"));
        newGamePageGenre.setText(getIntent().getStringExtra("newGamePageGenre"));
        newGamePageDev.setText(getIntent().getStringExtra("newGamePageDev"));
        newGamePageText.setText(getIntent().getStringExtra("newGamePageText"));
        newGamePagePrice.setText(getIntent().getStringExtra("newGamePagePrice"));

        bt_add_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Shop> shopList = viewModel.getAll_shop();
                boolean chek = true;
                for (int i = 0; i < shopList.size(); i++){
                    if (shopList.get(i).getTitle().equals(getIntent().getStringExtra("newGamePageTitle"))){
                        chek = false;
                    }
                }
                if (chek) {
                    Shop shop = new Shop(
                            getIntent().getIntExtra("ImageCart", 0),
                            getIntent().getStringExtra("newGamePageTitle"),
                            getIntent().getStringExtra("newGamePageGenre"),
                            getIntent().getStringExtra("newGamePageDev"),
                            Integer.parseInt(getIntent().getStringExtra("newGamePagePrice").replace("₽", "")),
                            1
                    );
                    viewModel.insert_shop(shop);
                }else {
                    Toast.makeText(getBaseContext(), "Товар уже добавлен в корзину!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}