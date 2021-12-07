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
import android.widget.Button;
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

public class EncyclopediaActivity extends AppCompatActivity {
    ListView pdfListView;
    ArrayList<String> stringArrayList = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encyclopedia);

        ActionBar actionBar = getSupportActionBar();
        SearchView searchView = findViewById(R.id.search_view);


        pdfListView = findViewById(R.id.myPDFList);

        stringArrayList.add("A형 간염 백신");
        stringArrayList.add("BCG 백신");
        stringArrayList.add("가정상비약");
        stringArrayList.add("감기약");
        stringArrayList.add("건선 치료제");
        stringArrayList.add("고혈압 치료제");
        stringArrayList.add("골다공증약");
        stringArrayList.add("공액리놀레산");
        stringArrayList.add("구충제");
        stringArrayList.add("국소 아토피 치료제");
        stringArrayList.add("근육이완제");
        stringArrayList.add("근육통약");
        stringArrayList.add("글리세린");
        stringArrayList.add("금연보조제");
        stringArrayList.add("나프록센");
        stringArrayList.add("녹내장 치료제");
        stringArrayList.add("뇌순환 개선제");
        stringArrayList.add("니자티딘");
        stringArrayList.add("니코틴");
        stringArrayList.add("다폭세틴");
        stringArrayList.add("당뇨병 치료제");
        stringArrayList.add("대상포진 치료제");
        stringArrayList.add("덱사메타손");
        stringArrayList.add("덱시부프로펜");
        stringArrayList.add("독시라민");
        stringArrayList.add("돔페리돈");
        stringArrayList.add("동상연고");
        stringArrayList.add("두타스테리드");
        stringArrayList.add("두통약");
        stringArrayList.add("디펜히드라민");
        stringArrayList.add("땀띠약");
        stringArrayList.add("라니티딘");
        stringArrayList.add("라도티닙");
        stringArrayList.add("라록시펜");
        stringArrayList.add("레보설피리드");
        stringArrayList.add("레보세티리진");
        stringArrayList.add("레보클로페라스틴");
        stringArrayList.add("레보티록신");
        stringArrayList.add("렘데시비르");
        stringArrayList.add("로라타딘");
        stringArrayList.add("로베글리타존");
        stringArrayList.add("로사르탄");
        stringArrayList.add("로수바스타틴");
        stringArrayList.add("로페라미드");
        stringArrayList.add("리라글루티드");
        stringArrayList.add("리바록사반");
        stringArrayList.add("멀미약");
        stringArrayList.add("메토프롤롤");
        stringArrayList.add("메트포르민");
        stringArrayList.add("메틸페니데이트");
        stringArrayList.add("멜라토닌");
        stringArrayList.add("모사프리드");
        stringArrayList.add("몬테루카스트");
        stringArrayList.add("무좀약");
        stringArrayList.add("미녹시딜");
        stringArrayList.add("미다졸람");
        stringArrayList.add("미라베그론");
        stringArrayList.add("밀크시슬엑스");
        stringArrayList.add("바레니클린");
        stringArrayList.add("발사르탄");
        stringArrayList.add("방광염 치료제");
        stringArrayList.add("배란촉진제");
        stringArrayList.add("백신");
        stringArrayList.add("벌레 물린데 바르는 약");
        stringArrayList.add("부신피질호르몬제");
        stringArrayList.add("부포테닌");
        stringArrayList.add("비듬약");
        stringArrayList.add("비마약성 진통제");
        stringArrayList.add("비사코딜");
        stringArrayList.add("비소프롤롤");
        stringArrayList.add("비염 치료제");
        stringArrayList.add("사후피임약");
        stringArrayList.add("생리 늦추는 약");
        stringArrayList.add("성장호르몬 주사");
        stringArrayList.add("세레콕시브");
        stringArrayList.add("소화성 궤양 치료제");
        stringArrayList.add("소화제");
        stringArrayList.add("손발톱무좀약");
        stringArrayList.add("수면제");
        stringArrayList.add("수용성 비타민");
        stringArrayList.add("슈도에페드린");
        stringArrayList.add("스멕타이트");
        stringArrayList.add("스피로노락톤");
        stringArrayList.add("습윤밴드");
        stringArrayList.add("시클로피록스");
        stringArrayList.add("시타글립틴");
        stringArrayList.add("시프로플록사신");
        stringArrayList.add("식염포도당");
        stringArrayList.add("식욕억제제");
        stringArrayList.add("신경안정제");
        stringArrayList.add("신종플루백신");
        stringArrayList.add("심부전 치료제");
        stringArrayList.add("아목시실린");
        stringArrayList.add("아세트아미노펜");
        stringArrayList.add("아스피린");
        stringArrayList.add("아지트로마이신");
        stringArrayList.add("아토르바스타틴");
        stringArrayList.add("아편");
        stringArrayList.add("안구건조증 치료제");
        stringArrayList.add("알벤다졸");
        stringArrayList.add("알프라졸람");
        stringArrayList.add("암브록솔");
        stringArrayList.add("암페타민");
        stringArrayList.add("에스시탈로프람");
        stringArrayList.add("에스오메프라졸");
        stringArrayList.add("에이즈 백신");
        stringArrayList.add("에이즈 치료제");
        stringArrayList.add("에제티미브");
        stringArrayList.add("여드름약");
        stringArrayList.add("역류성 식도염 치료제");
        stringArrayList.add("영양제");
        stringArrayList.add("오메프라졸");
        stringArrayList.add("오셀타미비르");
        stringArrayList.add("요실금 치료제");
        stringArrayList.add("이명치료제");
        stringArrayList.add("이버멕틴");
        stringArrayList.add("이부프로펜");
        stringArrayList.add("이상지질혈증약");
        stringArrayList.add("이소트레티노인");
        stringArrayList.add("인공눈물");
        stringArrayList.add("인플루엔자 백신");
        stringArrayList.add("인플릭시맵");
        stringArrayList.add("자궁경부암 백신");
        stringArrayList.add("자나미비르");
        stringArrayList.add("전립선비대증 치료제");
        stringArrayList.add("제산제");
        stringArrayList.add("조산방지제");
        stringArrayList.add("졸피뎀");
        stringArrayList.add("주의력결핍 과잉행동장애 치료제");
        stringArrayList.add("지사제");
        stringArrayList.add("지용성 비타민");
        stringArrayList.add("진경제");
        stringArrayList.add("진토제");
        stringArrayList.add("진통제");
        stringArrayList.add("질염약");
        stringArrayList.add("차전자피");
        stringArrayList.add("천식약");
        stringArrayList.add("치매치료제");
        stringArrayList.add("치질약");
        stringArrayList.add("칼시트리올");
        stringArrayList.add("콜린알포세레이트");
        stringArrayList.add("콜키신");
        stringArrayList.add("클로트리마졸");
        stringArrayList.add("클로피도그렐");
        stringArrayList.add("탈모 치료제");
        stringArrayList.add("테트라사이클린");
        stringArrayList.add("트라마돌");
        stringArrayList.add("트레티노인");
        stringArrayList.add("트리메부틴");
        stringArrayList.add("파모티딘");
        stringArrayList.add("팽창성 하제");
        stringArrayList.add("펜디메트라진");
        stringArrayList.add("펜터민");
        stringArrayList.add("편두통약");
        stringArrayList.add("폐렴구균백신");
        stringArrayList.add("폐렴약");
        stringArrayList.add("포도씨건조엑스");
        stringArrayList.add("퓨시드산");
        stringArrayList.add("프로포폴");
        stringArrayList.add("플루옥세틴");
        stringArrayList.add("플루코나졸");
        stringArrayList.add("피로회복제");
        stringArrayList.add("하이드로콜로이드 밴드");
        stringArrayList.add("항결핵제");
        stringArrayList.add("항말라리아제");
        stringArrayList.add("항바이러스제");
        stringArrayList.add("항불안제");
        stringArrayList.add("항생제");
        stringArrayList.add("항암제");
        stringArrayList.add("항우울제");
        stringArrayList.add("항응고제");
        stringArrayList.add("항혈소판제");
        stringArrayList.add("항히스타민제");
        stringArrayList.add("해열제");
        stringArrayList.add("향정신성의약품");
        stringArrayList.add("혈액순환제");
        stringArrayList.add("협심증 치료제");
        stringArrayList.add("화상연고");
        stringArrayList.add("흉터치료제");
        // 맨 밑에 있는 두개가 칸이 잘려서 안보이길래 공백으로 두칸 넣었음
        stringArrayList.add("");
        stringArrayList.add("");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(EncyclopediaActivity.this,android.R.layout.simple_list_item_1,stringArrayList)
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

//    public void GoNews(View view){
//        Button GoNews = findViewById(R.id.en_btn1);
//        Intent intent1 = new Intent(this,News.class);
//        startActivity(intent1);
//    }
//
//    public void GoSideEffect(View view){
//        Button GoSideEffect = findViewById(R.id.en_btn2);
//        Intent intent2 = new Intent(this,SideEffect.class);
//        startActivity(intent2);
//    }

    public void back(View view) {
        Intent intent = new Intent(EncyclopediaActivity.this, Healthy_Knowledge.class);
        startActivity(intent);
    }
}