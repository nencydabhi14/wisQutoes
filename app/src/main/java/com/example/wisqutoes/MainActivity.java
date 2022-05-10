package com.example.wisqutoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final int READ_STORAGE_PERMISSION_REQUEST_CODE = 41;
    private LinearLayout create_img, quotes_img, category_img, picture_img, setting_img,search_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding();

        try {
            checkIfAlreadyhavePermission();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.orange));

        create_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Select_Media_Activity.class);
                startActivity(intent);

            }
        });
        quotes_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Quoyes_page.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Tap to Change Background...!!!", Toast.LENGTH_SHORT).show();
            }
        });
        category_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Loader_custom.class);
                startActivity(intent);
            }
        });

        picture_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Picture_Screen.class);
                startActivity(intent);
            }
        });

        setting_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Setting_Screen.class);
                startActivity(intent);
            }
        });
        search_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Search_Screen_Page.class);
                startActivity(intent);
            }
        });

    }

    private void checkIfAlreadyhavePermission() throws Exception {
        try {
            ActivityCompat.requestPermissions((MainActivity.this), new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                    READ_STORAGE_PERMISSION_REQUEST_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void binding() {
        create_img = (LinearLayout) findViewById(R.id.create_img);
        quotes_img = (LinearLayout) findViewById(R.id.quotes_img);
        category_img = (LinearLayout) findViewById(R.id.category_img);
        picture_img = (LinearLayout) findViewById(R.id.picture_img);
        setting_img = (LinearLayout) findViewById(R.id.setting_img);
        search_img = (LinearLayout) findViewById(R.id.search_img);
    }
}