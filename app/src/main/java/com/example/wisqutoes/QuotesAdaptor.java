package com.example.wisqutoes;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class QuotesAdaptor extends RecyclerView.Adapter<QuotesAdaptor.ViewData> {

    Context context;
    String[] img_quotes;
    String[] quotes;
    int i = 0;

    public QuotesAdaptor(Quoyes_page quoyes_page, String[] img_quotes, String[] quotes) {
        context = quoyes_page;
        this.img_quotes = img_quotes;
        this.quotes = quotes;
    }
    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.quotes_screen_design,parent,false);
        return new ViewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewData holder, @SuppressLint("RecyclerView") int position) {
        holder.quotes_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int n1 = random.nextInt(img_quotes.length);

//                holder.quotes_img.setImageResource(img_quotes[n1]);

                Glide.with(context)
                        .load(img_quotes[n1])
                        .centerCrop()
                        .placeholder(R.drawable.glide_placeholder)
                        .into(holder.quotes_img);
            }
        });

        holder.quotes_txt.setText(quotes[position]);

        holder.copied_img.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Quotes Copied !!!", Toast.LENGTH_SHORT).show();

                Copy("", quotes[position]);
            }
        });
        holder.save_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.quote_frem_img.setDrawingCacheEnabled(true);
                holder.quote_frem_img.destroyDrawingCache();
                Bitmap bitmap = holder.quote_frem_img.getDrawingCache();
                try {
                    saveBitmap(context,bitmap, Bitmap.CompressFormat.PNG,"image/*","quote.png");
                }catch(Exception e) {

                }

                Toast.makeText(context, "Post Saved Successfully...!!!", Toast.LENGTH_SHORT).show();
            }
        });
        holder.share_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Hello USER,\nPlease Rate wsQuotes App On Play Store\n⭐⭐⭐⭐⭐\n\nYOUR QUOTE\n \uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\n\n" + quotes[position];
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, quotes[position]);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        holder.like_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.like_img.setImageResource(R.drawable.liked);
                Toast.makeText(context, "Liked !!", Toast.LENGTH_SHORT).show();

                holder.insta_post_like.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        holder.insta_post_like.setVisibility(View.INVISIBLE);
                    }
                }, 1000);
                MediaPlayer song = MediaPlayer.create(context, R.raw.like);
                song.start();

                holder.like_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.like_img.setImageResource(R.drawable.like);
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return quotes.length;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    void Copy(String s, String text) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(s, text);
        clipboard.setPrimaryClip(clip);
    }

    public class ViewData extends RecyclerView.ViewHolder {
        ImageView quotes_img,copied_img,like_img,insta_post_like,save_img,share_img;
        ProgressBar quotes_progress;
        TextView quotes_txt;
        FrameLayout quote_frem_img;

        public ViewData(@NonNull View itemView) {
            super(itemView);
            quotes_img = (ImageView) itemView.findViewById(R.id.quotes_img);
            copied_img = (ImageView) itemView.findViewById(R.id.copied_img);
            quote_frem_img = (FrameLayout) itemView.findViewById(R.id.quote_frem_img);
            insta_post_like = (ImageView) itemView.findViewById(R.id.insta_post_like);
            like_img = (ImageView) itemView.findViewById(R.id.like_img);
            save_img = (ImageView) itemView.findViewById(R.id.save_img);
            share_img = (ImageView) itemView.findViewById(R.id.share_img);
            quotes_progress = (ProgressBar) itemView.findViewById(R.id.quotes_progress);
            quotes_txt = (TextView) itemView.findViewById(R.id.quotes_txt);
        }
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

}
