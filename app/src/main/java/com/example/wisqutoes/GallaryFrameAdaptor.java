package com.example.wisqutoes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class GallaryFrameAdaptor extends RecyclerView.Adapter<GallaryFrameAdaptor.ViewData> {

    Context context;
    String[] frem_gallery;

    public GallaryFrameAdaptor(gallary_page gallary_page, String[] frem_gallery) {
        context = gallary_page;
        this.frem_gallery=frem_gallery;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gallary_frem_design, parent, false);
        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context)
                .load(frem_gallery[position])
                .centerCrop()
                .into(holder.gallery_frem_create);

        holder.gallery_frem_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(context)
                        .load(frem_gallery[position])
                        .centerCrop()
                        .into(gallary_page.gallery_frem_img); }
        });
    }

    @Override
    public int getItemCount() {
        return frem_gallery.length;
    }

    public class ViewData extends RecyclerView.ViewHolder {

        ImageView gallery_frem_create;

        public ViewData(@NonNull View itemView) {
            super(itemView);
            gallery_frem_create = (ImageView) itemView.findViewById(R.id.gallery_frem_create);
        }
    }
}
