package com.example.wisqutoes;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.LauncherActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Select_Media_Activity extends AppCompatActivity {

    private LinearLayout camera_linimg, gallery_img_linear, background_img_linear, color_img_linear;
    private ImageView back_create;
    public static Bitmap bitmap_img;
    public static Uri uri;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_media);

        binding();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));


        camera_linimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 200);
            }
        });

        gallery_img_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 100);



            }

        });

        background_img_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Select_Media_Activity.this, Background_picture.class);
                startActivity(intent);
            }
        });

        color_img_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Select_Media_Activity.this, Color_Selection_Picture.class);
                startActivity(intent);
            }
        });

        back_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Select_Media_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }



    @SuppressLint("WrongViewCast")
    private void binding() {

        back_create = (ImageView) findViewById(R.id.back_create);

        camera_linimg = (LinearLayout) findViewById(R.id.camera_linimg);
        gallery_img_linear = (LinearLayout) findViewById(R.id.gallery_img_linear);
        background_img_linear = (LinearLayout) findViewById(R.id.background_img_linear);
        color_img_linear = (LinearLayout) findViewById(R.id.color_img_linear);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 200) {
            Intent intent = new Intent(Select_Media_Activity.this, Create_page.class);
            bitmap_img = (Bitmap) data.getExtras().get("data");
            startActivity(intent);
        } else if (requestCode == 100) {



            Intent intent = new Intent(Select_Media_Activity.this, gallary_page.class);
            uri = data.getData();
            startActivity(intent);
        }
    }
//    private boolean checkIfAlreadyhavePermission() {
//        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS);
//        if (result == PackageManager.PERMISSION_GRANTED) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//
//   public boolean checkPermissionForReadExtertalStorage() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            final int READ_STORAGE_PERMISSION_REQUEST_CODE = 41;
//            int result = Select_Media_Activity.checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE);
//            return result == PackageManager.PERMISSION_GRANTED;
//        }
//        return false;
//    }

}
