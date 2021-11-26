package com.example.mylittledoctor.Calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mylittledoctor.R;

import java.util.ArrayList;
import java.util.List;

public class add_dosing_list extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter_dosing adapter;

    private ImageButton btn_finish;
    private Button btn_add;
    private TextView adding_request;
    private LinearLayout alram;

    ArrayList<String> title = new ArrayList<String>();
    ArrayList<String> ar_dosage = new ArrayList<String>();
    ArrayList<String> ar_dosing_days = new ArrayList<String>();
    ArrayList<Integer> ar_dosing_number = new ArrayList<Integer>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_add_dosing_list);

        alram = (LinearLayout) findViewById(R.id.alram_setting);
        btn_finish = (ImageButton) findViewById(R.id.imageButton3);
        btn_add = (Button) findViewById(R.id.add_item_dosing_list);
        listView = (ListView) findViewById(R.id.listview_item_dosing);
        adding_request = (TextView) findViewById(R.id.txt_adding_request);

        adapter = new ListViewAdapter_dosing(add_dosing_list.this);
        listView.setAdapter(adapter);


        alram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlramActivity.class);
                intent.putStringArrayListExtra("title", title);
                intent.putStringArrayListExtra("dosage", ar_dosage);
                intent.putStringArrayListExtra("dosing_days", ar_dosing_days);
                intent.putIntegerArrayListExtra("dosing_number",ar_dosing_number);

                /*
                for(int i = 0 ; i < title.size() ; i ++) {
                    intent.putStringArrayListExtra("title", title);
                }
                */

                setResult(RESULT_OK, intent);
                startActivity(intent);
            }
        });

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                //데이터 받기
                String S_title = data.getStringExtra("title");
                String dosage = data.getStringExtra("dosage");
                String dosing_days = data.getStringExtra("dosing_days");
                int dosing_number = data.getIntExtra("dosing_number",0);

                //데이터 가공
                String indiredient = "주성분";
                String s_sub2 = "투약량 : " + dosage;
                String s_sub3 = "횟수 : " + dosing_number + "  /  일수 : " + dosing_days;

                title.add(S_title);
                ar_dosage.add(dosage);
                ar_dosing_days.add(dosing_days);
                ar_dosing_number.add(dosing_number);
                adapter.addItem(S_title,indiredient,s_sub2,s_sub3);

                adding_request.setVisibility(View.GONE);

                adapter.notifyDataSetChanged();
            }
        }

    }



}