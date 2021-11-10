package com.example.mylittledoctor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<LocationResult.body.items.item> hData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView_dutyName;
        TextView textView_distance;
        TextView textView_dutyAddr;

        ViewHolder(View itemView){
            super(itemView);
            textView_dutyName = itemView.findViewById(R.id.dutyName);
            textView_distance = itemView.findViewById(R.id.distance);
            textView_dutyAddr = itemView.findViewById(R.id.dutyAddr);

            // 아이템 클릭 이벤트 처리
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Intent intent = new Intent(v.getContext(), MapInfoActivity.class);
                    intent.putExtra("hpid", hData.get(pos).gethpid());
                    intent.putExtra("WGS84LAT", hData.get(pos).getLatitude());
                    intent.putExtra("WGS84LON", hData.get(pos).getLongitude());
                    v.getContext().startActivity(intent);
                }
            });
        }

        void onBind(LocationResult.body.items.item Item)
        {
            textView_dutyName.setText(Item.getdutyName());
            textView_distance.setText(Double.toString(Item.getDistance()) + "km");
            textView_dutyAddr.setText(Item.getDutyAddr());
        }
    }

    Adapter(ArrayList<LocationResult.body.items.item> list){
        hData = list;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_recycler, parent, false);
        Adapter.ViewHolder vh = new Adapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        holder.onBind(hData.get(position));
    }

    @Override
    public int getItemCount() {
        if(hData != null) {
            return hData.size();
        }
        return 0;
    }

}
