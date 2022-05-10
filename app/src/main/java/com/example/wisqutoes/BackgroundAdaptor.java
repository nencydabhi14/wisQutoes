package com.example.wisqutoes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class BackgroundAdaptor extends RecyclerView.Adapter<BackgroundAdaptor.ViewData> {

    Activity activity;
    String[] background;

    public BackgroundAdaptor(Create_page create_page, String[] background) {

        activity = create_page;
        this.background = background;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.background_fram,parent,false);
        return new  ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(activity)
                .load(background[position])
                .centerCrop()
                .into(holder.background_create);

        holder.background_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Create_page.preview_img.

                Glide.with(activity)
                        .load(background[position])
                        .centerCrop()
                        .into(Create_page.preview_img); }
        });

    }



    @Override
    public int getItemCount() {
        return background.length;
    }

    public class ViewData extends RecyclerView.ViewHolder {

        ImageView background_create;
        public ViewData(@NonNull View itemView) {
            super(itemView);
            background_create = (ImageView) itemView.findViewById(R.id.background_create);
        }
    }
}
