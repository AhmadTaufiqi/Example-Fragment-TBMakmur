package com.kipli.tbmakmur.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kipli.tbmakmur.R;
import com.kipli.tbmakmur.data.ItemData;
import com.kipli.tbmakmur.model.ItemModel;

import java.util.ArrayList;

import javax.crypto.spec.IvParameterSpec;

public class CardItemAdapter extends RecyclerView.Adapter {
    ArrayList<ItemModel> List;
    public CardItemAdapter(ArrayList<ItemModel> list) {
        this.List = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new CardItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((CardItemHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private class CardItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mItemTitle, mItemStock;
        private ImageView mItemImage;

        public CardItemHolder(View itemView) {
            super(itemView);
            mItemTitle = itemView.findViewById(R.id.tv_item_name);
            mItemStock = itemView.findViewById(R.id.tv_item_detail);
            mItemImage = itemView.findViewById(R.id.img_item_photo);

            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {
            mItemTitle.setText(ItemData.itemsNames[position]);
            mItemStock.setText(ItemData.itemsStock[position]);
            mItemImage.setImageResource(ItemData.itemsImages[position]);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
