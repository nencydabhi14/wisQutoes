package com.example.wisqutoes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class SubAdaptor extends RecyclerView.Adapter<SubAdaptor.ViewData> {

    Activity activity;
    String[] temp;
    String[] temp_name;
    int i=0;

    public SubAdaptor(SubQuotes_design subQuotes_design, String[] temp, String[] temp_name) {
        activity = subQuotes_design;
        this.temp = temp;
        this.temp_name = temp_name;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.sub_post_design, parent, false);
        return new ViewData(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {
        holder.quot_cat_txt.setText(temp_name[position]);

        holder.txt_post.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {

                Random random = new Random();
                int n1 = random.nextInt(temp.length);

                Glide.with(activity)
                        .load(temp[n1])
                        .centerCrop()
                        .skipMemoryCache(false)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.glide_placeholder)
//                        .override(20, 20)
                        .into(holder.txt_post);
            }
        });


        holder.liked_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.liked_post.setImageResource(R.drawable.liked);
                Toast.makeText(activity, "Liked  !!", Toast.LENGTH_SHORT).show();

                holder.insta_category_like.setVisibility(View.VISIBLE);

                MediaPlayer song = MediaPlayer.create(activity, R.raw.like);
                song.start();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        holder.insta_category_like.setVisibility(View.INVISIBLE);
                    }
                }, 1000);
                holder.liked_post.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.liked_post.setImageResource(R.drawable.like);
                    }
                });

            }

        });
        holder.copy_post.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Copied  !!!", Toast.LENGTH_SHORT).show();

                Copy("", temp_name[position]);
            }
        });
        holder.share_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Hello USER,\nPlease Rate wsQuotes App On Play Store\n⭐⭐⭐⭐⭐\n\nYOUR QUOTE\n \uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\n\n" + temp_name[position];
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, temp_name[position]);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                activity.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        holder.save_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.quotes_category_frem.setDrawingCacheEnabled(true);
                holder.quotes_category_frem.destroyDrawingCache();
                Bitmap bitmap = holder.quotes_category_frem.getDrawingCache();
                try {
                    saveBitmap(activity,bitmap, Bitmap.CompressFormat.PNG,"image/*","quote.png");
                }catch(Exception e) {

                }
                Toast.makeText(activity, "Post Saved Successfully  !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return temp.length;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    void Copy(String s, String text) {
        ClipboardManager clipboard = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(s, text);
        clipboard.setPrimaryClip(clip);
    }

    public Uri saveBitmap(@NonNull final Context context, @NonNull final Bitmap bitmap, @NonNull final Bitmap.CompressFormat format, @NonNull final String mimeType, @NonNull final String displayName) throws IOException {

        final String relativeLocation = Environment.DIRECTORY_DCIM + File.separator + "wsQuotes";
        final ContentValues values = new ContentValues();
        values.put(MediaStore.MediaColumns.DISPLAY_NAME, displayName);
        values.put(MediaStore.MediaColumns.MIME_TYPE, mimeType);
        values.put(MediaStore.MediaColumns.RELATIVE_PATH, relativeLocation);

        final ContentResolver resolver = context.getContentResolver();
        Uri uri = null;

        try {
            final Uri contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            uri = resolver.insert(contentUri, values);

            if (uri == null)
                throw new IOException("Failed to create new MediaStore record.");

            try (final OutputStream stream = resolver.openOutputStream(uri)) {
                if (stream == null)
                    throw new IOException("Failed to open output stream.");

                if (!bitmap.compress(format, 95, stream))
                    throw new IOException("Failed to save bitmap.");
            }
            Toast.makeText(context, ""+uri, Toast.LENGTH_SHORT).show();

            return uri;
        }
        catch (IOException e) {

            if (uri != null) {
                // Don't leave an orphan entry in the MediaStore
                resolver.delete(uri, null, null);
            }

            throw e;
        }
    }


    public class ViewData extends RecyclerView.ViewHolder {
        ImageView txt_post,liked_post,copy_post,insta_category_like,save_post,share_post;
        TextView quot_cat_txt;
        FrameLayout quotes_category_frem;
//        ProgressBar progress_bar_post;
        public ViewData(@NonNull View itemView) {
            super(itemView);

            txt_post = itemView.findViewById(R.id.txt_post);
            liked_post = itemView.findViewById(R.id.liked_post);
            quotes_category_frem = itemView.findViewById(R.id.quotes_category_frem);
            insta_category_like = itemView.findViewById(R.id.insta_category_like);
            copy_post = itemView.findViewById(R.id.copy_post);
            save_post = itemView.findViewById(R.id.save_post);
            share_post = itemView.findViewById(R.id.share_post);
            quot_cat_txt = itemView.findViewById(R.id.quot_cat_txt);
//            progress_bar_post = (ProgressBar) itemView.findViewById(R.id.progress_bar_post);

        }
    }
}
