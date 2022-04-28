package com.example.networking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MountainAdapter extends RecyclerView.Adapter<MountainAdapter.ViewHolder> {

    private List<Mountain> mountains;

    public MountainAdapter(List<Mountain> mountains) { this.mountains = mountains; }

    public void setMountains(List<Mountain> mountains) {
        this.mountains = mountains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mountain_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mountain mountain = mountains.get(position);
        holder.tv_name.setText(mountain.getName());
        holder.tv_location.setText(mountain.getLocation());
        holder.tv_size.setText("Size: " + mountain.getSize());
        holder.tv_cost.setText("Cost: " + mountain.getCost());
        holder.tv_wiki.setText(mountain.getAuxdata().getWiki());

        Picasso.get().load(mountain.getAuxdata().getImg()).into(holder.iv_img);
    }

    @Override
    public int getItemCount() { return mountains.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_name;
        private final TextView tv_location;
        private final TextView tv_size;
        private final TextView tv_cost;
        private final TextView tv_wiki;
        private final ImageView iv_img;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_location = itemView.findViewById(R.id.tv_location);
            tv_size = itemView.findViewById(R.id.tv_size);
            tv_cost = itemView.findViewById(R.id.tv_cost);
            tv_wiki = itemView.findViewById(R.id.tv_link);
            iv_img = itemView.findViewById(R.id.iv_image);
        }
    }
}
