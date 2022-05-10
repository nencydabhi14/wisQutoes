package com.example.wisqutoes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class Picture_like extends AppCompatActivity {

    String[] picture;
    int ps;
    ImageView picture_like, liked_pic, saved_pic,picture_like_insta,share_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_like);

        binding();

        picture = getIntent().getStringArrayExtra("image");
        ps = getIntent().getIntExtra("ps", 0);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));

        Glide.with(Picture_like.this)
                .load(picture[ps])
                .centerCrop()
                .placeholder(R.drawable.glide_placeholder)
                .into(picture_like);

        liked_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liked_pic.setImageResource(R.drawable.liked);
                Toast.makeText(Picture_like.this, "Liked !!", Toast.LENGTH_SHORT).show();

                picture_like_insta.setVisibility(View.VISIBLE);

                MediaPlayer song = MediaPlayer.create(Picture_like.this, R.raw.like);
                song.start();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        picture_like_insta.setVisibility(View.INVISIBLE);
                    }
                }, 1000);

                liked_pic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        liked_pic.setImageResource(R.drawable.like);
                    }
                });
            }
        });

        saved_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                picture_like.setDrawingCacheEnabled(true);
                picture_like.destroyDrawingCache();
                Bitmap bitmap = picture_like.getDrawingCache();
                try {
                    saveBitmap(Picture_like.this,bitmap, Bitmap.CompressFormat.PNG,"image/*","quote.png");
                }catch(Exception e) {

                }

                Toast.makeText(Picture_like.this, "Picture Saved Successfully...!!!", Toast.LENGTH_SHORT).show();
            }
        });
        share_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Hello USER,\nPlease Rate wsQuotes App On Play Store\n⭐⭐⭐⭐⭐\n\nYOUR QUOTE\n \uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\n\n" + picture[ps];
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, picture[ps]);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                Picture_like.this.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
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


    private void binding() {
        picture_like = (ImageView) findViewById(R.id.picture_like);
        picture_like_insta = (ImageView) findViewById(R.id.picture_like_insta);
        liked_pic = (ImageView) findViewById(R.id.liked_pic);
        saved_pic = (ImageView) findViewById(R.id.saved_pic);
        share_picture = (ImageView) findViewById(R.id.share_picture);
    }
}