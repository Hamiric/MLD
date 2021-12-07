package com.example.mylittledoctor.MainUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylittledoctor.Calendar.CalendarActivity;
import com.example.mylittledoctor.Encyclopedia.EncyclopediaActivity;
import com.example.mylittledoctor.HospitalMap.HospitalMapActivity;
import com.example.mylittledoctor.LoginActivity;
import com.example.mylittledoctor.R;
import com.example.mylittledoctor.Search.SearchingActivity;
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
    FirebaseUser user;
    ViewPager vp;
    TextView nav_name;
    TextView nav_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_init();
        firebase_init();
        page_view();

        Drawer_and_Navigation_init();
        Nav_init();
        tab_click_event();
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
    void firebase_init(){
        try {
            mAuth = FirebaseAuth.getInstance();
            user = mAuth.getCurrentUser();
        }catch (Exception e){
            Intent intent=new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
    void Drawer_and_Navigation_init(){
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        nv=(NavigationView) findViewById(R.id.nav_view);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();

                int id=item.getItemId();
                Intent intent;
                if(id==R.id.menu1){
                    intent = new Intent(MainActivity.this, CalendarActivity.class);
                    startActivity(intent);
                }else if(id==R.id.menu2){
                    intent = new Intent(MainActivity.this, CalendarActivity.class);
                    startActivity(intent);
                }else if(id==R.id.menu3){
                    intent = new Intent(MainActivity.this, HospitalMapActivity.class);
                    startActivity(intent);
                }else if(id==R.id.menu4){
                    intent = new Intent(MainActivity.this, SearchingActivity.class);
                    startActivity(intent);
                }else if(id==R.id.menu5){
                    intent = new Intent(MainActivity.this, Emergency.class);
                    startActivity(intent);
                }else if(id==R.id.menu6){

                }else if(id==R.id.menu7){
                    SharedPreferences sp=getSharedPreferences("state_login", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putInt("state",1);
                    editor.commit();

                    mAuth.signOut();

                    intent=new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(getApplicationContext(),"로그아웃하였습니다.", Toast.LENGTH_SHORT).show();

                }else{

                }
                return true;
            }
        });
    }
    void Nav_init(){
        //  String uid=user.getUid();
        nav_name=(TextView)findViewById(R.id.nav_name1);
        nav_email=(TextView)findViewById(R.id.nav_email1);

        //getString(필드값)을 통해 해당 필드에 대 //nav_name.setText("이학준");응하는 value값을 가져온다.
        //
        // nav_email.setText(user.getEmail());
    }

    void tab_click_event(){
        tab_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });
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
                intent = new Intent(MainActivity.this, SearchingActivity.class);
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