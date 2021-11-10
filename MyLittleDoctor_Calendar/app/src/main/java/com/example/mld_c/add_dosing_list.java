package com.example.mld_c;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class add_dosing_list extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter_dosing adapter;

    private ImageButton btn_finish;
    private Button btn_add;
    private TextView adding_request;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_dosing_list);

        btn_finish = (ImageButton) findViewById(R.id.imageButton3);
        btn_add = (Button) findViewById(R.id.add_item_dosing_list);
        listView = (ListView) findViewById(R.id.listview_item_dosing);
        adding_request = (TextView) findViewById(R.id.txt_adding_request);

        adapter = new ListViewAdapter_dosing(add_dosing_list.this);
        listView.setAdapter(adapter);

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                //데이터 받기
                String title = data.getStringExtra("title");
                Log.d("title", "onActivityResult: " + title);
                adapter.addItem(title);

                adding_request.setVisibility(View.GONE);

                adapter.notifyDataSetChanged();
            }
        }

    }

}