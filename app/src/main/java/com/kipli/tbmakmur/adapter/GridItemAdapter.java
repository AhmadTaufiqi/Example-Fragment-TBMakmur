package com.kipli.tbmakmur.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kipli.tbmakmur.R;
import com.kipli.tbmakmur.model.ItemModel;

import java.util.ArrayList;

public class GridItemAdapter extends RecyclerView.Adapter<GridItemAdapter.GridViewHolder> {
    private ArrayList<ItemModel> list;
    private OnItemClickCallback onItemClickCallback;

    public GridItemAdapter(ArrayList<ItemModel> list) {
        this.list = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gridview, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
    ItemModel itemModel = list.get(position);
        Glide.with(holder.itemView.getContext())
                .load(list.get(position).getPhoto())
                .into(holder.mItemImage);
        holder.mItemTitle.setText(itemModel.getName());
        holder.mItemDetail.setText(itemModel.getStock());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(list.get(holder.getAbsoluteAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        private TextView mItemTitle, mItemDetail;
        private ImageView mItemImage;
        public GridViewHolder(@NonNull View itemView) {
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
