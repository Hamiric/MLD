package com.example.mylittledoctor.HospitalMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mylittledoctor.R;

import java.util.ArrayList;

public class Info_Adapter extends RecyclerView.Adapter<Info_Adapter.ViewHolder> {

    private ArrayList<InfoResult.body_info.items_info.item_info> iData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView_dutyName;
        TextView textView_dutyAddr;
        TextView textView_dutyTel1;
        TextView textView_dutyTime1;
        TextView textView_dutyTime2;
        TextView textView_dutyTime3;
        TextView textView_dutyTime4;
        TextView textView_dutyTime5;
        TextView textView_dutyTime6;
        TextView textView_dutyTime7;
        TextView textView_dutyTime8;
        TextView textView_dgidIdName;

        ViewHolder(View itemView) {
            super(itemView);

            textView_dutyName = itemView.findViewById(R.id.Info_item_dutyName);
            textView_dutyAddr = itemView.findViewById(R.id.Info_item_dutyAddr);
            textView_dutyTel1 = itemView.findViewById(R.id.Info_item_dutyTel1);
            textView_dutyTime1 = itemView.findViewById(R.id.Info_item_dutyTime1);
            textView_dutyTime2 = itemView.findViewById(R.id.Info_item_dutyTime2);
            textView_dutyTime3 = itemView.findViewById(R.id.Info_item_dutyTime3);
            textView_dutyTime4 = itemView.findViewById(R.id.Info_item_dutyTime4);
            textView_dutyTime5 = itemView.findViewById(R.id.Info_item_dutyTime5);
            textView_dutyTime6 = itemView.findViewById(R.id.Info_item_dutyTime6);
            textView_dutyTime7 = itemView.findViewById(R.id.Info_item_dutyTime7);
            textView_dutyTime8 = itemView.findViewById(R.id.Info_item_dutyTime8);
            textView_dgidIdName = itemView.findViewById(R.id.Info_item_dgidIdName);
        }

        void onBind(InfoResult.body_info.items_info.item_info Item) {

            textView_dutyName.setText(Item.getDutyName());
            textView_dutyAddr.setText(Item.getDutyAddr());
            textView_dutyTel1.setText(Item.getDutyTel1());
            if(Item.dutyTime1s != null) {
                textView_dutyTime1.setText("월요일     |   " + Item.getDutyTime1s().substring(0,2) + ":" + Item.getDutyTime1s().substring(2,4) + "-" + Item.getDutyTime1c().substring(0,2) + ":" + Item.getDutyTime1c().substring(2,4));
            }
            if(Item.dutyTime2s != null) {
                textView_dutyTime2.setText("화요일     |   " + Item.getDutyTime2s().substring(0,2) + ":" + Item.getDutyTime2s().substring(2,4) + "-" + Item.getDutyTime2c().substring(0,2) + ":" + Item.getDutyTime2c().substring(2,4));
            }
            if(Item.dutyTime3s != null) {
                textView_dutyTime3.setText("수요일     |   " + Item.getDutyTime3s().substring(0,2) + ":" + Item.getDutyTime3s().substring(2,4) + "-" + Item.getDutyTime3c().substring(0,2) + ":" + Item.getDutyTime3c().substring(2,4));
            }
            if(Item.dutyTime4s != null) {
                textView_dutyTime4.setText("목요일     |   " + Item.getDutyTime4s().substring(0,2) + ":" + Item.getDutyTime4s().substring(2,4) + "-" + Item.getDutyTime4c().substring(0,2) + ":" + Item.getDutyTime4c().substring(2,4));
            }
            if(Item.dutyTime5s != null) {
                textView_dutyTime5.setText("금요일     |   " + Item.getDutyTime5s().substring(0,2) + ":" + Item.getDutyTime5s().substring(2,4) + "-" + Item.getDutyTime5c().substring(0,2) + ":" + Item.getDutyTime5c().substring(2,4));
            }
            if(Item.dutyTime6s != null) {
                textView_dutyTime6.setText("토요일     |   " + Item.getDutyTime6s().substring(0,2) + ":" + Item.getDutyTime6s().substring(2,4) + "-" + Item.getDutyTime6c().substring(0,2) + ":" + Item.getDutyTime6c().substring(2,4));
            }
            if(Item.dutyTime7s != null) {
                textView_dutyTime7.setText("일요일     |   " + Item.getDutyTime7s().substring(0,2) + ":" + Item.getDutyTime7s().substring(2,4) + "-" + Item.getDutyTime7c().substring(0,2) + ":" + Item.getDutyTime7c().substring(2,4));
            }
            if(Item.dutyTime8s != null) {
                textView_dutyTime8.setText("공휴일     |   " + Item.getDutyTime8s().substring(0,2) + ":" + Item.getDutyTime8s().substring(2,4) + "-" + Item.getDutyTime8c().substring(0,2) + ":" + Item.getDutyTime8c().substring(2,4));
            }
            textView_dgidIdName.setText(Item.getDgidldName());
        }
    }

    Info_Adapter(ArrayList<InfoResult.body_info.items_info.item_info> list) {
        iData = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_hospitalinfo, parent, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(iData.get(position));
    }

    @Override
    public int getItemCount() {
        if (iData != null) {
            return iData.size();
        }
        return 0;
    }
}
