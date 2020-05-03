package com.kipli.tbmakmur.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kipli.tbmakmur.R;
import com.kipli.tbmakmur.data.ItemData;
import com.kipli.tbmakmur.model.ItemModel;

import java.util.ArrayList;


public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListViewHolder> {
    private ArrayList<ItemModel> itemList;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }
    public ListItemAdapter(ArrayList<ItemModel> list) {
    this.itemList = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListItemAdapter.ListViewHolder holder, int position) {
        ItemModel itemModel = itemList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(itemModel.getPhoto())
                .into(holder.mItemImage);
        holder.mItemTitle.setText(itemModel.getName());
        holder.mItemDetail.setText(itemModel.getStock());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(itemList.get(holder.getBindingAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView mItemTitle, mItemDetail;
        private ImageView mItemImage;
        public ListViewHolder(View itemView) {
            super(itemView);
            mItemTitle = itemView.findViewById(R.id.tv_item_name);
            mItemDetail = itemView.findViewById(R.id.tv_item_detail);
            mItemImage = itemView.findViewById(R.id.img_item_photo);
        }
    }
    public interface OnItemClickCallback{
        void onItemClicked(ItemModel itemModel);
    }
}

