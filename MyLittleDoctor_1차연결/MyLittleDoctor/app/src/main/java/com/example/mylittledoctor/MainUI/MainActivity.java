package com.example.mylittledoctor.MainUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mylittledoctor.Calendar.CalendarActivity;
import com.example.mylittledoctor.Encyclopedia.EncyclopediaActivity;
import com.example.mylittledoctor.HospitalMap.HospitalMapActivity;
import com.example.mylittledoctor.R;

public class MainActivity extends AppCompatActivity {
    Button tab_btn1,tab_btn2;
    Button icon_btn1,icon_btn2,icon_btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void view_init(){
        icon_btn1=(Button)findViewById(R.id.icon_btn1);
        icon_btn2=(Button)findViewById(R.id.icon_btn2);
        icon_btn3=(Button)findViewById(R.id.icon_btn3);
        tab_btn1=(Button)findViewById(R.id.tab_btn1);

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