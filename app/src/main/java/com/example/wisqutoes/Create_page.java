package com.example.wisqutoes;

import static com.example.wisqutoes.Select_Media_Activity.bitmap_img;
import static com.example.wisqutoes.Select_Media_Activity.uri;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.intellij.lang.annotations.JdkConstants;

import java.net.URI;

public class Create_page extends AppCompatActivity {

    String[] background = {"https://miro.medium.com/max/2000/1*--lG41sA959jnwHKcJ01Tw.jpeg",
            "https://img.wallpapersafari.com/desktop/1536/864/48/71/2R6kSo.jpg",
            "https://wallpapers-hd-wide.com/wp-content/uploads/2020/05/hd-motivational-start-doing_1200.jpg",
            "https://assets.entrepreneur.com/content/3x2/2000/20150921045005-shutterstock-157706513.jpeg",
            "https://i.ytimg.com/vi/hMb583X1Wx0/maxresdefault.jpg",
            "https://www.travelmeetshappy.com/wp-content/uploads/2017/09/Travellers-Movie-Wallpapers.jpg",
            "https://www.insidehighered.com/sites/default/server_files/media/iStock-625736338.jpg",
            "https://assets.wallpapersin4k.org/uploads/2017/04/Tree-Silhouette-Wallpaper-5.jpg",
            "https://t3.ftcdn.net/jpg/04/29/35/62/360_F_429356296_CVQ5LkC6Pl55kUNLqLisVKgTw9vjyif1.jpg",
            "https://www.progressionsolicitors.com/wp-content/uploads/2021/12/Family-Mediation-2021.jpg",
            "https://gcdn.suwalls.com/wallpapers/artistic/rainbow-thoughts-14870-1920x1200.jpg",
            "https://media.istockphoto.com/photos/makeup-brushes-on-black-background-picture-id1090043994?k=20&m=1090043994&s=170667a&w=0&h=uHJmoGwVRaNeEHAs-R5BjQ833tVZJ_sM9Uw5hvttG4Y=",
            "https://wallpaperset.com/w/full/f/9/9/224677.jpg",
            "https://stpaulsherwood.org/wp-content/uploads/2020/01/thank-you.jpg",
            "https://d1el5jddkxvjyd.cloudfront.net/viceroyhotelsandresorts.com-2109743334/cms/cache/v2/5c708de080ee7.jpg/1920x1080/fit/80/057fb72a9947f202aa494de7067929b5.jpg",
            "https://hushoffice.com/wp-content/uploads/2021/01/shutterstock_1302585175.jpg",
            "https://www.desktopbackground.org/download/1920x1080/2011/10/23/285260_good-morning-sunshine-and-greenery-wallpapers_1920x1200_h.jpg",};

    private ImageView text_edt_img, background_img, style_img, color_img, shadow_img, vector_img, sticker_img,back_camera;
    private View txt_view, background_view, style_view, color_view, shadow_view, vector_view, sticker_view;
    private TextView txt_edt;
    private TextView save_camera;
    private RecyclerView background_recycler;
    private CardView background_post_recycler;
    public static ImageView preview_img;
    String txt;

//    String[] bk_create;
//    int ps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_page);
        binding();
        preview_img.setImageBitmap(bitmap_img);

//        if(condition to The image coming from gallery)
//        {
            //the things i have to do with bitmap that i know
//        }

//        else if (preview_img .equals(uri)){
//            preview_img.setImageURI(Select_Media_Activity.uri);
//        }
//        else if (preview_img.equals(bk_create)){
//            bk_create = getIntent().getStringArrayExtra("image");
//            ps = getIntent().getIntExtra("ps", 0);
//
//            Glide.with(Create_page.this).load(bk_create[ps]).into(preview_img);
//        }


