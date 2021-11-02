package com.example.mld_c;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Calendar;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;


public class MainActivity extends AppCompatActivity
{
    MaterialCalendarView materialCalendarView;
    final Calendar date = Calendar.getInstance();

    public TextView SelectDay_textview;

    private ListView listView;
    private ListViewAdapter adapter;

    private Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SelectDay_textview = findViewById(R.id. SelectDay_textview);

        materialCalendarView = (MaterialCalendarView)findViewById(R.id.calendarView);

        btn_add = (Button) findViewById(R.id.btn_add);
        listView = (ListView) findViewById(R.id.listview);

        adapter = new ListViewAdapter(MainActivity.this);
        listView.setAdapter(adapter);

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
                int Year = date.getYear();
                int Month = date.getMonth();
                int Day = date.getDay();

                SelectDay_textview.setVisibility(View.VISIBLE);
                SelectDay_textview.setText(String.format("%d" + "월 " + "%d" + "일", Month + 1, Day));
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), add_dosing_list.class);
                startActivity(intent);
            }
        });

    }
}