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

public class Category_screen extends AppCompatActivity {

    private RecyclerView category_recycler;
    private ImageView back_category;
    String[] quotname = {"Love Quotes", "Miss You Quotes", "Motivational Quotes", "Success Quotes", "Happiness Quotes", "Travel Quotes", "Friendship Quotes",
            "Life Quotes", "Working Out Quotes", "Family Quotes", "Attitude Quotes", "Beauty Quotes", "Smile Quotes", "Thank You Quotes", "Random Quotes",
            "Keep Calm Quotes", "Good Morning Quotes"};

    String[] imgquotes   = {"https://miro.medium.com/max/2000/1*--lG41sA959jnwHKcJ01Tw.jpeg",
            "https://img.wallpapersafari.com/desktop/1536/864/48/71/2R6kSo.jpg",
            "https://wallpapers-hd-wide.com/wp-content/uploads/2020/05/hd-motivational-start-doing_1200.jpg",
            "https://assets.entrepreneur.com/content/3x2/2000/20150921045005-shutterstock-157706513.jpeg",
            "https://i.ytimg.com/vi/hMb583X1Wx0/maxresdefault.jpg",
            "https://www.travelmeetshappy.com/wp-content/uploads/2017/09/Travellers-Movie-Wallpapers.jpg",
            "https://www.insidehighered.com/sites/default/server_files/media/iStock-625736338.jpg",
            "https://assets.wallpapersin4k.org/uploads/2017/04/Tree-Silhouette-Wallpaper-5.jpg",
            "https://t3.ftcdn.net/jpg/04/29/35/62/360_F_429356296_CVQ5LkC6Pl55kUNLqLisVKgTw9vjyif1.jpg",
            "https://www.progressionsolicitors.com/wp-content/uploads/2021/12/Family-Mediation-2021.jpg",
            "https://cdn.hipwallpaper.com/i/5/55/93YDki.jpg",
            "https://media.istockphoto.com/photos/makeup-brushes-on-black-background-picture-id1090043994?k=20&m=1090043994&s=170667a&w=0&h=uHJmoGwVRaNeEHAs-R5BjQ833tVZJ_sM9Uw5hvttG4Y=",
            "https://wallpaperset.com/w/full/f/9/9/224677.jpg",
            "https://stpaulsherwood.org/wp-content/uploads/2020/01/thank-you.jpg",
            "https://d1el5jddkxvjyd.cloudfront.net/viceroyhotelsandresorts.com-2109743334/cms/cache/v2/5c708de080ee7.jpg/1920x1080/fit/80/057fb72a9947f202aa494de7067929b5.jpg",
            "https://hushoffice.com/wp-content/uploads/2021/01/shutterstock_1302585175.jpg",
            "https://www.desktopbackground.org/download/1920x1080/2011/10/23/285260_good-morning-sunshine-and-greenery-wallpapers_1920x1200_h.jpg",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_screen);

        binding();


        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));


        CatagoryAdaptor catagoryAdaptor = new CatagoryAdaptor(Category_screen.this, quotname, imgquotes);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        category_recycler.setLayoutManager(layoutManager);
        category_recycler.setAdapter(catagoryAdaptor);

        back_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category_screen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private  void binding(){
        category_recycler = (RecyclerView) findViewById(R.id.category_recycler);
        back_category = (ImageView) findViewById(R.id.back_category);
    }

}