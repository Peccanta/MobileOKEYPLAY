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

public class SaleGamePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_game_page);

        getSupportActionBar().hide();

        ImageView saleGamePageImage = findViewById(R.id.saleGamePageImage);
        TextView saleGamePageTitle = findViewById(R.id.saleGamePageTitle);
        TextView saleGamePageGenre = findViewById(R.id.saleGamePageGenre);
        TextView saleGamePageDev = findViewById(R.id.saleGamePageDev);
        TextView saleGamePageText = findViewById(R.id.saleGamePageText);
        TextView saleGamePagePrice = findViewById(R.id.saleGamePagePrice);

        BdViewModel viewModel = new ViewModelProvider(SaleGamePage.this).get(BdViewModel.class);
        viewModel.createMV(getApplicationContext());

        Button bt_add_shop = findViewById(R.id.addToCart);

        saleGamePageImage.setImageResource(getIntent().getIntExtra("saleGamePageImage",0));
        saleGamePageTitle.setText(getIntent().getStringExtra("saleGamePageTitle"));
        saleGamePageGenre.setText(getIntent().getStringExtra("saleGamePageGenre"));
        saleGamePageDev.setText(getIntent().getStringExtra("saleGamePageDev"));
        saleGamePageText.setText(getIntent().getStringExtra("saleGamePageText"));
        saleGamePagePrice.setText(getIntent().getStringExtra("saleGamePagePrice"));

        bt_add_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Shop> shopList = viewModel.getAll_shop();
                boolean chek = true;
                for (int i = 0; i < shopList.size(); i++){
                    if (shopList.get(i).getTitle().equals(getIntent().getStringExtra("saleGamePageTitle"))){
                        chek = false;
                    }
                }
                if (chek) {
                    Shop shop = new Shop(
                            getIntent().getIntExtra("ImageCart", 0),
                            getIntent().getStringExtra("saleGamePageTitle"),
                            getIntent().getStringExtra("saleGamePageGenre"),
                            getIntent().getStringExtra("saleGamePageDev"),
                            Integer.parseInt(getIntent().getStringExtra("saleGamePagePrice").replace("₽", "")),
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