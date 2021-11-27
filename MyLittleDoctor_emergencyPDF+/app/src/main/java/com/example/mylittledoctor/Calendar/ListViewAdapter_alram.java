package com.example.mylittledoctor.Calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mylittledoctor.R;

import java.util.ArrayList;

public class ListViewAdapter_alram extends BaseAdapter {

    private Context mContext;
    private ArrayList<ListItem_dosing> listItems = new ArrayList<ListItem_dosing>();

    private TextView drag_title;
    private int status;

    private int Year, Month, Day;

    DBHelper dbHelper;

    public ListViewAdapter_alram(Context context){
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // item.xml 레이아웃을 inflate해서 참조획득
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_alram, parent, false);
        }

        // item.xml 의 참조 획득
        drag_title = (TextView)convertView.findViewById(R.id.drag_title);

        ListItem_dosing listItem = listItems.get(position);

        dbHelper = new DBHelper(mContext.getApplicationContext(), 1);

        Year = listItem.getYear();
        Month = listItem.getMonth();
        Day = listItem.getDay();

        status = listItem.getNumber();

        // 가져온 데이터를 텍스트뷰에 입력
        drag_title.setText(listItem.getTitle());

        Button morning = (Button) convertView.findViewById(R.id.morning);
        Button lunch = (Button) convertView.findViewById(R.id.lunch);
        Button dinner = (Button) convertView.findViewById(R.id.dinner);


        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(morning.getText().toString() == "선택됨") {
                    morning.setText("아침");
                }
                else{
                    morning.setText("선택됨");
                }

                setstat(dbHelper, listItem.getTitle(), morning, lunch, dinner, Year, Month, Day);
            }
        });


        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lunch.getText().toString() == "선택됨") {
                    lunch.setText("점심");
                }
                else{
                    lunch.setText("선택됨");
                }

                setstat(dbHelper, listItem.getTitle(), morning, lunch, dinner, Year, Month, Day);
            }
        });


        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dinner.getText().toString() == "선택됨") {
                    dinner.setText("저녁");
                }
                else{
                    dinner.setText("선택됨");
                }

                setstat(dbHelper, listItem.getTitle(), morning, lunch, dinner, Year, Month, Day);
            }
        });

        if(status == 1){
            morning.setText("아침");
            lunch.setText("선택됨");
            dinner.setText("저녁");
        }
        else if(status == 2){
            morning.setText("선택됨");
            lunch.setText("점심");
            dinner.setText("선택됨");
        }
        else if(status == 3){
            morning.setText("선택됨");
            lunch.setText("선택됨");
            dinner.setText("선택됨");
        }
        else if(status == 4){
            morning.setText("아침");
            lunch.setText("선택됨");
            dinner.setText("선택됨");
        }
        else if(status == 5){
            morning.setText("선택됨");
            lunch.setText("선택됨");
            dinner.setText("저녁");
        }
        else if(status == 6){
            morning.setText("아침");
            lunch.setText("점심");
            dinner.setText("선택됨");
        }
        else if(status == 7){
            morning.setText("선택됨");
            lunch.setText("점심");
            dinner.setText("저녁");
        }
        else if(status == 8){
            morning.setText("아침");
            lunch.setText("점심");
            dinner.setText("저녁");
        }

        return convertView;
    }

    public void addItem(String title, int stat, int Year, int Month, int Day){
        ListItem_dosing listItem = new ListItem_dosing();

        listItem.setTitle(title);
        listItem.setNumber(stat);
        listItem.setYear(Year);
        listItem.setMonth(Month);
        listItem.setDay(Day);

        listItems.add(listItem);
    }

    public void setstat(DBHelper db, String title, Button a, Button b, Button c, int Year, int Month, int Day){
        int stat;
        String a_s = a.getText().toString();
        String b_s = b.getText().toString();
        String c_s = c.getText().toString();

        if(a_s == "선택됨" && b_s == "선택됨" && c_s == "선택됨"){
            stat = 3;
            db.Update(title, Year, Month, Day, stat);
        }
        else if (a_s == "아침" && b_s == "선택됨" && c_s == "선택됨"){
            stat = 4;
            db.Update(title, Year, Month, Day, stat);
        }
        else if (a_s == "선택됨" && b_s == "점심" && c_s == "선택됨"){
            stat = 2;
            db.Update(title, Year, Month, Day, stat);
        }
        else if (a_s == "선택됨" && b_s == "선택됨" && c_s == "저녁"){
            stat = 5;
            db.Update(title, Year, Month, Day, stat);
        }
        else if (a_s == "아침" && b_s == "점심" && c_s == "선택됨"){
            stat = 6;
            db.Update(title, Year, Month, Day, stat);
        }
        else if (a_s == "아침" && b_s == "선택됨" && c_s == "저녁"){
            stat = 1;
            db.Update(title, Year, Month, Day, stat);
        }
        else if (a_s == "선택됨" && b_s == "점심" && c_s == "저녁"){
            stat = 7;
            db.Update(title, Year, Month, Day, stat);
        }
        else if (a_s == "아침" && b_s == "점심" && c_s == "저녁"){
            stat = 8;
            db.Update(title, Year, Month, Day, stat);
        }
    }
}