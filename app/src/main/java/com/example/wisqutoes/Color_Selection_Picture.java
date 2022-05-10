package com.example.wisqutoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Color_Selection_Picture extends AppCompatActivity {


    String[] color_create = {"https://images.unsplash.com/flagged/photo-1593005510329-8a4035a7238f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8c29saWQlMjBjb2xvcnxlbnwwfHwwfHw%3D&w=1000&q=80",
            "https://png.pngtree.com/thumb_back/fw800/background/20200821/pngtree-plain-red-solid-color-background-image_396556.jpg",
            "https://media.istockphoto.com/photos/abstract-orange-background-picture-id679762938?k=20&m=679762938&s=612x612&w=0&h=y79QcJh8Y_8-WT1dqJa6OOZKcakVSpylQHbG3CC5GOc=",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQC-JIEionsHuM44UdKgbiKqmwp1uu5fNsYSQ&usqp=CAU",
            "https://www.solidbackgrounds.com/images/2880x1800/2880x1800-teal-deer-solid-color-background.jpg",
            "https://w0.peakpx.com/wallpaper/520/803/HD-wallpaper-blue-solid-colors-background-black-total-plain-color-navy.jpg",
            "https://www.solidbackgrounds.com/images/1920x1080/1920x1080-yellow-solid-color-background.jpg",
            "https://www.greenyogaindia.com/wp-content/uploads/2016/11/2880x1800-dark-spring-green-solid-color-background.jpg",
            "https://i.stack.imgur.com/UVhEI.jpg",
            "https://thebrooklyninstitute.com/wp-content/uploads/2020/03/2732x2732-red-pantone-solid-color-background-scaled.jpg    ",
            "https://wallpapercave.com/wp/wp2749139.jpg",
            "https://thumbs.dreamstime.com/b/bright-solid-color-background-empty-orange-surface-fine-texture-preparation-designer-layout-bright-solid-color-185024617.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/Dark-brown-solid-color-background.jpg/800px-Dark-brown-solid-color-background.jpg?20200516143845",
            "https://wallpaperaccess.com/full/1732229.jpg",
            "https://i.pinimg.com/originals/84/48/37/844837f390c486525c0331d079e9176d.jpg",
            "https://st4.depositphotos.com/20563840/i/600/depositphotos_386699384-stock-photo-simple-solid-color-background.jpg",
            "https://www.wallpapers4u.org/wp-content/uploads/solid_colors_stains_light_18571_1920x1080.jpg",
            "https://f.vividscreen.info/soft/bb865ab2a4d5afba60d0d60c5c739ecf/Blue-Color-2880x1920.jpg",
            "https://wallpaperstrend.com/wp-content/uploads/Abstract/abstract01/blurred-colors-wide-3840x2160.jpg"};

    RecyclerView color_recycler;
    private ImageView color_back_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_selection_picture);

        binding();


        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));

        ColorpictureAdaptor colorpictureAdaptor = new ColorpictureAdaptor(Color_Selection_Picture.this, color_create);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        color_recycler.setLayoutManager(layoutManager);
        color_recycler.setAdapter(colorpictureAdaptor);

        color_back_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Color_Selection_Picture.this,Select_Media_Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private  void binding(){
        color_recycler = (RecyclerView) findViewById(R.id.color_recycler);
        color_back_post = (ImageView) findViewById(R.id.color_back_post);
    }
}