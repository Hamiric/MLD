package com.example.mylittledoctor;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class Holder extends RecyclerView.ViewHolder {
    TextView tv;

    public Holder(@NonNull View itemView){
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}