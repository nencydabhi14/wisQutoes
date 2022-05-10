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

public class ColorpictureAdaptor extends RecyclerView.Adapter<ColorpictureAdaptor.ViewData> {


    Context context;
    String[] color_create;

    public ColorpictureAdaptor(Color_Selection_Picture color_selection_picture, String[] color_create) {

        context = color_selection_picture;
        this.color_create = color_create;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.color_design, parent, false);
        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context)
                .load(color_create[position])
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.color_progress_create.setVisibility(View.GONE);
                        return false; }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.color_progress_create.setVisibility(View.GONE);
                        return false;
                    }
                })
                .centerCrop()
                .into(holder.color_create);

        holder.color_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Color_Create_Screen.class);
                intent.putExtra("color_image",color_create);
                intent.putExtra("ps_color",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return color_create.length;
    }

    public class ViewData extends RecyclerView.ViewHolder {

        ImageView color_create;
        ProgressBar color_progress_create;

        public ViewData(@NonNull View itemView) {
            super(itemView);

            color_create = (ImageView) itemView.findViewById(R.id.color_create);
            color_progress_create = (ProgressBar) itemView.findViewById(R.id.color_progress_create);
        }
    }
}
