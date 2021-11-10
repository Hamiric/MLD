package com.example.mylittledoctor;

import android.content.Context;
import android.icu.text.IDNA;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

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
            if(Item.dutyTime1s != 0 && Item.dutyTime1c != 0) {
                textView_dutyTime1.setText("월요일     |   " + Item.getDutyTime1s() + "-" + Item.getDutyTime1c());
            }
            if(Item.dutyTime2s != 0 && Item.dutyTime2c != 0) {
                textView_dutyTime2.setText("화요일     |   " + Item.getDutyTime2s() + "-" + Item.getDutyTime2c());
            }
            if(Item.dutyTime3s != 0 && Item.dutyTime3c != 0) {
                textView_dutyTime3.setText("수요일     |   " + Item.getDutyTime3s() + "-" + Item.getDutyTime3c());
            }
            if(Item.dutyTime4s != 0 && Item.dutyTime4c != 0) {
                textView_dutyTime4.setText("목요일     |   " + Item.getDutyTime4s() + "-" + Item.getDutyTime4c());
            }
            if(Item.dutyTime5s != 0 && Item.dutyTime5c != 0) {
                textView_dutyTime5.setText("금요일     |   " + Item.getDutyTime5s() + "-" + Item.getDutyTime5c());
            }
            if(Item.dutyTime6s != 0 && Item.dutyTime6c != 0) {
                textView_dutyTime6.setText("토요일     |   " + Item.getDutyTime6s() + "-" + Item.getDutyTime6c());
            }
            if(Item.dutyTime7s != 0 && Item.dutyTime7c != 0) {
                textView_dutyTime7.setText("일요일     |   " + Item.getDutyTime7s() + "-" + Item.getDutyTime7c());
            }
            if(Item.dutyTime8s != 0 && Item.dutyTime8c != 0) {
                textView_dutyTime8.setText("공휴일     |   " + Item.getDutyTime8s() + "-" + Item.getDutyTime8c());
            }
            textView_dgidIdName.setText(Item.getDgidldName());
        }
    }

    Info_Adapter(ArrayList<InfoResult.body_info.items_info.item_info> list) {
        iData = list;
    }

    @Override
    public Info_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_info, parent, false);
        Info_Adapter.ViewHolder vh = new Info_Adapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(Info_Adapter.ViewHolder holder, int position) {
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
