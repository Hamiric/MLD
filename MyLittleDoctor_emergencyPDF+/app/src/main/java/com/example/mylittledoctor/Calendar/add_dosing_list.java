package com.example.mylittledoctor.Calendar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
    private TextView adding_request, list_day;
    private LinearLayout alram;

    DBHelper dbHelper;

    ArrayList<String> title = new ArrayList<String>();
    ArrayList<Integer> ar_dosage = new ArrayList<Integer>();
    ArrayList<Integer> ar_dosing_days = new ArrayList<Integer>();
    ArrayList<Integer> ar_dosing_number = new ArrayList<Integer>();

    private int Year, Month, Day;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_add_dosing_list);

        alram = (LinearLayout) findViewById(R.id.alram_setting);
        btn_finish = (ImageButton) findViewById(R.id.imageButton3);
        btn_add = (Button) findViewById(R.id.add_item_dosing_list);
        listView = (ListView) findViewById(R.id.listview_item_dosing);
        adding_request = (TextView) findViewById(R.id.txt_adding_request);
        list_day = (TextView) findViewById(R.id.list_day);

        adapter = new ListViewAdapter_dosing(add_dosing_list.this);
        listView.setAdapter(adapter);

        dbHelper = new DBHelper(getApplicationContext(), 1);

        Year = getIntent().getIntExtra("Year", 0000);
        Month = getIntent().getIntExtra("Month", 00);
        Day = getIntent().getIntExtra("Day", 00);

        list_day.setText(Year + " / " + Month + " / " + Day);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Medicine", null);

        while(cursor.moveToNext()){
            if(Year == cursor.getInt(5)){
                if(Month == cursor.getInt(6)){
                    if(Day == cursor.getInt(7)){

                        String S_title = cursor.getString(0);
                        String indiredient = cursor.getString(1);
                        int dosage = cursor.getInt(2);
                        int dosing_number = cursor.getInt(4);
                        int dosing_days = cursor.getInt(3);

                        //String indiredient = "주성분";
                        String s_sub2 = "투약량 : " + dosage;
                        String s_sub3 = "횟수 : " + dosing_number + "  /  일수 : " + dosing_days;

                        adapter.addItem(S_title,indiredient,s_sub2,s_sub3, Year, Month, Day, dosing_days);

                        adding_request.setVisibility(View.GONE);
                    }
                }
            }
        }

        alram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlramActivity.class);
                intent.putStringArrayListExtra("title", title);
                intent.putIntegerArrayListExtra("dosage", ar_dosage);
                intent.putIntegerArrayListExtra("dosing_days", ar_dosing_days);
                intent.putIntegerArrayListExtra("dosing_number",ar_dosing_number);

                intent.putExtra("Year", Year);
                intent.putExtra("Month", Month);
                intent.putExtra("Day", Day);

                setResult(RESULT_OK, intent);
                startActivity(intent);

                finish();
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
                intent.putExtra("Year", Year);
                intent.putExtra("Month", Month);
                intent.putExtra("Day", Day);
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
                String ingredient = data.getStringExtra("ingredient");
                int dosage = data.getIntExtra("dosage",0);
                int dosing_days = data.getIntExtra("dosing_days",0);
                int dosing_number = data.getIntExtra("dosing_number",0);

                //데이터 가공
                //String ingredient = "주성분";
                String s_sub2 = "투약량 : " + dosage;
                String s_sub3 = "횟수 : " + dosing_number + "  /  일수 : " + dosing_days;

                title.add(S_title);
                ar_dosage.add(dosage);
                ar_dosing_days.add(dosing_days);
                ar_dosing_number.add(dosing_number);
                adapter.addItem(S_title,ingredient,s_sub2,s_sub3, Year, Month, Day, dosing_days);

                adding_request.setVisibility(View.GONE);

                adapter.notifyDataSetChanged();
            }
        }

    }

}