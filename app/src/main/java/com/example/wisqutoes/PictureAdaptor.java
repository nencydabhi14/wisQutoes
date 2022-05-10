package com.example.wisqutoes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class PictureAdaptor extends RecyclerView.Adapter<PictureAdaptor.ViewData> {

    Context context;
    String[] picture;
    public PictureAdaptor(Picture_Screen picture_screen, String[] picture) {

        context = picture_screen;
        this.picture = picture; }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.picture_post_design,parent,false);
        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context)
                .load(picture[position])
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progress_picture.setVisibility(View.GONE);
                        return false; }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progress_picture.setVisibility(View.GONE);
                        return false;
                    }
                })
                .centerCrop()
                .into(holder.picture_post);

        holder.picture_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Picture_like.class);
                intent.putExtra("image",picture);
                intent.putExtra("ps",position);


                MediaPlayer song = MediaPlayer.create(context, R.raw.tap_sound);
                song.start();

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return picture.length;
    }

    public static class ViewData extends RecyclerView.ViewHolder {
        ImageView picture_post;
        ProgressBar progress_picture;
        public ViewData(@NonNull View itemView) {
            super(itemView);
            picture_post = (ImageView) itemView.findViewById(R.id.picture_post);
            progress_picture = (ProgressBar) itemView.findViewById(R.id.progress_picture);
        }
    }
}
