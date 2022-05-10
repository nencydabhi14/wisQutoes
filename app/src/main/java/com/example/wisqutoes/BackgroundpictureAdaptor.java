package com.example.wisqutoes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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

public class BackgroundpictureAdaptor extends RecyclerView.Adapter<BackgroundpictureAdaptor.ViewData> {

    Context context;
    String[] bk_create;

    public BackgroundpictureAdaptor(Background_picture background_picture, String[] bk_create) {

        context = background_picture;
        this.bk_create = bk_create;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.background_design, parent, false);
        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context)
                .load(bk_create[position])
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progress_create.setVisibility(View.GONE);
                        return false; }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progress_create.setVisibility(View.GONE);
                        return false;
                    }
                })
                .centerCrop()
                .into(holder.background_picture_create);

        holder.background_picture_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Background_page_screen.class);
                intent.putExtra("image",bk_create);
                intent.putExtra("ps",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bk_create.length;
    }

    public class ViewData extends RecyclerView.ViewHolder {

        ImageView background_picture_create;
        ProgressBar progress_create;

        public ViewData(@NonNull View itemView) {
            super(itemView);
            background_picture_create = (ImageView) itemView.findViewById(R.id.background_picture_create);
            progress_create = (ProgressBar) itemView.findViewById(R.id.progress_create);
        }
    }
}