        BackgroundAdaptor backgroundAdaptor = new BackgroundAdaptor(Create_page.this, background);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Create_page.this, RecyclerView.HORIZONTAL, false);
        background_recycler.setLayoutManager(layoutManager);
        background_recycler.setAdapter(backgroundAdaptor);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));

        background_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_img.setImageResource(R.drawable.font);
                txt_view.setVisibility(View.INVISIBLE);
                style_img.setImageResource(R.drawable.style);
                style_view.setVisibility(View.INVISIBLE);
                color_img.setImageResource(R.drawable.color);
                color_view.setVisibility(View.INVISIBLE);
                shadow_img.setImageResource(R.drawable.shadow);
                shadow_view.setVisibility(View.INVISIBLE);
                vector_img.setImageResource(R.drawable.bkvctr);
                vector_view.setVisibility(View.INVISIBLE);
                sticker_img.setImageResource(R.drawable.sticker);
                sticker_view.setVisibility(sticker_view.INVISIBLE);

                background_img.setImageResource(R.drawable.background);
                background_view.setVisibility(background_view.VISIBLE);

                background_post_recycler.setVisibility(View.VISIBLE);
            }
        });

        text_edt_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_img.setImageResource(R.drawable.fontw);
                txt_view.setVisibility(txt_view.VISIBLE);

                textdialog();
                background_post_recycler.setVisibility(View.INVISIBLE);

                color_img.setImageResource(R.drawable.color);
                color_view.setVisibility(color_view.INVISIBLE);
                shadow_img.setImageResource(R.drawable.shadow);
                shadow_view.setVisibility(shadow_view.INVISIBLE);
                vector_img.setImageResource(R.drawable.bkvctr);
                vector_view.setVisibility(vector_view.INVISIBLE);
                sticker_img.setImageResource(R.drawable.sticker);
                sticker_view.setVisibility(sticker_view.INVISIBLE);
                background_img.setImageResource(R.drawable.backgnd);
                background_view.setVisibility(background_view.INVISIBLE);
                style_img.setImageResource(R.drawable.style);
                style_view.setVisibility(style_view.INVISIBLE);
            }
        });

        style_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_img.setImageResource(R.drawable.font);
                txt_view.setVisibility(txt_view.INVISIBLE);
                background_img.setImageResource(R.drawable.backgnd);
                background_view.setVisibility(background_view.INVISIBLE);
                color_img.setImageResource(R.drawable.color);
                color_view.setVisibility(color_view.INVISIBLE);
                shadow_img.setImageResource(R.drawable.shadow);
                shadow_view.setVisibility(shadow_view.INVISIBLE);
                vector_img.setImageResource(R.drawable.bkvctr);
                vector_view.setVisibility(vector_view.INVISIBLE);
                sticker_img.setImageResource(R.drawable.sticker);
                sticker_view.setVisibility(sticker_view.INVISIBLE);
                background_post_recycler.setVisibility(View.INVISIBLE);

                style_img.setImageResource(R.drawable.stylew);
                style_view.setVisibility(style_view.VISIBLE);
            }
        });

        color_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_img.setImageResource(R.drawable.font);
                txt_view.setVisibility(View.INVISIBLE);
                background_img.setImageResource(R.drawable.backgnd);
                background_view.setVisibility(View.INVISIBLE);
                style_img.setImageResource(R.drawable.style);
                style_view.setVisibility(View.INVISIBLE);
                shadow_img.setImageResource(R.drawable.shadow);
                shadow_view.setVisibility(View.INVISIBLE);
                vector_img.setImageResource(R.drawable.bkvctr);
                vector_view.setVisibility(View.INVISIBLE);
                sticker_img.setImageResource(R.drawable.sticker);
                sticker_view.setVisibility(View.INVISIBLE);
                background_post_recycler.setVisibility(View.INVISIBLE);


                color_img.setImageResource(R.drawable.colorw);
                color_view.setVisibility(View.VISIBLE);

