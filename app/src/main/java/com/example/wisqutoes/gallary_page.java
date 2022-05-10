package com.example.wisqutoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class gallary_page extends AppCompatActivity {

     public static ImageView gallery_frem_img;
     private ImageView gallary_img,frem_gallery_img,text_gallery_img,style_gallery_img,color_gallery_img,shadow_gallery_img,vector_gallery_img,sticker_gallery_img,back_gallery;
     private View frem_gallery_view,txt_gallery_view,style_gallery_view,color_gallery_view,shadow_gallery_view,vector_gallery_view,sticker_gallery_view;
     private TextView txt_gallery_edt;
     private CardView gallery_card;
     private RecyclerView gallery_recycler;
     private TextView save_gallery_txt;

    String[] frem_gallery = {"https://upload.wikimedia.org/wikipedia/commons/d/da/Eleven_Blind_Leaders_title_frame.png",
//            "https://i.ya-webdesign.com/images/round-picture-frame-png.png",
//            "https://www.clipartmax.com/png/full/71-717723_flower-shop-flowers-photo-frames-designs-flower-hd-photo-frame.png",
//            "476-4760812_flowers-frame-png-flower-frame-square-png-transparent-removebg-preview (3)",
//            "https://www.pngmart.com/files/15/Flower-Frame-PNG-Transparent-Image.png",
//            "https://pngfreepic.com/wp-content/uploads/2021/08/frame-996.png?v=1629458640",
            "https://www.insidehighered.com/sites/default/server_files/media/iStock-625736338.jpg",
            "https://assets.wallpapersin4k.org/uploads/2017/04/Tree-Silhouette-Wallpaper-5.jpg",
            "https://t3.ftcdn.net/jpg/04/29/35/62/360_F_429356296_CVQ5LkC6Pl55kUNLqLisVKgTw9vjyif1.jpg",
            "https://www.progressionsolicitors.com/wp-content/uploads/2021/12/Family-Mediation-2021.jpg",
            "https://cdn.suwalls.com/wallpapers/artistic/rainbow-thoughts-14870-1920x1200.jpg",
            "https://media.istockphoto.com/photos/makeup-brushes-on-black-background-picture-id1090043994?k=20&m=1090043994&s=170667a&w=0&h=uHJmoGwVRaNeEHAs-R5BjQ833tVZJ_sM9Uw5hvttG4Y=",
            "https://wallpaperset.com/w/full/f/9/9/224677.jpg",
            "https://stpaulsherwood.org/wp-content/uploads/2020/01/thank-you.jpg",
            "https://d1el5jddkxvjyd.cloudfront.net/viceroyhotelsandresorts.com-2109743334/cms/cache/v2/5c708de080ee7.jpg/1920x1080/fit/80/057fb72a9947f202aa494de7067929b5.jpg",
            "https://hushoffice.com/wp-content/uploads/2021/01/shutterstock_1302585175.jpg",
            "https://www.desktopbackground.org/download/1920x1080/2011/10/23/285260_good-morning-sunshine-and-greenery-wallpapers_1920x1200_h.jpg",};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary_page);

        binding();
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));

        gallary_img.setImageURI(Select_Media_Activity.uri);


        GallaryFrameAdaptor gallaryFrameAdaptor = new GallaryFrameAdaptor(gallary_page.this, frem_gallery);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(gallary_page.this, RecyclerView.HORIZONTAL, false);
        gallery_recycler.setLayoutManager(layoutManager);
        gallery_recycler.setAdapter(gallaryFrameAdaptor);

        frem_gallery_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_gallery_img.setImageResource(R.drawable.font);
                txt_gallery_view.setVisibility(View.INVISIBLE);
                style_gallery_img.setImageResource(R.drawable.style);
                style_gallery_view.setVisibility(View.INVISIBLE);
                color_gallery_img.setImageResource(R.drawable.color);
                color_gallery_view.setVisibility(View.INVISIBLE);
                shadow_gallery_img.setImageResource(R.drawable.shadow);
                shadow_gallery_view.setVisibility(View.INVISIBLE);
                vector_gallery_img.setImageResource(R.drawable.bkvctr);
                vector_gallery_view.setVisibility(View.INVISIBLE);
                sticker_gallery_img.setImageResource(R.drawable.sticker);
                style_gallery_view.setVisibility(View.INVISIBLE);


                frem_gallery_img.setImageResource(R.drawable.background);
                frem_gallery_view.setVisibility(View.VISIBLE);

                gallery_card.setVisibility(View.VISIBLE);
            }
        });

        text_gallery_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_gallery_img.setImageResource(R.drawable.fontw);
                txt_gallery_view.setVisibility(View.VISIBLE);

                textdialog();
                gallery_card.setVisibility(View.INVISIBLE);

                color_gallery_img.setImageResource(R.drawable.color);
                color_gallery_view.setVisibility(View.INVISIBLE);
                shadow_gallery_img.setImageResource(R.drawable.shadow);
                shadow_gallery_view.setVisibility(View.INVISIBLE);
                vector_gallery_img.setImageResource(R.drawable.bkvctr);
                vector_gallery_view.setVisibility(View.INVISIBLE);
                sticker_gallery_img.setImageResource(R.drawable.sticker);
                sticker_gallery_view.setVisibility(View.INVISIBLE);
                frem_gallery_img.setImageResource(R.drawable.backgnd);
                frem_gallery_view.setVisibility(View.INVISIBLE);
                style_gallery_img.setImageResource(R.drawable.style);
                style_gallery_view.setVisibility(View.INVISIBLE);
            }
        });

        style_gallery_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_gallery_img.setImageResource(R.drawable.font);
                txt_gallery_view.setVisibility(View.INVISIBLE);
                frem_gallery_img.setImageResource(R.drawable.backgnd);
                frem_gallery_view.setVisibility(View.INVISIBLE);
                color_gallery_img.setImageResource(R.drawable.color);
                color_gallery_view.setVisibility(View.INVISIBLE);
                shadow_gallery_img.setImageResource(R.drawable.shadow);
                shadow_gallery_view.setVisibility(View.INVISIBLE);
                vector_gallery_img.setImageResource(R.drawable.bkvctr);
                vector_gallery_view.setVisibility(View.INVISIBLE);
                sticker_gallery_img.setImageResource(R.drawable.sticker);
                sticker_gallery_view.setVisibility(View.INVISIBLE);
                gallery_card.setVisibility(View.INVISIBLE);

                style_gallery_img.setImageResource(R.drawable.stylew);
                style_gallery_view.setVisibility(View.VISIBLE);
            }
        });

        color_gallery_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_gallery_img.setImageResource(R.drawable.font);
                txt_gallery_view.setVisibility(View.INVISIBLE);
                frem_gallery_img.setImageResource(R.drawable.backgnd);
                frem_gallery_view.setVisibility(View.INVISIBLE);
                style_gallery_img.setImageResource(R.drawable.style);
                style_gallery_view.setVisibility(View.INVISIBLE);
                shadow_gallery_img.setImageResource(R.drawable.shadow);
                shadow_gallery_view.setVisibility(View.INVISIBLE);
                vector_gallery_img.setImageResource(R.drawable.bkvctr);
                vector_gallery_view.setVisibility(View.INVISIBLE);
                sticker_gallery_img.setImageResource(R.drawable.sticker);
                sticker_gallery_view.setVisibility(View.INVISIBLE);
                gallery_card.setVisibility(View.INVISIBLE);

                color_gallery_img.setImageResource(R.drawable.colorw);
                color_gallery_view.setVisibility(View.VISIBLE);

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

        shadow_gallery_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_gallery_img.setImageResource(R.drawable.font);
                txt_gallery_view.setVisibility(View.INVISIBLE);
                frem_gallery_img.setImageResource(R.drawable.backgnd);
                frem_gallery_view.setVisibility(View.INVISIBLE);
                style_gallery_img.setImageResource(R.drawable.style);
                style_gallery_view.setVisibility(View.INVISIBLE);
                color_gallery_img.setImageResource(R.drawable.color);
                color_gallery_view.setVisibility(View.INVISIBLE);
                vector_gallery_img.setImageResource(R.drawable.bkvctr);
                vector_gallery_view.setVisibility(View.INVISIBLE);
                sticker_gallery_img.setImageResource(R.drawable.sticker);
                sticker_gallery_view.setVisibility(View.INVISIBLE);
                gallery_card.setVisibility(View.INVISIBLE);

                shadow_gallery_img.setImageResource(R.drawable.shadoww);
                shadow_gallery_view.setVisibility(View.VISIBLE);
            }
        });

        vector_gallery_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_gallery_img.setImageResource(R.drawable.font);
                txt_gallery_view.setVisibility(View.INVISIBLE);
                frem_gallery_img.setImageResource(R.drawable.backgnd);
                frem_gallery_view.setVisibility(View.INVISIBLE);
                style_gallery_img.setImageResource(R.drawable.style);
                style_gallery_view.setVisibility(View.INVISIBLE);
                color_gallery_img.setImageResource(R.drawable.color);
                color_gallery_view.setVisibility(View.INVISIBLE);
                shadow_gallery_img.setImageResource(R.drawable.shadow);
                shadow_gallery_view.setVisibility(View.INVISIBLE);
                sticker_gallery_img.setImageResource(R.drawable.sticker);
                sticker_gallery_view.setVisibility(View.INVISIBLE);
                gallery_card.setVisibility(View.INVISIBLE);


                vector_gallery_img.setImageResource(R.drawable.bkvctrw);
                vector_gallery_view.setVisibility(View.VISIBLE);
            }
        });

        sticker_gallery_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_gallery_img.setImageResource(R.drawable.font);
                txt_gallery_view.setVisibility(View.INVISIBLE);
                frem_gallery_img.setImageResource(R.drawable.backgnd);
                frem_gallery_view.setVisibility(View.INVISIBLE);
                style_gallery_img.setImageResource(R.drawable.style);
                style_gallery_view.setVisibility(View.INVISIBLE);
                color_gallery_img.setImageResource(R.drawable.color);
                color_gallery_view.setVisibility(View.INVISIBLE);
                shadow_gallery_img.setImageResource(R.drawable.shadow);
                shadow_gallery_view.setVisibility(View.INVISIBLE);
                vector_gallery_img.setImageResource(R.drawable.bkvctr);
                vector_gallery_view.setVisibility(View.INVISIBLE);
                gallery_card.setVisibility(View.INVISIBLE);

                sticker_gallery_img.setImageResource(R.drawable.stickerw);
                sticker_gallery_view.setVisibility(View.VISIBLE);
            }
        });

        back_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(gallary_page.this,Select_Media_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        save_gallery_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(gallary_page.this, "Saved Successfully...!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void textdialog(){
        Dialog dialog = new Dialog(gallary_page.this);
        dialog.setContentView(R.layout.dailog_design);

        EditText txt_dailog = dialog.findViewById(R.id.txt_dailog);
        Button ok_btn = dialog.findViewById(R.id.ok_btn);

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = txt_dailog.getText().toString();
                txt_gallery_edt.setText(txt);
                dialog.dismiss();
            }

        });
        dialog.show();

    }



    private  void binding(){
        gallary_img = (ImageView) findViewById(R.id.gallary_img);
        gallery_frem_img = (ImageView) findViewById(R.id.gallery_frem_img);
        back_gallery = (ImageView) findViewById(R.id.back_gallery);

        frem_gallery_img = (ImageView) findViewById(R.id.frem_gallery_img);
        text_gallery_img = (ImageView) findViewById(R.id.text_gallery_img);
        style_gallery_img = (ImageView) findViewById(R.id.style_gallery_img);
        color_gallery_img = (ImageView) findViewById(R.id.color_gallery_img);
        shadow_gallery_img = (ImageView) findViewById(R.id.shadow_gallery_img);
        vector_gallery_img = (ImageView) findViewById(R.id.vector_gallery_img);
        sticker_gallery_img = (ImageView) findViewById(R.id.sticker_gallery_img);


        frem_gallery_view = (View) findViewById(R.id.frem_gallery_view);
        txt_gallery_view = (View) findViewById(R.id.txt_gallery_view);
        style_gallery_view = (View) findViewById(R.id.style_gallery_view);
        color_gallery_view = (View) findViewById(R.id.color_gallery_view);
        shadow_gallery_view = (View) findViewById(R.id.shadow_gallery_view);
        vector_gallery_view = (View) findViewById(R.id.vector_gallery_view);
        sticker_gallery_view = (View) findViewById(R.id.sticker_gallery_view);

        gallery_card = (CardView) findViewById(R.id.gallery_card);
        gallery_recycler = (RecyclerView) findViewById(R.id.gallery_recycler);

        save_gallery_txt = (TextView) findViewById(R.id.save_gallery_txt);

        txt_gallery_edt = (TextView) findViewById(R.id.txt_gallery_edt);
    }
}