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
import android.widget.Toast;

public class Picture_Screen extends AppCompatActivity {

    private RecyclerView picture_recycler;
    private ImageView back_picture_page;
    String[] picture = {"https://i.pinimg.com/564x/f6/b4/27/f6b4275cbe6bced3dcf7ea2688902fbf.jpg",
    "https://avatars.mds.yandex.net/i?id=38bd5302ae101612a5aad77a99239677-5887755-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=6aac266dbc7fdc6f3b351edda1bad728-5656601-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=60b2c12dbbb087b01497cb150117301e-4298511-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=370e98826c620d480b7f5419f11b5b08-4886237-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=2a00000179f56a9f0cf205dd651ea953dbda-4230821-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=b7c4ed35db095a171214da2169107fbe-5325528-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=2006a5b95b3531f867ad16196925726b-5236321-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=8db4214811d6b3043d4780a2f0f02859-5859282-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=b48cec090f72c3c98cee55af90ebd4e8-5437458-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=1b42d2a7898030082de92faca55001ec-5716968-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=d853c6ca15de7b6d0c4e67e05b33aa51-5734795-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=d654ce022d357f8e324c122ddb6108a4-5486213-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=755abbfe2bfd02a2eafc86524467831c-5879341-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=3711155b5007513ba66e5beea634c8e5-5147142-images-thumbs&n=13",
    "https://happylives360.com/wp-content/uploads/2019/08/97.jpg",
    "https://avatars.mds.yandex.net/i?id=34b3cef671f0615cd8a19f0350b228c1-5878159-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=3d59b528f5b5ae0e645b15ffa1451561-4570384-images-thumbs&n=13",
    "https://avatars.mds.yandex.net/i?id=474748801bff0325ebe5af4af352b918-4592636-images-thumbs&n=13",
    "https://www.quotemaster.org/images/7c/7cc12b353f1d797ad3ce9302076df31a.jpg",
    "https://www.segerios.com/wp-content/uploads/2017/04/Small-Simplicity-Quotes-and-Sayings.jpg",
    "https://www.armia.com.au/wp-content/uploads/2018/05/fachrul-com-inspirational-quotes.jpg",
    "https://pbs.twimg.com/media/DPyFo7nWkAAXMNw.jpg",
    "https://www.wallpaperflare.com/static/126/117/95/quote-motivational-digital-art-typography-wallpaper.jpg",
    "https://www.yourcreativejunkie.com/wp-content/uploads/2014/12/Time-Evolve-or-Perish-Tip1.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_screen);
        binding();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));

        PictureAdaptor pictureAdaptor = new PictureAdaptor(Picture_Screen.this,picture);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        picture_recycler.setLayoutManager(layoutManager);
        picture_recycler.setAdapter(pictureAdaptor);



        back_picture_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Picture_Screen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private void  binding(){
        picture_recycler = (RecyclerView) findViewById(R.id.picture_recycler);
        back_picture_page = (ImageView) findViewById(R.id.back_picture_page);
    }

}