//                ColorPickerDialogBuilder
//                        .with(Create_page.this)
//                        .setTitle("Choose color")
//                        .initialColor(currentBackgroundColor)
//                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
//                        .density(12)
////                        .setOnColorSelectedListener(new OnColorSelectedListener() {
////                            public void onColorSelected(int selectedColor) {
////                                toast("onColorSelected: 0x" + Integer.toHexString(selectedColor));
////                            }
////                        })
//                        .setPositiveButton("ok",
//                                new ColorPickerClickListener() {
//                                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
//                                        changeBackgroundColor(selectedColor);
//                                    }
//                                })
//                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                            }
//                        })
//                        .build()
//                        .show();

            }
        });

        shadow_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_img.setImageResource(R.drawable.font);
                txt_view.setVisibility(txt_view.INVISIBLE);
                background_img.setImageResource(R.drawable.backgnd);
                background_view.setVisibility(background_view.INVISIBLE);
                style_img.setImageResource(R.drawable.style);
                style_view.setVisibility(style_view.INVISIBLE);
                color_img.setImageResource(R.drawable.color);
                color_view.setVisibility(color_view.INVISIBLE);
                vector_img.setImageResource(R.drawable.bkvctr);
                vector_view.setVisibility(vector_view.INVISIBLE);
                sticker_img.setImageResource(R.drawable.sticker);
                sticker_view.setVisibility(sticker_view.INVISIBLE);
                background_post_recycler.setVisibility(View.INVISIBLE);

                shadow_img.setImageResource(R.drawable.shadoww);
                shadow_view.setVisibility(shadow_view.VISIBLE);
            }
        });

        vector_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_img.setImageResource(R.drawable.font);
                txt_view.setVisibility(txt_view.INVISIBLE);
                background_img.setImageResource(R.drawable.backgnd);
                background_view.setVisibility(background_view.INVISIBLE);
                style_img.setImageResource(R.drawable.style);
                style_view.setVisibility(style_view.INVISIBLE);
                color_img.setImageResource(R.drawable.color);
                color_view.setVisibility(color_view.INVISIBLE);
                shadow_img.setImageResource(R.drawable.shadow);
                shadow_view.setVisibility(shadow_view.INVISIBLE);
                sticker_img.setImageResource(R.drawable.sticker);
                sticker_view.setVisibility(sticker_view.INVISIBLE);
                background_post_recycler.setVisibility(View.INVISIBLE);


                vector_img.setImageResource(R.drawable.bkvctrw);
                vector_view.setVisibility(vector_view.VISIBLE);
            }
        });

        sticker_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_img.setImageResource(R.drawable.font);
                txt_view.setVisibility(txt_view.INVISIBLE);
                background_img.setImageResource(R.drawable.backgnd);
                background_view.setVisibility(background_view.INVISIBLE);
                style_img.setImageResource(R.drawable.style);
                style_view.setVisibility(style_view.INVISIBLE);
                color_img.setImageResource(R.drawable.color);
                color_view.setVisibility(color_view.INVISIBLE);
                shadow_img.setImageResource(R.drawable.shadow);
                shadow_view.setVisibility(shadow_view.INVISIBLE);
                vector_img.setImageResource(R.drawable.bkvctr);
                vector_view.setVisibility(vector_view.INVISIBLE);
                background_post_recycler.setVisibility(View.INVISIBLE);

                sticker_img.setImageResource(R.drawable.stickerw);
                sticker_view.setVisibility(sticker_view.VISIBLE);
            }
        });
        back_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Create_page.this,Select_Media_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        save_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Create_page.this, "Saved Successfully...!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void binding() {
        text_edt_img = (ImageView) findViewById(R.id.text_edt_img);
        preview_img = findViewById(R.id.preview_img);
        background_img = (ImageView) findViewById(R.id.background_img);
        style_img = (ImageView) findViewById(R.id.style_img);
        color_img = (ImageView) findViewById(R.id.color_img);
        shadow_img = (ImageView) findViewById(R.id.shadow_img);
        vector_img = (ImageView) findViewById(R.id.vector_img);
        sticker_img = (ImageView) findViewById(R.id.sticker_img);
        back_camera = (ImageView) findViewById(R.id.back_camera);

        txt_view = (View) findViewById(R.id.txt_view);
        background_view = (View) findViewById(R.id.background_view);
        style_view = (View) findViewById(R.id.style_view);
        color_view = (View) findViewById(R.id.color_view);
        shadow_view = (View) findViewById(R.id.shadow_view);
        vector_view = (View) findViewById(R.id.vector_view);
        sticker_view = (View) findViewById(R.id.sticker_view);

        txt_edt = (TextView) findViewById(R.id.txt_edt);

        save_camera = (TextView) findViewById(R.id.save_camera);

        background_recycler = (RecyclerView) findViewById(R.id.background_recycler);

        background_post_recycler = (CardView) findViewById(R.id.background_post_recycler);
    }


    private void textdialog(){
        Dialog dialog = new Dialog(Create_page.this);
        dialog.setContentView(R.layout.dailog_design);

        EditText txt_dailog = dialog.findViewById(R.id.txt_dailog);
        Button ok_btn = dialog.findViewById(R.id.ok_btn);

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = txt_dailog.getText().toString();
                txt_edt.setText(txt);
                dialog.dismiss();
            }

        });
        dialog.show();

    }




}