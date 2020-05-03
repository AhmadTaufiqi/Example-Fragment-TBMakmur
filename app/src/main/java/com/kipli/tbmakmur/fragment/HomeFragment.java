package com.kipli.tbmakmur.fragment;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.InputDevice;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kipli.tbmakmur.R;
import com.kipli.tbmakmur.adapter.ListItemAdapter;
import com.kipli.tbmakmur.data.ItemData;
import com.kipli.tbmakmur.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<ItemModel> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_home, container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView =view.findViewById(R.id.rv_home);
        list.addAll(ItemData.getDataList());
        showList();
    }

//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.mode_grid){
//            GridFragment gridFragment = new GridFragment();
//            FragmentManager fragmentManager = getFragmentManager();
//            if (fragmentManager != null){
//                fragmentManager
//                        .beginTransaction()
//                        .replace(R.id.grid_fragment, gridFragment, GridFragment.class.getSimpleName())
//                        .addToBackStack(null)
//                        .commit();
//            }
//        }
//    }
    private void showList(){

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListItemAdapter listItemAdapter = new ListItemAdapter(list);
        recyclerView.setAdapter(listItemAdapter);

        listItemAdapter.setOnItemClickCallback(new ListItemAdapter.OnItemClickCallback(){

            public void onItemClicked(ItemModel itemModel){
               Toast.makeText(getContext(), "kamu memilih " + itemModel.getName(), Toast.LENGTH_SHORT).show();
           }
        });
    }

}
