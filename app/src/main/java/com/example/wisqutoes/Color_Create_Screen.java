package com.example.wisqutoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

public class Color_Create_Screen extends AppCompatActivity {

   private ImageView color_img_create, text_color_img, style_color_img, color_color_img, shadow_color_img, back_color,vector_color_img, sticker_color_img;
   private View txt_color_view, style_color_view, color_color_view, shadow_color_view, vector_color_view, sticker_color_view;
   private TextView txt_color_edt;
   private TextView save_color_txt;

   String[] color_create;
   int pscolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_create_screen);

        binding();
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));

        color_create = getIntent().getStringArrayExtra("color_image");
        pscolor = getIntent().getIntExtra("ps_color", 0);
        Glide.with(Color_Create_Screen.this).load(color_create[pscolor]).into(color_img_create);


        text_color_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_color_img.setImageResource(R.drawable.fontw);
                txt_color_view.setVisibility(View.VISIBLE);


                textdialog();

                color_color_img.setImageResource(R.drawable.color);
                color_color_view.setVisibility(View.INVISIBLE);
                shadow_color_img.setImageResource(R.drawable.shadow);
                shadow_color_view.setVisibility(View.INVISIBLE);
                vector_color_img.setImageResource(R.drawable.bkvctr);
                vector_color_view.setVisibility(View.INVISIBLE);
                sticker_color_img.setImageResource(R.drawable.sticker);
                sticker_color_view.setVisibility(View.INVISIBLE);
                style_color_img.setImageResource(R.drawable.style);
                style_color_view.setVisibility(View.INVISIBLE);
            }
        });

        style_color_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_color_img.setImageResource(R.drawable.font);
                txt_color_view.setVisibility(View.INVISIBLE);

                color_color_img.setImageResource(R.drawable.color);
                color_color_view.setVisibility(View.INVISIBLE);
                shadow_color_img.setImageResource(R.drawable.shadow);
                shadow_color_view.setVisibility(View.INVISIBLE);
                vector_color_img.setImageResource(R.drawable.bkvctr);
                vector_color_view.setVisibility(View.INVISIBLE);
                sticker_color_img.setImageResource(R.drawable.sticker);
                sticker_color_view.setVisibility(View.INVISIBLE);

                style_color_img.setImageResource(R.drawable.stylew);
                style_color_view.setVisibility(View.VISIBLE);
            }
        });

        color_color_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_color_img.setImageResource(R.drawable.font);
                txt_color_view.setVisibility(View.INVISIBLE);
                style_color_img.setImageResource(R.drawable.style);
                style_color_view.setVisibility(View.INVISIBLE);
                shadow_color_img.setImageResource(R.drawable.shadow);
                shadow_color_view.setVisibility(View.INVISIBLE);
                vector_color_img.setImageResource(R.drawable.bkvctr);
                vector_color_view.setVisibility(View.INVISIBLE);
                sticker_color_img.setImageResource(R.drawable.sticker);
                sticker_color_view.setVisibility(View.INVISIBLE);



                color_color_img.setImageResource(R.drawable.colorw);
                color_color_view.setVisibility(View.VISIBLE);

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

        shadow_color_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_color_img.setImageResource(R.drawable.font);
                txt_color_view.setVisibility(View.INVISIBLE);
                style_color_img.setImageResource(R.drawable.style);
                style_color_view.setVisibility(View.INVISIBLE);
                color_color_img.setImageResource(R.drawable.color);
                color_color_view.setVisibility(View.INVISIBLE);
                vector_color_img.setImageResource(R.drawable.bkvctr);
                vector_color_view.setVisibility(View.INVISIBLE);
                sticker_color_img.setImageResource(R.drawable.sticker);
                sticker_color_view.setVisibility(View.INVISIBLE);


                shadow_color_img.setImageResource(R.drawable.shadoww);
                shadow_color_view.setVisibility(View.VISIBLE);
            }
        });

        vector_color_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_color_img.setImageResource(R.drawable.font);
                txt_color_view.setVisibility(View.INVISIBLE);

                style_color_img.setImageResource(R.drawable.style);
                style_color_view.setVisibility(View.INVISIBLE);
                color_color_img.setImageResource(R.drawable.color);
                color_color_view.setVisibility(View.INVISIBLE);
                shadow_color_img.setImageResource(R.drawable.shadow);
                shadow_color_view.setVisibility(View.INVISIBLE);
                sticker_color_img.setImageResource(R.drawable.sticker);
                sticker_color_view.setVisibility(View.INVISIBLE);



                vector_color_img.setImageResource(R.drawable.bkvctrw);
                vector_color_view.setVisibility(View.VISIBLE);
            }
        });

        sticker_color_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_color_img.setImageResource(R.drawable.font);
                txt_color_view.setVisibility(View.INVISIBLE);
                style_color_img.setImageResource(R.drawable.style);
                style_color_view.setVisibility(View.INVISIBLE);
                color_color_img.setImageResource(R.drawable.color);
                color_color_view.setVisibility(View.INVISIBLE);
                shadow_color_img.setImageResource(R.drawable.shadow);
                shadow_color_view.setVisibility(View.INVISIBLE);
                vector_color_img.setImageResource(R.drawable.bkvctr);
                vector_color_view.setVisibility(View.INVISIBLE);

                sticker_color_img.setImageResource(R.drawable.stickerw);
                sticker_color_view.setVisibility(View.VISIBLE);
            }
        });

        save_color_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Color_Create_Screen.this, "Saved Successfully...!!!", Toast.LENGTH_SHORT).show();
            }
        });

        back_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Color_Create_Screen.this,Select_Media_Activity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void textdialog(){
        Dialog dialog = new Dialog(Color_Create_Screen.this);
        dialog.setContentView(R.layout.dailog_design);

        EditText txt_dailog = dialog.findViewById(R.id.txt_dailog);
        Button ok_btn = dialog.findViewById(R.id.ok_btn);

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = txt_dailog.getText().toString();
                txt_color_edt.setText(txt);
                dialog.dismiss();
            }

        });
        dialog.show();

    }


    private void binding() {
        color_img_create = findViewById(R.id.color_img_create);

        text_color_img =(ImageView) findViewById(R.id.text_color_img);
        style_color_img =(ImageView) findViewById(R.id.style_color_img);
        color_color_img =(ImageView) findViewById(R.id.color_color_img);
        shadow_color_img =(ImageView) findViewById(R.id.shadow_color_img);
        vector_color_img =(ImageView) findViewById(R.id.vector_color_img);
        sticker_color_img =(ImageView) findViewById(R.id.sticker_color_img);

        back_color =(ImageView) findViewById(R.id.back_color);

        txt_color_view =(View) findViewById(R.id.txt_color_view);
        style_color_view =(View) findViewById(R.id.style_color_view);
        color_color_view =(View) findViewById(R.id.color_color_view);
        shadow_color_view =(View) findViewById(R.id.shadow_color_view);
        vector_color_view =(View) findViewById(R.id.vector_color_view);
        sticker_color_view =(View) findViewById(R.id.sticker_color_view);

        txt_color_edt = (TextView) findViewById(R.id.txt_color_edt);
        save_color_txt = (TextView) findViewById(R.id.save_color_txt);
    }
}