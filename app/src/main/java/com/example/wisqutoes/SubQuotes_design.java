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
import android.widget.TextView;

public class SubQuotes_design extends AppCompatActivity {


    private RecyclerView recycler_post;
    private  ImageView back_subcategory;
    private TextView txt_view;
    String[] quotname = {"Love Quotes", "Miss You Quotes", "Motivational Quotes", "Success Quotes", "Happiness Quotes", "Travel Quotes", "Friendship Quotes",
            "Life Quotes", "Working Out Quotes", "Family Quotes", "Attitude Quotes", "Beauty Quotes", "Smile Quotes", "Thank You Quotes", "Random Quotes",
            "Keep Calm Quotes", "Good Morning Quotes"};
    int position;

    String[] love = {"https://images.pexels.com/photos/36717/amazing-animal-beautiful-beautifull.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/33041/antelope-canyon-lower-canyon-arizona.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/2343170/pexels-photo-2343170.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6616435/pexels-photo-6616435.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4197491/pexels-photo-4197491.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/2120614/pexels-photo-2120614.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5874617/pexels-photo-5874617.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5874631/pexels-photo-5874631.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6037944/pexels-photo-6037944.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "https://images.pexels.com/photos/5874709/pexels-photo-5874709.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7557532/pexels-photo-7557532.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4338015/pexels-photo-4338015.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6923733/pexels-photo-6923733.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1684617/pexels-photo-1684617.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1393437/pexels-photo-1393437.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5842235/pexels-photo-5842235.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1408221/pexels-photo-1408221.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",};

    String[] miss = {"https://images.pexels.com/photos/4436700/pexels-photo-4436700.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7006194/pexels-photo-7006194.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://www.pexels.com/photo/a-camera-beside-the-backlit-text-board-8049996/",
            "https://images.pexels.com/photos/5807320/pexels-photo-5807320.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4247553/pexels-photo-4247553.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5408915/pexels-photo-5408915.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4966533/pexels-photo-4966533.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6059339/pexels-photo-6059339.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1888022/pexels-photo-1888022.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/8709454/pexels-photo-8709454.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6425781/pexels-photo-6425781.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/985266/pexels-photo-985266.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1069798/pexels-photo-1069798.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1629236/pexels-photo-1629236.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7577804/pexels-photo-7577804.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1930381/pexels-photo-1930381.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/2778746/pexels-photo-2778746.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",};

    String[] motivation = {"https://images.pexels.com/photos/3756042/pexels-photo-3756042.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3837433/pexels-photo-3837433.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/8468285/pexels-photo-8468285.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/2740954/pexels-photo-2740954.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4114775/pexels-photo-4114775.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1510659/pexels-photo-1510659.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/9472034/pexels-photo-9472034.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6073599/pexels-photo-6073599.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/760721/pexels-photo-760721.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1485657/pexels-photo-1485657.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6935107/pexels-photo-6935107.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/733745/pexels-photo-733745.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/41004/alaska-wilderness-sky-aurora-borealis-41004.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "https://images.pexels.com/photos/4445221/pexels-photo-4445221.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/354939/pexels-photo-354939.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4058743/pexels-photo-4058743.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4646866/pexels-photo-4646866.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",};

    String[] success = {"https://images.pexels.com/photos/941693/pexels-photo-941693.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/6623684/pexels-photo-6623684.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4386346/pexels-photo-4386346.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4968548/pexels-photo-4968548.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7708806/pexels-photo-7708806.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/21696/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://www.bluekeypartners.com/wp-content/files/Personal-development.jpg",
            "https://blog.2winglobal.com/hs-fs/hubfs/Depositphotos_142114836_l-2015.jpg?width=4998&name=Depositphotos_142114836_l-2015.jpg",
            "https://miro.medium.com/max/1200/0*9E1oOZ6VU6RVPadH.jpeg",
            "https://www.rehberlikservisi.net/wp-content/uploads/success212e12.jpg",
            "https://www.insidesales.com/wp-content/uploads/2021/01/Young-city-professional-man-success-mindset-getty.jpg",
            "https://www.bakertilly.ie/wp-content/uploads/2017/11/shutterstock_262020983.jpg",
            "https://15e5b039cl9ui3o5j1hn9xgl-wpengine.netdna-ssl.com/wp-content/uploads/2020/09/Depositphotos_9839661_xl-2015-scaled.jpg",
            "https://assets.wam.ae/uploads/2020/08/1720664919872643144.jpg",
            "https://blog.urbancatalyst.com/hubfs/iStock-511601860.jpg",
            "https://images.squarespace-cdn.com/content/v1/56d300aee32140b8a0c08446/1574447535929-42YVJWE09INBCIPQC9SV/shutterstock_283233374.jpg",
            "https://chiefexecutive.net/wp-content/uploads/2018/12/AdobeStock_42343333-compressor-e1545257439607.jpeg",};

    String[] happiness = {"https://wallpapertag.com/wallpaper/full/5/0/b/891364-large-hd-cute-wallpapers-1920x1200.jpg",
            "https://kartinkin.net/uploads/posts/2021-01/1610805900_20-p-fon-schaste-43.jpg",
            "https://images.pexels.com/photos/3768126/pexels-photo-3768126.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3807755/pexels-photo-3807755.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6898854/pexels-photo-6898854.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/207983/pexels-photo-207983.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/208147/pexels-photo-208147.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7313449/pexels-photo-7313449.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4681461/pexels-photo-4681461.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/762559/pexels-photo-762559.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/10526561/pexels-photo-10526561.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",
            "https://images.pexels.com/photos/761827/pexels-photo-761827.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/208888/pexels-photo-208888.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",
            "https://images.pexels.com/photos/9764955/pexels-photo-9764955.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/10528315/pexels-photo-10528315.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",
            "https://images.pexels.com/photos/1193902/pexels-photo-1193902.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/800246/pexels-photo-800246.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",};

    String[] travel = {"https://images.pexels.com/photos/853199/pexels-photo-853199.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/219998/pexels-photo-219998.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/872831/pexels-photo-872831.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3608311/pexels-photo-3608311.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/33545/sunrise-phu-quoc-island-ocean.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/739407/pexels-photo-739407.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1446624/pexels-photo-1446624.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6992/forest-trees-northwestisbest-exploress.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/247431/pexels-photo-247431.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1051073/pexels-photo-1051073.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1051077/pexels-photo-1051077.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1770775/pexels-photo-1770775.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3889855/pexels-photo-3889855.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1309737/pexels-photo-1309737.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "https://images.pexels.com/photos/1774389/pexels-photo-1774389.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "https://images.pexels.com/photos/2090645/pexels-photo-2090645.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "https://images.pexels.com/photos/2105935/pexels-photo-2105935.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",};

    String[] frdship = {"https://images.pexels.com/photos/2409681/pexels-photo-2409681.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/2609463/pexels-photo-2609463.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/9775015/pexels-photo-9775015.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6123677/pexels-photo-6123677.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5255164/pexels-photo-5255164.jpeg?auto=compress&cs=tinysrgb&w=400",
            "https://images.pexels.com/photos/1387037/pexels-photo-1387037.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "https://images.pexels.com/photos/5935240/pexels-photo-5935240.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5935215/pexels-photo-5935215.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7168996/pexels-photo-7168996.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5063326/pexels-photo-5063326.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5384621/pexels-photo-5384621.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1603845/pexels-photo-1603845.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6150579/pexels-photo-6150579.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3776815/pexels-photo-3776815.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6954094/pexels-photo-6954094.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3764551/pexels-photo-3764551.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6147077/pexels-photo-6147077.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",};

    String[] life = {"https://images.pexels.com/photos/4147343/pexels-photo-4147343.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5209213/pexels-photo-5209213.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/8793849/pexels-photo-8793849.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7291906/pexels-photo-7291906.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3626528/pexels-photo-3626528.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/10216441/pexels-photo-10216441.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/9550865/pexels-photo-9550865.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6197407/pexels-photo-6197407.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6727642/pexels-photo-6727642.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1    ",
            "https://images.pexels.com/photos/3073694/pexels-photo-3073694.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7633703/pexels-photo-7633703.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6707631/pexels-photo-6707631.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4532825/pexels-photo-4532825.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/303383/pexels-photo-303383.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/39811/pexels-photo-39811.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/2397262/pexels-photo-2397262.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/38134/pexels-photo-38134.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",};

    String[] workout = {"https://images.pexels.com/photos/941693/pexels-photo-941693.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/6623684/pexels-photo-6623684.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4386346/pexels-photo-4386346.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4968548/pexels-photo-4968548.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7708806/pexels-photo-7708806.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/21696/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://www.bluekeypartners.com/wp-content/files/Personal-development.jpg",
            "https://blog.2winglobal.com/hs-fs/hubfs/Depositphotos_142114836_l-2015.jpg?width=4998&name=Depositphotos_142114836_l-2015.jpg",
            "https://miro.medium.com/max/1200/0*9E1oOZ6VU6RVPadH.jpeg",
            "https://www.rehberlikservisi.net/wp-content/uploads/success212e12.jpg",
            "https://www.insidesales.com/wp-content/uploads/2021/01/Young-city-professional-man-success-mindset-getty.jpg",
            "https://www.bakertilly.ie/wp-content/uploads/2017/11/shutterstock_262020983.jpg",
            "https://15e5b039cl9ui3o5j1hn9xgl-wpengine.netdna-ssl.com/wp-content/uploads/2020/09/Depositphotos_9839661_xl-2015-scaled.jpg",
            "https://assets.wam.ae/uploads/2020/08/1720664919872643144.jpg",
            "https://blog.urbancatalyst.com/hubfs/iStock-511601860.jpg",
            "https://images.squarespace-cdn.com/content/v1/56d300aee32140b8a0c08446/1574447535929-42YVJWE09INBCIPQC9SV/shutterstock_283233374.jpg",
            "https://chiefexecutive.net/wp-content/uploads/2018/12/AdobeStock_42343333-compressor-e1545257439607.jpeg",};

    String[] family = {"https://images.pexels.com/photos/8829185/pexels-photo-8829185.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4149018/pexels-photo-4149018.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/4149003/pexels-photo-4149003.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/3985282/pexels-photo-3985282.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/3985257/pexels-photo-3985257.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/7879666/pexels-photo-7879666.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/7943926/pexels-photo-7943926.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/3893721/pexels-photo-3893721.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/8236417/pexels-photo-8236417.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/1940532/pexels-photo-1940532.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3912356/pexels-photo-3912356.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3791664/pexels-photo-3791664.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6274867/pexels-photo-6274867.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "hhttps://images.pexels.com/photos/8944880/pexels-photo-8944880.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3890722/pexels-photo-3890722.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5727775/pexels-photo-5727775.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/5778899/pexels-photo-5778899.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",};

    String[] attitude = {"https://images.pexels.com/photos/3819538/pexels-photo-3819538.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3812729/pexels-photo-3812729.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3251664/pexels-photo-3251664.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://www.teahub.io/photos/full/2-26435_boy-on-the-road-4k-hd-desktop.jpg",
            "https://mobimg.b-cdn.net/v3/fetch/db/dba53205bc8507f3cdba0b89736550bf.jpeg",
            "https://www.kolpaper.com/wp-content/uploads/2020/04/Wallpaper-Loneliness.jpg",
            "https://wallpapertag.com/wallpaper/full/9/f/9/616617-gorgerous-sad-backgrounds-1920x1080-ipad-retina.jpg",
            "https://motaen.com/upload/wallpapers/2018/07/04/11/04/57745/15306914035b3c7f4bc415b5.03055564.jpg",
            "https://www.gapintelligence.com/wp-content/uploads/AdobeStock_57150624ev.jpg",
            "https://cdn.pixabay.com/photo/2014/11/21/00/09/man-539993_1280.jpg",
            "https://www.lastingchangehypnosis.ca/wp-content/uploads/2019/05/feel.jpg",
            "https://storge.pic2.me/upload/217/527c28fd5822c.jpg",
            "https://meeco-institute.org/wp-content/uploads/2018/05/breakthrough.jpg",
            "https://miro.medium.com/max/8192/1*6_TnYHG4yHPQpBd17wlmKQ.jpeg",
            "https://www.pixel-creation.com/wp-content/uploads/cool-backgrounds-for-guys-68-images-1.jpg",
            "https://wallup.net/wp-content/uploads/2016/03/29/182938-Run-sports-Olympics-field-748x468.jpg",
            "https://camplemonadestand.com/wp-content/uploads/2021/01/getty_175280847_83814.jpg",};

    String[] beauty = {"https://img.wallpapersafari.com/desktop/1366/768/65/28/A4adCY.jpg",
            "https://img5.goodfon.com/wallpaper/nbig/0/13/rozovyi-fon-orkhideia-kompozitsiia.jpg",
            "https://st.depositphotos.com/2005667/1986/v/450/depositphotos_19866397-stock-illustration-ornate-retro-card.jpg",
            "https://content1.rozetka.com.ua/goods/images/original/11925343.jpg",
            "https://content1.rozetka.com.ua/goods/images/original/168036164.jpg",
            "http://pic5.photophoto.cn/20071123/0008020391999135_b.jpg",
            "https://img4.goodfon.com/original/2880x1800/7/5e/pink-orchid-flowers-orkhideia-1.jpg",
            "https://mold-decor.com.ua/wp-content/uploads/2019/10/4083_glitter-fioletovyy-01-1-pak.jpg",
            "https://img.pixers.pics/pho_wat(s3:700/FO/42/49/39/93/700_FO42493993_a7ca70fd2ac64638bda43c2e74483692.jpg,700,700,cms:2018/10/5bd1b6b8d04b8_220x50-watermark.png,over,480,650,jpg)/papiers-peints-mariage-d-39-elegance-fond.jpg.jpg",
            "https://salfetki.kiev.ua/wa-data/public/shop/products/90/04/20490/images/28778/28778.750x0.jpg",
            "https://plitburg.ru/upload/iblock/a9a/p5ryeksfq7nbo83r4tbxswm7t3qwyawn.jpg",
            "https://media.istockphoto.com/photos/makeup-brushes-on-black-background-picture-id1090043994?k=20&m=1090043994&s=170667a&w=0&h=uHJmoGwVRaNeEHAs-R5BjQ833tVZJ_sM9Uw5hvttG4Y=",
            "https://promtoshop.ru/wp-content/uploads/2021/08/700-nw-125231.jpg",
            "https://art-wall.ru/aw/bs4422.jpg",
            "https://fotooboimoi.ru/upload/iblock/660/6605cd1c0bee226b52c0cc0381ab110d.jpg",
            "https://viland.ee/image/catalog/products/PRINT/WM/JPG/2948-PRINT.jpg",
            "https://wallplays.in/wp-content/uploads/2019/05/BSN6006-min.jpg"};

    String[] smile = {"https://wallpapertag.com/wallpaper/full/5/0/b/891364-large-hd-cute-wallpapers-1920x1200.jpg",
            "https://kartinkin.net/uploads/posts/2021-01/1610805900_20-p-fon-schaste-43.jpg",
            "https://images.pexels.com/photos/3768126/pexels-photo-3768126.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3807755/pexels-photo-3807755.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6898854/pexels-photo-6898854.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/207983/pexels-photo-207983.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/208147/pexels-photo-208147.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/7313449/pexels-photo-7313449.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/4681461/pexels-photo-4681461.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/762559/pexels-photo-762559.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/10526561/pexels-photo-10526561.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",
            "https://images.pexels.com/photos/761827/pexels-photo-761827.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/208888/pexels-photo-208888.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",
            "https://images.pexels.com/photos/9764955/pexels-photo-9764955.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/10528315/pexels-photo-10528315.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",
            "https://images.pexels.com/photos/1193902/pexels-photo-1193902.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/800246/pexels-photo-800246.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load",};

    String[] thankyou = {"https://www.teahub.io/photos/full/91-912006_thank-you-wallpapers-top-beautiful-pics-4k-ultra.jpg",
            "https://tipsmake.com/data/images/powerpoint-thank-you-wallpapers-thanks-for-the-slide-ends-picture-36-7186QveUk.jpeg",
            "https://www.slidebackground.com/uploads/thank-you/hd-thank-you-picture-free-background.jpg",
            "https://www.pixel-creation.com/wp-content/uploads/316-images-for-thank-you-pictures-photos-pics-greeting-post-card.jpg",
            "https://www.wallpapertip.com/wmimgs/247-2475420_thank-you-innovative-thank-you-images-hd.jpg",
            "https://www.wallpaperup.com/uploads/wallpapers/2013/01/19/30228/f361bd35b2880c7f2d26e72e4077c2fd.jpg",
            "https://ernestrecruit.co.uk/wp-content/uploads/2017/11/Thank-you-476040492_1258x838.jpeg",
            "https://f.vividscreen.info/soft/8a7ea435ec093da0288c9439a435c442/Pieces-of-Paper-with-Phrase-Thank-You-1920x1080.jpg",
            "https://www.keepersministry.com/sites/keepers/uploads/images/wp-content/2014/10/Thank-You-Card.jpg",
            "https://myragolden.com/wp-content/uploads/2012/08/thank-you.jpg?w=300",
            "https://solvitnow.com/wp-content/uploads/2017/07/solvit-says-thanks.jpg",
            "https://pbs.twimg.com/media/DnTiOiaW0AAWXzk.jpg",
            "https://www.caeiowa.org/wp-content/uploads/2017/06/02I50373.jpg",
            "https://stpaulsherwood.org/wp-content/uploads/2020/01/thank-you.jpg",
            "https://survivalstronghold.com/wp-content/uploads/2016/12/photo_esl_b.jpg",
            "https://cdn.hipwallpaper.com/i/13/85/AlXzEr.jpg",
            "https://www.dominatethegmat.com/wp-content/uploads/2011/12/ThankYou.jpg",};

    String[] random = {"https://images.pexels.com/photos/853199/pexels-photo-853199.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/219998/pexels-photo-219998.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/872831/pexels-photo-872831.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3608311/pexels-photo-3608311.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/33545/sunrise-phu-quoc-island-ocean.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "https://images.pexels.com/photos/739407/pexels-photo-739407.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "https://images.pexels.com/photos/1446624/pexels-photo-1446624.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "https://images.pexels.com/photos/6992/forest-trees-northwestisbest-exploress.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "https://images.pexels.com/photos/247431/pexels-photo-247431.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "https://images.pexels.com/photos/1051073/pexels-photo-1051073.jpeg?auto=compress&cs=tinysrgb&w=600",
                "https://images.pexels.com/photos/1051077/pexels-photo-1051077.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1770775/pexels-photo-1770775.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3889855/pexels-photo-3889855.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1309737/pexels-photo-1309737.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "https://images.pexels.com/photos/1774389/pexels-photo-1774389.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "https://images.pexels.com/photos/2090645/pexels-photo-2090645.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "https://images.pexels.com/photos/2105935/pexels-photo-2105935.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",};

    String[] Keepcalm = {"https://images.pexels.com/photos/853199/pexels-photo-853199.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/219998/pexels-photo-219998.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/872831/pexels-photo-872831.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3608311/pexels-photo-3608311.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/33545/sunrise-phu-quoc-island-ocean.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/739407/pexels-photo-739407.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1446624/pexels-photo-1446624.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6992/forest-trees-northwestisbest-exploress.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/247431/pexels-photo-247431.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1051073/pexels-photo-1051073.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1051077/pexels-photo-1051077.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1770775/pexels-photo-1770775.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3889855/pexels-photo-3889855.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1309737/pexels-photo-1309737.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "https://images.pexels.com/photos/1774389/pexels-photo-1774389.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "https://images.pexels.com/photos/2090645/pexels-photo-2090645.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "https://images.pexels.com/photos/2105935/pexels-photo-2105935.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",};

    String[] goodmrg = {"https://images.pexels.com/photos/853199/pexels-photo-853199.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/219998/pexels-photo-219998.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/872831/pexels-photo-872831.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3608311/pexels-photo-3608311.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/33545/sunrise-phu-quoc-island-ocean.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/739407/pexels-photo-739407.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1446624/pexels-photo-1446624.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/6992/forest-trees-northwestisbest-exploress.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/247431/pexels-photo-247431.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1051073/pexels-photo-1051073.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1051077/pexels-photo-1051077.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1770775/pexels-photo-1770775.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/3889855/pexels-photo-3889855.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/1309737/pexels-photo-1309737.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "https://images.pexels.com/photos/1774389/pexels-photo-1774389.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "https://images.pexels.com/photos/2090645/pexels-photo-2090645.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            "https://images.pexels.com/photos/2105935/pexels-photo-2105935.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",};

    String[] love_quot = {"\"I need you like a heart needs a beat\"",
            "\"To the world you may be one person, but to one person you are the world\"",
            "\"I have found the one whom my soul loves\"",
            "\"You are, and always have been, my dream\"",
            "Love is composed of a single soul inhabiting two bodies\"",
            "\"Love is a force more formidable than any other\"",
            "\"Love doesn’t make the world go ’round. Love is what makes the ride worthwhile\"",
            "\"To love and be loved is to feel the sun from both sides\"",
            "\"Love is like the wind, you can’t see it but you can feel it\"",
            "\"In love there are two things: bodies and words\"",
            "\"To love is to recognize yourself in another\"",
            "\"Passion makes the world go 'round. Love just makes it a safer place\"",
            "\"\"Have enough courage to trust love one more time and always one more time\"",
            "\"Where we love is home – home that our feet may leave, but not our hearts\"",
            "\"Love is that condition in which the happiness of another person is essential to your own\"",
            "\"Love makes your soul crawl out from its hiding place\"",
            "\"Love is the whole thing. We are only pieces\""};

    String[] miss_quot = {"\"I wish you were here.\"",
            "\"I think about you all the time.\"",
            "\"I see you everywhere around me.\"",
            "\"When will I see you again?\"",
            "\"I'm counting the days by minutes.\"",
            "\"I can't stop thinking about you.\"",
            "\"I can't wait to be with you again.\"",
            "\"I can feel your breath on my neck.\"",
            "\"I wish we could be together right now.\"",
            "\"I miss our conversations. ...\"",
            "\"The last time I felt alive – I was looking into your eyes. ...\"",
            "\"I miss you deeply, unfathomably, senselessly, terribly.\"",
            "\"Every song I hear reminds me of how much I miss you and want you by my side.\"",
            "\"Let him know that he's on your mind.\"",
            "\"Share an inside joke.\"",
            "\"Reminisce about a good time that you had together.\"",
            "\"Ask him how his day is going.\""};

    String[] motivate_quot = {"“When you have a dream, you've got to grab it and never let go.” ...",
            "“Nothing is impossible. ...",
            "“There is nothing impossible to they who will try.” ...",
            "“The bad news is time flies. ...",
            "“Life has got all those twists and turns. ...",
            "“Keep your face always toward the sunshine, and shadows will fall behind you.”",
            "“Do the best you can. ...",
            "“Do what you can, with what you have, where you are.” – Theodore Roosevelt.",
            "“If you can dream it, you can do it.” – Walt Disney.",
            "'It's never too late to be what you might've been.” – George Eliot.",
            "“Trust yourself that you can do it and get it.” – Baz Luhrmann.",
            "“The best is yet to be.” – ...",
            "“Try to be a rainbow in someone's cloud.” – ...",
            "“Do good and good will come to you.” – ...",
            "“A positive mindset brings positive things.” – ...",
            "“Positivity always wins… ...",
            "“When things go wrong, don't go with them.” – ..."};

    String[] success_quot = {"\"Success is not final; failure is not fatal: It is the courage to continue that counts.\" — ...",
            "\"It is better to fail in originality than to succeed in imitation.\" — ...",
            "\"The road to success and the road to failure are almost exactly the same.\" —\n",
            "\"Success is not final; failure is not fatal: It is the courage to continue that counts.\"",
            " \"It is better to fail in originality than to succeed in imitation.\"",
            "\"Be Strategic. ...\"",
            "\"Stay Organized and Better Manage Your Time. ...\"",
            "\"Believe in yourself. Your limitation—it's only your imagination.\"",
            "\"Don't wait. ...\"",
            "\"Step outside your comfort zone. ...\"",
            "\"Be a dreamer and a doer. ...\"",
            "\"Take action. ...\"",
            "\"Don't give up. ...\"",
            "\"Set big goals.\n\"",
            "“When you have a dream, you’ve got to grab it and never let go.”",
            "“Nothing is impossible. The word itself says ‘I’m possible!'”",
            "“There is nothing impossible to they who will try.”"};

    String[] happiness_quot = {"“Happiness is a direction, not a place.” – ...",
            "“Happiness depends upon ourselves.” – ...",
            "“Happiness is a form of courage.” – ...",
            "“Happiness is not a goal; it is a by-product.” – ...",
            "“Happiness is only real when shared.” – ...",
            "“No medicine cures what happiness cannot.” –",
            "\"Happiness is not the absence of problems, it’s the ability to deal with them.\"",
            "\"Happiness is not being pained in body or troubled in mind.\"",
            "\"The secret of happiness is to find a congenial monotony.\"",
            "\"There is only one happiness in this life, to love and be loved.\"",
            "\"Happiness is not an ideal of reason, but of imagination.\"",
            "\"To be without some of the things you want is an indispensable part of happiness.\"",
            "\"A great obstacle to happiness is to expect too much happiness.\"",
            "\"The secret of happiness is freedom, the secret of freedom is courage.\"",
            "\"It is not how much we have, but how much we enjoy, that makes happiness.\"",
            "\"The only way to find true happiness is to risk being completely cut open.\"",
            "\"Nobody really cares if you’re miserable, so you might as well be happy.\""};

    String[] travel_quot = {"“Travel is the only thing you buy that makes you richer” ",
            "“The journey is my home” ",
            "“To travel is to live” ",
            "“It feels good to be lost in the right direction”",
            "\"Life is a journey, not a destination”",
            "\"You miss 100% of the shots you don't take. - ...\"",
            "\"Whether you think you can or you think you can't, you're right. - ...\"",
            "\"I have learned over the years that when one's mind is made up, this diminishes fear. - ...\"",
            "\"I alone cannot change the world, but I can cast a stone across the water to create many ripples. -\"",
            "“Live as if you were to die tomorrow. ...\"",
            "“That which does not kill us makes us stronger.” ...",
            "“We must not allow other people's limited perceptions to define us.”",
            "\"The journey of a thousand miles begins with one step. ...\"",
            "\"The journey is never ending. ... \"",
            "\"Success is a journey, not a destination. ...\"",
            "\"Sometimes it's the journey that teaches you a lot about your destination. ...\"",
            "\"Enjoy the journey and try to get better every day. ...\""};

    String[] friendship_quot = {"“A friend may be waiting behind a stranger’s face.”",
            "“Life is an awful, ugly place to not have a best friend.”",
            "“The best gift anyone can give, I believe, is the gift of sharing themselves.”",
            "\"Try to be a rainbow in someone's cloud.\"",
            "\"A sweet friendship refreshes the soul.\"",
            "“There’s not a word yet for old friends who’ve just met.”",
            "“True friends are always together in spirit.”",
            "“Awards become corroded. Friends gather no dust.” ",
            "“Anything is possible when you have the right people there to support you.”",
            "“A friend is one who overlooks your broken fence and admires the flowers in your garden.”",
            "“There is nothing I would not do for those who are really my friends.”",
            "\"True friendship comes when the silence between two people is comfortable.\"",
            "\"Friendship is the only cement that will ever hold the world together.\"",
            "\"A single rose can be my garden… a single friend, my world.\"",
            "“Friends are relatives you make for yourself.”",
            "“Friendship is the golden thread that ties the heart of all the world.”",
            "“There’s nothing like a really loyal, dependable, good friend. Nothing.”"};

    String[] life_quot = {"\"Life is a long lesson in humility. - ...\"",
            "\"Love the life you live. ...\"",
            "\"Life is either a daring adventure or nothing at all. -\"",
            "\"In three words I can sum up everything I've learned about life: it goes on. - ...\n\"",
            " “The purpose of our lives is to be happy.” ",
            "“Get busy living or get busy dying.”",
            "“You only live once, but if you do it right, once is enough.”",
            "“If you want to live a happy life, tie it to a goal, not to people or things.”–",
            "“Never let the fear of striking out keep you from playing the game.”–",
            "“Not how long, but how well you have lived is the main thing.” —",
            "“If life were predictable it would cease to be life, and be without flavor.” ",
            "“In order to write about life first you must live it.”– ",
            "“Life is not a problem to be solved, but a reality to be experienced.”–",
            "“The unexamined life is not worth living.” ",
            " “Turn your wounds into wisdom.” ",
            " “I like criticism. It makes you strong.” ",
            " “Live for each second without hesitation.” —"};

    String[] workout_quot = {"'The last three or four reps is what makes the muscle grow. ...\"",
            " ¨The only person you are destined to become is the person you decide to be.¨",
            "“Once you learn to quit, it becomes a habit.¨ ",
            "¨A year from now you may wish you had started today.¨",
            "¨Our growing softness, our increasing lack of physical fitness, is a menace to our security.¨",
            "“Success usually comes to those who are too busy to be looking for it.” ",
            "¨Exercise is labor without weariness.¨",
            "¨The first time I see a jogger smiling, I’ll consider it.¨",
            "“All progress takes place outside the comfort zone.”",
            "¨Look in the mirror. That’s your competition.¨ ",
            "¨Tough times don’t last. Tough people do.¨",
            " ¨A feeble body weakens the mind.¨ ",
            "¨Reading is to the mind what exercise is to the body.¨",
            "¨Success is what comes after your stop making excuses.¨ ",
            "¨Get comfortable with being uncomfortable!¨ ",
            " ¨Confidence comes from discipline and training.¨ ",
            " “No pain, no gain.” "};

    String[] family_quot = {"“It didn’t matter how big our house was; it mattered that there was love in it.” ",
            "“Family means nobody gets left behind or forgotten.”",
            " “We may have our differences, but nothing’s more important than family.”",
            "“A happy family is but an earlier heaven.” ",
            "“Happiness is having a large, loving, caring, close-knit family in another city.” ",
            "\"The most important thing in the world is family and love.”",
            "“Family is not an important thing. It’s everything.”",
            " “Family faces are magic mirrors. Looking at people who belong to us, we see the past, present, and future.” ",
            "“You are the bows from which your children as living arrows are sent forth.¨",
            "¨A man should never neglect his family for business.” ",
            "“Being part of a family means smiling for photos.” ",
            "Family is family.” ",
            "“In time of test, family is best.” ",
            "“Ohana means family and family means nobody gets left behind or forgotten.” ",
            "“Life is beautiful. It’s about giving. It’s about family.”",
            "“Then I discovered that being related is no guarantee of love!”",
            "“Family is the most important thing in the world.”"};

    String[] attitude_quot = {"\"Attitude is a little thing that makes a big difference. ...\"",
            "\"We cannot change our past. ...\"",
            "\"People may hear your words, but they feel your attitude. ...\"",
            "\"Ability is what you're capable of doing. ...\"",
            "“A positive attitude is a person’s passport to a better tomorrow.”",
            "“The only disability in life is a bad attitude.”",
            "“To be an overachiever you have to be an over-believer.”",
            "“Perpetual optimism is a force multiplier.” ",
            "“The way I see it, if you want the rainbow, you gotta put up with the rain.” ",
            "“Accept hardship as a necessary discipline.” ",
            "“If you can change your mind, you can change your life.” ",
            "“You can often change your circumstances by changing your attitude.”",
            "“Everyone has his burden. What counts is how you carry it.” ",
            "“Weakness of attitude becomes weakness of character.” ",
            "“Sometimes it takes a wrong turn to get you to the right place.”",
            "“Attitude is everything, so pick a good one.”",
            "“It is good people who make good places.”"};

    String[] beauty_quot = {"\"Everything has beauty, but not everyone sees it. ...\"",
            "\"Beauty is power; a smile is its sword. ...\"",
            "\"Let us live for the beauty of our own reality. ...\"",
            "\"Real beauty is to be true to oneself.\n\"",
            "“Beauty is not in the face; beauty is a light in the heart.”",
            "“Beauty begins the moment you decide to be yourself.” ",
            "“Beauty is not caused. It is.” ",
            "“Beauty is an attitude.” ",
            "“Beauty is power; a smile is its sword.”",
            "“There is no cosmetic for beauty like happiness.” ",
            "“There is a kind of beauty in imperfection.”",
            "“Integrity reveals beauty.” ",
            "“Beauty is in the heart of the beholder.”",
            " “The absence of flaw in beauty is itself a flaw.” ",
            "“Beauty has a lot to do with character.”",
            "“Outer beauty turns the head, but inner beauty turns the heart.” ",
            " “Beauty is not something you buy; instead, beauty is what lies within.” "};

    String[] smile_quot = {"“ Because of your smile, you make life more beautiful.”",
            "“ Peace begins with a smile.”",
            "“ Life is short. ...\"",
            "“ There is fear when frowning. ...\"",
            "“Peace begins with a smile.”",
            "“Life is short. Smile while you still have teeth.” ",
            " “Nothing shakes the smiling heart.” ",
            "“Nothing you wear is more important than your smile.”",
            "“Just for today, smile a little more.” ",
            "¨Smile at strangers and you just might change a life.¨",
            " “People seldom notice old clothes if you wear a big smile.”",
            "“Don’t cry because it’s over, smile because it happened.”",
            "¨Smile is the beauty of the soul.¨",
            "A smile is the universal welcome.”",
            "“A smiling face is a beautiful face. A smiling heart is a happy heart.”",
            "“A smile is an inexpensive way to change your looks.” ",
            "¨Science teaches to think but love teaches to smile.¨"};

    String[] thank_quot = {"“Thank you for being the reason I smile.”",
            "“Thank you for being you.”",
            "“Here’s to those who inspire you and don’t even know it.”",
            "“Thank you for brightening my world.”",
            "“Let us be kinder to one another.” ",
            "“You’ve always believed in me. Thank you!” ",
            "“Thank you for being an important part of my story.” ",
            "“Never let the things you want make you forget the things you have.” ",
            "“Gratitude is the open door to abundance.” ",
            "“Gratitude is the sign of noble souls.” ",
            "“I appreciate you…especially your heart.”",
            "“The smallest act of kindness is worth more than the grandest intention.”",
            "“You put the you in thank you!”",
            "“For it is in giving that we receive.”",
            "“Thank you God for giving me the strength to keep going.”",
            "“Thank you God for blessing me much more than I deserve.” ",
            "“Thank you for making so many ordinary moments, extraordinary.”"};

    String[] random_quot = {"\"I always wanted to be somebody, but now I realize I should have been more specific.\"",
            "\"If you let your head get too big, it'll break your neck.\"",
            "\"I am an early bird and a night owl… so I am wise and I have worms\"",
            " \"Age is of no importance unless you're a cheese.\"",
            "\"Whatever you are, be a good one.\"",
            "\"In the middle of every difficulty lies opportunity.\"",
            " \"Because when I look at you, I can feel it. And I look at you and I'm home.\"",
            "\"Who, being loved, is poor?\"",
            " \"There is some good in this world, and it's worth fighting for.\"",
            "\"The greatest gift of life is friendship.\"",
            "\"The only way to have a friend is to be one.\"",
            "\"True friends are always together in spirit.\"",
            "\"Try to be a rainbow in someone's cloud.\"",
            "\"Let all that you do be done in love.\"",
            "\"Our faith can move mountains.\"",
            " \"Hatred stirs up strife, But love covers all sins.\"",
            "\"I have found the one whom my soul loves.\""};

    String[] calm_quot = {"\"A WILD PERSON WITH CALM MIND CAN MAKE ANYTHING. ...\"",
            "\"The nearer a man comes to a calm mind the closer he is to strenght. ...\"",
            "\"I never lose either win or learn. ...\"",
            "\"LIVE LIFE KING SIZE. ...\"",
            "\"It's all about finding the calm in the chaos. ...\"",
            "\"Make peace with mind, it's your best ally. ...\"",
            "\"GRATIFY THY MIND.\"",
            "\"Focus on the Positives. ...\"",
            "\"Go for a Walk. ... \"",
            "\"Meditate. ...\"",
            "\"Surround yourself with positive people.  ",
            "\"Let your soul stand cool and composed before a million universes. ...\"",
            "\"I'm a mirror. ...\"",
            "\"Live a life of purpose. ...\"",
            "\"Value yourself for who you are. ...\"",
            "\"Keep your head up.\"",
            "\"Be brave. ...\""};

    String[] morning_quot = {"“An early-morning walk is a blessing for the whole day.”",
            "“ Write it on your heart that every day is the best day in the year.”",
            "“ I get up every morning and it's going to be a great day. ...",
            "“ Today's goals: Coffee and kindness. ...",
            "\"In the end, it's not the years in your life that count. ..\"",
            "\"Good morning, gorgeous. ...\"",
            "\"I hope your morning is as bright and gorgeous as your smile.\"",
            "\"Let this morning bring you only pleasant feelings. ...\"",
            "\"People say that morning can't be good.\"",
            "\" Cuddling with you would be perfect right now.\"",
            "\" Hurry up and wake up cuz I miss you.\"",
            "\"Thank you for making every morning such a great one.\"",
            "\"Let your most beautiful dream will become a reality. Good morning, beautiful.\"",
            "\"What Sort Of Things Make You Laugh Out Louchd?\"",
            "\"What’s the most spontaneous thing you’ve ever done?\"",
            "\" I was dreaming of you all night long.\"",
            "\"I feel like you are the reward for everything I did right in my life.\""};

    String[] temp;
    String[] temp_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_quotes_design);
        binding();


        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));

        position = getIntent().getIntExtra("ps", 0);
        txt_view.setText(quotname[position]);


        if (position == 0) {
            temp = love;
            temp_name = love_quot;
        } else if (position == 1) {
            temp = miss;
            temp_name = miss_quot;
        } else if (position == 2) {
            temp = motivation;
            temp_name = motivate_quot;
        } else if (position == 3) {
            temp = success;
            temp_name = success_quot;
        } else if (position == 4) {
            temp = happiness;
            temp_name = happiness_quot;
        } else if (position == 5) {
            temp = travel;
            temp_name = travel_quot;
        } else if (position == 6) {
            temp = frdship;
            temp_name = friendship_quot;
        } else if (position == 7) {
            temp = life;
            temp_name = life_quot;
        } else if (position == 8) {
            temp = workout;
            temp_name = workout_quot;
        } else if (position == 9) {
            temp = family;
            temp_name = family_quot;
        } else if (position == 10) {
            temp = attitude;
            temp_name = attitude_quot;
        } else if (position == 11) {
            temp = beauty;
            temp_name = beauty_quot;
        } else if (position == 12) {
            temp = smile;
            temp_name = smile_quot;
        } else if (position == 13) {
            temp = thankyou;
            temp_name = thank_quot;
        } else if (position == 14) {
            temp = random;
            temp_name = random_quot;
        } else if (position == 15) {
            temp = Keepcalm;
            temp_name = calm_quot;
        } else if (position == 16) {
            temp = goodmrg;
            temp_name = morning_quot;
        }

        SubAdaptor subAdaptor = new SubAdaptor(SubQuotes_design.this, temp, temp_name);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SubQuotes_design.this);
        recycler_post.setLayoutManager(layoutManager);
        recycler_post.setAdapter(subAdaptor);


        back_subcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubQuotes_design.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void binding() {
        recycler_post = (RecyclerView) findViewById(R.id.recycler_post);
        txt_view = (TextView) findViewById(R.id.txt_view);
        back_subcategory = (ImageView) findViewById(R.id.back_subcategory);
    }
}