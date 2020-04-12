package com.example.eventandguest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridGuestAdapter extends RecyclerView.Adapter<GridGuestAdapter.GridViewHolder> {

    private ArrayList<Guest> listGuest = new ArrayList<>();

    private OnItemClickCallback onItemClickCallback;

    public GridGuestAdapter() {
    }

    public void setData (ArrayList<Guest> items){
        listGuest.clear();
        listGuest.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GridGuestAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_guest, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridGuestAdapter.GridViewHolder holder, int position) {
        Guest guest = listGuest.get(position);
        Glide.with(holder.itemView.getContext())
                .load(guest.getAvatar())
                .apply(new RequestOptions().override(350, 350))
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listGuest.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listGuest.size();
    }


    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_guest);
        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Guest data);
    }

    public ArrayList<Guest> getListGuest() {
        return listGuest;
    }
}
