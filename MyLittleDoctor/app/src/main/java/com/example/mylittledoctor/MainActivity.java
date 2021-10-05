package com.example.mylittledoctor;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }
    public void click(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.icon_btn1:
                intent=new Intent(MainActivity.this,Diagnosis.class);
                startActivity(intent);
                break;
            case R.id.icon_btn2:
                intent=new Intent(MainActivity.this,Encyclopedia.class);
                startActivity(intent);
                break;
            case R.id.icon_btn3:
                intent=new Intent(MainActivity.this,HospitalMap.class);
                startActivity(intent);
                break;
        }
    }
}