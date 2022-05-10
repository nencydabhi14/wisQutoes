package com.example.wisqutoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Quoyes_page extends AppCompatActivity {


    private RecyclerView quotes_recycler;
    String[] img_quotes = {"https://phonoteka.org/uploads/posts/2022-01/1642455055_39-phonoteka-org-p-fon-na-rabochii-stol-minimalizm-originalni-40.jpg",
    "https://i.pinimg.com/originals/c3/69/03/c36903df333678d960a2f6b3be72ba5d.png",
    "https://images3.alphacoders.com/925/925897.jpg",
    "https://cdn.hipwallpaper.com/i/66/69/dmO9oS.png",
    "https://i.pinimg.com/originals/7d/56/e3/7d56e3cc2a946fb5a352af7a796fca97.png",
    "https://wallpapertops.com/walldb/original/0/1/e/408984.jpg",
    "https://catherineasquithgallery.com/uploads/posts/2021-02/1613414521_191-p-bezhevii-fon-dlya-rabochego-stola-minimali-251.jpg",
    "https://img1.goodfon.com/original/2560x1600/9/71/minimalizm-pticy-fon.jpg",
    "https://cutewallpaper.org/21/fun-backgrounds-for-computers/Computer-Backgrounds-65+-pictures-.jpg",
    "https://i.imgur.com/KdbGJnt.jpeg",
    "https://c.wallhere.com/photos/57/73/1920x1080_px_humor_minimalism_Pluto_Simple_Background_space_Star_Wars-786514.jpg!d",
    "https://i.pinimg.com/originals/98/53/6b/98536bc0828419d669b41ce4b21536a1.jpg",
    "https://i.pinimg.com/originals/5c/e5/41/5ce54140afee93c303084e1ba3eebe3f.jpg",
    "https://avatars.mds.yandex.net/i?id=1078aa1a089faecbc0e46ad8689f2115-5869855-images-thumbs&n=13",
    "https://wallup.net/wp-content/uploads/2019/09/8536-minimalistic-moleskine-pencils.jpg",
    "https://i.pinimg.com/originals/1a/2f/ce/1a2fce9d9ad2c08b01995324bff7a9b3.jpg",
    "https://i.pinimg.com/originals/59/95/7d/59957d6d91bcd7f9f2ba8f910fba3b97.jpg"};

    String[] quotes = {"“The best is yet to be.”",
            "“Try to be a rainbow in someone's cloud.”",
            "“Do good and good will come to you.” ",
            "“A positive mindset brings positive things.”",
            "“Positivity always wins… ",
            "“When things go wrong, don't go with them.”",
            "“Live life to the fullest and focus on the positive.” ",
            "“Keep looking up…",
            "“The way I see it, if you want the rainbow, you gotta put up with the rain.” ",
            "“Accept hardship as a necessary discipline.” ",
            "“If you can change your mind, you can change your life.” ",
            "“You can often change your circumstances by changing your attitude.”",
            "“Everyone has his burden. What counts is how you carry it.” ",
            " “People seldom notice old clothes if you wear a big smile.”",
            "“Don’t cry because it’s over, smile because it happened.”",
            "¨Smile is the beauty of the soul.¨",
            "A smile is the universal welcome.”",    "\"Believe in yourself. Your limitation—it's only your imagination.\"",
            "\"Don't wait. ...\"",
            "\"Step outside your comfort zone. ...\"",
            "\"Be a dreamer and a doer. ...\"",
            "\"Take action. ...\"",
            "\"Don't give up. ...\"",
            "\"Set big goals.\n\"",
            "“When you have a dream, yo“"};

    private ImageView back_quotes_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quoyes_page);
        binding();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));

        QuotesAdaptor quotesAdaptor = new QuotesAdaptor(Quoyes_page.this, img_quotes, quotes);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        quotes_recycler.setLayoutManager(layoutManager);
        quotes_recycler.setAdapter(quotesAdaptor);

        back_quotes_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quoyes_page.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void binding() {
        quotes_recycler = (RecyclerView) findViewById(R.id.quotes_recycler);
        back_quotes_page = (ImageView) findViewById(R.id.back_quotes_page);
    }
}