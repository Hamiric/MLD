package com.example.mylittledoctor.Calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mylittledoctor.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<ListItem> listItems = new ArrayList<ListItem>();

    public ListViewAdapter(Context context){
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
            convertView = inflater.inflate(R.layout.item_calendar_alarm, parent, false);
        }

        // item.xml 의 참조 획득
        TextView txt_title = (TextView)convertView.findViewById(R.id.txt_title);
        //Button btn_delete = (Button)convertView.findViewById(R.id.btn_delete);

        ListItem listItem = listItems.get(position);

        // 가져온 데이터를 텍스트뷰에 입력
        txt_title.setText(listItem.getTitle());


        /*
        // 리스트 아이템 삭제
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItems.remove(position);
                notifyDataSetChanged();
            }
        });
        */

        LinearLayout item = (LinearLayout)convertView.findViewById(R.id.item);
        item.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

            }
        });

        return convertView;
    }

    public void addItem(String title){
        ListItem listItem = new ListItem();

        listItem.setTitle(title);

        listItems.add(listItem);
    }
}