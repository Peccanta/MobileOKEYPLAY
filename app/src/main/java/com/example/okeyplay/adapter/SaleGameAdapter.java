package com.example.okeyplay.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.okeyplay.NewGamePage;
import com.example.okeyplay.R;
import com.example.okeyplay.SaleGamePage;
import com.example.okeyplay.model.HitGame;
import com.example.okeyplay.model.SaleGame;

import java.util.List;

public class SaleGameAdapter extends RecyclerView.Adapter<SaleGameAdapter.SaleGameViewHolder> {

    Context context;
    List<SaleGame> saleGames;

    public SaleGameAdapter(Context context, List<SaleGame> saleGames) {
        this.context = context;
        this.saleGames = saleGames;
    }

    @NonNull
    @Override
    public SaleGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View salegameItems = LayoutInflater.from(context).inflate(R.layout.salegame_item, parent, false);
        return new SaleGameAdapter.SaleGameViewHolder(salegameItems);
    }

    @Override
    public void onBindViewHolder(@NonNull SaleGameAdapter.SaleGameViewHolder holder, int position) {
        int imageId = context.getResources().getIdentifier(saleGames.get(position).getImg(), "drawable", context.getPackageName());
        holder.salegameImage.setImageResource(imageId);

        holder.salegameTitle.setText(saleGames.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SaleGamePage.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context,
                        new Pair<View, String>(holder.salegameImage, "salegameImage")
                );

                intent.putExtra("saleGamePageImage", imageId);
                switch (position){
                    case 0:
                        intent.putExtra("ImageCart", R.drawable.g9);
                        break;

                    case 1:
                        intent.putExtra("ImageCart", R.drawable.g10);
                        break;

                    case 2:
                        intent.putExtra("ImageCart", R.drawable.g11);
                        break;

                    case 3:
                        intent.putExtra("ImageCart", R.drawable.g12);
                        break;
                }
                intent.putExtra("saleGamePageTitle", saleGames.get(position).getTitle());
                intent.putExtra("saleGamePageGenre", saleGames.get(position).getGenre());
                intent.putExtra("saleGamePageDev", saleGames.get(position).getDev());
                intent.putExtra("saleGamePageText", saleGames.get(position).getText());
                intent.putExtra("saleGamePagePrice", saleGames.get(position).getPrice());

                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return saleGames.size();
    }

    public static final class SaleGameViewHolder extends RecyclerView.ViewHolder{

        ImageView salegameImage;
        TextView salegameTitle;

        public SaleGameViewHolder(@NonNull View itemView) {
            super(itemView);

            salegameImage = itemView.findViewById(R.id.salegameImage);
            salegameTitle = itemView.findViewById(R.id.salegameTitle);
        }
    }
}
