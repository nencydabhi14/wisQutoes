package com.example.wisqutoes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.telephony.CellInfoWcdma;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class Search_Screen_Page extends AppCompatActivity {

    String[] name = {"Love Quotes", "Miss You Quotes", "Motivational Quotes", "Success Quotes", "Happiness Quotes", "Travel Quotes", "Friendship Quotes",
            "Life Quotes", "Working Out Quotes", "Family Quotes", "Attitude Quotes", "Beauty Quotes", "Smile Quotes", "Thank You Quotes", "Random Quotes",
            "Keep Calm Quotes", "Good Morning Quotes"};

    String[] love = {"https://images.pexels.com/photos/2120614/pexels-photo-2120614.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5874617/pexels-photo-5874617.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5874631/pexels-photo-5874631.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6037944/pexels-photo-6037944.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "https://images.pexels.com/photos/5874709/pexels-photo-5874709.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",};

    String[] miss = {"https://images.pexels.com/photos/985266/pexels-photo-985266.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1069798/pexels-photo-1069798.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1629236/pexels-photo-1629236.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7577804/pexels-photo-7577804.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1930381/pexels-photo-1930381.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"};

    String[] motivation = {"https://images.pexels.com/photos/4114775/pexels-photo-4114775.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1510659/pexels-photo-1510659.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/9472034/pexels-photo-9472034.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6073599/pexels-photo-6073599.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/760721/pexels-photo-760721.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"};

    String[] success = {"https://images.pexels.com/photos/4968548/pexels-photo-4968548.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7708806/pexels-photo-7708806.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/21696/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://www.bluekeypartners.com/wp-content/files/Personal-development.jpg",
            "https://blog.2winglobal.com/hs-fs/hubfs/Depositphotos_142114836_l-2015.jpg?width=4998&name=Depositphotos_142114836_l-2015.jpg",
    };

    String[] happiness = {"https://images.pexels.com/photos/6898854/pexels-photo-6898854.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/207983/pexels-photo-207983.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/208147/pexels-photo-208147.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7313449/pexels-photo-7313449.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4681461/pexels-photo-4681461.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",};

    String[] travel = { "https://images.pexels.com/photos/3608311/pexels-photo-3608311.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/33545/sunrise-phu-quoc-island-ocean.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/739407/pexels-photo-739407.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1446624/pexels-photo-1446624.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6992/forest-trees-northwestisbest-exploress.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",};

    String[] friendship = {"https://images.pexels.com/photos/2609463/pexels-photo-2609463.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/9775015/pexels-photo-9775015.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6123677/pexels-photo-6123677.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5255164/pexels-photo-5255164.jpeg?auto=compress&cs=tinysrgb&w=400",
            "https://images.pexels.com/photos/1387037/pexels-photo-1387037.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
    };

    String[] life = {"https://images.pexels.com/photos/4147343/pexels-photo-4147343.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5209213/pexels-photo-5209213.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/8793849/pexels-photo-8793849.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7291906/pexels-photo-7291906.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3626528/pexels-photo-3626528.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
    };

    String[] workout = {"https://www.bakertilly.ie/wp-content/uploads/2017/11/shutterstock_262020983.jpg",
            "https://15e5b039cl9ui3o5j1hn9xgl-wpengine.netdna-ssl.com/wp-content/uploads/2020/09/Depositphotos_9839661_xl-2015-scaled.jpg",
            "https://assets.wam.ae/uploads/2020/08/1720664919872643144.jpg",
            "https://blog.urbancatalyst.com/hubfs/iStock-511601860.jpg",
            "https://images.squarespace-cdn.com/content/v1/56d300aee32140b8a0c08446/1574447535929-42YVJWE09INBCIPQC9SV/shutterstock_283233374.jpg",
    };

    String[] family = {"https://images.pexels.com/photos/4149018/pexels-photo-4149018.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/4149003/pexels-photo-4149003.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/3985282/pexels-photo-3985282.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/3985257/pexels-photo-3985257.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/7879666/pexels-photo-7879666.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
    };

    String[] attitude = {  "https://images.pexels.com/photos/3812729/pexels-photo-3812729.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3251664/pexels-photo-3251664.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://www.teahub.io/photos/full/2-26435_boy-on-the-road-4k-hd-desktop.jpg",
            "https://mobimg.b-cdn.net/v3/fetch/db/dba53205bc8507f3cdba0b89736550bf.jpeg",
            "https://www.kolpaper.com/wp-content/uploads/2020/04/Wallpaper-Loneliness.jpg",};

    String[] beauty = { "https://img5.goodfon.com/wallpaper/nbig/0/13/rozovyi-fon-orkhideia-kompozitsiia.jpg",
            "https://st.depositphotos.com/2005667/1986/v/450/depositphotos_19866397-stock-illustration-ornate-retro-card.jpg",
            "https://content1.rozetka.com.ua/goods/images/original/11925343.jpg",
            "https://content1.rozetka.com.ua/goods/images/original/168036164.jpg",
            "http://pic5.photophoto.cn/20071123/0008020391999135_b.jpg",
    };

    String[] smile = { "https://kartinkin.net/uploads/posts/2021-01/1610805900_20-p-fon-schaste-43.jpg",
            "https://images.pexels.com/photos/3768126/pexels-photo-3768126.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3807755/pexels-photo-3807755.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6898854/pexels-photo-6898854.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/207983/pexels-photo-207983.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
    };

    String[] thank_you = { "https://tipsmake.com/data/images/powerpoint-thank-you-wallpapers-thanks-for-the-slide-ends-picture-36-7186QveUk.jpeg",
            "https://www.slidebackground.com/uploads/thank-you/hd-thank-you-picture-free-background.jpg",
            "https://www.pixel-creation.com/wp-content/uploads/316-images-for-thank-you-pictures-photos-pics-greeting-post-card.jpg",
            "https://www.wallpapertip.com/wmimgs/247-2475420_thank-you-innovative-thank-you-images-hd.jpg",
            "https://www.wallpaperup.com/uploads/wallpapers/2013/01/19/30228/f361bd35b2880c7f2d26e72e4077c2fd.jpg",
    };

    String[] random = {"https://images.pexels.com/photos/739407/pexels-photo-739407.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1446624/pexels-photo-1446624.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6992/forest-trees-northwestisbest-exploress.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/247431/pexels-photo-247431.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1051073/pexels-photo-1051073.jpeg?auto=compress&cs=tinysrgb&w=600",
    };

    String[] Keepcalm = {"https://images.pexels.com/photos/1770775/pexels-photo-1770775.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3889855/pexels-photo-3889855.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1309737/pexels-photo-1309737.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "https://images.pexels.com/photos/1774389/pexels-photo-1774389.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "https://images.pexels.com/photos/2090645/pexels-photo-2090645.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
    };

    String[] goodmorning = { "https://images.pexels.com/photos/3608311/pexels-photo-3608311.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/33545/sunrise-phu-quoc-island-ocean.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/739407/pexels-photo-739407.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1446624/pexels-photo-1446624.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6992/forest-trees-northwestisbest-exploress.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",};
    private AutoCompleteTextView search_auto;
    private ImageView quotes_search, quotes1_search, quotes2_search, quotes3_search, quotes4_search, search_img,back_search;
    private LinearLayout search_quotes_need, design_quotes_linear;
    private TextView txt_else;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen_page);

        binding();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));


        ArrayAdapter arrayAdapter = new ArrayAdapter(Search_Screen_Page.this, android.R.layout.simple_list_item_1, name);
        search_auto.setAdapter(arrayAdapter);

        search_auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Search_Screen_Page.this, "" + name[i], Toast.LENGTH_SHORT).show();

                if (name[0].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);
                    Glide.with(Search_Screen_Page.this)
                            .load(love[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(love[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(love[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(love[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(love[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[1].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(miss[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(miss[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(miss[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(miss[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(miss[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[2].equals(search_auto.getText().toString())) {
                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(motivation[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(motivation[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(motivation[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(motivation[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(motivation[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[3].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(success[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(success[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(success[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(success[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(success[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[4].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(happiness[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(happiness[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(happiness[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(happiness[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(happiness[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[5].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(travel[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(travel[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(travel[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(travel[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(travel[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[6].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(friendship[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(friendship[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(friendship[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(friendship[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(friendship[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[7].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(life[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(life[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(life[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(life[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(life[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[8].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(workout[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(workout[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(workout[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(workout[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(workout[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[9].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(family[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(family[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(family[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(family[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(family[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[10].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(attitude[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(attitude[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(attitude[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(attitude[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(attitude[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[11].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(beauty[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(beauty[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(beauty[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(beauty[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(beauty[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[12].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(smile[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(smile[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(smile[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(smile[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(smile[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[13].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(thank_you[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(thank_you[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(thank_you[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(thank_you[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(thank_you[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[14].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(random[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(random[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(random[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(random[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(random[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[15].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(Keepcalm[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(Keepcalm[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(Keepcalm[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(Keepcalm[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(Keepcalm[4])
                            .centerCrop()
                            .into(quotes4_search);
                }
                if (name[16].equals(search_auto.getText().toString())) {

                    design_quotes_linear.setVisibility(View.VISIBLE);

                    Glide.with(Search_Screen_Page.this)
                            .load(goodmorning[0])
                            .centerCrop()
                            .into(quotes_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(goodmorning[1])
                            .centerCrop()
                            .into(quotes1_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(goodmorning[2])
                            .centerCrop()
                            .into(quotes2_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(goodmorning[3])
                            .centerCrop()
                            .into(quotes3_search);

                    Glide.with(Search_Screen_Page.this)
                            .load(goodmorning[4])
                            .centerCrop()
                            .into(quotes4_search);
                }

                else {
                    search_quotes_need.setVisibility(View.VISIBLE);
                    txt_else.setText("No Quotes , We Didn't find any Quotes");
                }
                search_quotes_need.setVisibility(View.INVISIBLE);
            }
        });

        back_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search_Screen_Page.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void binding() {
        search_auto = (AutoCompleteTextView) findViewById(R.id.search_auto);
        quotes_search = (ImageView) findViewById(R.id.quotes_search);
        back_search = (ImageView) findViewById(R.id.back_search);
        quotes1_search = (ImageView) findViewById(R.id.quotes1_search);
        quotes2_search = (ImageView) findViewById(R.id.quotes2_search);
        quotes3_search = (ImageView) findViewById(R.id.quotes3_search);
        quotes4_search = (ImageView) findViewById(R.id.quotes4_search);
        search_img = (ImageView) findViewById(R.id.search_img);
        search_quotes_need = (LinearLayout) findViewById(R.id.search_quotes_need);
        design_quotes_linear = (LinearLayout) findViewById(R.id.design_quotes_linear);

        txt_else = (TextView) findViewById(R.id.txt_else);
    }
}