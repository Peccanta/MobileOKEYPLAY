package com.example.okeyplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.okeyplay.model.Shop;
import com.example.okeyplay.ui.BdViewModel;

import java.util.List;
import java.util.Objects;

public class HitGamePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hit_game_page);

        getSupportActionBar().hide();

        ImageView hitGamePageImage = findViewById(R.id.hitGamePageImage);
        TextView hitGamePageTitle = findViewById(R.id.hitGamePageTitle);
        TextView hitGamePageGenre = findViewById(R.id.hitGamePageGenre);
        TextView hitGamePageDev = findViewById(R.id.hitGamePageDev);
        TextView hitGamePageText = findViewById(R.id.hitGamePageText);
        TextView hitGamePagePrice = findViewById(R.id.hitGamePagePrice);

        BdViewModel viewModel = new ViewModelProvider(HitGamePage.this).get(BdViewModel.class);
        viewModel.createMV(getApplicationContext());

        Button bt_add_shop = findViewById(R.id.addToCart);

        hitGamePageImage.setImageResource(getIntent().getIntExtra("hitGamePageImage",0));
        hitGamePageTitle.setText(getIntent().getStringExtra("hitGamePageTitle"));
        hitGamePageGenre.setText(getIntent().getStringExtra("hitGamePageGenre"));
        hitGamePageDev.setText(getIntent().getStringExtra("hitGamePageDev"));
        hitGamePageText.setText(getIntent().getStringExtra("hitGamePageText"));
        hitGamePagePrice.setText(getIntent().getStringExtra("hitGamePagePrice"));

        bt_add_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Shop> shopList = viewModel.getAll_shop();
                boolean chek = true;
                for (int i = 0; i < shopList.size(); i++){
                    if (shopList.get(i).getTitle().equals(getIntent().getStringExtra("hitGamePageTitle"))){
                        chek = false;
                    }
                }
                if (chek) {
                    Shop shop = new Shop(
                            getIntent().getIntExtra("ImageCart", 0),
                            getIntent().getStringExtra("hitGamePageTitle"),
                            getIntent().getStringExtra("hitGamePageGenre"),
                            getIntent().getStringExtra("hitGamePageDev"),
                            Integer.parseInt(getIntent().getStringExtra("hitGamePagePrice").replace("₽", "")),
                            1
                    );
                    viewModel.insert_shop(shop);
                }else {
                    Toast.makeText(getBaseContext(), "Товар уже в корзине", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}