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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Background_page_screen extends AppCompatActivity {

    String[] frem = {"https://miro.medium.com/max/2000/1*--lG41sA959jnwHKcJ01Tw.jpeg",
            "https://img.wallpapersafari.com/desktop/1536/864/48/71/2R6kSo.jpg",
            "https://wallpapers-hd-wide.com/wp-content/uploads/2020/05/hd-motivational-start-doing_1200.jpg",
            "https://assets.entrepreneur.com/content/3x2/2000/20150921045005-shutterstock-157706513.jpeg",
            "https://i.ytimg.com/vi/hMb583X1Wx0/maxresdefault.jpg",
            "https://www.travelmeetshappy.com/wp-content/uploads/2017/09/Travellers-Movie-Wallpapers.jpg",
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


    public static ImageView frem_bk;
    ImageView background_img_create, bk_frem_img, text_edt_bk_img, style_bk_img, color_bk_img,back_background_create, shadow_bk_img, vector_bk_img, sticker_bk_img;
    View bk_frem_view, txt_bk_view, style_bk_view, color_bk_view, shadow_bk_view, vector_bk_view, sticker_bk_view;
    CardView cardview_bk_frem;
    TextView txt_bk_frem_edt;
    TextView save_txt_bk;
    RecyclerView bk_create_recycler;

    String[] bk_create;
    int ps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_page_screen);
        binding();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));


        bk_create = getIntent().getStringArrayExtra("image");
        ps = getIntent().getIntExtra("ps", 0);
        Glide.with(Background_page_screen.this).load(bk_create[ps]).into(background_img_create);

        BkFrameAdaptor bkFrameAdaptor = new BkFrameAdaptor(Background_page_screen.this, frem);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Background_page_screen.this, RecyclerView.HORIZONTAL, false);
        bk_create_recycler.setLayoutManager(layoutManager);
        bk_create_recycler.setAdapter(bkFrameAdaptor);


        bk_frem_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_bk_img.setImageResource(R.drawable.font);
                txt_bk_view.setVisibility(View.INVISIBLE);
                style_bk_img.setImageResource(R.drawable.style);
                style_bk_view.setVisibility(View.INVISIBLE);
                color_bk_img.setImageResource(R.drawable.color);
                color_bk_view.setVisibility(View.INVISIBLE);
                shadow_bk_img.setImageResource(R.drawable.shadow);
                shadow_bk_view.setVisibility(View.INVISIBLE);
                vector_bk_img.setImageResource(R.drawable.bkvctr);
                vector_bk_view.setVisibility(View.INVISIBLE);
                sticker_bk_img.setImageResource(R.drawable.sticker);
                sticker_bk_view.setVisibility(View.INVISIBLE);

                bk_frem_img.setImageResource(R.drawable.background);
                bk_frem_view.setVisibility(View.VISIBLE);

                cardview_bk_frem.setVisibility(View.VISIBLE);
            }
        });

        text_edt_bk_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_bk_img.setImageResource(R.drawable.fontw);
                txt_bk_view.setVisibility(View.VISIBLE);

                textdialog();

                cardview_bk_frem.setVisibility(View.INVISIBLE);

                color_bk_img.setImageResource(R.drawable.color);
                color_bk_view.setVisibility(View.INVISIBLE);
                shadow_bk_img.setImageResource(R.drawable.shadow);
                shadow_bk_view.setVisibility(View.INVISIBLE);
                vector_bk_img.setImageResource(R.drawable.bkvctr);
                vector_bk_view.setVisibility(View.INVISIBLE);
                sticker_bk_img.setImageResource(R.drawable.sticker);
                sticker_bk_view.setVisibility(View.INVISIBLE);
                bk_frem_img.setImageResource(R.drawable.backgnd);
                bk_frem_view.setVisibility(View.INVISIBLE);
                style_bk_img.setImageResource(R.drawable.style);
                style_bk_view.setVisibility(View.INVISIBLE);
            }
        });

        style_bk_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_bk_img.setImageResource(R.drawable.font);
                txt_bk_view.setVisibility(View.INVISIBLE);
                bk_frem_img.setImageResource(R.drawable.backgnd);
                bk_frem_view.setVisibility(View.INVISIBLE);
                color_bk_img.setImageResource(R.drawable.color);
                color_bk_view.setVisibility(View.INVISIBLE);
                shadow_bk_img.setImageResource(R.drawable.shadow);
                shadow_bk_view.setVisibility(View.INVISIBLE);
                vector_bk_img.setImageResource(R.drawable.bkvctr);
                vector_bk_view.setVisibility(View.INVISIBLE);
                sticker_bk_img.setImageResource(R.drawable.sticker);
                sticker_bk_view.setVisibility(View.INVISIBLE);
                cardview_bk_frem.setVisibility(View.INVISIBLE);

                style_bk_img.setImageResource(R.drawable.stylew);
                style_bk_view.setVisibility(View.VISIBLE);
            }
        });

        color_bk_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_bk_img.setImageResource(R.drawable.font);
                txt_bk_view.setVisibility(View.INVISIBLE);
                bk_frem_img.setImageResource(R.drawable.backgnd);
                bk_frem_view.setVisibility(View.INVISIBLE);
                style_bk_img.setImageResource(R.drawable.style);
                style_bk_view.setVisibility(View.INVISIBLE);
                shadow_bk_img.setImageResource(R.drawable.shadow);
                shadow_bk_view.setVisibility(View.INVISIBLE);
                vector_bk_img.setImageResource(R.drawable.bkvctr);
                vector_bk_view.setVisibility(View.INVISIBLE);
                sticker_bk_img.setImageResource(R.drawable.sticker);
                sticker_bk_view.setVisibility(View.INVISIBLE);
                cardview_bk_frem.setVisibility(View.INVISIBLE);


                color_bk_img.setImageResource(R.drawable.colorw);
                color_bk_view.setVisibility(View.VISIBLE);

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

        shadow_bk_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_bk_img.setImageResource(R.drawable.font);
                txt_bk_view.setVisibility(View.INVISIBLE);
                bk_frem_img.setImageResource(R.drawable.backgnd);
                bk_frem_view.setVisibility(View.INVISIBLE);
                style_bk_img.setImageResource(R.drawable.style);
                style_bk_view.setVisibility(View.INVISIBLE);
                color_bk_img.setImageResource(R.drawable.color);
                color_bk_view.setVisibility(View.INVISIBLE);
                vector_bk_img.setImageResource(R.drawable.bkvctr);
                vector_bk_view.setVisibility(View.INVISIBLE);
                sticker_bk_img.setImageResource(R.drawable.sticker);
                sticker_bk_view.setVisibility(View.INVISIBLE);
                cardview_bk_frem.setVisibility(View.INVISIBLE);

                shadow_bk_img.setImageResource(R.drawable.shadoww);
                shadow_bk_view.setVisibility(View.VISIBLE);
            }
        });

        vector_bk_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_bk_img.setImageResource(R.drawable.font);
                txt_bk_view.setVisibility(View.INVISIBLE);
                bk_frem_img.setImageResource(R.drawable.backgnd);
                bk_frem_view.setVisibility(View.INVISIBLE);
                style_bk_img.setImageResource(R.drawable.style);
                style_bk_view.setVisibility(View.INVISIBLE);
                color_bk_img.setImageResource(R.drawable.color);
                color_bk_view.setVisibility(View.INVISIBLE);
                shadow_bk_img.setImageResource(R.drawable.shadow);
                shadow_bk_view.setVisibility(View.INVISIBLE);
                sticker_bk_img.setImageResource(R.drawable.sticker);
                sticker_bk_view.setVisibility(View.INVISIBLE);
                cardview_bk_frem.setVisibility(View.INVISIBLE);



                vector_bk_img.setImageResource(R.drawable.bkvctrw);
                vector_bk_view.setVisibility(View.VISIBLE);
            }
        });

        sticker_bk_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_edt_bk_img.setImageResource(R.drawable.font);
                txt_bk_view.setVisibility(View.INVISIBLE);
                bk_frem_img.setImageResource(R.drawable.backgnd);
                bk_frem_view.setVisibility(View.INVISIBLE);
                style_bk_img.setImageResource(R.drawable.style);
                style_bk_view.setVisibility(View.INVISIBLE);
                color_bk_img.setImageResource(R.drawable.color);
                color_bk_view.setVisibility(View.INVISIBLE);
                shadow_bk_img.setImageResource(R.drawable.shadow);
                shadow_bk_view.setVisibility(View.INVISIBLE);
                vector_bk_img.setImageResource(R.drawable.bkvctr);
                vector_bk_view.setVisibility(View.INVISIBLE);
                cardview_bk_frem.setVisibility(View.INVISIBLE);

                sticker_bk_img.setImageResource(R.drawable.stickerw);
                sticker_bk_view.setVisibility(View.VISIBLE);
            }
        });


        back_background_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Background_page_screen.this,Select_Media_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        save_txt_bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Background_page_screen.this, "Saved Successfully...!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void textdialog(){
        Dialog dialog = new Dialog(Background_page_screen.this);
        dialog.setContentView(R.layout.dailog_design);

        EditText txt_dailog = dialog.findViewById(R.id.txt_dailog);
        Button ok_btn = dialog.findViewById(R.id.ok_btn);

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = txt_dailog.getText().toString();
                txt_bk_frem_edt.setText(txt);
                dialog.dismiss();
            }

        });
        dialog.show();

    }


    private void binding() {
        background_img_create = (ImageView) findViewById(R.id.background_img_create);
        frem_bk = (ImageView) findViewById(R.id.frem_bk);
        back_background_create = (ImageView) findViewById(R.id.back_background_create);

        bk_frem_img = (ImageView) findViewById(R.id.bk_frem_img);
        text_edt_bk_img = (ImageView) findViewById(R.id.text_edt_bk_img);
        style_bk_img = (ImageView) findViewById(R.id.style_bk_img);
        color_bk_img = (ImageView) findViewById(R.id.color_bk_img);
        shadow_bk_img = (ImageView) findViewById(R.id.shadow_bk_img);
        vector_bk_img = (ImageView) findViewById(R.id.vector_bk_img);
        sticker_bk_img = (ImageView) findViewById(R.id.sticker_bk_img);

        bk_frem_view = (View) findViewById(R.id.bk_frem_view);
        txt_bk_view = (View) findViewById(R.id.txt_bk_view);
        style_bk_view = (View) findViewById(R.id.style_bk_view);
        color_bk_view = (View) findViewById(R.id.color_bk_view);
        shadow_bk_view = (View) findViewById(R.id.shadow_bk_view);
        vector_bk_view = (View) findViewById(R.id.vector_bk_view);
        sticker_bk_view = (View) findViewById(R.id.sticker_bk_view);

        txt_bk_frem_edt = (TextView) findViewById(R.id.txt_bk_frem_edt);

        cardview_bk_frem = (CardView) findViewById(R.id.cardview_bk_frem);

        save_txt_bk = (TextView) findViewById(R.id.save_txt_bk);

        bk_create_recycler = (RecyclerView) findViewById(R.id.bk_create_recycler);
    }
}