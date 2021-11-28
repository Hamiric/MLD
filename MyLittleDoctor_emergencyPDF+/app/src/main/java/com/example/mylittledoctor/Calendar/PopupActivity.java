package com.example.mylittledoctor.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import jxl.Sheet;
import jxl.Workbook;

import com.example.mylittledoctor.R;
import com.example.mylittledoctor.Search.Medicine_Structure;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PopupActivity extends Activity {

    AutoCompleteTextView autoSearchView;
    int numbering;

    private ArrayList<String>name=new ArrayList<>();
    private ArrayList<String>ingredients=new ArrayList<>();

    ArrayList<list_Structure> List=new ArrayList<list_Structure>();

    CheckBox dosing_number1, dosing_number2, dosing_number3;
    EditText dosage, dosing_days;

    private int Year, Month, Day;
    private String N_S;

    DBHelper dbHelper;

    Workbook wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_calendar_dosing_list);

        SharedPreferences sharedPreferences = getSharedPreferences("sample", MODE_PRIVATE);
        numbering = sharedPreferences.getInt("numbering", 0);

        settingList();

        dbHelper = new DBHelper(getApplicationContext(), 1);

        Year = getIntent().getIntExtra("Year", 0000);
        Month = getIntent().getIntExtra("Month", 00);
        Day = getIntent().getIntExtra("Day", 00);

        //UI 객체생성
        autoSearchView = (AutoCompleteTextView) findViewById(R.id.autoSearchView);
        autoSearchView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, name));

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

        autoSearchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                N_S = (String) parent.getItemAtPosition(position);
            }
        });

    }

    //확인 버튼 클릭
    public void mOnClose(View v){
        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("title", ((EditText)autoSearchView).getText().toString());
        intent.putExtra("ingredient", ingredients.get(searching_ingredient(N_S)));
        intent.putExtra("dosage",Integer.parseInt(dosage.getText().toString()));
        intent.putExtra("dosing_days",Integer.parseInt(dosing_days.getText().toString()));
        intent.putExtra("dosing_number",checking(dosing_number1,dosing_number2,dosing_number3));

        dbHelper.insert(((EditText)autoSearchView).getText().toString(), ingredients.get(searching_ingredient(N_S)),Integer.parseInt(dosage.getText().toString()), Integer.parseInt(dosing_days.getText().toString()), checking(dosing_number1,dosing_number2,dosing_number3), Year, Month, Day, checking(dosing_number1,dosing_number2,dosing_number3));

        setResult(RESULT_OK, intent);

        name.clear();
        ingredients.clear();
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
        for (int i = 1; i < 12; i++) {
            Log.d("확인",i+"번째액셀파일실행");
            try {
                String File_Name="data"+i+".xls";
                InputStream is = getBaseContext().getResources().getAssets().open(File_Name);
                wb = Workbook.getWorkbook(is);
                if (wb != null) {
                    Sheet sheet = wb.getSheet(0);   // 시트 불러오기
                    if (sheet != null) {
                        int colTotal = sheet.getColumns();    // 전체 컬럼
                        int rowIndexStart = 1;                  // row 인덱스 시작
                        int rowTotal = sheet.getColumn(colTotal - 1).length;

                        for (int row = rowIndexStart; row < rowTotal; row++) {
                            String Code=sheet.getCell(0, row).getContents();
                            String Name=sheet.getCell(1, row).getContents();
                            String Ingredients=sheet.getCell(8, row).getContents();
                            String E=sheet.getCell(25, row).getContents();
                            List.add(new list_Structure(Code,Name,Ingredients,E));
                        }
                    }else {
                        Log.d("test", "sheet 없음");
                        Toast.makeText(getApplicationContext(), "sheet", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d("test", "workbook 없음");
                    Toast.makeText(getApplicationContext(), "workbook", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {
                Log.d("test", "에러발생");
                Log.d("확인","에러:"+e.getMessage());
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
            }

        }

        for(int i=0; i<List.size(); i++){
            name.add(List.get(i).Name);
            ingredients.add(List.get(i).Ingredients);
        }

    }

    public int searching_ingredient(String Sname){
        int pos = -1;
        for(int i = 0 ; i < name.size(); i ++){
            if(name.get(i) == Sname){
                pos = i;
            }
        }
        return pos;
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
