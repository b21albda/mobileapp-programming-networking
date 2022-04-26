package com.example.networking;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class MountainAdapter extends RecyclerView.Adapter<MountainAdapter.ViewHolder> {
    private List<Mountain> mountains;

    public MountainAdapter(List<Mountain> mountains) { this.mountains = mountains; }

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
        holder.tv_size.setText(mountain.getSize());
        holder.tv_cost.setText(mountain.getCost());
        holder.tv_wiki.setText(mountain.getAuxdata().getWiki());
        try {
            InputStream in = (InputStream) new URL(mountain.getAuxdata().getImg()).getContent();
            Bitmap bitmap = BitmapFactory.decodeStream(in);
            holder.iv_img.setImageBitmap(bitmap);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() { return mountains.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_location;
        private TextView tv_size;
        private TextView tv_cost;
        private TextView tv_wiki;
        private ImageView iv_img;


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
