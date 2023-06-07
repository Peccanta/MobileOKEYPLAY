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
import com.example.okeyplay.model.NewGame;

import java.util.List;

public class NewGameAdapter extends RecyclerView.Adapter<NewGameAdapter.NewGameViewHolder> {

    Context context;
    List<NewGame> newGames;

    public NewGameAdapter(Context context, List<NewGame> newGames) {
        this.context = context;
        this.newGames = newGames;
    }

    @NonNull
    @Override
    public NewGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newgameItems = LayoutInflater.from(context).inflate(R.layout.newgame_item, parent, false);
        return new NewGameAdapter.NewGameViewHolder(newgameItems);
    }

    @Override
    public void onBindViewHolder(@NonNull NewGameAdapter.NewGameViewHolder holder, int position) {
        int imageId = context.getResources().getIdentifier(newGames.get(position).getImg(), "drawable", context.getPackageName());
        holder.newgameImage.setImageResource(imageId);

        holder.newgameTitle.setText(newGames.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewGamePage.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context,
                        new Pair<View, String>(holder.newgameImage, "newgameImage")
                );

                intent.putExtra("newGamePageImage", imageId);
                switch (position){
                    case 0:
                        intent.putExtra("ImageCart", R.drawable.g1);
                        break;

                    case 1:
                        intent.putExtra("ImageCart", R.drawable.g2);
                        break;

                    case 2:
                        intent.putExtra("ImageCart", R.drawable.g3);
                        break;

                    case 3:
                        intent.putExtra("ImageCart", R.drawable.g4);
                        break;
                }
                intent.putExtra("newGamePageTitle", newGames.get(position).getTitle());
                intent.putExtra("newGamePageGenre", newGames.get(position).getGenre());
                intent.putExtra("newGamePageDev", newGames.get(position).getDev());
                intent.putExtra("newGamePageText", newGames.get(position).getText());
                intent.putExtra("newGamePagePrice", newGames.get(position).getPrice());

                intent.putExtra("newGamePageId", newGames.get(position).getId());

                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return newGames.size();
    }

    public static final class NewGameViewHolder extends RecyclerView.ViewHolder{

        ImageView newgameImage;
        TextView newgameTitle;

        public NewGameViewHolder(@NonNull View itemView) {
            super(itemView);

            newgameImage = itemView.findViewById(R.id.newgameImage);
            newgameTitle = itemView.findViewById(R.id.newgameTitle);
        }
    }
}
