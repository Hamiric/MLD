package com.example.mld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFOpener extends AppCompatActivity {

    PDFView myPDFViewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopner);

        myPDFViewer = (PDFView) findViewById(R.id.pdfViewer);

        String getItem = getIntent().getStringExtra("pdfFileName");

        if(getItem.equals("알벤다졸")){
            myPDFViewer.fromAsset("약물백과/알벤다졸.pdf").load();
        }

        if(getItem.equals("편두통약")){
            myPDFViewer.fromAsset("약물백과/편두통약.pdf").load();
        }

        if(getItem.equals("항히스타민제")){
            myPDFViewer.fromAsset("약물백과/항히스타민제.pdf").load();
        }

        if(getItem.equals("아스피린")){
            myPDFViewer.fromAsset("약물백과/아스피린.pdf").load();
        }

        if(getItem.equals("사후피임약")){
            myPDFViewer.fromAsset("약물백과/사후피임약.pdf").load();
        }

        if(getItem.equals("라니티딘")){
            myPDFViewer.fromAsset("약물백과/라니티딘.pdf").load();
        }

        if(getItem.equals("에이즈 백신")){
            myPDFViewer.fromAsset("약물백과/에이즈 백신.pdf").load();
        }

        if(getItem.equals("프로포폴")){
            myPDFViewer.fromAsset("약물백과/프로포폴.pdf").load();
        }

        if(getItem.equals("신경안정제")){
            myPDFViewer.fromAsset("약물백과/신경안정제.pdf").load();
        }

        if(getItem.equals("레보세티리진")){
            myPDFViewer.fromAsset("약물백과/레보세티리진.pdf").load();
        }

        if(getItem.equals("흉터치료제")){
            myPDFViewer.fromAsset("약물백과/흉터치료제.pdf").load();
        }

        if(getItem.equals("펜터민")){
            myPDFViewer.fromAsset("약물백과/펜터민.pdf").load();
        }

        if(getItem.equals("생리 늦추는 약")){
            myPDFViewer.fromAsset("약물백과/생리 늦추는 약.pdf").load();
        }

        if(getItem.equals("클로트리마졸")){
            myPDFViewer.fromAsset("약물백과/클로트리마졸.pdf").load();
        }

        if(getItem.equals("식욕억제제")){
            myPDFViewer.fromAsset("약물백과/식욕억제제.pdf").load();
        }

        if(getItem.equals("메토프롤롤")){
            myPDFViewer.fromAsset("약물백과/메토프롤롤.pdf").load();
        }

        if(getItem.equals("항생제")){
            myPDFViewer.fromAsset("약물백과/항생제.pdf").load();
        }

        if(getItem.equals("식염포도당")){
            myPDFViewer.fromAsset("약물백과/식염포도당.pdf").load();
        }

        if(getItem.equals("습윤밴드")){
            myPDFViewer.fromAsset("약물백과/습윤밴드.pdf").load();
        }

        if(getItem.equals("레보설피리드")){
            myPDFViewer.fromAsset("약물백과/레보설피리드.pdf").load();
        }

        if(getItem.equals("인공눈물")){
            myPDFViewer.fromAsset("약물백과/인공눈물.pdf").load();
        }

        if(getItem.equals("니자티딘")){
            myPDFViewer.fromAsset("약물백과/니자티딘.pdf").load();
        }

        if(getItem.equals("화상연고")){
            myPDFViewer.fromAsset("약물백과/화상연고.pdf").load();
        }

        if(getItem.equals("두타스테리드")){
            myPDFViewer.fromAsset("약물백과/두타스테리드.pdf").load();
        }

        if(getItem.equals("진토제")){
            myPDFViewer.fromAsset("약물백과/진토제.pdf").load();
        }

        if(getItem.equals("아토르바스타틴")){
            myPDFViewer.fromAsset("약물백과/아토르바스타틴.pdf").load();
        }

        if(getItem.equals("구충제")){
            myPDFViewer.fromAsset("약물백과/구충제.pdf").load();
        }

        if(getItem.equals("글리세린")){
            myPDFViewer.fromAsset("약물백과/글리세린.pdf").load();
        }

        if(getItem.equals("제산제")){
            myPDFViewer.fromAsset("약물백과/제산제.pdf").load();
        }

        if(getItem.equals("아목시실린")){
            myPDFViewer.fromAsset("약물백과/아목시실린.pdf").load();
        }

        if(getItem.equals("항우울제")){
            myPDFViewer.fromAsset("약물백과/항우울제.pdf").load();
        }

        if(getItem.equals("메틸페니데이트")){
            myPDFViewer.fromAsset("약물백과/메틸페니데이트.pdf").load();
        }

        if(getItem.equals("두통약")){
            myPDFViewer.fromAsset("약물백과/두통약.pdf").load();
        }

        if(getItem.equals("트리메부틴")){
            myPDFViewer.fromAsset("약물백과/트리메부틴.pdf").load();
        }

        if(getItem.equals("인플루엔자 백신")){
            myPDFViewer.fromAsset("약물백과/인플루엔자 백신.pdf").load();
        }

        if(getItem.equals("나프록센")){
            myPDFViewer.fromAsset("약물백과/나프록센.pdf").load();
        }

        if(getItem.equals("치질약")){
            myPDFViewer.fromAsset("약물백과/치질약.pdf").load();
        }

        if(getItem.equals("덱사메타손")){
            myPDFViewer.fromAsset("약물백과/덱사메타손.pdf").load();
        }

        if(getItem.equals("근육이완제")){
            myPDFViewer.fromAsset("약물백과/근육이완제.pdf").load();
        }

        if(getItem.equals("졸피뎀")){
            myPDFViewer.fromAsset("약물백과/졸피뎀.pdf").load();
        }

        if(getItem.equals("항혈소판제")){
            myPDFViewer.fromAsset("약물백과/항혈소판제.pdf").load();
        }

        if(getItem.equals("오메프라졸")){
            myPDFViewer.fromAsset("약물백과/오메프라졸.pdf").load();
        }

        if(getItem.equals("금연보조제")){
            myPDFViewer.fromAsset("약물백과/금연보조제.pdf").load();
        }

        if(getItem.equals("미다졸람")){
            myPDFViewer.fromAsset("약물백과/미다졸람.pdf").load();
        }

        if(getItem.equals("녹내장 치료제")){
            myPDFViewer.fromAsset("약물백과/녹내장 치료제.pdf").load();
        }

        if(getItem.equals("스피로노락톤")){
            myPDFViewer.fromAsset("약물백과/스피로노락톤.pdf").load();
        }

        if(getItem.equals("해열제")){
            myPDFViewer.fromAsset("약물백과/해열제.pdf").load();
        }

        if(getItem.equals("로페라미드")){
            myPDFViewer.fromAsset("약물백과/로페라미드.pdf").load();
        }

        if(getItem.equals("성장호르몬 주사")){
            myPDFViewer.fromAsset("약물백과/성장호르몬 주사.pdf").load();
        }

        if(getItem.equals("로베글리타존")){
            myPDFViewer.fromAsset("약물백과/로베글리타존.pdf").load();
        }

        if(getItem.equals("손발톱무좀약")){
            myPDFViewer.fromAsset("약물백과/손발톱무좀약.pdf").load();
        }

        if(getItem.equals("다폭세틴")){
            myPDFViewer.fromAsset("약물백과/다폭세틴.pdf").load();
        }

        if(getItem.equals("주의력결핍 과잉행동장애 치료제")){
            myPDFViewer.fromAsset("약물백과/주의력결핍 과잉행동장애 치료제.pdf").load();
        }

        if(getItem.equals("부포테닌")){
            myPDFViewer.fromAsset("약물백과/부포테닌.pdf").load();
        }

        if(getItem.equals("수면제")){
            myPDFViewer.fromAsset("약물백과/수면제.pdf").load();
        }

        if(getItem.equals("암페타민")){
            myPDFViewer.fromAsset("약물백과/암페타민.pdf").load();
        }

        if(getItem.equals("A형 간염 백신")){
            myPDFViewer.fromAsset("약물백과/A형 간염 백신.pdf").load();
        }

        if(getItem.equals("아편")){
            myPDFViewer.fromAsset("약물백과/아편.pdf").load();
        }

        if(getItem.equals("향정신성의약품")){
            myPDFViewer.fromAsset("약물백과/향정신성의약품.pdf").load();
        }

        if(getItem.equals("세레콕시브")){
            myPDFViewer.fromAsset("약물백과/세레콕시브.pdf").load();
        }

        if(getItem.equals("항결핵제")){
            myPDFViewer.fromAsset("약물백과/항결핵제.pdf").load();
        }

        if(getItem.equals("로수바스타틴")){
            myPDFViewer.fromAsset("약물백과/로수바스타틴.pdf").load();
        }

        if(getItem.equals("지사제")){
            myPDFViewer.fromAsset("약물백과/지사제.pdf").load();
        }

        if(getItem.equals("시클로피록스")){
            myPDFViewer.fromAsset("약물백과/시클로피록스.pdf").load();
        }

        if(getItem.equals("여드름약")){
            myPDFViewer.fromAsset("약물백과/여드름약.pdf").load();
        }

        if(getItem.equals("콜린알포세레이트")){
            myPDFViewer.fromAsset("약물백과/콜린알포세레이트.pdf").load();
        }

        if(getItem.equals("벌레 물린데 바르는 약")){
            myPDFViewer.fromAsset("약물백과/벌레 물린데 바르는 약.pdf").load();
        }

        if(getItem.equals("퓨시드산")){
            myPDFViewer.fromAsset("약물백과/퓨시드산.pdf").load();
        }

        if(getItem.equals("탈모 치료제")){
            myPDFViewer.fromAsset("약물백과/탈모 치료제.pdf").load();
        }

        if(getItem.equals("펜디메트라진")){
            myPDFViewer.fromAsset("약물백과/펜디메트라진.pdf").load();
        }

        if(getItem.equals("방광염 치료제")){
            myPDFViewer.fromAsset("약물백과/방광염 치료제.pdf").load();
        }

        if(getItem.equals("슈도에페드린")){
            myPDFViewer.fromAsset("약물백과/슈도에페드린.pdf").load();
        }

        if(getItem.equals("피로회복제")){
            myPDFViewer.fromAsset("약물백과/피로회복제.pdf").load();
        }

        if(getItem.equals("모사프리드")){
            myPDFViewer.fromAsset("약물백과/모사프리드.pdf").load();
        }

        if(getItem.equals("소화성 궤양 치료제")){
            myPDFViewer.fromAsset("약물백과/소화성 궤양 치료제.pdf").load();
        }

        if(getItem.equals("파모티딘")){
            myPDFViewer.fromAsset("약물백과/파모티딘.pdf").load();
        }

        if(getItem.equals("신종플루백신")){
            myPDFViewer.fromAsset("약물백과/신종플루백신.pdf").load();
        }

        if(getItem.equals("오셀타미비르")){
            myPDFViewer.fromAsset("약물백과/오셀타미비르.pdf").load();
        }

        if(getItem.equals("뇌순환 개선제")){
            myPDFViewer.fromAsset("약물백과/뇌순환 개선제.pdf").load();
        }

        if(getItem.equals("레보클로페라스틴")){
            myPDFViewer.fromAsset("약물백과/레보클로페라스틴.pdf").load();
        }

        if(getItem.equals("진통제")){
            myPDFViewer.fromAsset("약물백과/진통제.pdf").load();
        }

        if(getItem.equals("몬테루카스트")){
            myPDFViewer.fromAsset("약물백과/몬테루카스트.pdf").load();
        }

        if(getItem.equals("협심증 치료제")){
            myPDFViewer.fromAsset("약물백과/협심증 치료제.pdf").load();
        }

        if(getItem.equals("비소프롤롤")){
            myPDFViewer.fromAsset("약물백과/비소프롤롤.pdf").load();
        }

        if(getItem.equals("건선 치료제")){
            myPDFViewer.fromAsset("약물백과/건선 치료제.pdf").load();
        }

        if(getItem.equals("에스오메프라졸")){
            myPDFViewer.fromAsset("약물백과/에스오메프라졸.pdf").load();
        }

        if(getItem.equals("당뇨병 치료제")){
            myPDFViewer.fromAsset("약물백과/당뇨병 치료제.pdf").load();
        }

        if(getItem.equals("메트포르민")){
            myPDFViewer.fromAsset("약물백과/메트포르민.pdf").load();
        }

        if(getItem.equals("팽창성 하제")){
            myPDFViewer.fromAsset("약물백과/팽창성 하제.pdf").load();
        }

        if(getItem.equals("차전자피")){
            myPDFViewer.fromAsset("약물백과/차전자피.pdf").load();
        }

        if(getItem.equals("폐렴구균백신")){
            myPDFViewer.fromAsset("약물백과/폐렴구균백신.pdf").load();
        }

        if(getItem.equals("플루옥세틴")){
            myPDFViewer.fromAsset("약물백과/플루옥세틴.pdf").load();
        }

        if(getItem.equals("항바이러스제")){
            myPDFViewer.fromAsset("약물백과/항바이러스제.pdf").load();
        }

        if(getItem.equals("아지트로마이신")){
            myPDFViewer.fromAsset("약물백과/아지트로마이신.pdf").load();
        }

        if(getItem.equals("에이즈 치료제")){
            myPDFViewer.fromAsset("약물백과/에이즈 치료제.pdf").load();
        }

        if(getItem.equals("리라글루티드")){
            myPDFViewer.fromAsset("약물백과/리라글루티드.pdf").load();
        }

        if(getItem.equals("항말라리아제")){
            myPDFViewer.fromAsset("약물백과/항말라리아제.pdf").load();
        }

        if(getItem.equals("자나미비르")){
            myPDFViewer.fromAsset("약물백과/자나미비르.pdf").load();
        }

        if(getItem.equals("천식약")){
            myPDFViewer.fromAsset("약물백과/천식약.pdf").load();
        }

        if(getItem.equals("아세트아미노펜")){
            myPDFViewer.fromAsset("약물백과/아세트아미노펜.pdf").load();
        }

        if(getItem.equals("비마약성 진통제")){
            myPDFViewer.fromAsset("약물백과/비마약성 진통제.pdf").load();
        }

        if(getItem.equals("이부프로펜")){
            myPDFViewer.fromAsset("약물백과/이부프로펜.pdf").load();
        }

        if(getItem.equals("감기약")){
            myPDFViewer.fromAsset("약물백과/감기약.pdf").load();
        }

        if(getItem.equals("이버멕틴")){
            myPDFViewer.fromAsset("약물백과/이버멕틴.pdf").load();
        }

        if(getItem.equals("항불안제")){
            myPDFViewer.fromAsset("약물백과/항불안제.pdf").load();
        }

        if(getItem.equals("에스시탈로프람")){
            myPDFViewer.fromAsset("약물백과/에스시탈로프람.pdf").load();
        }

        if(getItem.equals("영양제")){
            myPDFViewer.fromAsset("약물백과/영양제.pdf").load();
        }

        if(getItem.equals("시프로플록사신")){
            myPDFViewer.fromAsset("약물백과/시프로플록사신.pdf").load();
        }

        if(getItem.equals("소화제")){
            myPDFViewer.fromAsset("약물백과/소화제.pdf").load();
        }

        if(getItem.equals("클로피도그렐")){
            myPDFViewer.fromAsset("약물백과/클로피도그렐.pdf").load();
        }

        if(getItem.equals("이상지질혈증약")){
            myPDFViewer.fromAsset("약물백과/이상지질혈증약.pdf").load();
        }

        if(getItem.equals("이소트레티노인")){
            myPDFViewer.fromAsset("약물백과/이소트레티노인.pdf").load();
        }

        if(getItem.equals("부신피질호르몬제")){
            myPDFViewer.fromAsset("약물백과/부신피질호르몬제.pdf").load();
        }

        if(getItem.equals("플루코나졸")){
            myPDFViewer.fromAsset("약물백과/플루코나졸.pdf").load();
        }

        if(getItem.equals("대상포진 치료제")){
            myPDFViewer.fromAsset("약물백과/대상포진 치료제.pdf").load();
        }

        if(getItem.equals("라록시펜")){
            myPDFViewer.fromAsset("약물백과/라록시펜.pdf").load();
        }

        if(getItem.equals("땀띠약")){
            myPDFViewer.fromAsset("약물백과/땀띠약.pdf").load();
        }

        if(getItem.equals("디펜히드라민")){
            myPDFViewer.fromAsset("약물백과/디펜히드라민.pdf").load();
        }

        if(getItem.equals("멀미약")){
            myPDFViewer.fromAsset("약물백과/멀미약.pdf").load();
        }

        if(getItem.equals("스멕타이트")){
            myPDFViewer.fromAsset("약물백과/스멕타이트.pdf").load();
        }

        if(getItem.equals("국소 아토피 치료제")){
            myPDFViewer.fromAsset("약물백과/국소 아토피 치료제.pdf").load();
        }

        if(getItem.equals("멜라토닌")){
            myPDFViewer.fromAsset("약물백과/멜라토닌.pdf").load();
        }

        if(getItem.equals("진경제")){
            myPDFViewer.fromAsset("약물백과/진경제.pdf").load();
        }

        if(getItem.equals("발사르탄")){
            myPDFViewer.fromAsset("약물백과/발사르탄.pdf").load();
        }

        if(getItem.equals("수용성 비타민")){
            myPDFViewer.fromAsset("약물백과/수용성 비타민.pdf").load();
        }

        if(getItem.equals("알프라졸람")){
            myPDFViewer.fromAsset("약물백과/알프라졸람.pdf").load();
        }

        if(getItem.equals("지용성 비타민")){
            myPDFViewer.fromAsset("약물백과/지용성 비타민.pdf").load();
        }

        if(getItem.equals("돔페리돈")){
            myPDFViewer.fromAsset("약물백과/돔페리돈.pdf").load();
        }

        if(getItem.equals("비염 치료제")){
            myPDFViewer.fromAsset("약물백과/비염 치료제.pdf").load();
        }

        if(getItem.equals("암브록솔")){
            myPDFViewer.fromAsset("약물백과/암브록솔.pdf").load();
        }

        if(getItem.equals("비듬약")){
            myPDFViewer.fromAsset("약물백과/비듬약.pdf").load();
        }

        if(getItem.equals("인플릭시맵")){
            myPDFViewer.fromAsset("약물백과/인플릭시맵.pdf").load();
        }

        if(getItem.equals("안구건조증 치료제")){
            myPDFViewer.fromAsset("약물백과/안구건조증 치료제.pdf").load();
        }

        if(getItem.equals("라도티닙")){
            myPDFViewer.fromAsset("약물백과/라도티닙.pdf").load();
        }

        if(getItem.equals("치매치료제")){
            myPDFViewer.fromAsset("약물백과/치매치료제.pdf").load();
        }

        if(getItem.equals("미라베그론")){
            myPDFViewer.fromAsset("약물백과/미라베그론.pdf").load();
        }

        if(getItem.equals("혈액순환제")){
            myPDFViewer.fromAsset("약물백과/혈액순환제.pdf").load();
        }

        if(getItem.equals("비사코딜")){
            myPDFViewer.fromAsset("약물백과/비사코딜.pdf").load();
        }

        if(getItem.equals("백신")){
            myPDFViewer.fromAsset("약물백과/백신.pdf").load();
        }

        if(getItem.equals("리바록사반")){
            myPDFViewer.fromAsset("약물백과/리바록사반.pdf").load();
        }

        if(getItem.equals("동상연고")){
            myPDFViewer.fromAsset("약물백과/동상연고.pdf").load();
        }

        if(getItem.equals("니코틴")){
            myPDFViewer.fromAsset("약물백과/니코틴.pdf").load();
        }

        if(getItem.equals("근육통약")){
            myPDFViewer.fromAsset("약물백과/근육통약.pdf").load();
        }

        if(getItem.equals("미녹시딜")){
            myPDFViewer.fromAsset("약물백과/미녹시딜.pdf").load();
        }

        if(getItem.equals("요실금 치료제")){
            myPDFViewer.fromAsset("약물백과/요실금 치료제.pdf").load();
        }

        if(getItem.equals("시타글립틴")){
            myPDFViewer.fromAsset("약물백과/시타글립틴.pdf").load();
        }

        if(getItem.equals("골다공증약")){
            myPDFViewer.fromAsset("약물백과/골다공증약.pdf").load();
        }

        if(getItem.equals("트라마돌")){
            myPDFViewer.fromAsset("약물백과/트라마돌.pdf").load();
        }

        if(getItem.equals("역류성 식도염 치료제")){
            myPDFViewer.fromAsset("약물백과/역류성 식도염 치료제.pdf").load();
        }

        if(getItem.equals("렘데시비르")){
            myPDFViewer.fromAsset("약물백과/렘데시비르.pdf").load();
        }

        if(getItem.equals("폐렴약")){
            myPDFViewer.fromAsset("약물백과/폐렴약.pdf").load();
        }

        if(getItem.equals("밀크시슬엑스")){
            myPDFViewer.fromAsset("약물백과/밀크시슬엑스.pdf").load();
        }

        if(getItem.equals("하이드로콜로이드 밴드")){
            myPDFViewer.fromAsset("약물백과/하이드로콜로이드 밴드.pdf").load();
        }

        if(getItem.equals("에제티미브")){
            myPDFViewer.fromAsset("약물백과/에제티미브.pdf").load();
        }

        if(getItem.equals("조산방지제")){
            myPDFViewer.fromAsset("약물백과/조산방지제.pdf").load();
        }

        if(getItem.equals("칼시트리올")){
            myPDFViewer.fromAsset("약물백과/칼시트리올.pdf").load();
        }

        if(getItem.equals("BCG 백신")){
            myPDFViewer.fromAsset("약물백과/BCG 백신.pdf").load();
        }

        if(getItem.equals("로라타딘")){
            myPDFViewer.fromAsset("약물백과/로라타딘.pdf").load();
        }

        if(getItem.equals("항응고제")){
            myPDFViewer.fromAsset("약물백과/항응고제.pdf").load();
        }

        if(getItem.equals("레보티록신")){
            myPDFViewer.fromAsset("약물백과/레보티록신.pdf").load();
        }

        if(getItem.equals("심부전 치료제")){
            myPDFViewer.fromAsset("약물백과/심부전 치료제.pdf").load();
        }

        if(getItem.equals("콜키신")){
            myPDFViewer.fromAsset("약물백과/콜키신.pdf").load();
        }

        if(getItem.equals("무좀약")){
            myPDFViewer.fromAsset("약물백과/무좀약.pdf").load();
        }

        if(getItem.equals("포도씨건조엑스")){
            myPDFViewer.fromAsset("약물백과/포도씨건조엑스.pdf").load();
        }

        if(getItem.equals("질염약")){
            myPDFViewer.fromAsset("약물백과/질염약.pdf").load();
        }

        if(getItem.equals("테트라사이클린")){
            myPDFViewer.fromAsset("약물백과/테트라사이클린.pdf").load();
        }

        if(getItem.equals("전립선비대증 치료제")){
            myPDFViewer.fromAsset("약물백과/전립선비대증 치료제.pdf").load();
        }

        if(getItem.equals("공액리놀레산")){
            myPDFViewer.fromAsset("약물백과/공액리놀레산.pdf").load();
        }

        if(getItem.equals("항암제")){
            myPDFViewer.fromAsset("약물백과/항암제.pdf").load();
        }

        if(getItem.equals("독시라민")){
            myPDFViewer.fromAsset("약물백과/독시라민.pdf").load();
        }

        if(getItem.equals("가정상비약")){
            myPDFViewer.fromAsset("약물백과/가정상비약.pdf").load();
        }

        if(getItem.equals("트레티노인")){
            myPDFViewer.fromAsset("약물백과/트레티노인.pdf").load();
        }

        if(getItem.equals("자궁경부암 백신")){
            myPDFViewer.fromAsset("약물백과/자궁경부암 백신.pdf").load();
        }

        if(getItem.equals("덱시부프로펜")){
            myPDFViewer.fromAsset("약물백과/덱시부프로펜.pdf").load();
        }

        if(getItem.equals("고혈압 치료제")){
            myPDFViewer.fromAsset("약물백과/고혈압 치료제.pdf").load();
        }

        if(getItem.equals("바레니클린")){
            myPDFViewer.fromAsset("약물백과/바레니클린.pdf").load();
        }

        if(getItem.equals("배란촉진제")){
            myPDFViewer.fromAsset("약물백과/배란촉진제.pdf").load();
        }

        if(getItem.equals("로사르탄")){
            myPDFViewer.fromAsset("약물백과/로사르탄.pdf").load();
        }

        if(getItem.equals("이명치료제")){
            myPDFViewer.fromAsset("약물백과/이명치료제.pdf").load();
        }

        if(getItem.equals("2개의 일반적인 체중감량 수술을 비교한 연구")){
            myPDFViewer.fromAsset("해외의약뉴스/2개의 일반적인 체중감량 수술을 비교한 연구.pdf").load();
        }

        if(getItem.equals("40세 미만의 대상포진 환자에서 뇌졸중 발생 위험이 증가할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/40세 미만의 대상포진 환자에서 뇌졸중 발생 위험이 증가할 수 있다.pdf").load();
        }

        if(getItem.equals("ADHD 의약품이 폐경기 여성에게도 도움이 될 수 있을까")){
            myPDFViewer.fromAsset("해외의약뉴스/ADHD 의약품이 폐경기 여성에게도 도움이 될 수 있을까.pdf").load();
        }

        if(getItem.equals("ADHD 치료제가 비만 위험의 증가와 관련이 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/ADHD 치료제가 비만 위험의 증가와 관련이 있다.pdf").load();
        }

        if(getItem.equals("ASHP 가이드라인 - 약사의 환자 교육과 상담 (1)")){
            myPDFViewer.fromAsset("해외의약뉴스/ASHP 가이드라인 - 약사의 환자 교육과 상담 (1).pdf").load();
        }

        if(getItem.equals("ASHP 가이드라인 - 약사의 환자 교육과 상담 (2)")){
            myPDFViewer.fromAsset("해외의약뉴스/ASHP 가이드라인 - 약사의 환자 교육과 상담 (2).pdf").load();
        }

        if(getItem.equals("C형 간염과 연관된 두경부암")){
            myPDFViewer.fromAsset("해외의약뉴스/C형 간염과 연관된 두경부암.pdf").load();
        }

        if(getItem.equals("FDA에서는 암젠의 심부전 치료약을 승인한다")){
            myPDFViewer.fromAsset("해외의약뉴스/FDA에서는 암젠의 심부전 치료약을 승인한다.pdf").load();
        }

        if(getItem.equals("가장 효과적인 모기 기피제 선택 방법")){
            myPDFViewer.fromAsset("해외의약뉴스/가장 효과적인 모기 기피제 선택 방법.pdf").load();
        }

        if(getItem.equals("가정보관의약품(family medication)을 안전하게 관리하는 간단한 3가지 방법")){
            myPDFViewer.fromAsset("해외의약뉴스/가정보관의약품(family medication)을 안전하게 관리하는 간단한 3가지 방법.pdf").load();
        }

        if(getItem.equals("가정에서 사용하는 살충제 스프레이의 어린이암 유발 가능성")){
            myPDFViewer.fromAsset("해외의약뉴스/가정에서 사용하는 살충제 스프레이의 어린이암 유발 가능성.pdf").load();
        }

        if(getItem.equals("갑상선기능항진증-유방암 연관성")){
            myPDFViewer.fromAsset("해외의약뉴스/갑상선기능항진증-유방암 연관성.pdf").load();
        }

        if(getItem.equals("갑작스런 혈압 강하, 치매 위험 높일 수 있어")){
            myPDFViewer.fromAsset("해외의약뉴스/갑작스런 혈압 강하, 치매 위험 높일 수 있어.pdf").load();
        }

        if(getItem.equals("개국약국에서의 당뇨병 및 심혈관질환의 위험요인에 대한 스크리닝의 효과 (1)")){
            myPDFViewer.fromAsset("해외의약뉴스/개국약국에서의 당뇨병 및 심혈관질환의 위험요인에 대한 스크리닝의 효과 (1).pdf").load();
        }

        if(getItem.equals("개국약국에서의 당뇨병 및 심혈관질환의 위험요인에 대한 스크리닝의 효과 (2)")){
            myPDFViewer.fromAsset("해외의약뉴스/개국약국에서의 당뇨병 및 심혈관질환의 위험요인에 대한 스크리닝의 효과 (2).pdf").load();
        }

        if(getItem.equals("개정된 콜레스테롤 가이드라인은 심혈관질환 위험을 정확하게 확인한다")){
            myPDFViewer.fromAsset("해외의약뉴스/개정된 콜레스테롤 가이드라인은 심혈관질환 위험을 정확하게 확인한다.pdf").load();
        }

        if(getItem.equals("건강상태를 추적하는 전자피부")){
            myPDFViewer.fromAsset("해외의약뉴스/건강상태를 추적하는 전자피부.pdf").load();
        }

        if(getItem.equals("경도인지 장애 환자의 기억력 향상시킬 수 있는 게임 앱 개발")){
            myPDFViewer.fromAsset("해외의약뉴스/경도인지 장애 환자의 기억력 향상시킬 수 있는 게임 앱 개발.pdf").load();
        }

        if(getItem.equals("고농도의 염이 포함된 발포정은 심장질환 환자에게 부담을 줄 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/고농도의 염이 포함된 발포정은 심장질환 환자에게 부담을 줄 수 있다.pdf").load();
        }

        if(getItem.equals("고용량의 비타민 E 복용이 알츠하이머병의 진행 속도를 늦출 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/고용량의 비타민 E 복용이 알츠하이머병의 진행 속도를 늦출 수 있다.pdf").load();
        }

        if(getItem.equals("고지방 음식을 섭취하더라도 체중증가를 피할 수 있다면")){
            myPDFViewer.fromAsset("해외의약뉴스/고지방 음식을 섭취하더라도 체중증가를 피할 수 있다면.pdf").load();
        }

        if(getItem.equals("고지혈증 치료제가 잇몸염증을 감소시킨다")){
            myPDFViewer.fromAsset("해외의약뉴스/고지혈증 치료제가 잇몸염증을 감소시킨다.pdf").load();
        }

        if(getItem.equals("고추 성분이 유방암 억제할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/고추 성분이 유방암 억제할 수 있다.pdf").load();
        }

        if(getItem.equals("고칼로리 식이요법이 루게릭병의 진행속도를 늦출 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/고칼로리 식이요법이 루게릭병의 진행속도를 늦출 수 있다.pdf").load();
        }

        if(getItem.equals("공기오염이 제2형 당뇨병 위험 높일 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/공기오염이 제2형 당뇨병 위험 높일 수 있다.pdf").load();
        }

        if(getItem.equals("과도한 녹차섭취는 건강에 해로운가")){
            myPDFViewer.fromAsset("해외의약뉴스/과도한 녹차섭취는 건강에 해로운가.pdf").load();
        }

        if(getItem.equals("과민성 대장증후군(IBS)과 연관된 비타민D 결핍")){
            myPDFViewer.fromAsset("해외의약뉴스/과민성 대장증후군(IBS)과 연관된 비타민D 결핍.pdf").load();
        }

        if(getItem.equals("궤양성 대장염, 식초로 치료할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/궤양성 대장염, 식초로 치료할 수 있다.pdf").load();
        }

        if(getItem.equals("규칙적으로 샤워하더라도 피부 미생물은 여전히 남아있다")){
            myPDFViewer.fromAsset("해외의약뉴스/규칙적으로 샤워하더라도 피부 미생물은 여전히 남아있다.pdf").load();
        }

        if(getItem.equals("규칙적인 식습관, 심질환 예방에 도움 된다")){
            myPDFViewer.fromAsset("해외의약뉴스/규칙적인 식습관, 심질환 예방에 도움 된다.pdf").load();
        }

        if(getItem.equals("금연을 위한 지역약국 기반의 약물학적 중재와 방법에 대한 고찰 (1)")){
            myPDFViewer.fromAsset("해외의약뉴스/금연을 위한 지역약국 기반의 약물학적 중재와 방법에 대한 고찰 (1).pdf").load();
        }

        if(getItem.equals("금연을 위한 지역약국 기반의 약물학적 중재와 방법에 대한 고찰 (2)")){
            myPDFViewer.fromAsset("해외의약뉴스/금연을 위한 지역약국 기반의 약물학적 중재와 방법에 대한 고찰 (2).pdf").load();
        }

        if(getItem.equals("기존 항암치료 뛰어 넘는 새로운 암 세포 사멸 기술 발견")){
            myPDFViewer.fromAsset("해외의약뉴스/기존 항암치료 뛰어 넘는 새로운 암 세포 사멸 기술 발견.pdf").load();
        }

        if(getItem.equals("남성 유방암 관련 단백질 발견, 새로운 치료의 길 열릴까")){
            myPDFViewer.fromAsset("해외의약뉴스/남성 유방암 관련 단백질 발견, 새로운 치료의 길 열릴까.pdf").load();
        }

        if(getItem.equals("낭포성 섬유증 치료제가 FDA 자문 패널의 승인을 받다")){
            myPDFViewer.fromAsset("해외의약뉴스/낭포성 섬유증 치료제가 FDA 자문 패널의 승인을 받다.pdf").load();
        }

        if(getItem.equals("낮은 수치의 비타민 D는 질병의 원인보다는 결과와 관련이 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/낮은 수치의 비타민 D는 질병의 원인보다는 결과와 관련이 있다.pdf").load();
        }

        if(getItem.equals("낮잠 1시간, 노인 기억력 향상에 도움 된다")){
            myPDFViewer.fromAsset("해외의약뉴스/낮잠 1시간, 노인 기억력 향상에 도움 된다.pdf").load();
        }

        if(getItem.equals("노인에게 독감 백신이 덜 효과적인 이유")){
            myPDFViewer.fromAsset("해외의약뉴스/노인에게 독감 백신이 덜 효과적인 이유.pdf").load();
        }

        if(getItem.equals("높은 에스트로겐 수치와 당뇨는 치매 위험을 증가시킨다")){
            myPDFViewer.fromAsset("해외의약뉴스/높은 에스트로겐 수치와 당뇨는 치매 위험을 증가시킨다.pdf").load();
        }

        if(getItem.equals("높은 혈당은 알츠하이머 질병의 원인이 될 수 있을까")){
            myPDFViewer.fromAsset("해외의약뉴스/높은 혈당은 알츠하이머 질병의 원인이 될 수 있을까.pdf").load();
        }

        if(getItem.equals("뇌 MRI 촬영으로 자살 위험 예측할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/뇌 MRI 촬영으로 자살 위험 예측할 수 있다.pdf").load();
        }

        if(getItem.equals("뇌질환으로서의 비만, 새로운 치료법")){
            myPDFViewer.fromAsset("해외의약뉴스/뇌질환으로서의 비만, 새로운 치료법.pdf").load();
        }

        if(getItem.equals("다발성 경화증이나 건선치료에 쓰이는 의약품의 성분이 두 개의 치명적 뇌 감염과 관련이 있다고 밝혀졌다. 하지만 전문가들은 이 합병증은 드문 것이고 약을 중단할 필요는 없다고 말한다")){
            myPDFViewer.fromAsset("해외의약뉴스/다발성 경화증이나 건선치료에 쓰이는 의약품의 성분이 두 개의 치명적 뇌 감염과 관련이 있다고 밝혀졌다. 하지만 전문가들은 이 합병증은 드문 것이고 약을 중단할 필요는 없다고 말한다.pdf").load();
        }

        if(getItem.equals("당뇨병 약은 심부전 위험을 악화시키지 않는다")){
            myPDFViewer.fromAsset("해외의약뉴스/당뇨병 약은 심부전 위험을 악화시키지 않는다.pdf").load();
        }

        if(getItem.equals("당뇨병, 패취제로 인슐린 투여 가능해진다")){
            myPDFViewer.fromAsset("해외의약뉴스/당뇨병, 패취제로 인슐린 투여 가능해진다.pdf").load();
        }

        if(getItem.equals("당뇨병성 신장 질환에서 ACE 억제제와 ARB 제제를 병용투여하면 신장에 손상을 줄 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/당뇨병성 신장 질환에서 ACE 억제제와 ARB 제제를 병용투여하면 신장에 손상을 줄 수 있다.pdf").load();
        }

        if(getItem.equals("당뇨약 메트포르민은 일부 환자에게서 갑상선 기능에 영향을 미칠 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/당뇨약 메트포르민은 일부 환자에게서 갑상선 기능에 영향을 미칠 수 있다.pdf").load();
        }

        if(getItem.equals("대학생의 17% 가 ADHD 약물을 남용하고 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/대학생의 17% 가 ADHD 약물을 남용하고 있다.pdf").load();
        }

        if(getItem.equals("류마티스 관절염 있으면 만성폐쇄성폐질환(COPD) 위험 높아질 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/류마티스 관절염 있으면 만성폐쇄성폐질환(COPD) 위험 높아질 수 있다.pdf").load();
        }

        if(getItem.equals("마그네슘이 혈압을 조절할 수 있을까")){
            myPDFViewer.fromAsset("해외의약뉴스/마그네슘이 혈압을 조절할 수 있을까.pdf").load();
        }

        if(getItem.equals("만성 신경통의 새로운 기전 밝혀져 - 새로운 치료법 개발 기대")){
            myPDFViewer.fromAsset("해외의약뉴스/만성 신경통의 새로운 기전 밝혀져 - 새로운 치료법 개발 기대.pdf").load();
        }

        if(getItem.equals("만성적인 수면 방해, 간암 위험 높일 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/만성적인 수면 방해, 간암 위험 높일 수 있다.pdf").load();
        }

        if(getItem.equals("매일 견과류 한 줌, 여러 질환 및 사망 위험 낮춘다")){
            myPDFViewer.fromAsset("해외의약뉴스/매일 견과류 한 줌, 여러 질환 및 사망 위험 낮춘다.pdf").load();
        }

        if(getItem.equals("매일 아스피린을 복용하는 것이 난소암의 위험을 20퍼센트 낮춘다")){
            myPDFViewer.fromAsset("해외의약뉴스/매일 아스피린을 복용하는 것이 난소암의 위험을 20퍼센트 낮춘다.pdf").load();
        }

        if(getItem.equals("메트포르민, 취약 X 증후군 치료제로서의 잠재적 가능성 보여")){
            myPDFViewer.fromAsset("해외의약뉴스/메트포르민, 취약 X 증후군 치료제로서의 잠재적 가능성 보여.pdf").load();
        }

        if(getItem.equals("면역억제제인 마이코페놀산은 유산이나 선척적 기형의 위험을 증가시킬 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/면역억제제인 마이코페놀산은 유산이나 선척적 기형의 위험을 증가시킬 수 있다.pdf").load();
        }

        if(getItem.equals("미국 FDA는 수면제인 루네스타(Lunesta)의 초기 복용량을 낮추라고 지시했다")){
            myPDFViewer.fromAsset("해외의약뉴스/미국 FDA는 수면제인 루네스타(Lunesta)의 초기 복용량을 낮추라고 지시했다.pdf").load();
        }

        if(getItem.equals("미국 질병통제예방센터, 지카 바이러스-소두증 연관성 보도")){
            myPDFViewer.fromAsset("해외의약뉴스/미국 질병통제예방센터, 지카 바이러스-소두증 연관성 보도.pdf").load();
        }

        if(getItem.equals("반려동물이 신생아 장내세균 변화시켜 알레르기와 비만 위험 낮춘다")){
            myPDFViewer.fromAsset("해외의약뉴스/반려동물이 신생아 장내세균 변화시켜 알레르기와 비만 위험 낮춘다.pdf").load();
        }

        if(getItem.equals("배고픔 느끼는 정도, 칼로리 섭취량과 관련 없다")){
            myPDFViewer.fromAsset("해외의약뉴스/배고픔 느끼는 정도, 칼로리 섭취량과 관련 없다.pdf").load();
        }

        if(getItem.equals("벤조디아제핀 장기복용은 알츠하이머 위험을 증가시킨다")){
            myPDFViewer.fromAsset("해외의약뉴스/벤조디아제핀 장기복용은 알츠하이머 위험을 증가시킨다.pdf").load();
        }

        if(getItem.equals("변비, 신장질환의 위험인자일 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/변비, 신장질환의 위험인자일 수 있다.pdf").load();
        }

        if(getItem.equals("변화하는 보건의료환경에서의 약사의 역할 (1)")){
            myPDFViewer.fromAsset("해외의약뉴스/변화하는 보건의료환경에서의 약사의 역할 (1).pdf").load();
        }

        if(getItem.equals("변화하는 보건의료환경에서의 약사의 역할 (2)")){
            myPDFViewer.fromAsset("해외의약뉴스/변화하는 보건의료환경에서의 약사의 역할 (2).pdf").load();
        }

        if(getItem.equals("비만 아동들에게 어떻게 약물을 투여해야 하는가")){
            myPDFViewer.fromAsset("해외의약뉴스/비만 아동들에게 어떻게 약물을 투여해야 하는가.pdf").load();
        }

        if(getItem.equals("비만인 사람들이 대장암에 잘 걸리는 이유")){
            myPDFViewer.fromAsset("해외의약뉴스/비만인 사람들이 대장암에 잘 걸리는 이유.pdf").load();
        }

        if(getItem.equals("비타민 B3, 유산 및 선천성 기형 예방에 도움 된다")){
            myPDFViewer.fromAsset("해외의약뉴스/비타민 B3, 유산 및 선천성 기형 예방에 도움 된다.pdf").load();
        }

        if(getItem.equals("비타민 C는 운동 후 기도폐쇄 또는 호흡기 증상에 도움이 될 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/비타민 C는 운동 후 기도폐쇄 또는 호흡기 증상에 도움이 될 수 있다.pdf").load();
        }

        if(getItem.equals("비타민 D만으로는 골 건강이 향상되지 않는다")){
            myPDFViewer.fromAsset("해외의약뉴스/비타민 D만으로는 골 건강이 향상되지 않는다.pdf").load();
        }

        if(getItem.equals("비타민 D의 수준이 낮으면 알츠하이머의 위험을 증가시킬 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/비타민 D의 수준이 낮으면 알츠하이머의 위험을 증가시킬 수 있다.pdf").load();
        }

        if(getItem.equals("비타민 및 무기질 보충제가 ADHD 치료에 도움이 될까")){
            myPDFViewer.fromAsset("해외의약뉴스/비타민 및 무기질 보충제가 ADHD 치료에 도움이 될까.pdf").load();
        }

        if(getItem.equals("비타민D 저하는 비알코올성 지방간 질환 위험을 증가시킨다")){
            myPDFViewer.fromAsset("해외의약뉴스/비타민D 저하는 비알코올성 지방간 질환 위험을 증가시킨다.pdf").load();
        }

        if(getItem.equals("비타민D의 부족은 침습성 진행형 전립선암과 연관이 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/비타민D의 부족은 침습성 진행형 전립선암과 연관이 있다.pdf").load();
        }

        if(getItem.equals("새로운 C형 간염 치료제로써 경구용 복합제가 연구 중에 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/새로운 C형 간염 치료제로써 경구용 복합제가 연구 중에 있다.pdf").load();
        }

        if(getItem.equals("새로운 뎅기열 바이러스 백신, 효과입증")){
            myPDFViewer.fromAsset("해외의약뉴스/새로운 뎅기열 바이러스 백신, 효과입증.pdf").load();
        }

        if(getItem.equals("새로운 콜레스테롤 치료 가이드라인 약사에 대한 영향")){
            myPDFViewer.fromAsset("해외의약뉴스/새로운 콜레스테롤 치료 가이드라인 약사에 대한 영향.pdf").load();
        }

        if(getItem.equals("새로운 혈압 가이드라인은 약물 사용을 줄일 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/새로운 혈압 가이드라인은 약물 사용을 줄일 수 있다.pdf").load();
        }

        if(getItem.equals("설탕이 정신건강에도 해로울 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/설탕이 정신건강에도 해로울 수 있다.pdf").load();
        }

        if(getItem.equals("세균과 독소에 반응하는 물질을 이용한 의약외품 개발")){
            myPDFViewer.fromAsset("해외의약뉴스/세균과 독소에 반응하는 물질을 이용한 의약외품 개발.pdf").load();
        }

        if(getItem.equals("수면 부족한 어린이, 제2형 당뇨병 위험 높아진다")){
            myPDFViewer.fromAsset("해외의약뉴스/수면 부족한 어린이, 제2형 당뇨병 위험 높아진다.pdf").load();
        }

        if(getItem.equals("수면을 유도하는 새로운 뇌세포 밝혀져")){
            myPDFViewer.fromAsset("해외의약뉴스/수면을 유도하는 새로운 뇌세포 밝혀져.pdf").load();
        }

        if(getItem.equals("스마트렌즈, 녹내장 진행 위험 예측할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/스마트렌즈, 녹내장 진행 위험 예측할 수 있다.pdf").load();
        }

        if(getItem.equals("스타틴계 약물은 전립선암 생존을 향상시키는데 도움이 될 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/스타틴계 약물은 전립선암 생존을 향상시키는데 도움이 될 수 있다.pdf").load();
        }

        if(getItem.equals("스타틴은 수면무호흡중과 연관된 심장 위험을 줄인다")){
            myPDFViewer.fromAsset("해외의약뉴스/스타틴은 수면무호흡중과 연관된 심장 위험을 줄인다.pdf").load();
        }

        if(getItem.equals("스타틴이 당뇨와 관련된 신경손상을 예방하는데 도움이 될 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/스타틴이 당뇨와 관련된 신경손상을 예방하는데 도움이 될 수 있다.pdf").load();
        }

        if(getItem.equals("스타틴이 심장 구조와 기능 향상시킬 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/스타틴이 심장 구조와 기능 향상시킬 수 있다.pdf").load();
        }

        if(getItem.equals("식사에 집중하는 것이 체중 감량에 도움 될 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/식사에 집중하는 것이 체중 감량에 도움 될 수 있다.pdf").load();
        }

        if(getItem.equals("식이단백질을 많이 섭취하는 것이 체중 조절에 도움이 된다는 주장을 뒷받침하는 새로운 연구 결과")){
            myPDFViewer.fromAsset("해외의약뉴스/식이단백질을 많이 섭취하는 것이 체중 조절에 도움이 된다는 주장을 뒷받침하는 새로운 연구 결과.pdf").load();
        }

        if(getItem.equals("식품첨가제, 장내세균 변화시켜 대장암 발생 촉진할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/식품첨가제, 장내세균 변화시켜 대장암 발생 촉진할 수 있다.pdf").load();
        }

        if(getItem.equals("신약은 편두통을 예방하는데 도움이 될 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/신약은 편두통을 예방하는데 도움이 될 수 있다.pdf").load();
        }

        if(getItem.equals("실험약물은 화학요법 없이 백혈병의 생존율을 높일 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/실험약물은 화학요법 없이 백혈병의 생존율을 높일 수 있다.pdf").load();
        }

        if(getItem.equals("아기 성별이 엄마의 면역력에 영향을 줄 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/아기 성별이 엄마의 면역력에 영향을 줄 수 있다.pdf").load();
        }

        if(getItem.equals("아세트아미노펜 중독, 약사가 알아야 할 것들")){
            myPDFViewer.fromAsset("해외의약뉴스/아세트아미노펜 중독, 약사가 알아야 할 것들.pdf").load();
        }

        if(getItem.equals("아세트아미노펜의 위험은 과소평가되었을 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/아세트아미노펜의 위험은 과소평가되었을 수 있다.pdf").load();
        }

        if(getItem.equals("아스피린은 자간전증의 위험이 있는 모든 산모들에게 도움이 된다")){
            myPDFViewer.fromAsset("해외의약뉴스/아스피린은 자간전증의 위험이 있는 모든 산모들에게 도움이 된다.pdf").load();
        }

        if(getItem.equals("아침 식사를 거르는 것이 대사에 미치는 영향, 체중에 따라 다르다")){
            myPDFViewer.fromAsset("해외의약뉴스/아침 식사를 거르는 것이 대사에 미치는 영향, 체중에 따라 다르다.pdf").load();
        }

        if(getItem.equals("알레르기성 비염과 비강내 코르티코스테로이드 스프레이(1)")){
            myPDFViewer.fromAsset("해외의약뉴스/알레르기성 비염과 비강내 코르티코스테로이드 스프레이(1).pdf").load();
        }

        if(getItem.equals("알레르기성 비염과 비강내 코르티코스테로이드 스프레이(2)")){
            myPDFViewer.fromAsset("해외의약뉴스/알레르기성 비염과 비강내 코르티코스테로이드 스프레이(2).pdf").load();
        }

        if(getItem.equals("알츠하이머병, 증상 나타나기 훨씬 전에 예측할 수 있다면")){
            myPDFViewer.fromAsset("해외의약뉴스/알츠하이머병, 증상 나타나기 훨씬 전에 예측할 수 있다면.pdf").load();
        }

        if(getItem.equals("약국에서 듣는 음악이 태도에 미치는 영향")){
            myPDFViewer.fromAsset("해외의약뉴스/약국에서 듣는 음악이 태도에 미치는 영향.pdf").load();
        }

        if(getItem.equals("약국에서 유망한 Point-of-Care(POC) HIV 검사")){
            myPDFViewer.fromAsset("해외의약뉴스/약국에서 유망한 Point-of-Care(POC) HIV 검사.pdf").load();
        }

        if(getItem.equals("약물 상호 작용에 따른 위장 출혈")){
            myPDFViewer.fromAsset("해외의약뉴스/약물 상호 작용에 따른 위장 출혈.pdf").load();
        }

        if(getItem.equals("약사 주도 사례관리가 뇌졸중 환자의 혈압 및 콜레스테롤 수치를 개선시킬 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/약사 주도 사례관리가 뇌졸중 환자의 혈압 및 콜레스테롤 수치를 개선시킬 수 있다.pdf").load();
        }

        if(getItem.equals("약사가 복약순응도를 향상시킬 수 있는 5가지 방법")){
            myPDFViewer.fromAsset("해외의약뉴스/약사가 복약순응도를 향상시킬 수 있는 5가지 방법.pdf").load();
        }

        if(getItem.equals("약사들이 슈퍼버그 확산을 막기 위한 3가지 방법")){
            myPDFViewer.fromAsset("해외의약뉴스/약사들이 슈퍼버그 확산을 막기 위한 3가지 방법.pdf").load();
        }

        if(getItem.equals("약사들이 아세트아미노펜 과다복용을 예방하기 위한 방법")){
            myPDFViewer.fromAsset("해외의약뉴스/약사들이 아세트아미노펜 과다복용을 예방하기 위한 방법.pdf").load();
        }

        if(getItem.equals("약사를 위한 환자 복약지도 도구")){
            myPDFViewer.fromAsset("해외의약뉴스/약사를 위한 환자 복약지도 도구.pdf").load();
        }

        if(getItem.equals("어린 시절 비타민D 부족이 나중에 심장 위험과 관련이 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/어린 시절 비타민D 부족이 나중에 심장 위험과 관련이 있다.pdf").load();
        }

        if(getItem.equals("어린 시절 자주 이사하면 자살위험 증가")){
            myPDFViewer.fromAsset("해외의약뉴스/어린 시절 자주 이사하면 자살위험 증가.pdf").load();
        }

        if(getItem.equals("어린이 약물 과다복용을 억제하기 위한 3단계 조치")){
            myPDFViewer.fromAsset("해외의약뉴스/어린이 약물 과다복용을 억제하기 위한 3단계 조치.pdf").load();
        }

        if(getItem.equals("어린이의 에너지 음료 섭취 위험은 교육할 필요가 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/어린이의 에너지 음료 섭취 위험은 교육할 필요가 있다.pdf").load();
        }

        if(getItem.equals("에너지 음료가 24시간 이내 체내에 미치는 영향")){
            myPDFViewer.fromAsset("해외의약뉴스/에너지 음료가 24시간 이내 체내에 미치는 영향.pdf").load();
        }

        if(getItem.equals("에너지음료 소비증가가 국민건강을 위협할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/에너지음료 소비증가가 국민건강을 위협할 수 있다.pdf").load();
        }

        if(getItem.equals("에볼라 바이러스에 대한 환자 평가 의사들을 위한 CDC 권고사항")){
            myPDFViewer.fromAsset("해외의약뉴스/에볼라 바이러스에 대한 환자 평가 의사들을 위한 CDC 권고사항.pdf").load();
        }

        if(getItem.equals("여성들을 위한 유방암 예방에의 기여 약사들의 도전")){
            myPDFViewer.fromAsset("해외의약뉴스/여성들을 위한 유방암 예방에의 기여 약사들의 도전.pdf").load();
        }

        if(getItem.equals("연구에서 확인된 신장질환에 대한 조기 경보 신호")){
            myPDFViewer.fromAsset("해외의약뉴스/연구에서 확인된 신장질환에 대한 조기 경보 신호.pdf").load();
        }

        if(getItem.equals("엽산보충제는 저체중아가 태어나는 위험을 감소시킨다")){
            myPDFViewer.fromAsset("해외의약뉴스/엽산보충제는 저체중아가 태어나는 위험을 감소시킨다.pdf").load();
        }

        if(getItem.equals("영국 NICE 지질관리 가이드라인 개정")){
            myPDFViewer.fromAsset("해외의약뉴스/영국 NICE 지질관리 가이드라인 개정.pdf").load();
        }

        if(getItem.equals("오래 숙성된 치즈 속 성분이 간암을 예방하고 수명 연장할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/오래 숙성된 치즈 속 성분이 간암을 예방하고 수명 연장할 수 있다.pdf").load();
        }

        if(getItem.equals("오메가-3 지방산의 섭취는 뇌의 노화를 늦출 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/오메가-3 지방산의 섭취는 뇌의 노화를 늦출 수 있다.pdf").load();
        }

        if(getItem.equals("오메가3, 비타민, 미네랄 보충제가 아동의 공격성을 줄여준다")){
            myPDFViewer.fromAsset("해외의약뉴스/오메가3, 비타민, 미네랄 보충제가 아동의 공격성을 줄여준다.pdf").load();
        }

        if(getItem.equals("오메가3지방산 보충제는 안구건조 증상을 개선할 수 있는가")){
            myPDFViewer.fromAsset("해외의약뉴스/오메가3지방산 보충제는 안구건조 증상을 개선할 수 있는가.pdf").load();
        }

        if(getItem.equals("와파린 처방에는 다른 약물과의 심각한 상호작용이 잠재되어 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/와파린 처방에는 다른 약물과의 심각한 상호작용이 잠재되어 있다.pdf").load();
        }

        if(getItem.equals("왜 메르스 백신이 없는가 통찰력 부족은 과학자들에게 좌절감을 일으킨다")){
            myPDFViewer.fromAsset("해외의약뉴스/왜 메르스 백신이 없는가 통찰력 부족은 과학자들에게 좌절감을 일으킨다.pdf").load();
        }

        if(getItem.equals("운동이 금연에 도움 되는 것으로 밝혀져")){
            myPDFViewer.fromAsset("해외의약뉴스/운동이 금연에 도움 되는 것으로 밝혀져.pdf").load();
        }

        if(getItem.equals("운동이 유방암 발병 위험을 감소시킬 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/운동이 유방암 발병 위험을 감소시킬 수 있다.pdf").load();
        }

        if(getItem.equals("운동이 일부 질환으로 인한 사망률을 낮추는데 약만큼 효과가 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/운동이 일부 질환으로 인한 사망률을 낮추는데 약만큼 효과가 있다.pdf").load();
        }

        if(getItem.equals("원인을 알 수 없는 기침을 치료하기 위한 6가지 가이드라인")){
            myPDFViewer.fromAsset("해외의약뉴스/원인을 알 수 없는 기침을 치료하기 위한 6가지 가이드라인.pdf").load();
        }

        if(getItem.equals("위산분비 억제제가 비타민 B12의 결핍을 초래할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/위산분비 억제제가 비타민 B12의 결핍을 초래할 수 있다.pdf").load();
        }

        if(getItem.equals("유명한 속쓰림 약이 심장마비 위험을 높이는 것과 연관이 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/유명한 속쓰림 약이 심장마비 위험을 높이는 것과 연관이 있다.pdf").load();
        }

        if(getItem.equals("유방암 위험에 영향을 미치는 과일과 알코올")){
            myPDFViewer.fromAsset("해외의약뉴스/유방암 위험에 영향을 미치는 과일과 알코올.pdf").load();
        }

        if(getItem.equals("유아기, 천식위험을 줄이기 위한 3가지 방법")){
            myPDFViewer.fromAsset("해외의약뉴스/유아기, 천식위험을 줄이기 위한 3가지 방법.pdf").load();
        }

        if(getItem.equals("의료사고, 미국의 주요 사망원인 3위")){
            myPDFViewer.fromAsset("해외의약뉴스/의료사고, 미국의 주요 사망원인 3위.pdf").load();
        }

        if(getItem.equals("인슐린 저항성 개선에 도움이 되는 식이요법 팁")){
            myPDFViewer.fromAsset("해외의약뉴스/인슐린 저항성 개선에 도움이 되는 식이요법 팁.pdf").load();
        }

        if(getItem.equals("인터페론을 포함하지 않는 애브비 요법이 유전자 1형 HCV 환자의 96 퍼센트를 치료하다")){
            myPDFViewer.fromAsset("해외의약뉴스/인터페론을 포함하지 않는 애브비 요법이 유전자 1형 HCV 환자의 96 퍼센트를 치료하다.pdf").load();
        }

        if(getItem.equals("일반적인 항생제 조합은 돌연사의 원인이 될 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/일반적인 항생제 조합은 돌연사의 원인이 될 수 있다.pdf").load();
        }

        if(getItem.equals("일반커피냐, 디카페인 커피냐 둘 다 간에 도움이 될 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/일반커피냐, 디카페인 커피냐 둘 다 간에 도움이 될 수 있다.pdf").load();
        }

        if(getItem.equals("일부 OTC 국소 여드름 치료제는 심각한 유해반응을 야기할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/일부 OTC 국소 여드름 치료제는 심각한 유해반응을 야기할 수 있다.pdf").load();
        }

        if(getItem.equals("임산부의 식습관이 질병유전에 미치는 영향")){
            myPDFViewer.fromAsset("해외의약뉴스/임산부의 식습관이 질병유전에 미치는 영향.pdf").load();
        }

        if(getItem.equals("임신 중 감초 섭취, 자녀의 ADHD와 관련 있나")){
            myPDFViewer.fromAsset("해외의약뉴스/임신 중 감초 섭취, 자녀의 ADHD와 관련 있나.pdf").load();
        }

        if(getItem.equals("임신 중 아세트아미노펜 복용과 아이의 행동문제의 연관성")){
            myPDFViewer.fromAsset("해외의약뉴스/임신 중 아세트아미노펜 복용과 아이의 행동문제의 연관성.pdf").load();
        }

        if(getItem.equals("임신 중 항우울제 복용은 신생아의 지속성 페동맥 고혈압의 위험성과 관련이 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/임신 중 항우울제 복용은 신생아의 지속성 페동맥 고혈압의 위험성과 관련이 있다.pdf").load();
        }

        if(getItem.equals("자기 전에 아스피린을 복용하는 것이 심장보호에 효과적이다")){
            myPDFViewer.fromAsset("해외의약뉴스/자기 전에 아스피린을 복용하는 것이 심장보호에 효과적이다.pdf").load();
        }

        if(getItem.equals("자폐증 정확하게 진달할 수 있는 생화학적 방법 개발돼")){
            myPDFViewer.fromAsset("해외의약뉴스/자폐증 정확하게 진달할 수 있는 생화학적 방법 개발돼.pdf").load();
        }

        if(getItem.equals("장내세균이 과민성대장증후군 환자의 뇌에도 영향 준다")){
            myPDFViewer.fromAsset("해외의약뉴스/장내세균이 과민성대장증후군 환자의 뇌에도 영향 준다.pdf").load();
        }

        if(getItem.equals("저열량 인공감미료, 오히려 지방 형성 높일 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/저열량 인공감미료, 오히려 지방 형성 높일 수 있다.pdf").load();
        }

        if(getItem.equals("저지방 우유, 요거트 섭취가 우울증 위험 낮춘다")){
            myPDFViewer.fromAsset("해외의약뉴스/저지방 우유, 요거트 섭취가 우울증 위험 낮춘다.pdf").load();
        }

        if(getItem.equals("저지방 유제품이 파킨슨병 위험 높이나")){
            myPDFViewer.fromAsset("해외의약뉴스/저지방 유제품이 파킨슨병 위험 높이나.pdf").load();
        }

        if(getItem.equals("저체중 노인, 알츠하이머 발병 위험 높다")){
            myPDFViewer.fromAsset("해외의약뉴스/저체중 노인, 알츠하이머 발병 위험 높다.pdf").load();
        }

        if(getItem.equals("전자파는 치명적인 뇌종양 치료에 도움이 될 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/전자파는 치명적인 뇌종양 치료에 도움이 될 수 있다.pdf").load();
        }

        if(getItem.equals("정신병, 뇌 염증과 관련있다고 밝혀져 - 항체 치료가 새로운 희망으로 부상")){
            myPDFViewer.fromAsset("해외의약뉴스/정신병, 뇌 염증과 관련있다고 밝혀져 - 항체 치료가 새로운 희망으로 부상.pdf").load();
        }

        if(getItem.equals("정신적 스트레스가 어떻게 질병을 유발하는가")){
            myPDFViewer.fromAsset("해외의약뉴스/정신적 스트레스가 어떻게 질병을 유발하는가.pdf").load();
        }

        if(getItem.equals("제1형 당뇨병 환자 중 약 절반은 인슐린 생산 새로운 치료의 길 열릴까")){
            myPDFViewer.fromAsset("해외의약뉴스/제1형 당뇨병 환자 중 약 절반은 인슐린 생산 새로운 치료의 길 열릴까.pdf").load();
        }

        if(getItem.equals("제2형 당뇨병 환자들의 혈압 및 콜레스테롤 수치를 집중 치료하는 것이 기억력 감소의 위험을 낮추는데 도움이 되지 않는다")){
            myPDFViewer.fromAsset("해외의약뉴스/제2형 당뇨병 환자들의 혈압 및 콜레스테롤 수치를 집중 치료하는 것이 기억력 감소의 위험을 낮추는데 도움이 되지 않는다.pdf").load();
        }

        if(getItem.equals("제네릭 의약품이 유방암 환자의 치료 지속에 도움이 될 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/제네릭 의약품이 유방암 환자의 치료 지속에 도움이 될 수 있다.pdf").load();
        }

        if(getItem.equals("줄기세포 이식으로 골다공증 쥐 완치")){
            myPDFViewer.fromAsset("해외의약뉴스/줄기세포 이식으로 골다공증 쥐 완치.pdf").load();
        }

        if(getItem.equals("줄기세포 치료가 심부전 환자의 심장 손상 악화시킬 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/줄기세포 치료가 심부전 환자의 심장 손상 악화시킬 수 있다.pdf").load();
        }

        if(getItem.equals("중동호흡기증후군 코로나바이러스(MERS-CoV)의 정의와 증상")){
            myPDFViewer.fromAsset("해외의약뉴스/중동호흡기증후군 코로나바이러스(MERS-CoV)의 정의와 증상.pdf").load();
        }

        if(getItem.equals("지방세포 크기 줄이는 신약 개발되나")){
            myPDFViewer.fromAsset("해외의약뉴스/지방세포 크기 줄이는 신약 개발되나.pdf").load();
        }

        if(getItem.equals("지속적으로 삶을 즐기는 사람이 더 오래 산다")){
            myPDFViewer.fromAsset("해외의약뉴스/지속적으로 삶을 즐기는 사람이 더 오래 산다.pdf").load();
        }

        if(getItem.equals("지중해식단, 인지력 감퇴를 늦추고 알츠하이머 예방한다")){
            myPDFViewer.fromAsset("해외의약뉴스/지중해식단, 인지력 감퇴를 늦추고 알츠하이머 예방한다.pdf").load();
        }

        if(getItem.equals("진드기와 라임 병 우리는 얼마나 걱정해야 하는가")){
            myPDFViewer.fromAsset("해외의약뉴스/진드기와 라임 병 우리는 얼마나 걱정해야 하는가.pdf").load();
        }

        if(getItem.equals("진통제 트라마돌은 저혈당과 관련이 있다.")){
            myPDFViewer.fromAsset("해외의약뉴스/진통제 트라마돌은 저혈당과 관련이 있다..pdf").load();
        }

        if(getItem.equals("질병을 유발하는 유전자돌연변이에도 건강한 사람 발견")){
            myPDFViewer.fromAsset("해외의약뉴스/질병을 유발하는 유전자돌연변이에도 건강한 사람 발견.pdf").load();
        }

        if(getItem.equals("책상에 앉아서 일하는 사람들을 위한 에너지 증진 방법")){
            myPDFViewer.fromAsset("해외의약뉴스/책상에 앉아서 일하는 사람들을 위한 에너지 증진 방법.pdf").load();
        }

        if(getItem.equals("처음으로 FDA 패널이 고가 바이오 의약품에 대한 제네릭 의약품을 승인한다")){
            myPDFViewer.fromAsset("해외의약뉴스/처음으로 FDA 패널이 고가 바이오 의약품에 대한 제네릭 의약품을 승인한다.pdf").load();
        }

        if(getItem.equals("철분 부족하면 심질환 위험 높아질 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/철분 부족하면 심질환 위험 높아질 수 있다.pdf").load();
        }

        if(getItem.equals("청소년들의 전자담배 흡연 증가가 일반담배 흡연의 증가와 관계가 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/청소년들의 전자담배 흡연 증가가 일반담배 흡연의 증가와 관계가 있다.pdf").load();
        }

        if(getItem.equals("체중 적으면 폐경 앞당겨질 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/체중 적으면 폐경 앞당겨질 수 있다.pdf").load();
        }

        if(getItem.equals("체지방을 없애기 위해서는 칼로리가 지방이나 탄수화물보다 더 중요할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/체지방을 없애기 위해서는 칼로리가 지방이나 탄수화물보다 더 중요할 수 있다.pdf").load();
        }

        if(getItem.equals("충분한 수분 섭취는 신장결석 위험을 감소시킬 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/충분한 수분 섭취는 신장결석 위험을 감소시킬 수 있다.pdf").load();
        }

        if(getItem.equals("치매 환자 중 20%, 초미세먼지 때문일 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/치매 환자 중 20%, 초미세먼지 때문일 수 있다.pdf").load();
        }

        if(getItem.equals("치즈 매일 섭취하면 심질환 예방에 도움 된다")){
            myPDFViewer.fromAsset("해외의약뉴스/치즈 매일 섭취하면 심질환 예방에 도움 된다.pdf").load();
        }

        if(getItem.equals("카페인은 ADHD 환자에게 어떤 효과가 있을까")){
            myPDFViewer.fromAsset("해외의약뉴스/카페인은 ADHD 환자에게 어떤 효과가 있을까.pdf").load();
        }

        if(getItem.equals("칼로리가 낮은 감미료는 유용한가 위험한가")){
            myPDFViewer.fromAsset("해외의약뉴스/칼로리가 낮은 감미료는 유용한가 위험한가.pdf").load();
        }

        if(getItem.equals("칼륨이 풍부한 식단은 당뇨환자의 신장을 보호할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/칼륨이 풍부한 식단은 당뇨환자의 신장을 보호할 수 있다.pdf").load();
        }

        if(getItem.equals("칼슘채널차단제, 암 전이 억제에 효과적일 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/칼슘채널차단제, 암 전이 억제에 효과적일 수 있다.pdf").load();
        }

        if(getItem.equals("케일 속 루테인 성분, 인지기능에도 도움 된다")){
            myPDFViewer.fromAsset("해외의약뉴스/케일 속 루테인 성분, 인지기능에도 도움 된다.pdf").load();
        }

        if(getItem.equals("코 분비물 검사(Nasal Swab)로 폐암 여부 알 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/코 분비물 검사(Nasal Swab)로 폐암 여부 알 수 있다.pdf").load();
        }

        if(getItem.equals("코르티코스테로이드류가 중증 천식 환자를 완벽하게 치료하지 못하는 이유")){
            myPDFViewer.fromAsset("해외의약뉴스/코르티코스테로이드류가 중증 천식 환자를 완벽하게 치료하지 못하는 이유.pdf").load();
        }

        if(getItem.equals("콜드 터키(Cold Turkey), 가장 효과적인 금연법")){
            myPDFViewer.fromAsset("해외의약뉴스/콜드 터키(Cold Turkey), 가장 효과적인 금연법.pdf").load();
        }

        if(getItem.equals("콜레스테롤 약은 다발성경화증의 진행을 늦추는데 도움을 줄 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/콜레스테롤 약은 다발성경화증의 진행을 늦추는데 도움을 줄 수 있다.pdf").load();
        }

        if(getItem.equals("콩, 채소 그리고 뇌를 위한 가장 좋은 음식")){
            myPDFViewer.fromAsset("해외의약뉴스/콩, 채소 그리고 뇌를 위한 가장 좋은 음식.pdf").load();
        }

        if(getItem.equals("크런치효과(Crunch effect) 어떻게 식욕을 억제할 수 있을까")){
            myPDFViewer.fromAsset("해외의약뉴스/크런치효과(Crunch effect) 어떻게 식욕을 억제할 수 있을까.pdf").load();
        }

        if(getItem.equals("클로람부실과 오비누투주맙의 병용투여가 백혈병 노인 환자들의 삶을 연장시킬 수 있다는 연구결과가 나왔다")){
            myPDFViewer.fromAsset("해외의약뉴스/클로람부실과 오비누투주맙의 병용투여가 백혈병 노인 환자들의 삶을 연장시킬 수 있다는 연구결과가 나왔다.pdf").load();
        }

        if(getItem.equals("탈모와 흰머리 원인 규명돼")){
            myPDFViewer.fromAsset("해외의약뉴스/탈모와 흰머리 원인 규명돼.pdf").load();
        }

        if(getItem.equals("통조림 음식에 들어있는 비스페놀 A(BPA)가 혈압을 높일 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/통조림 음식에 들어있는 비스페놀 A(BPA)가 혈압을 높일 수 있다.pdf").load();
        }

        if(getItem.equals("편두통 약이 일부 청소년의 식이장애 위험을 높일 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/편두통 약이 일부 청소년의 식이장애 위험을 높일 수 있다.pdf").load();
        }

        if(getItem.equals("폐경 여성, 알츠하이머병에 더 취약할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/폐경 여성, 알츠하이머병에 더 취약할 수 있다.pdf").load();
        }

        if(getItem.equals("피임주사는 HIV 위험성을 증가시킬 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/피임주사는 HIV 위험성을 증가시킬 수 있다.pdf").load();
        }

        if(getItem.equals("하루 8잔 물 섭취 목마를 때에만 마시는 것이 좋다")){
            myPDFViewer.fromAsset("해외의약뉴스/하루 8잔 물 섭취 목마를 때에만 마시는 것이 좋다.pdf").load();
        }

        if(getItem.equals("항구토제인 메토클로프라미드는 임산부에게 사용할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/항구토제인 메토클로프라미드는 임산부에게 사용할 수 있다.pdf").load();
        }

        if(getItem.equals("항우울제 복용으로 사망 위험 높아질 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/항우울제 복용으로 사망 위험 높아질 수 있다.pdf").load();
        }

        if(getItem.equals("항우울제 셀렉사(Celexa)가 알츠하이머 환자의 불안감을 완화하는데 도움이 된다")){
            myPDFViewer.fromAsset("해외의약뉴스/항우울제 셀렉사(Celexa)가 알츠하이머 환자의 불안감을 완화하는데 도움이 된다.pdf").load();
        }

        if(getItem.equals("항우울제로 파킨슨병 진행 늦출 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/항우울제로 파킨슨병 진행 늦출 수 있다.pdf").load();
        }

        if(getItem.equals("항응고제 프라닥사(Pradaxa) 처방 시 주의가 필요하다고 연구(보고서)는 경고한다")){
            myPDFViewer.fromAsset("해외의약뉴스/항응고제 프라닥사(Pradaxa) 처방 시 주의가 필요하다고 연구(보고서)는 경고한다.pdf").load();
        }

        if(getItem.equals("항체검사는 예방단계에서 알츠하이머를 발견할 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/항체검사는 예방단계에서 알츠하이머를 발견할 수 있다.pdf").load();
        }

        if(getItem.equals("항체를 생산하기 위해 개발된 혁신적인 기술")){
            myPDFViewer.fromAsset("해외의약뉴스/항체를 생산하기 위해 개발된 혁신적인 기술.pdf").load();
        }

        if(getItem.equals("항혈액응고제와 특정 진통제를 함께 복용하는 것은 출혈의 위험을 높일 수 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/항혈액응고제와 특정 진통제를 함께 복용하는 것은 출혈의 위험을 높일 수 있다.pdf").load();
        }

        if(getItem.equals("헬리코박터 파일로리 치료를 위한 새로운 가이드라인")){
            myPDFViewer.fromAsset("해외의약뉴스/헬리코박터 파일로리 치료를 위한 새로운 가이드라인.pdf").load();
        }

        if(getItem.equals("혈당조절과 체중감소에 효과가 있는 당뇨병 신약이 개발 중에 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/혈당조절과 체중감소에 효과가 있는 당뇨병 신약이 개발 중에 있다.pdf").load();
        }

        if(getItem.equals("호르몬 요법을 이용한 새로운 폐경기 가이드라인")){
            myPDFViewer.fromAsset("해외의약뉴스/호르몬 요법을 이용한 새로운 폐경기 가이드라인.pdf").load();
        }

        if(getItem.equals("환자 순응도에 영향을 주는 약사")){
            myPDFViewer.fromAsset("해외의약뉴스/환자 순응도에 영향을 주는 약사.pdf").load();
        }

        if(getItem.equals("환자들이 인지하지 못하는 일반의약품 과다복용의 위험")){
            myPDFViewer.fromAsset("해외의약뉴스/환자들이 인지하지 못하는 일반의약품 과다복용의 위험.pdf").load();
        }

        if(getItem.equals("휴대폰 장기 사용은 뇌종양 위험과 관련된다")){
            myPDFViewer.fromAsset("해외의약뉴스/휴대폰 장기 사용은 뇌종양 위험과 관련된다.pdf").load();
        }

        if(getItem.equals("흡연은 만성 허리통증 증가와 관련이 있다")){
            myPDFViewer.fromAsset("해외의약뉴스/흡연은 만성 허리통증 증가와 관련이 있다.pdf").load();
        }

        if(getItem.equals("흡연은 정신 분열증에 원인이 되는가")){
            myPDFViewer.fromAsset("해외의약뉴스/흡연은 정신 분열증에 원인이 되는가.pdf").load();
        }

        if(getItem.equals("가바펜틴(gabapentin) 탈모")){
            myPDFViewer.fromAsset("부작용 리포트/가바펜틴(gabapentin) 탈모.pdf").load();
        }

        if(getItem.equals("글리메피리드(glimepiride) 저혈당증")){
            myPDFViewer.fromAsset("부작용 리포트/글리메피리드(glimepiride) 저혈당증.pdf").load();
        }

        if(getItem.equals("나프로닐옥살산염(nafronyl oxalate) 요로결석")){
            myPDFViewer.fromAsset("부작용 리포트/나프로닐옥살산염(nafronyl oxalate) 요로결석.pdf").load();
        }

        if(getItem.equals("다파글리플로진(dapagliflozin) 방광염")){
            myPDFViewer.fromAsset("부작용 리포트/다파글리플로진(dapagliflozin) 방광염.pdf").load();
        }

        if(getItem.equals("다파글리플로진(dapagliflozin) 빈뇨")){
            myPDFViewer.fromAsset("부작용 리포트/다파글리플로진(dapagliflozin) 빈뇨.pdf").load();
        }

        if(getItem.equals("덱시부프로펜(dexibuprofen) 시각장애")){
            myPDFViewer.fromAsset("부작용 리포트/덱시부프로펜(dexibuprofen) 시각장애.pdf").load();
        }

        if(getItem.equals("독사조신(doxazosin) 심한 어지러움증")){
            myPDFViewer.fromAsset("부작용 리포트/독사조신(doxazosin) 심한 어지러움증.pdf").load();
        }

        if(getItem.equals("독시사이클린(doxycycline) 궤양성식도염")){
            myPDFViewer.fromAsset("부작용 리포트/독시사이클린(doxycycline) 궤양성식도염.pdf").load();
        }

        if(getItem.equals("둘라글루타이드(dulaglutide) 급성췌장염")){
            myPDFViewer.fromAsset("부작용 리포트/둘라글루타이드(dulaglutide) 급성췌장염.pdf").load();
        }

        if(getItem.equals("둘록세틴(duloxetine) 배뇨곤란")){
            myPDFViewer.fromAsset("부작용 리포트/둘록세틴(duloxetine) 배뇨곤란.pdf").load();
        }

        if(getItem.equals("디곡신(digoxin) 졸음 및 시야 이상")){
            myPDFViewer.fromAsset("부작용 리포트/디곡신(digoxin) 졸음 및 시야 이상.pdf").load();
        }

        if(getItem.equals("라록시펜(raloxifene) 안와부종")){
            myPDFViewer.fromAsset("부작용 리포트/라록시펜(raloxifene) 안와부종.pdf").load();
        }

        if(getItem.equals("레보설피리드(levosulpiride) 유즙분비")){
            myPDFViewer.fromAsset("부작용 리포트/레보설피리드(levosulpiride) 유즙분비.pdf").load();
        }

        if(getItem.equals("리바록사반(rivaroxaban) 혈뇨")){
            myPDFViewer.fromAsset("부작용 리포트/리바록사반(rivaroxaban) 혈뇨.pdf").load();
        }

        if(getItem.equals("리세드론산나트륨(risedronate sodium) 사지,관절통")){
            myPDFViewer.fromAsset("부작용 리포트/리세드론산나트륨(risedronate sodium) 사지,관절통.pdf").load();
        }

        if(getItem.equals("메트포르민(metformin) 식욕상실")){
            myPDFViewer.fromAsset("부작용 리포트/메트포르민(metformin) 식욕상실.pdf").load();
        }

        if(getItem.equals("메틸페니데이트(methylphenidate) 가슴두근거림")){
            myPDFViewer.fromAsset("부작용 리포트/메틸페니데이트(methylphenidate) 가슴두근거림.pdf").load();
        }

        if(getItem.equals("메틸프레드니솔론(methylprednisolone) 망막장애")){
            myPDFViewer.fromAsset("부작용 리포트/메틸프레드니솔론(methylprednisolone) 망막장애.pdf").load();
        }

        if(getItem.equals("메플로퀸(mefloquine) 정신신경계 이상반응")){
            myPDFViewer.fromAsset("부작용 리포트/메플로퀸(mefloquine) 정신신경계 이상반응.pdf").load();
        }

        if(getItem.equals("멜록시캄(meloxicam) 혈중 칼륨농도 증가")){
            myPDFViewer.fromAsset("부작용 리포트/멜록시캄(meloxicam) 혈중 칼륨농도 증가.pdf").load();
        }

        if(getItem.equals("미노사이클린(minocycline) 손톱 변색")){
            myPDFViewer.fromAsset("부작용 리포트/미노사이클린(minocycline) 손톱 변색.pdf").load();
        }

        if(getItem.equals("미녹시딜(minoxidil)액 외이염 및 시야흐림")){
            myPDFViewer.fromAsset("부작용 리포트/미녹시딜(minoxidil)액 외이염 및 시야흐림.pdf").load();
        }

        if(getItem.equals("미르타자핀(mirtazapine) 손가락관절통 및 부종")){
            myPDFViewer.fromAsset("부작용 리포트/미르타자핀(mirtazapine) 손가락관절통 및 부종.pdf").load();
        }

        if(getItem.equals("부프레노르핀(buprenorphine) 실신")){
            myPDFViewer.fromAsset("부작용 리포트/부프레노르핀(buprenorphine) 실신.pdf").load();
        }

        if(getItem.equals("사이클로스포린(cyclosporine) 다모증")){
            myPDFViewer.fromAsset("부작용 리포트/사이클로스포린(cyclosporine) 다모증.pdf").load();
        }

        if(getItem.equals("세팔락신(cephalexin) 간질성 경련 유사 증상")){
            myPDFViewer.fromAsset("부작용 리포트/세팔락신(cephalexin) 간질성 경련 유사 증상.pdf").load();
        }

        if(getItem.equals("실데나필(sildenafil) 청색시증")){
            myPDFViewer.fromAsset("부작용 리포트/실데나필(sildenafil) 청색시증.pdf").load();
        }

        if(getItem.equals("실로스타졸(cilostazol) 두통")){
            myPDFViewer.fromAsset("부작용 리포트/실로스타졸(cilostazol) 두통.pdf").load();
        }

        if(getItem.equals("아리피프라졸(aripiprazole) 식욕 및 체중 증가")){
            myPDFViewer.fromAsset("부작용 리포트/아리피프라졸(aripiprazole) 식욕 및 체중 증가.pdf").load();
        }

        if(getItem.equals("아리피프라졸(aripiprazole) 핍뇨 및 저나트륨혈증")){
            myPDFViewer.fromAsset("부작용 리포트/아리피프라졸(aripiprazole) 핍뇨 및 저나트륨혈증.pdf").load();
        }

        if(getItem.equals("아목시실린(amoxicillin) 질염 유사 증상")){
            myPDFViewer.fromAsset("부작용 리포트/아목시실린(amoxicillin) 질염 유사 증상.pdf").load();
        }

        if(getItem.equals("아미오다론(amiodarone) 갑상선 기능이상")){
            myPDFViewer.fromAsset("부작용 리포트/아미오다론(amiodarone) 갑상선 기능이상.pdf").load();
        }

        if(getItem.equals("아미오다론(amiodarone) 마비성 보행")){
            myPDFViewer.fromAsset("부작용 리포트/아미오다론(amiodarone) 마비성 보행.pdf").load();
        }

        if(getItem.equals("아지트로마이신(azithromycin) 이명 악화")){
            myPDFViewer.fromAsset("부작용 리포트/아지트로마이신(azithromycin) 이명 악화.pdf").load();
        }

        if(getItem.equals("아토르바스타틴(atorvastatin) 급성 췌장염")){
            myPDFViewer.fromAsset("부작용 리포트/아토르바스타틴(atorvastatin) 급성 췌장염.pdf").load();
        }

        if(getItem.equals("아토르바스타틴(atorvastatin) 시야결손")){
            myPDFViewer.fromAsset("부작용 리포트/아토르바스타틴(atorvastatin) 시야결손.pdf").load();
        }

        if(getItem.equals("아토목세틴(atomoxetine) 두통")){
            myPDFViewer.fromAsset("부작용 리포트/아토목세틴(atomoxetine) 두통.pdf").load();
        }

        if(getItem.equals("암로디핀(amlodipine) 다리 부종")){
            myPDFViewer.fromAsset("부작용 리포트/암로디핀(amlodipine) 다리 부종.pdf").load();
        }

        if(getItem.equals("암로디핀(amlodipine) 후각이상")){
            myPDFViewer.fromAsset("부작용 리포트/암로디핀(amlodipine) 후각이상.pdf").load();
        }

        if(getItem.equals("에르투글리플로진(ertugliflozin),피오글리타존(pioglitazone) 식욕부진, 불면, 우울감 등")){
            myPDFViewer.fromAsset("부작용 리포트/에르투글리플로진(ertugliflozin),피오글리타존(pioglitazone) 식욕부진, 불면, 우울감 등.pdf").load();
        }

        if(getItem.equals("에스시탈로프람(escitalopram) 언어장애 및 보행실조")){
            myPDFViewer.fromAsset("부작용 리포트/에스시탈로프람(escitalopram) 언어장애 및 보행실조.pdf").load();
        }

        if(getItem.equals("에스트리올 질좌제(estriol vaginal suppositories) 전신증상(발열, 통증, 구토 등)")){
            myPDFViewer.fromAsset("부작용 리포트/에스트리올 질좌제(estriol vaginal suppositories) 전신증상(발열, 통증, 구토 등).pdf").load();
        }

        if(getItem.equals("에토리콕시브(etoricoxib) 신장 손상")){
            myPDFViewer.fromAsset("부작용 리포트/에토리콕시브(etoricoxib) 신장 손상.pdf").load();
        }

        if(getItem.equals("오셀타미비르(oseltamivir) 환각")){
            myPDFViewer.fromAsset("부작용 리포트/오셀타미비르(oseltamivir) 환각.pdf").load();
        }

        if(getItem.equals("와파린(warfarin) 및 메트로니다졸(metronidazole) INR 증가")){
            myPDFViewer.fromAsset("부작용 리포트/와파린(warfarin) 및 메트로니다졸(metronidazole) INR 증가.pdf").load();
        }

        if(getItem.equals("이소소르비드이질산염(isosorbide dinitrate) 스프레이 두통")){
            myPDFViewer.fromAsset("부작용 리포트/이소소르비드이질산염(isosorbide dinitrate) 스프레이 두통.pdf").load();
        }

        if(getItem.equals("이소트레티노인(isotretinoin) 모발 손실(탈모)")){
            myPDFViewer.fromAsset("부작용 리포트/이소트레티노인(isotretinoin) 모발 손실(탈모).pdf").load();
        }

        if(getItem.equals("졸피뎀(zolpidem) 몽유병")){
            myPDFViewer.fromAsset("부작용 리포트/졸피뎀(zolpidem) 몽유병.pdf").load();
        }

        if(getItem.equals("카르바마제핀(carbamazepine) 가려움증")){
            myPDFViewer.fromAsset("부작용 리포트/카르바마제핀(carbamazepine) 가려움증.pdf").load();
        }

        if(getItem.equals("카르베딜롤(carvedilol) 건선 악화")){
            myPDFViewer.fromAsset("부작용 리포트/카르베딜롤(carvedilol) 건선 악화.pdf").load();
        }

        if(getItem.equals("카베르골린(cabergoline) 가려움 및 피부변색")){
            myPDFViewer.fromAsset("부작용 리포트/카베르골린(cabergoline) 가려움 및 피부변색.pdf").load();
        }

        if(getItem.equals("콜키신(colchicine) 전신 증상(배뇨곤란, 관절통, 무기력 등)")){
            myPDFViewer.fromAsset("부작용 리포트/콜키신(colchicine) 전신 증상(배뇨곤란, 관절통, 무기력 등).pdf").load();
        }

        if(getItem.equals("클로미펜(clomiphene) 광시증(섬광증)")){
            myPDFViewer.fromAsset("부작용 리포트/클로미펜(clomiphene) 광시증(섬광증).pdf").load();
        }

        if(getItem.equals("타다라필(tadalafil) 근육통")){
            myPDFViewer.fromAsset("부작용 리포트/타다라필(tadalafil) 근육통.pdf").load();
        }

        if(getItem.equals("타크로리무스(tacrolimus) 근육경련")){
            myPDFViewer.fromAsset("부작용 리포트/타크로리무스(tacrolimus) 근육경련.pdf").load();
        }

        if(getItem.equals("타크로리무스(tacrolimus) 저림 및 눈밑떨림")){
            myPDFViewer.fromAsset("부작용 리포트/타크로리무스(tacrolimus) 저림 및 눈밑떨림.pdf").load();
        }

        if(getItem.equals("테네리글립틴(teneligliptin) 급성 췌장염")){
            myPDFViewer.fromAsset("부작용 리포트/테네리글립틴(teneligliptin) 급성 췌장염.pdf").load();
        }

        if(getItem.equals("테르비나핀(terbinafine) 미각 상실")){
            myPDFViewer.fromAsset("부작용 리포트/테르비나핀(terbinafine) 미각 상실.pdf").load();
        }

        if(getItem.equals("토피라메이트(topiramate) 모발 손실")){
            myPDFViewer.fromAsset("부작용 리포트/토피라메이트(topiramate) 모발 손실.pdf").load();
        }

        if(getItem.equals("툴로부테롤(tulobuterol) 패치 불면, 나쁜 기분 등")){
            myPDFViewer.fromAsset("부작용 리포트/툴로부테롤(tulobuterol) 패치 불면, 나쁜 기분 등.pdf").load();
        }

        if(getItem.equals("트레티노인(tretinoin) 피부 색소침착")){
            myPDFViewer.fromAsset("부작용 리포트/트레티노인(tretinoin) 피부 색소침착.pdf").load();
        }

        if(getItem.equals("티몰롤(timolol) 기침")){
            myPDFViewer.fromAsset("부작용 리포트/티몰롤(timolol) 기침.pdf").load();
        }

        if(getItem.equals("펜터민(phentermine) 호흡곤란(숨가쁨)")){
            myPDFViewer.fromAsset("부작용 리포트/펜터민(phentermine) 호흡곤란(숨가쁨).pdf").load();
        }

        if(getItem.equals("프레드니솔론(prednisolone) 어지러움 및 환각")){
            myPDFViewer.fromAsset("부작용 리포트/프레드니솔론(prednisolone) 어지러움 및 환각.pdf").load();
        }

        if(getItem.equals("플루나리진(flunarizine) 흐느적거리는 몸")){
            myPDFViewer.fromAsset("부작용 리포트/플루나리진(flunarizine) 흐느적거리는 몸.pdf").load();
        }

        if(getItem.equals("피나스테리드(finasteride) 남성 유방통")){
            myPDFViewer.fromAsset("부작용 리포트/피나스테리드(finasteride) 남성 유방통.pdf").load();
        }

        if(getItem.equals("피록시캄(piroxicam) 기침")){
            myPDFViewer.fromAsset("부작용 리포트/피록시캄(piroxicam) 기침.pdf").load();
        }

        if(getItem.equals("피르페니돈(pirfenidone) 피부발진 및 물집")){
            myPDFViewer.fromAsset("부작용 리포트/피르페니돈(pirfenidone) 피부발진 및 물집.pdf").load();
        }

        if(getItem.equals("피타바스타틴(pitavastatin) 간질성폐렴")){
            myPDFViewer.fromAsset("부작용 리포트/피타바스타틴(pitavastatin) 간질성폐렴.pdf").load();
        }

        if(getItem.equals("피타바스타틴(pitavastatin) 음주 시 혈뇨")){
            myPDFViewer.fromAsset("부작용 리포트/피타바스타틴(pitavastatin) 음주 시 혈뇨.pdf").load();
        }
    }
}