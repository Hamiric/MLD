package com.example.mylittledoctor.Calendar;

import static java.sql.Types.NULL;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mylittledoctor.MainUI.MainActivity;
import com.example.mylittledoctor.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity
{
    MaterialCalendarView materialCalendarView;
    final Calendar date = Calendar.getInstance();

    public TextView SelectDay_textview;

    private ListView listView;
    private ListViewAdapter adapter;

    private Button btn_add;
    private ImageButton btn_finish;

    DBHelper dbHelper;

    private int Year, Month, Day;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        SelectDay_textview = findViewById(R.id. SelectDay_textview);

        materialCalendarView = (MaterialCalendarView)findViewById(R.id.calendarView);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_finish = (ImageButton) findViewById(R.id.imageButton2);
        listView = (ListView) findViewById(R.id.listview);

        adapter = new ListViewAdapter(CalendarActivity.this);
        listView.setAdapter(adapter);

        dbHelper = new DBHelper(getApplicationContext(), 1);

        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2017, 0, 1))
                .setMaximumDate(CalendarDay.from(2040, 11, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        materialCalendarView.addDecorators(
                new SaturdayDecorator(),
                new SundayDecorator(),
                new onDayDecorator()
        );

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Year = date.getYear();
                Month = date.getMonth() + 1;
                Day = date.getDay();

                SelectDay_textview.setVisibility(View.VISIBLE);
                SelectDay_textview.setText(String.format("%d" + "월 " + "%d" + "일", Month, Day));

                adapter.clear();

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
                                int stat = cursor.getInt(8);

                                //String indiredient = "주성분";
                                String s_sub2 = "투약량 : " + dosage;
                                String s_sub3 = "횟수 : " + dosing_number + "  /  일수 : " + dosing_days;

                                adapter.addItem(S_title, indiredient, s_sub2, s_sub3, stat);
                            }
                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Year == NULL){
                    Toast.makeText(getApplicationContext(), "날짜를 선택해 주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), add_dosing_list.class);
                    intent.putExtra("Year", Year);
                    intent.putExtra("Month", Month);
                    intent.putExtra("Day", Day);
                    startActivity(intent);
                }
            }
        });

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_calendar);

        SelectDay_textview = findViewById(R.id. SelectDay_textview);

        materialCalendarView = (MaterialCalendarView)findViewById(R.id.calendarView);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_finish = (ImageButton) findViewById(R.id.imageButton2);
        listView = (ListView) findViewById(R.id.listview);

        adapter = new ListViewAdapter(CalendarActivity.this);
        listView.setAdapter(adapter);

        dbHelper = new DBHelper(getApplicationContext(), 1);

        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2017, 0, 1))
                .setMaximumDate(CalendarDay.from(2040, 11, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        materialCalendarView.addDecorators(
                new SaturdayDecorator(),
                new SundayDecorator(),
                new onDayDecorator()
        );

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Year = date.getYear();
                Month = date.getMonth() + 1;
                Day = date.getDay();

                SelectDay_textview.setVisibility(View.VISIBLE);
                SelectDay_textview.setText(String.format("%d" + "월 " + "%d" + "일", Month, Day));

                adapter.clear();

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
                                int stat = cursor.getInt(8);

                                //String indiredient = "주성분";
                                String s_sub2 = "투약량 : " + dosage;
                                String s_sub3 = "횟수 : " + dosing_number + "  /  일수 : " + dosing_days;

                                adapter.addItem(S_title, indiredient, s_sub2, s_sub3, stat);
                            }
                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Year == NULL){
                    Toast.makeText(getApplicationContext(), "날짜를 선택해 주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), add_dosing_list.class);
                    intent.putExtra("Year", Year);
                    intent.putExtra("Month", Month);
                    intent.putExtra("Day", Day);
                    startActivity(intent);
                }
            }
        });

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent = new Intent(getApplicationContext(), MainActivity.class);
               // startActivity(intent);

                finish();
            }
        });

    }

}
