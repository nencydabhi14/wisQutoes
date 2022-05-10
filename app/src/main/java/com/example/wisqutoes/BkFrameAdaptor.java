package com.example.wisqutoes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class BkFrameAdaptor extends RecyclerView.Adapter<BkFrameAdaptor.ViewData> {


    Activity activity;
    String[] frem;

    public BkFrameAdaptor(Background_page_screen background_page_screen, String[] frem) {
        activity = background_page_screen;
        this.frem = frem;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.bk_frem_design, parent, false);
        return new ViewData(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(activity)
                .load(frem[position])
                .centerCrop()
                .into(holder.frem_create);

        holder.frem_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(activity)
                        .load(frem[position])
                        .centerCrop()
                        .into(Background_page_screen.frem_bk); }
        });
    }

    @Override
    public int getItemCount() {
        return frem.length;
    }

    public class ViewData extends RecyclerView.ViewHolder {

        ImageView frem_create;
        public ViewData(@NonNull View itemView) {
            super(itemView);

            frem_create = (ImageView) itemView.findViewById(R.id.frem_create);
        }
    }
}
