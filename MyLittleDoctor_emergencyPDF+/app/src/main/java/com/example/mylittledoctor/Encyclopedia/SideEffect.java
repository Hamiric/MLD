package com.example.mylittledoctor.Encyclopedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import com.example.mylittledoctor.MainUI.Healthy_Knowledge;
import com.example.mylittledoctor.R;

import java.util.ArrayList;

public class SideEffect extends AppCompatActivity {
    ListView pdfListView;
    ArrayList<String> stringArrayList = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_effect);

        ActionBar actionBar = getSupportActionBar();
        SearchView searchView = findViewById(R.id.search_view);


        pdfListView = findViewById(R.id.myPDFList);

        stringArrayList.add("가바펜틴(gabapentin) 탈모");
        stringArrayList.add("글리메피리드(glimepiride) 저혈당증");
        stringArrayList.add("나프로닐옥살산염(nafronyl oxalate) 요로결석");
        stringArrayList.add("다파글리플로진(dapagliflozin) 방광염");
        stringArrayList.add("다파글리플로진(dapagliflozin) 빈뇨");
        stringArrayList.add("덱시부프로펜(dexibuprofen) 시각장애");
        stringArrayList.add("독사조신(doxazosin) 심한 어지러움증");
        stringArrayList.add("독시사이클린(doxycycline) 궤양성식도염");
        stringArrayList.add("둘라글루타이드(dulaglutide) 급성췌장염");
        stringArrayList.add("둘록세틴(duloxetine) 배뇨곤란");
        stringArrayList.add("디곡신(digoxin) 졸음 및 시야 이상");
        stringArrayList.add("라록시펜(raloxifene) 안와부종");
        stringArrayList.add("레보설피리드(levosulpiride) 유즙분비");
        stringArrayList.add("리바록사반(rivaroxaban) 혈뇨");
        stringArrayList.add("리세드론산나트륨(risedronate sodium) 사지,관절통");
        stringArrayList.add("메트포르민(metformin) 식욕상실");
        stringArrayList.add("메틸페니데이트(methylphenidate) 가슴두근거림");
        stringArrayList.add("메틸프레드니솔론(methylprednisolone) 망막장애");
        stringArrayList.add("메플로퀸(mefloquine) 정신신경계 이상반응");
        stringArrayList.add("멜록시캄(meloxicam) 혈중 칼륨농도 증가");
        stringArrayList.add("미노사이클린(minocycline) 손톱 변색");
        stringArrayList.add("미녹시딜(minoxidil)액 외이염 및 시야흐림");
        stringArrayList.add("미르타자핀(mirtazapine) 손가락관절통 및 부종");
        stringArrayList.add("부프레노르핀(buprenorphine) 실신");
        stringArrayList.add("사이클로스포린(cyclosporine) 다모증");
        stringArrayList.add("세팔락신(cephalexin) 간질성 경련 유사 증상");
        stringArrayList.add("실데나필(sildenafil) 청색시증");
        stringArrayList.add("실로스타졸(cilostazol) 두통");
        stringArrayList.add("아리피프라졸(aripiprazole) 식욕 및 체중 증가");
        stringArrayList.add("아리피프라졸(aripiprazole) 핍뇨 및 저나트륨혈증");
        stringArrayList.add("아목시실린(amoxicillin) 질염 유사 증상");
        stringArrayList.add("아미오다론(amiodarone) 갑상선 기능이상");
        stringArrayList.add("아미오다론(amiodarone) 마비성 보행");
        stringArrayList.add("아지트로마이신(azithromycin) 이명 악화");
        stringArrayList.add("아토르바스타틴(atorvastatin) 급성 췌장염");
        stringArrayList.add("아토르바스타틴(atorvastatin) 시야결손");
        stringArrayList.add("아토목세틴(atomoxetine) 두통");
        stringArrayList.add("암로디핀(amlodipine) 다리 부종");
        stringArrayList.add("암로디핀(amlodipine) 후각이상");
        stringArrayList.add("에르투글리플로진(ertugliflozin),피오글리타존(pioglitazone) 식욕부진, 불면, 우울감 등");
        stringArrayList.add("에스시탈로프람(escitalopram) 언어장애 및 보행실조");
        stringArrayList.add("에스트리올 질좌제(estriol vaginal suppositories) 전신증상(발열, 통증, 구토 등)");
        stringArrayList.add("에토리콕시브(etoricoxib) 신장 손상");
        stringArrayList.add("오셀타미비르(oseltamivir) 환각");
        stringArrayList.add("와파린(warfarin) 및 메트로니다졸(metronidazole) INR 증가");
        stringArrayList.add("이소소르비드이질산염(isosorbide dinitrate) 스프레이 두통");
        stringArrayList.add("이소트레티노인(isotretinoin) 모발 손실(탈모)");
        stringArrayList.add("졸피뎀(zolpidem) 몽유병");
        stringArrayList.add("카르바마제핀(carbamazepine) 가려움증");
        stringArrayList.add("카르베딜롤(carvedilol) 건선 악화");
        stringArrayList.add("카베르골린(cabergoline) 가려움 및 피부변색");
        stringArrayList.add("콜키신(colchicine) 전신 증상(배뇨곤란, 관절통, 무기력 등)");
        stringArrayList.add("클로미펜(clomiphene) 광시증(섬광증)");
        stringArrayList.add("타다라필(tadalafil) 근육통");
        stringArrayList.add("타크로리무스(tacrolimus) 근육경련");
        stringArrayList.add("타크로리무스(tacrolimus) 저림 및 눈밑떨림");
        stringArrayList.add("테네리글립틴(teneligliptin) 급성 췌장염");
        stringArrayList.add("테르비나핀(terbinafine) 미각 상실");
        stringArrayList.add("토피라메이트(topiramate) 모발 손실");
        stringArrayList.add("툴로부테롤(tulobuterol) 패치 불면, 나쁜 기분 등");
        stringArrayList.add("트레티노인(tretinoin) 피부 색소침착");
        stringArrayList.add("티몰롤(timolol) 기침");
        stringArrayList.add("펜터민(phentermine) 호흡곤란(숨가쁨)");
        stringArrayList.add("프레드니솔론(prednisolone) 어지러움 및 환각");
        stringArrayList.add("플루나리진(flunarizine) 흐느적거리는 몸");
        stringArrayList.add("피나스테리드(finasteride) 남성 유방통");
        stringArrayList.add("피록시캄(piroxicam) 기침");
        stringArrayList.add("피르페니돈(pirfenidone) 피부발진 및 물집");
        stringArrayList.add("피타바스타틴(pitavastatin) 간질성폐렴");
        stringArrayList.add("피타바스타틴(pitavastatin) 음주 시 혈뇨");


        // 맨 밑에 있는 두개가 칸이 잘려서 안보이길래 공백으로 두칸 넣었음
        stringArrayList.add("");
        stringArrayList.add("");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SideEffect.this,android.R.layout.simple_list_item_1,stringArrayList)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
            {
                View view = super.getView(position, convertView, parent);
                TextView myText = (TextView) view.findViewById(android.R.id.text1);
                return view;
            }
        };


        pdfListView.setAdapter((adapter));
        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = pdfListView.getItemAtPosition(i).toString();
                Intent start = new Intent(getApplicationContext(),PDFOpener.class);
                start.putExtra("pdfFileName",item);
                startActivity(start);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String S) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate((R.menu.menu_encyclopedia_search),menu);
        MenuItem menuItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        return super.onCreateOptionsMenu(menu);

    }

    public void back(View view) {
        Intent intent = new Intent(SideEffect.this, Healthy_Knowledge.class);
        startActivity(intent);
    }
}
