package com.example.mylittledoctor.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylittledoctor.R;

import java.util.ArrayList;
import java.util.List;

public class PopupActivity extends Activity {

    AutoCompleteTextView autoSearchView;
    int numbering;

    private List<String> list;

    CheckBox dosing_number1, dosing_number2, dosing_number3;
    EditText dosage, dosing_days;

    private int Year, Month, Day;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_calendar_dosing_list);

        SharedPreferences sharedPreferences = getSharedPreferences("sample", MODE_PRIVATE);
        numbering = sharedPreferences.getInt("numbering", 0);

        list = new ArrayList<String>();
        settingList();

        dbHelper = new DBHelper(getApplicationContext(), 1);

        Year = getIntent().getIntExtra("Year", 0000);
        Month = getIntent().getIntExtra("Month", 00);
        Day = getIntent().getIntExtra("Day", 00);

        //UI 객체생성
        autoSearchView = (AutoCompleteTextView) findViewById(R.id.autoSearchView);
        autoSearchView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list));

        dosage = (EditText) findViewById(R.id.dosage);
        dosing_days = (EditText) findViewById(R.id.dosing_days);

        dosing_number1 = (CheckBox) findViewById(R.id.dosing_number1);
        dosing_number2 = (CheckBox) findViewById(R.id.dosing_number2);
        dosing_number3 = (CheckBox) findViewById(R.id.dosing_number3);

        dosing_number1.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                dosing_number2.setChecked(false);
                dosing_number3.setChecked(false);
            }
        });

        dosing_number2.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                dosing_number1.setChecked(false);
                dosing_number3.setChecked(false);
            }
        });

        dosing_number3.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){
                dosing_number1.setChecked(false);
                dosing_number2.setChecked(false);
            }
        });
    }

    //확인 버튼 클릭
    public void mOnClose(View v){
        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("title", ((EditText)autoSearchView).getText().toString());
        intent.putExtra("dosage",Integer.parseInt(dosage.getText().toString()));
        intent.putExtra("dosing_days",Integer.parseInt(dosing_days.getText().toString()));
        intent.putExtra("dosing_number",checking(dosing_number1,dosing_number2,dosing_number3));

        String indiredient = "주성분";

        dbHelper.insert(((EditText)autoSearchView).getText().toString(), indiredient,Integer.parseInt(dosage.getText().toString()), Integer.parseInt(dosing_days.getText().toString()), checking(dosing_number1,dosing_number2,dosing_number3), Year, Month, Day, checking(dosing_number1,dosing_number2,dosing_number3));

        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    /*
    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
    */

    private void settingList(){
        list.add("채수빈");
        list.add("박지현");
        list.add("수지");
    }

    private int checking(CheckBox a, CheckBox b, CheckBox c){
        if(a.isChecked()){
            return 1;
        }

        if(b.isChecked()){
            return 2;
        }

        if(c.isChecked()){
            return 3;
        }

        return 0;
    }

}
