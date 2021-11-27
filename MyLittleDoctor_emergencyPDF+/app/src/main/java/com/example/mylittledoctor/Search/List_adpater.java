package com.example.mylittledoctor.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylittledoctor.R;

import java.util.ArrayList;

public class List_adpater extends BaseAdapter {
    ArrayList<Medicine_Structure> medicine_list=new ArrayList<Medicine_Structure>();
    public List_adpater(ArrayList<Medicine_Structure>medicine_list){
        this.medicine_list=medicine_list;
    }

    @Override
    public int getCount() {
        return medicine_list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0; //잘 모르겠네..
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(medicine_list.get(position).e.length()==0){
                convertView = inflater.inflate(R.layout.searching_list_data_page1, parent, false);
            }else{
                convertView = inflater.inflate(R.layout.searching_list_data_page2, parent, false);
            }
        }

        ImageView img1=(ImageView)convertView.findViewById(R.id.img1);
        TextView tv1=(TextView)convertView.findViewById(R.id.tv1);
        TextView tv2=(TextView)convertView.findViewById(R.id.tv2);

        if(false){
            //이미지가 있는 경우
        }

        tv1.setText(medicine_list.get(position).Name);
        tv2.setText(medicine_list.get(position).Ingredients);

        return convertView;
    }
}


