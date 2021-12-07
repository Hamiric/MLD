package com.example.mylittledoctor.MainUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylittledoctor.Calendar.CalendarActivity;
import com.example.mylittledoctor.Encyclopedia.EncyclopediaActivity;
import com.example.mylittledoctor.Encyclopedia.News;
import com.example.mylittledoctor.Encyclopedia.SideEffect;
import com.example.mylittledoctor.R;
import com.example.mylittledoctor.Search.SearchingActivity;

public class Healthy_Knowledge extends AppCompatActivity {
    Button image_btn1, image_btn2, image_btn3, image_btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_knowledge);
    }

    void view_init(){
        image_btn1=(Button)findViewById(R.id.image_btn1);
        image_btn2=(Button)findViewById(R.id.image_btn2);
        image_btn3=(Button)findViewById(R.id.image_btn3);
        image_btn4=(Button)findViewById(R.id.image_btn4);
    }


    public void click(View view){
        Intent intent;
        switch (view.getId()) {
            case R.id.image_btn1:
                intent=new Intent(Healthy_Knowledge.this, EncyclopediaActivity.class);
                startActivity(intent);
                break;
            case R.id.image_btn2:
                intent=new Intent(Healthy_Knowledge.this, News.class);
                startActivity(intent);
                break;
            case R.id.image_btn3:
                intent=new Intent(Healthy_Knowledge.this, SideEffect.class);
                startActivity(intent);
                break;
            case R.id.image_btn4:
                intent=new Intent(Healthy_Knowledge.this, SearchingActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void back(View view) {
      //  Intent intent = new Intent(Healthy_Knowledge.this, MainActivity.class);
       // startActivity(intent);
        finish();
    }
}
