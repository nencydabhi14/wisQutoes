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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class CatagoryAdaptor extends RecyclerView.Adapter<CatagoryAdaptor.ViewData> {

    Context context;
    String[] quotname;
    String[] imgquotes;

    public CatagoryAdaptor(Category_screen category_screen, String[] quotname, String[] imgquotes) {
        context = category_screen;
        this.quotname = quotname;
        this.imgquotes = imgquotes;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.catagory_design,parent,false);
        return new ViewData(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {

        holder.txtcat_id.setText(quotname[position]);

        Glide.with(context)
                .load(imgquotes[position])
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progress_bar.setVisibility(View.GONE);
                        return false; }
                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progress_bar.setVisibility(View.GONE);
                        return false; }})
                .centerCrop()
                .into(holder.img_category);

        holder.img_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "" + quotname[position], Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context ,SubQuotes_design.class);
                intent.putExtra("name",quotname[position]);
                intent.putExtra("ps",position);
//                intent.putExtra("love",love[position]);
                context.startActivity(intent);


                MediaPlayer song = MediaPlayer.create(context, R.raw.tap_sound);
                song.start();


                Toast.makeText(context, "Tap to Change Background.. !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return quotname.length;
    }

    public class ViewData extends RecyclerView.ViewHolder {

        TextView txtcat_id;
        ImageView img_category;
        ProgressBar progress_bar;
        public ViewData(@NonNull View itemView) {
            super(itemView);
            txtcat_id = itemView.findViewById(R.id.txtcat_id);
            img_category = itemView.findViewById(R.id.img_category);
            progress_bar = itemView.findViewById(R.id.progress_bar);
        }
    }
}
