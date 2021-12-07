package com.example.mylittledoctor.Search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.mylittledoctor.Calendar.AlramActivity;
import com.example.mylittledoctor.Encyclopedia.SideEffect;
import com.example.mylittledoctor.MainUI.Healthy_Knowledge;
import com.example.mylittledoctor.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;

public class SearchingActivity extends AppCompatActivity {
    Workbook wb;
    EditText edt1,edt2,edt3;
    LinearLayout information;
    Button btn1;
    ImageButton btn2;
    SearchView sv;
    ArrayList<Medicine_Structure> Medicine_List=new ArrayList<Medicine_Structure>();

    List list=new ArrayList<Object>();
    Map<String, String> excel_sheet=new HashMap<String,String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);

        init();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Medicine_Name = edt1.getText().toString();
                String Corporate_Name=edt2.getText().toString();
                String Ingredient_Name=edt3.getText().toString();

                if(Medicine_Name.length()!=0 && Corporate_Name.length()==0 && Ingredient_Name.length()==0){
                    searching(Medicine_Name);
                }else if(Medicine_Name.length()==0 && Corporate_Name.length()!=0 && Ingredient_Name.length()==0){
                    searching(Corporate_Name);

                }else if(Medicine_Name==null && Corporate_Name==null && Ingredient_Name!=null){
                    searching(Ingredient_Name);
                }else if(Medicine_Name!=null && Corporate_Name!=null && Ingredient_Name!=null){

                }else if(Medicine_Name!=null && Corporate_Name==null && Ingredient_Name!=null){

                }else if(Medicine_Name==null && Corporate_Name!=null && Ingredient_Name!=null){

                }else{
                    //3개 모두 다 입력했을 경우.
                }

                if(Medicine_List.size()>=1) {
                    Intent intent = new Intent(getApplicationContext(),SeachedActivity.class);
                    ArrayList<String>code=new ArrayList<>();
                    ArrayList<String>name=new ArrayList<>();
                    ArrayList<String>ingredients=new ArrayList<>();
                    ArrayList<String>e=new ArrayList<>();
                    ArrayList<String>image=new ArrayList<>();

                    for(int i=0; i<Medicine_List.size(); i++){
                        code.add(Medicine_List.get(i).Code);
                        name.add(Medicine_List.get(i).Name);
                        ingredients.add(Medicine_List.get(i).Ingredients);
                        e.add(Medicine_List.get(i).e);
                        image.add(Medicine_List.get(i).Image);
                    }

                    intent.putStringArrayListExtra("Code",code);
                    intent.putStringArrayListExtra("Name",name);
                    intent.putStringArrayListExtra("Ingredients",ingredients);
                    intent.putStringArrayListExtra("E",e);
                    intent.putStringArrayListExtra("Image",image);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),"다시입력하세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchingActivity.this, Healthy_Knowledge.class);
                startActivity(intent);

                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    void init(){
        edt1=(EditText)findViewById(R.id.edt1);
        edt2=(EditText)findViewById(R.id.edt2);
        edt3=(EditText)findViewById(R.id.edt3);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(ImageButton)findViewById(R.id.imageButton2);
        information=(LinearLayout)findViewById(R.id.information);
    }

    void searching(String Searching_Name){
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
                            if(sheet.getCell(1, row).getContents().contains(Searching_Name)){
                                String Code=sheet.getCell(0, row).getContents();
                                String Name=sheet.getCell(1, row).getContents();
                                String Ingredients=sheet.getCell(8, row).getContents();
                                String E=sheet.getCell(25, row).getContents();
                                Medicine_List.add(new Medicine_Structure(Code,Name,Ingredients,E));

                                // Toast.makeText(getApplicationContext(), "data찾음!", Toast.LENGTH_SHORT).show();
                                // Log.d("확인",""+Searching_Name);
                            }
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
    }

}
