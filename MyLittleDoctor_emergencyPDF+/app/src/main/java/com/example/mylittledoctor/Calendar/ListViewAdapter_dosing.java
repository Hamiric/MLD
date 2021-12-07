package com.example.mylittledoctor.Calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylittledoctor.R;

import java.util.ArrayList;
import java.util.Calendar;

public class ListViewAdapter_dosing extends BaseAdapter {

    private Context mContext;
    private ArrayList<ListItem_dosing> listItems = new ArrayList<ListItem_dosing>();

    private TextView drag_title;
    private TextView indiredient, dosage, dosing_number_days;

    private int Year, Month, Day;

    private Button btn_delete;

    DBHelper dbHelper;

    public ListViewAdapter_dosing(Context context){
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
            convertView = inflater.inflate(R.layout.item_calendar_dosing_list, parent, false);
        }

        // item.xml 의 참조 획득
        drag_title = (TextView)convertView.findViewById(R.id.drag_title);
        indiredient = (TextView)convertView.findViewById(R.id.txt_sub);
        dosage = (TextView)convertView.findViewById(R.id.txt_sub2);
        dosing_number_days = (TextView)convertView.findViewById(R.id.txt_sub3);
        btn_delete = (Button)convertView.findViewById(R.id.delete_btn);

        ListItem_dosing listItem = listItems.get(position);

        dbHelper = new DBHelper(mContext.getApplicationContext(), 1);

        Year = listItem.getYear();
        Month = listItem.getMonth();
        Day = listItem.getDay();

        // 가져온 데이터를 텍스트뷰에 입력
        drag_title.setText(listItem.getTitle());
        indiredient.setText(listItem.getSub());
        dosage.setText(listItem.getSub2());
        dosing_number_days.setText(listItem.getSub3());

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems.remove(position);

                Toast.makeText(mContext.getApplicationContext(), listItem.getTitle() + " 기록이 삭제되었습니다.", Toast.LENGTH_LONG).show();

                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, Year);
                if(Month == 1){
                    cal.set(Calendar.MONTH, Calendar.JANUARY);
                }
                else if(Month == 2){
                    cal.set(Calendar.MONTH, Calendar.FEBRUARY);
                }
                else if(Month == 3){
                    cal.set(Calendar.MONTH, Calendar.MARCH);
                }
                else if(Month == 4){
                    cal.set(Calendar.MONTH, Calendar.APRIL);
                }
                else if(Month == 5){
                    cal.set(Calendar.MONTH, Calendar.MAY);
                }
                else if(Month == 6){
                    cal.set(Calendar.MONTH, Calendar.JUNE);
                }
                else if(Month == 7){
                    cal.set(Calendar.MONTH, Calendar.JULY);
                }
                else if(Month == 8){
                    cal.set(Calendar.MONTH, Calendar.AUGUST);
                }
                else if(Month == 9){
                    cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
                }
                else if(Month == 10){
                    cal.set(Calendar.MONTH, Calendar.OCTOBER);
                }
                else if(Month == 11){
                    cal.set(Calendar.MONTH, Calendar.NOVEMBER);
                }
                else if(Month == 12){
                    cal.set(Calendar.MONTH, Calendar.DECEMBER);
                }
                cal.set(Calendar.DAY_OF_MONTH, Day);
                
                for(int i = 0 ; i < listItem.getNumber() ; i ++){
                    dbHelper.Delete(listItem.getTitle(), cal.get(Calendar.YEAR), (cal.get(Calendar.MONTH)+1), cal.get(Calendar.DAY_OF_MONTH));
                    cal.add(Calendar.DAY_OF_MONTH, 1);
                }

                //dbHelper.Delete(listItem.getTitle(), Year, Month, Day);

                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    public void addItem(String s_title, String indiredient, String s_sub2, String s_sub3, int Year, int Month, int Day, int number){
        ListItem_dosing listItem = new ListItem_dosing();

        listItem.setTitle(s_title);
        listItem.setSub(indiredient);
        listItem.setSub2(s_sub2);
        listItem.setSub3(s_sub3);
        listItem.setYear(Year);
        listItem.setMonth(Month);
        listItem.setDay(Day);
        listItem.setNumber(number);

        listItems.add(listItem);
    }
}