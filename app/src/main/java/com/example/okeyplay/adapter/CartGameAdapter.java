package com.example.okeyplay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.okeyplay.R;
import com.example.okeyplay.model.AllGame;
import com.example.okeyplay.model.Shop;
import com.example.okeyplay.ui.BdViewModel;

import java.util.List;

public class CartGameAdapter extends RecyclerView.Adapter<CartGameAdapter.CartGameViewHolder> {

    Context context;
    List<Shop> shopList;

    BdViewModel viewModel;

    TextView textView_nullText;

    public CartGameAdapter(Context context, List<Shop> shopList, BdViewModel viewModel, TextView textView_nullText) {
        this.context = context;
        this.shopList = shopList;
        this.viewModel = viewModel;
        this.textView_nullText = textView_nullText;
    }

    @NonNull
    @Override
    public CartGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View allgameItems = LayoutInflater.from(context).inflate(R.layout.cartgame_item, parent, false);
        return new CartGameAdapter.CartGameViewHolder(allgameItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CartGameAdapter.CartGameViewHolder holder, int position) {

        Shop shop = shopList.get(position);

        holder.cartgameImage.setImageResource(shopList.get(position).getPicture());
        holder.cartgameTitle.setText(shopList.get(position).getTitle());
        holder.cartgameGenre.setText(shopList.get(position).getGenre());
        holder.cartgameDev.setText(shopList.get(position).getPageDev());
        holder.cartgamePrice.setText(String.valueOf(shopList.get(position).getPrice()));

        textView_nullText.setText("");

        /*
        int imageId = context.getResources().getIdentifier(allGames.get(position).getImg(), "drawable", context.getPackageName());
        holder.allgameImage.setImageResource(imageId);


        holder.allgameTitle.setText(allGames.get(position).getTitle());
        holder.allgameGenre.setText(allGames.get(position).getGenre());
        holder.allgameDev.setText(allGames.get(position).getDev());
        holder.allgamePrice.setText(allGames.get(position).getPrice());

         */

        holder.bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    Shop shop = shopList.get(currentPosition);
                    viewModel.delete_element_shop(shop.getUid());
                    removeItem(currentPosition);
                    if (shopList.size() == 0){
                        textView_nullText.setText("Пока что здесь пусто :(\n\nДобавьте понравившиеся товары!");
                    }
                }
            }
        });

        holder.bt_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shop.getCount() != 1){
                    shop.setCount(shop.getCount() - 1);
                    viewModel.update_shop(shop);
                    holder.cartCount.setText(String.valueOf(shop.getCount()));
                    holder.cartgamePrice.setText(String.valueOf((shop.getPrice()) *  shop.getCount() ));
                }
            }
        });

        holder.bt_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shop.setCount(shop.getCount() + 1);
                viewModel.update_shop(shop);
                holder.cartCount.setText(String.valueOf(shop.getCount()));
                holder.cartgamePrice.setText(String.valueOf((shop.getPrice()) *  shop.getCount() ));
            }
        });

    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public void removeItem(int position) {
        shopList.remove(position);
        // Уведомление об изменении данных в RecyclerView
        notifyItemRemoved(position);
    }

    public static final class CartGameViewHolder extends RecyclerView.ViewHolder{

        ImageView cartgameImage;
        TextView cartgameTitle;
        TextView cartgameGenre;
        TextView cartgameDev;
        TextView cartgamePrice;

        TextView cartCount;

        ImageButton bt_delete;
        ImageButton bt_plus;
        ImageButton bt_minus;

        public CartGameViewHolder(@NonNull View itemView) {
            super(itemView);

            cartgameImage = itemView.findViewById(R.id.cartgameImage);
            cartgameTitle = itemView.findViewById(R.id.cartgameTitle);
            cartgameGenre = itemView.findViewById(R.id.cartgameGenre);
            cartgameDev = itemView.findViewById(R.id.cartgameDev);
            cartgamePrice = itemView.findViewById(R.id.cartgamePrice);

            bt_delete = itemView.findViewById(R.id.deleteFromCart);
            bt_plus = itemView.findViewById(R.id.plusCart);
            bt_minus = itemView.findViewById(R.id.minusCart);

            cartCount = itemView.findViewById(R.id.cartgameCost);


        }
    }
}
