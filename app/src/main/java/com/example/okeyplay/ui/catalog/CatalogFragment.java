package com.example.okeyplay.ui.catalog;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.okeyplay.NewGamePage;
import com.example.okeyplay.R;
import com.example.okeyplay.adapter.AllGameAdapter;
import com.example.okeyplay.adapter.CategoryAdapter;
import com.example.okeyplay.model.AllGame;
import com.example.okeyplay.model.Category;
import com.example.okeyplay.model.Shop;
import com.example.okeyplay.ui.BdViewModel;
import com.example.okeyplay.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class CatalogFragment extends Fragment {

    private CatalogViewModel viewModel;

    RecyclerView categoryRecycler, allgameRecycler;
    CategoryAdapter categoryAdapter;
    static AllGameAdapter allGameAdapter;
    static List<AllGame> allgameList = new ArrayList<>();
    public static List<AllGame> fullAllGameList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(CatalogViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView Filter = view.findViewById(R.id.imageView_filter);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Arcade"));
        categoryList.add(new Category(2, "Action"));
        categoryList.add(new Category(3, "Shooter"));
        categoryList.add(new Category(4, "RPG"));
        categoryList.add(new Category(5, "Horror"));
        categoryList.add(new Category(6, "Racing"));
        categoryList.add(new Category(7, "Casual"));
        categoryList.add(new Category(8, "Fighting"));

        setCategoryRecycler(categoryList);

        allgameList.clear();
        fullAllGameList.clear();

        allgameList.add(new AllGame(1, "g1", "Hogwarts Legacy", "Action", "Steam", "1999₽", 2));
        allgameList.add(new AllGame(2, "g2", "Atomic Heart", "Shooter", "VK Play", "2299₽", 3));
        allgameList.add(new AllGame(3, "g3", "Dying Light 2:\nStay Human",  "Horror", "Steam", "1899₽", 5));
        allgameList.add(new AllGame(4, "g4", "Saints Row",  "RPG", "EGS", "1499₽", 4));
        allgameList.add(new AllGame(5, "g5", "Horizon Zero Dawn",  "Action", "EGS", "2199₽", 2));
        allgameList.add(new AllGame(6, "g6", "Elden Ring",  "Arcade", "Steam", "1899₽", 1));
        allgameList.add(new AllGame(7, "g7", "Far Cry 6",  "Racing", "Ubisoft", "1299₽", 6));
        allgameList.add(new AllGame(8, "g8", "The Witcher 3:\nWild Hunt",  "RPG", "EGS", "1499₽", 4));
        allgameList.add(new AllGame(9, "g9", "Doom Eternal",  "Shooter", "Steam", "1399₽", 3));
        allgameList.add(new AllGame(10, "g10", "God of War:\nRagnarök",  "Action", "Steam", "2299₽", 2));
        allgameList.add(new AllGame(11, "g11", "The Last of Us",  "Casual", "Steam", "1199₽", 7));
        allgameList.add(new AllGame(12, "g12", "For Honor",  "Fighting", "EGS", "1099₽", 8));

        fullAllGameList.addAll(allgameList);

        setAllGameRecycler(allgameList);

        Filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allgameList.clear();
                allgameList.addAll(fullAllGameList);
                allGameAdapter.notifyDataSetChanged();
            }
        });
    }
    private void setAllGameRecycler(List<AllGame> allgameList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        allgameRecycler = getView().findViewById(R.id.allgameRecycler);
        allgameRecycler.setLayoutManager(layoutManager);

        BdViewModel viewModel = new ViewModelProvider(CatalogFragment.this).get(BdViewModel.class);
        viewModel.createMV(getContext());
        List<Shop> shopList = viewModel.getAll_shop();

        allGameAdapter = new AllGameAdapter(getContext(), allgameList, shopList, viewModel);
        allgameRecycler.setAdapter(allGameAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        categoryRecycler = getView().findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(getContext(), categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showAllGamesByCategory(int category){
        allgameList.clear();
        allgameList.addAll(fullAllGameList);

        List<AllGame> filterAllGames = new ArrayList<>();

        for (AllGame c : fullAllGameList){
            if (c.getCategory() == category)
                filterAllGames.add(c);
        }

        allgameList.clear();
        allgameList.addAll(filterAllGames);
        filterAllGames.clear();
        allGameAdapter.notifyDataSetChanged();
    }
}