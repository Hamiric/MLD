package com.example.mylittledoctor.MainUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylittledoctor.Calendar.CalendarActivity;
import com.example.mylittledoctor.Encyclopedia.EncyclopediaActivity;
import com.example.mylittledoctor.R;

public class Emergency extends AppCompatActivity {
    Button image_btn1, image_btn2, image_btn3, image_btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
    }
}