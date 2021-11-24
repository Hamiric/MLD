package com.example.mylittledoctor.Calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mylittledoctor.Calendar.ListItem_dosing;
import com.example.mylittledoctor.R;

import java.util.ArrayList;

public class ListViewAdapter_dosing extends BaseAdapter {

    private Context mContext;
    private ArrayList<ListItem_dosing> listItems = new ArrayList<ListItem_dosing>();

    private TextView drag_title;


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

        ListItem_dosing listItem = listItems.get(position);

        // 가져온 데이터를 텍스트뷰에 입력
        drag_title.setText(listItem.getTitle());

        return convertView;
    }

    public void addItem(String title){
        ListItem_dosing listItem = new ListItem_dosing();

        listItem.setTitle(title);

        listItems.add(listItem);
    }
}