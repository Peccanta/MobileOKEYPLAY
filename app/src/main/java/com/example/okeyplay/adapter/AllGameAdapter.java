package com.example.okeyplay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.okeyplay.R;
import com.example.okeyplay.model.AllGame;
import com.example.okeyplay.model.Shop;
import com.example.okeyplay.ui.BdViewModel;

import java.util.List;

public class AllGameAdapter extends RecyclerView.Adapter<AllGameAdapter.AllGameViewHolder> {

    Context context;
    List<AllGame> allGames;
    List<Shop> shopList;
    BdViewModel viewModel;

    public AllGameAdapter(Context context, List<AllGame> allGames, List<Shop> shopList,  BdViewModel viewModel) {
        this.context = context;
        this.allGames = allGames;
        this.shopList = shopList;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public AllGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View allgameItems = LayoutInflater.from(context).inflate(R.layout.allgame_item, parent, false);
        return new AllGameAdapter.AllGameViewHolder(allgameItems);
    }

    @Override
    public void onBindViewHolder(@NonNull AllGameAdapter.AllGameViewHolder holder, int position) {
        int imageId = context.getResources().getIdentifier(allGames.get(position).getImg(), "drawable", context.getPackageName());
        holder.allgameImage.setImageResource(imageId);

        holder.allgameTitle.setText(allGames.get(position).getTitle());
        holder.allgameGenre.setText(allGames.get(position).getGenre());
        holder.allgameDev.setText(allGames.get(position).getDev());
        holder.allgamePrice.setText(allGames.get(position).getPrice());

        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chek = true;
                List<Shop> shopList2 = viewModel.getAll_shop();
                for (int i = 0; i < shopList2.size(); i++){
                    if (shopList2.get(i).getTitle().equals(allGames.get(position).getTitle())){
                        chek = false;
                    }
                }
                if (chek) {
                    Integer img = 0;
                    switch (allGames.get(position).getImg()){
                        case "g1":
                            img = R.drawable.g1;
                            break;
                        case "g2":
                            img = R.drawable.g2;
                            break;
                        case "g3":
                            img = R.drawable.g3;
                            break;
                        case "g4":
                            img = R.drawable.g4;
                            break;
                        case "g5":
                            img = R.drawable.g5;
                            break;
                        case "g6":
                            img = R.drawable.g6;
                            break;
                        case "g7":
                            img = R.drawable.g7;
                            break;
                        case "g8":
                            img = R.drawable.g8;
                            break;
                        case "g9":
                            img = R.drawable.g9;
                            break;
                        case "g10":
                            img = R.drawable.g10;
                            break;
                        case "g11":
                            img = R.drawable.g11;
                            break;
                        case "g12":
                            img = R.drawable.g12;
                            break;
                    }
                    Shop shop = new Shop(
                            img,
                            allGames.get(position).getTitle(),
                            allGames.get(position).getGenre(),
                            allGames.get(position).getDev(),

                            Integer.parseInt(allGames.get(position).getPrice().replace("₽", "")),
                            1
                    );
                    viewModel.insert_shop(shop);
                }else {
                    Toast.makeText(view.getContext(), "Товар уже добавлен в корзину!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return allGames.size();
    }

    public static final class AllGameViewHolder extends RecyclerView.ViewHolder{

        ImageView allgameImage;
        TextView allgameTitle;
        TextView allgameGenre;
        TextView allgameDev;
        TextView allgamePrice;

        Button addToCart;

        public AllGameViewHolder(@NonNull View itemView) {
            super(itemView);

            allgameImage = itemView.findViewById(R.id.allgameImage);
            allgameTitle = itemView.findViewById(R.id.allgameTitle);
            allgameGenre = itemView.findViewById(R.id.allgameGenre);
            allgameDev = itemView.findViewById(R.id.allgameDev);
            allgamePrice = itemView.findViewById(R.id.allgamePrice);
            addToCart = itemView.findViewById(R.id.addToCart);
        }
    }
}
