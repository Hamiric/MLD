package com.example.mylittledoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Diagnosis extends AppCompatActivity {
    Button Back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);
        init_view();

    }
    void init_view(){
        Back_btn=(Button)findViewById(R.id.Back_btn);
    }
    public void click(View view){
        switch (view.getId()){
            case R.id.Back_btn:
                finish();
                break;
            default:
                break;
        }
    }
}