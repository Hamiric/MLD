package com.example.mylittledoctor.MainUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylittledoctor.Calendar.CalendarActivity;
import com.example.mylittledoctor.HospitalMap.HospitalMapActivity;
import com.example.mylittledoctor.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Emergency extends AppCompatActivity {
    Button image_btn1, image_btn2, image_btn3, image_btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
    }

    public void back(View view) {
       // Intent intent = new Intent(Emergency.this, MainActivity.class);
       // startActivity(intent);
        finish();
    }

    public void btn1(View view) {
        Intent intent = new Intent(Emergency.this, CprPDF.class);
        startActivity(intent);
    }

    public void btn2(View view) {
        Intent intent = new Intent(Emergency.this, ChildrenCprPDF.class);
        startActivity(intent);
    }

    public void btn3(View view) {
        Intent intent = new Intent(Emergency.this, AirwayObstructionPDF.class);
        startActivity(intent);
    }

    public void btn4(View view) {
        Intent intent = new Intent(Emergency.this, FirstAidForEachSituationPDF.class);
        startActivity(intent);

    }

    public void menu(View view) {
    }

    public static class CprPDF extends AppCompatActivity {

        private PDFView cpr;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cprpdf);

            cpr = (PDFView) findViewById(R.id.buttonpdf1);
            cpr.fromAsset("응급상식/심폐소생술.pdf").load();
        }
    }

    public static class AirwayObstructionPDF extends AppCompatActivity {

        private PDFView airwayobstruction;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_airway_obstruction_pdf);

            airwayobstruction = (PDFView) findViewById(R.id.buttonpdf3);
            airwayobstruction.fromAsset("응급상식/기도폐쇄.pdf").load();
        }
    }

    public static class ChildrenCprPDF extends AppCompatActivity {

        private PDFView childrencpr;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_childrencprpdf);

            childrencpr = (PDFView) findViewById(R.id.buttonpdf2);
            childrencpr.fromAsset("응급상식/소아 심폐소생술.pdf").load();
        }
    }

    public static class FirstAidForEachSituationPDF extends AppCompatActivity {

        private PDFView firstaidforeachsituation;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_first_aid_for_each_situation_pdf);

            firstaidforeachsituation = (PDFView) findViewById(R.id.buttonpdf4);
            firstaidforeachsituation.fromAsset("응급상식/상황별 응급처치.pdf").load();
        }
    }

}