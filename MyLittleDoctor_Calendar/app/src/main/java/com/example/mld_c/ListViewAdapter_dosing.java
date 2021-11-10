package com.example.mld_c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ListViewAdapter_dosing extends BaseAdapter {

    private Context mContext;
    private ArrayList<ListItem_dosing> listItems = new ArrayList<ListItem_dosing>();

    private TextView txt_title;
    private ImageView tap;
    private LinearLayout layout_item_dosing_list;


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
            convertView = inflater.inflate(R.layout.item_dosing, parent, false);
        }

        // item.xml 의 참조 획득
        txt_title = (TextView)convertView.findViewById(R.id.list_title);
        tap = (ImageView)convertView.findViewById(R.id.tap);
        layout_item_dosing_list = (LinearLayout)convertView.findViewById(R.id.layout_item_dosing_list);

        ListItem_dosing listItem = listItems.get(position);

        // 가져온 데이터를 텍스트뷰에 입력
        txt_title.setText(listItem.getTitle());

        tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tap.setBackground(ContextCompat.getDrawable(mContext,R.drawable.up_image));
            }
        });

        return convertView;
    }

    public void addItem(String title){
        ListItem_dosing listItem = new ListItem_dosing();

        listItem.setTitle(title);

        listItems.add(listItem);
    }
}