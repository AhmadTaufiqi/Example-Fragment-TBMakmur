package com.kipli.tbmakmur.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kipli.tbmakmur.R;
import com.kipli.tbmakmur.adapter.GridItemAdapter;
import com.kipli.tbmakmur.data.ItemData;
import com.kipli.tbmakmur.model.ItemModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GridFragment extends Fragment {
 RecyclerView recyclerView;
 ArrayList<ItemModel> list = new ArrayList<>();

    public GridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_grid);
        list.addAll(ItemData.getDataList());
        showGridView();
    }

    private void showGridView(){
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        GridItemAdapter gridItemAdapter = new GridItemAdapter(list);
        recyclerView.setAdapter(gridItemAdapter);

        gridItemAdapter.setOnItemClickCallback(new GridItemAdapter.OnItemClickCallback(){
            public void onItemClicked (ItemModel itemModel){
                Toast.makeText(getContext(),"kamu memilih" + itemModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
