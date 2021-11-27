package com.example.mylittledoctor.Search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mylittledoctor.R;

import java.util.ArrayList;

public class SeachedActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Medicine_Structure>medicine_list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seached);

        init();
        Receive_Data();

        List_adpater adpater=new List_adpater(medicine_list);
        lv.setAdapter(adpater);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url="https://nedrug.mfds.go.kr/pbp/CCBBB01/getItemDetail?itemSeq="+medicine_list.get(position).Code;
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
    void init(){
        lv=(ListView)findViewById(R.id.lv);

    }
    void Receive_Data(){
        ArrayList<String> code=(ArrayList<String>)getIntent().getSerializableExtra("Code");
        ArrayList<String>name=(ArrayList<String>)getIntent().getSerializableExtra("Name");
        ArrayList<String>ingredients=(ArrayList<String>)getIntent().getSerializableExtra("Ingredients");
        ArrayList<String>e=(ArrayList<String>)getIntent().getSerializableExtra("E");
        ArrayList<String>image=(ArrayList<String>)getIntent().getSerializableExtra("Image");

        for(int i=0; i<code.size(); i++){
            medicine_list.add(new Medicine_Structure(code.get(i),name.get(i),ingredients.get(i),e.get(i)));
        }

    }
}

