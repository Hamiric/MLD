package com.example.mylittledoctor.MainUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.mylittledoctor.Calendar.CalendarActivity;
import com.example.mylittledoctor.Encyclopedia.EncyclopediaActivity;
import com.example.mylittledoctor.HospitalMap.HospitalMapActivity;
import com.example.mylittledoctor.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button tab_btn1;
    ImageButton tab_btn2;
    Button icon_btn1,icon_btn2,icon_btn3;
    ImageView img_cicle1,img_cicle2,img_cicle3,img_cicle4;
    DrawerLayout drawerLayout;
    NavigationView nv;
    FirebaseAuth mAuth;
    FirebaseFirestore db;
    FirebaseUser user;
    ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_init();
        page_view();
        }

    void view_init(){
        tab_btn1=(Button)findViewById(R.id.tab_btn1);
        tab_btn2= (ImageButton) findViewById(R.id.tab_btn2);
        icon_btn1=(Button)findViewById(R.id.icon_btn1);
        icon_btn2=(Button)findViewById(R.id.icon_btn2);
        icon_btn3=(Button)findViewById(R.id.icon_btn3);
        vp=(ViewPager) findViewById(R.id.vp);
        img_cicle1=(ImageView)findViewById(R.id.circle1);
        img_cicle2=(ImageView)findViewById(R.id.circle2);
        img_cicle3=(ImageView)findViewById(R.id.circle3);
        img_cicle4=(ImageView)findViewById(R.id.circle4);

    }
    void page_view(){
        vp=(ViewPager) findViewById(R.id.vp);
        ArrayList<Drawable> drawer=new ArrayList<>();
        drawer.add(getResources().getDrawable(R.drawable.main_page_img1));
        drawer.add(getResources().getDrawable(R.drawable.main_page_img2));
        drawer.add(getResources().getDrawable(R.drawable.main_page_img3));
        drawer.add(getResources().getDrawable(R.drawable.main_page_img4));
        ImagePagerAdapter adapter=new ImagePagerAdapter(getApplicationContext(),drawer);
        vp.setAdapter(adapter);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }


            @Override
            public void onPageSelected(int position) {
                img_cicle1.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle1));
                img_cicle2.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle1));
                img_cicle3.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle1));
                img_cicle4.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle1));
                switch (position){
                    case 0:
                        img_cicle1.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle2));
                        break;
                    case 1:
                        img_cicle2.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle2));
                        break;
                    case 2:
                        img_cicle3.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle2));
                        break;
                    case 3:
                        img_cicle4.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle2));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void click(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.icon_btn1:
                intent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent);
                break;
            case R.id.icon_btn2:
                intent = new Intent(MainActivity.this, Healthy_Knowledge.class);
                startActivity(intent);
                break;
            case R.id.icon_btn3:
                intent = new Intent(MainActivity.this, HospitalMapActivity.class);
                startActivity(intent);
                break;
            case R.id.tab_btn1:
                intent = new Intent(MainActivity.this, Emergency.class);
                startActivity(intent);
                break;
        }
    }
}