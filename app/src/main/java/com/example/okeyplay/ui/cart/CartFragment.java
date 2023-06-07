package com.example.okeyplay.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.okeyplay.R;
import com.example.okeyplay.adapter.CartGameAdapter;
import com.example.okeyplay.model.Shop;
import com.example.okeyplay.ui.BdViewModel;

import java.util.List;

public class CartFragment extends Fragment {

    private CartViewModel viewModel;


    List<Shop> shopList;
    BdViewModel viewModel_forRec;
    RecyclerView recyclerView_shop;
    RecyclerView.Adapter progAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(CartViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel_forRec = new ViewModelProvider(CartFragment.this).get(BdViewModel.class);

        viewModel_forRec.createMV(getActivity().getApplicationContext());
        shopList = viewModel_forRec.getAll_shop();
        TextView textView_nullText = view.findViewById(R.id.textView_nullText);

        recyclerView_shop = getView().findViewById(R.id.cartgameRecycler);
        recyclerView_shop.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView_shop.setLayoutManager(layoutManager);
        progAdapter = new CartGameAdapter(getContext(), shopList, viewModel_forRec, textView_nullText);
        recyclerView_shop.setAdapter(progAdapter);

    }
}