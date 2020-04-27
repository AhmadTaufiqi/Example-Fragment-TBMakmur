package com.kipli.tbmakmur.adapter;


import android.content.ClipData;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kipli.tbmakmur.R;
import com.kipli.tbmakmur.data.ItemData;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return ItemData.itemsNames.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mItemTitle, mItemDetail;
        private ImageView mItemImage;
        public ListViewHolder(View itemView){
            super(itemView);
            mItemTitle = (TextView) itemView.findViewById(R.id.tv_item_name);
            mItemDetail = (TextView) itemView.findViewById(R.id.tv_item_detail);
            mItemImage = (ImageView) itemView.findViewById(R.id.img_item_photo);

            itemView.setOnClickListener(this);
        }
        public void bindView(int position){
            mItemTitle.setText(ItemData.itemsNames[position]);
            mItemDetail.setText(ItemData.itemsStock[position]);
            mItemImage.setImageResource(ItemData.itemsImages[position]);
        }

        @Override
        public void onClick(View v) {

        }
    }
}

