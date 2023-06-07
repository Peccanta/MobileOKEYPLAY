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

import com.example.okeyplay.HitGamePage;
import com.example.okeyplay.NewGamePage;
import com.example.okeyplay.R;
import com.example.okeyplay.model.HitGame;

import java.util.List;

public class HitGameAdapter extends RecyclerView.Adapter<HitGameAdapter.HitGameViewHolder> {

    Context context;
    List<HitGame> hitGames;

    public HitGameAdapter(Context context, List<HitGame> hitGames) {
        this.context = context;
        this.hitGames = hitGames;
    }

    @NonNull
    @Override
    public HitGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View hitgameItems = LayoutInflater.from(context).inflate(R.layout.hitgame_item, parent, false);
        return new HitGameAdapter.HitGameViewHolder(hitgameItems);
    }

    @Override
    public void onBindViewHolder(@NonNull HitGameAdapter.HitGameViewHolder holder, int position) {
        int imageId = context.getResources().getIdentifier(hitGames.get(position).getImg(), "drawable", context.getPackageName());
        holder.hitgameImage.setImageResource(imageId);

        holder.hitgameTitle.setText(hitGames.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HitGamePage.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context,
                        new Pair<View, String>(holder.hitgameImage, "hitgameImage")
                );

                intent.putExtra("hitGamePageImage", imageId);
                switch (position){
                    case 0:
                        intent.putExtra("ImageCart", R.drawable.g5);
                        break;

                    case 1:
                        intent.putExtra("ImageCart", R.drawable.g6);
                        break;

                    case 2:
                        intent.putExtra("ImageCart", R.drawable.g7);
                        break;

                    case 3:
                        intent.putExtra("ImageCart", R.drawable.g8);
                        break;
                }
                intent.putExtra("hitGamePageTitle", hitGames.get(position).getTitle());
                intent.putExtra("hitGamePageGenre", hitGames.get(position).getGenre());
                intent.putExtra("hitGamePageDev", hitGames.get(position).getDev());
                intent.putExtra("hitGamePageText", hitGames.get(position).getText());
                intent.putExtra("hitGamePagePrice", hitGames.get(position).getPrice());


                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return hitGames.size();
    }

    public static final class HitGameViewHolder extends RecyclerView.ViewHolder{

        ImageView hitgameImage;
        TextView hitgameTitle;

        public HitGameViewHolder(@NonNull View itemView) {
            super(itemView);

            hitgameImage = itemView.findViewById(R.id.hitgameImage);
            hitgameTitle = itemView.findViewById(R.id.hitgameTitle);
        }
    }
}
