package com.kipli.tbmakmur.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kipli.tbmakmur.R;
import com.kipli.tbmakmur.adapter.CardItemAdapter;
import com.kipli.tbmakmur.adapter.ListItemAdapter;
import com.kipli.tbmakmur.data.ItemData;
import com.kipli.tbmakmur.model.ItemModel;

import java.util.ArrayList;


public class BasketFragment extends Fragment {
    private RecyclerView recyclerView;
private ArrayList<ItemModel> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_basket, container, false);
        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_basket);
        list.addAll(ItemData.getDataList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CardItemAdapter cardItemAdapter = new CardItemAdapter(list);
        recyclerView.setAdapter(cardItemAdapter);
    }
}
