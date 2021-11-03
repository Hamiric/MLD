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
            myPDFViewer.fromAsset("알벤다졸.pdf").load();
        }

        if(getItem.equals("편두통약")){
            myPDFViewer.fromAsset("편두통약.pdf").load();
        }

        if(getItem.equals("항히스타민제")){
            myPDFViewer.fromAsset("항히스타민제.pdf").load();
        }

        if(getItem.equals("아스피린")){
            myPDFViewer.fromAsset("아스피린.pdf").load();
        }

        if(getItem.equals("사후피임약")){
            myPDFViewer.fromAsset("사후피임약.pdf").load();
        }

        if(getItem.equals("라니티딘")){
            myPDFViewer.fromAsset("라니티딘.pdf").load();
        }

        if(getItem.equals("에이즈 백신")){
            myPDFViewer.fromAsset("에이즈 백신.pdf").load();
        }

        if(getItem.equals("프로포폴")){
            myPDFViewer.fromAsset("프로포폴.pdf").load();
        }

        if(getItem.equals("신경안정제")){
            myPDFViewer.fromAsset("신경안정제.pdf").load();
        }

        if(getItem.equals("레보세티리진")){
            myPDFViewer.fromAsset("레보세티리진.pdf").load();
        }

        if(getItem.equals("흉터치료제")){
            myPDFViewer.fromAsset("흉터치료제.pdf").load();
        }

        if(getItem.equals("펜터민")){
            myPDFViewer.fromAsset("펜터민.pdf").load();
        }

        if(getItem.equals("생리 늦추는 약")){
            myPDFViewer.fromAsset("생리 늦추는 약.pdf").load();
        }

        if(getItem.equals("클로트리마졸")){
            myPDFViewer.fromAsset("클로트리마졸.pdf").load();
        }

        if(getItem.equals("식욕억제제")){
            myPDFViewer.fromAsset("식욕억제제.pdf").load();
        }

        if(getItem.equals("메토프롤롤")){
            myPDFViewer.fromAsset("메토프롤롤.pdf").load();
        }

        if(getItem.equals("항생제")){
            myPDFViewer.fromAsset("항생제.pdf").load();
        }

        if(getItem.equals("식염포도당")){
            myPDFViewer.fromAsset("식염포도당.pdf").load();
        }

        if(getItem.equals("습윤밴드")){
            myPDFViewer.fromAsset("습윤밴드.pdf").load();
        }

        if(getItem.equals("레보설피리드")){
            myPDFViewer.fromAsset("레보설피리드.pdf").load();
        }

        if(getItem.equals("인공눈물")){
            myPDFViewer.fromAsset("인공눈물.pdf").load();
        }

        if(getItem.equals("니자티딘")){
            myPDFViewer.fromAsset("니자티딘.pdf").load();
        }

        if(getItem.equals("화상연고")){
            myPDFViewer.fromAsset("화상연고.pdf").load();
        }

        if(getItem.equals("두타스테리드")){
            myPDFViewer.fromAsset("두타스테리드.pdf").load();
        }

        if(getItem.equals("진토제")){
            myPDFViewer.fromAsset("진토제.pdf").load();
        }

        if(getItem.equals("아토르바스타틴")){
            myPDFViewer.fromAsset("아토르바스타틴.pdf").load();
        }

        if(getItem.equals("구충제")){
            myPDFViewer.fromAsset("구충제.pdf").load();
        }

        if(getItem.equals("글리세린")){
            myPDFViewer.fromAsset("글리세린.pdf").load();
        }

        if(getItem.equals("제산제")){
            myPDFViewer.fromAsset("제산제.pdf").load();
        }

        if(getItem.equals("아목시실린")){
            myPDFViewer.fromAsset("아목시실린.pdf").load();
        }

        if(getItem.equals("항우울제")){
            myPDFViewer.fromAsset("항우울제.pdf").load();
        }

        if(getItem.equals("메틸페니데이트")){
            myPDFViewer.fromAsset("메틸페니데이트.pdf").load();
        }

        if(getItem.equals("두통약")){
            myPDFViewer.fromAsset("두통약.pdf").load();
        }

        if(getItem.equals("트리메부틴")){
            myPDFViewer.fromAsset("트리메부틴.pdf").load();
        }

        if(getItem.equals("인플루엔자 백신")){
            myPDFViewer.fromAsset("인플루엔자 백신.pdf").load();
        }

        if(getItem.equals("나프록센")){
            myPDFViewer.fromAsset("나프록센.pdf").load();
        }

        if(getItem.equals("치질약")){
            myPDFViewer.fromAsset("치질약.pdf").load();
        }

        if(getItem.equals("덱사메타손")){
            myPDFViewer.fromAsset("덱사메타손.pdf").load();
        }

        if(getItem.equals("근육이완제")){
            myPDFViewer.fromAsset("근육이완제.pdf").load();
        }

        if(getItem.equals("졸피뎀")){
            myPDFViewer.fromAsset("졸피뎀.pdf").load();
        }

        if(getItem.equals("항혈소판제")){
            myPDFViewer.fromAsset("항혈소판제.pdf").load();
        }

        if(getItem.equals("오메프라졸")){
            myPDFViewer.fromAsset("오메프라졸.pdf").load();
        }

        if(getItem.equals("금연보조제")){
            myPDFViewer.fromAsset("금연보조제.pdf").load();
        }

        if(getItem.equals("미다졸람")){
            myPDFViewer.fromAsset("미다졸람.pdf").load();
        }

        if(getItem.equals("녹내장 치료제")){
            myPDFViewer.fromAsset("녹내장 치료제.pdf").load();
        }

        if(getItem.equals("스피로노락톤")){
            myPDFViewer.fromAsset("스피로노락톤.pdf").load();
        }

        if(getItem.equals("해열제")){
            myPDFViewer.fromAsset("해열제.pdf").load();
        }

        if(getItem.equals("로페라미드")){
            myPDFViewer.fromAsset("로페라미드.pdf").load();
        }

        if(getItem.equals("성장호르몬 주사")){
            myPDFViewer.fromAsset("성장호르몬 주사.pdf").load();
        }

        if(getItem.equals("로베글리타존")){
            myPDFViewer.fromAsset("로베글리타존.pdf").load();
        }

        if(getItem.equals("손발톱무좀약")){
            myPDFViewer.fromAsset("손발톱무좀약.pdf").load();
        }

        if(getItem.equals("다폭세틴")){
            myPDFViewer.fromAsset("다폭세틴.pdf").load();
        }

        if(getItem.equals("주의력결핍 과잉행동장애 치료제")){
            myPDFViewer.fromAsset("주의력결핍 과잉행동장애 치료제.pdf").load();
        }

        if(getItem.equals("부포테닌")){
            myPDFViewer.fromAsset("부포테닌.pdf").load();
        }

        if(getItem.equals("수면제")){
            myPDFViewer.fromAsset("수면제.pdf").load();
        }

        if(getItem.equals("암페타민")){
            myPDFViewer.fromAsset("암페타민.pdf").load();
        }

        if(getItem.equals("A형 간염 백신")){
            myPDFViewer.fromAsset("A형 간염 백신.pdf").load();
        }

        if(getItem.equals("아편")){
            myPDFViewer.fromAsset("아편.pdf").load();
        }

        if(getItem.equals("향정신성의약품")){
            myPDFViewer.fromAsset("향정신성의약품.pdf").load();
        }

        if(getItem.equals("세레콕시브")){
            myPDFViewer.fromAsset("세레콕시브.pdf").load();
        }

        if(getItem.equals("항결핵제")){
            myPDFViewer.fromAsset("항결핵제.pdf").load();
        }

        if(getItem.equals("로수바스타틴")){
            myPDFViewer.fromAsset("로수바스타틴.pdf").load();
        }

        if(getItem.equals("지사제")){
            myPDFViewer.fromAsset("지사제.pdf").load();
        }

        if(getItem.equals("시클로피록스")){
            myPDFViewer.fromAsset("시클로피록스.pdf").load();
        }

        if(getItem.equals("여드름약")){
            myPDFViewer.fromAsset("여드름약.pdf").load();
        }

        if(getItem.equals("콜린알포세레이트")){
            myPDFViewer.fromAsset("콜린알포세레이트.pdf").load();
        }

        if(getItem.equals("벌레 물린데 바르는 약")){
            myPDFViewer.fromAsset("벌레 물린데 바르는 약.pdf").load();
        }

        if(getItem.equals("퓨시드산")){
            myPDFViewer.fromAsset("퓨시드산.pdf").load();
        }

        if(getItem.equals("탈모 치료제")){
            myPDFViewer.fromAsset("탈모 치료제.pdf").load();
        }

        if(getItem.equals("펜디메트라진")){
            myPDFViewer.fromAsset("펜디메트라진.pdf").load();
        }

        if(getItem.equals("방광염 치료제")){
            myPDFViewer.fromAsset("방광염 치료제.pdf").load();
        }

        if(getItem.equals("슈도에페드린")){
            myPDFViewer.fromAsset("슈도에페드린.pdf").load();
        }

        if(getItem.equals("피로회복제")){
            myPDFViewer.fromAsset("피로회복제.pdf").load();
        }

        if(getItem.equals("모사프리드")){
            myPDFViewer.fromAsset("모사프리드.pdf").load();
        }

        if(getItem.equals("소화성 궤양 치료제")){
            myPDFViewer.fromAsset("소화성 궤양 치료제.pdf").load();
        }

        if(getItem.equals("파모티딘")){
            myPDFViewer.fromAsset("파모티딘.pdf").load();
        }

        if(getItem.equals("신종플루백신")){
            myPDFViewer.fromAsset("신종플루백신.pdf").load();
        }

        if(getItem.equals("오셀타미비르")){
            myPDFViewer.fromAsset("오셀타미비르.pdf").load();
        }

        if(getItem.equals("뇌순환 개선제")){
            myPDFViewer.fromAsset("뇌순환 개선제.pdf").load();
        }

        if(getItem.equals("레보클로페라스틴")){
            myPDFViewer.fromAsset("레보클로페라스틴.pdf").load();
        }

        if(getItem.equals("진통제")){
            myPDFViewer.fromAsset("진통제.pdf").load();
        }

        if(getItem.equals("몬테루카스트")){
            myPDFViewer.fromAsset("몬테루카스트.pdf").load();
        }

        if(getItem.equals("협심증 치료제")){
            myPDFViewer.fromAsset("협심증 치료제.pdf").load();
        }

        if(getItem.equals("비소프롤롤")){
            myPDFViewer.fromAsset("비소프롤롤.pdf").load();
        }

        if(getItem.equals("건선 치료제")){
            myPDFViewer.fromAsset("건선 치료제.pdf").load();
        }

        if(getItem.equals("에스오메프라졸")){
            myPDFViewer.fromAsset("에스오메프라졸.pdf").load();
        }

        if(getItem.equals("당뇨병 치료제")){
            myPDFViewer.fromAsset("당뇨병 치료제.pdf").load();
        }

        if(getItem.equals("메트포르민")){
            myPDFViewer.fromAsset("메트포르민.pdf").load();
        }

        if(getItem.equals("팽창성 하제")){
            myPDFViewer.fromAsset("팽창성 하제.pdf").load();
        }

        if(getItem.equals("차전자피")){
            myPDFViewer.fromAsset("차전자피.pdf").load();
        }

        if(getItem.equals("폐렴구균백신")){
            myPDFViewer.fromAsset("폐렴구균백신.pdf").load();
        }

        if(getItem.equals("플루옥세틴")){
            myPDFViewer.fromAsset("플루옥세틴.pdf").load();
        }

        if(getItem.equals("항바이러스제")){
            myPDFViewer.fromAsset("항바이러스제.pdf").load();
        }

        if(getItem.equals("아지트로마이신")){
            myPDFViewer.fromAsset("아지트로마이신.pdf").load();
        }

        if(getItem.equals("에이즈 치료제")){
            myPDFViewer.fromAsset("에이즈 치료제.pdf").load();
        }

        if(getItem.equals("리라글루티드")){
            myPDFViewer.fromAsset("리라글루티드.pdf").load();
        }

        if(getItem.equals("항말라리아제")){
            myPDFViewer.fromAsset("항말라리아제.pdf").load();
        }

        if(getItem.equals("자나미비르")){
            myPDFViewer.fromAsset("자나미비르.pdf").load();
        }

        if(getItem.equals("천식약")){
            myPDFViewer.fromAsset("천식약.pdf").load();
        }

        if(getItem.equals("아세트아미노펜")){
            myPDFViewer.fromAsset("아세트아미노펜.pdf").load();
        }

        if(getItem.equals("비마약성 진통제")){
            myPDFViewer.fromAsset("비마약성 진통제.pdf").load();
        }

        if(getItem.equals("이부프로펜")){
            myPDFViewer.fromAsset("이부프로펜.pdf").load();
        }

        if(getItem.equals("감기약")){
            myPDFViewer.fromAsset("감기약.pdf").load();
        }

        if(getItem.equals("이버멕틴")){
            myPDFViewer.fromAsset("이버멕틴.pdf").load();
        }

        if(getItem.equals("항불안제")){
            myPDFViewer.fromAsset("항불안제.pdf").load();
        }

        if(getItem.equals("에스시탈로프람")){
            myPDFViewer.fromAsset("에스시탈로프람.pdf").load();
        }

        if(getItem.equals("영양제")){
            myPDFViewer.fromAsset("영양제.pdf").load();
        }

        if(getItem.equals("시프로플록사신")){
            myPDFViewer.fromAsset("시프로플록사신.pdf").load();
        }

        if(getItem.equals("소화제")){
            myPDFViewer.fromAsset("소화제.pdf").load();
        }

        if(getItem.equals("클로피도그렐")){
            myPDFViewer.fromAsset("클로피도그렐.pdf").load();
        }

        if(getItem.equals("이상지질혈증약")){
            myPDFViewer.fromAsset("이상지질혈증약.pdf").load();
        }

        if(getItem.equals("이소트레티노인")){
            myPDFViewer.fromAsset("이소트레티노인.pdf").load();
        }

        if(getItem.equals("부신피질호르몬제")){
            myPDFViewer.fromAsset("부신피질호르몬제.pdf").load();
        }

        if(getItem.equals("플루코나졸")){
            myPDFViewer.fromAsset("플루코나졸.pdf").load();
        }

        if(getItem.equals("대상포진 치료제")){
            myPDFViewer.fromAsset("대상포진 치료제.pdf").load();
        }

        if(getItem.equals("라록시펜")){
            myPDFViewer.fromAsset("라록시펜.pdf").load();
        }

        if(getItem.equals("땀띠약")){
            myPDFViewer.fromAsset("땀띠약.pdf").load();
        }

        if(getItem.equals("디펜히드라민")){
            myPDFViewer.fromAsset("디펜히드라민.pdf").load();
        }

        if(getItem.equals("멀미약")){
            myPDFViewer.fromAsset("멀미약.pdf").load();
        }

        if(getItem.equals("스멕타이트")){
            myPDFViewer.fromAsset("스멕타이트.pdf").load();
        }

        if(getItem.equals("국소 아토피 치료제")){
            myPDFViewer.fromAsset("국소 아토피 치료제.pdf").load();
        }

        if(getItem.equals("멜라토닌")){
            myPDFViewer.fromAsset("멜라토닌.pdf").load();
        }

        if(getItem.equals("진경제")){
            myPDFViewer.fromAsset("진경제.pdf").load();
        }

        if(getItem.equals("발사르탄")){
            myPDFViewer.fromAsset("발사르탄.pdf").load();
        }

        if(getItem.equals("수용성 비타민")){
            myPDFViewer.fromAsset("수용성 비타민.pdf").load();
        }

        if(getItem.equals("알프라졸람")){
            myPDFViewer.fromAsset("알프라졸람.pdf").load();
        }

        if(getItem.equals("지용성 비타민")){
            myPDFViewer.fromAsset("지용성 비타민.pdf").load();
        }

        if(getItem.equals("돔페리돈")){
            myPDFViewer.fromAsset("돔페리돈.pdf").load();
        }

        if(getItem.equals("비염 치료제")){
            myPDFViewer.fromAsset("비염 치료제.pdf").load();
        }

        if(getItem.equals("암브록솔")){
            myPDFViewer.fromAsset("암브록솔.pdf").load();
        }

        if(getItem.equals("비듬약")){
            myPDFViewer.fromAsset("비듬약.pdf").load();
        }

        if(getItem.equals("인플릭시맵")){
            myPDFViewer.fromAsset("인플릭시맵.pdf").load();
        }

        if(getItem.equals("안구건조증 치료제")){
            myPDFViewer.fromAsset("안구건조증 치료제.pdf").load();
        }

        if(getItem.equals("라도티닙")){
            myPDFViewer.fromAsset("라도티닙.pdf").load();
        }

        if(getItem.equals("치매치료제")){
            myPDFViewer.fromAsset("치매치료제.pdf").load();
        }

        if(getItem.equals("미라베그론")){
            myPDFViewer.fromAsset("미라베그론.pdf").load();
        }

        if(getItem.equals("혈액순환제")){
            myPDFViewer.fromAsset("혈액순환제.pdf").load();
        }

        if(getItem.equals("비사코딜")){
            myPDFViewer.fromAsset("비사코딜.pdf").load();
        }

        if(getItem.equals("백신")){
            myPDFViewer.fromAsset("백신.pdf").load();
        }

        if(getItem.equals("리바록사반")){
            myPDFViewer.fromAsset("리바록사반.pdf").load();
        }

        if(getItem.equals("동상연고")){
            myPDFViewer.fromAsset("동상연고.pdf").load();
        }

        if(getItem.equals("니코틴")){
            myPDFViewer.fromAsset("니코틴.pdf").load();
        }

        if(getItem.equals("근육통약")){
            myPDFViewer.fromAsset("근육통약.pdf").load();
        }

        if(getItem.equals("미녹시딜")){
            myPDFViewer.fromAsset("미녹시딜.pdf").load();
        }

        if(getItem.equals("요실금 치료제")){
            myPDFViewer.fromAsset("요실금 치료제.pdf").load();
        }

        if(getItem.equals("시타글립틴")){
            myPDFViewer.fromAsset("시타글립틴.pdf").load();
        }

        if(getItem.equals("골다공증약")){
            myPDFViewer.fromAsset("골다공증약.pdf").load();
        }

        if(getItem.equals("트라마돌")){
            myPDFViewer.fromAsset("트라마돌.pdf").load();
        }

        if(getItem.equals("역류성 식도염 치료제")){
            myPDFViewer.fromAsset("역류성 식도염 치료제.pdf").load();
        }

        if(getItem.equals("렘데시비르")){
            myPDFViewer.fromAsset("렘데시비르.pdf").load();
        }

        if(getItem.equals("폐렴약")){
            myPDFViewer.fromAsset("폐렴약.pdf").load();
        }

        if(getItem.equals("밀크시슬엑스")){
            myPDFViewer.fromAsset("밀크시슬엑스.pdf").load();
        }

        if(getItem.equals("하이드로콜로이드 밴드")){
            myPDFViewer.fromAsset("하이드로콜로이드 밴드.pdf").load();
        }

        if(getItem.equals("에제티미브")){
            myPDFViewer.fromAsset("에제티미브.pdf").load();
        }

        if(getItem.equals("조산방지제")){
            myPDFViewer.fromAsset("조산방지제.pdf").load();
        }

        if(getItem.equals("칼시트리올")){
            myPDFViewer.fromAsset("칼시트리올.pdf").load();
        }

        if(getItem.equals("BCG 백신")){
            myPDFViewer.fromAsset("BCG 백신.pdf").load();
        }

        if(getItem.equals("로라타딘")){
            myPDFViewer.fromAsset("로라타딘.pdf").load();
        }

        if(getItem.equals("항응고제")){
            myPDFViewer.fromAsset("항응고제.pdf").load();
        }

        if(getItem.equals("레보티록신")){
            myPDFViewer.fromAsset("레보티록신.pdf").load();
        }

        if(getItem.equals("심부전 치료제")){
            myPDFViewer.fromAsset("심부전 치료제.pdf").load();
        }

        if(getItem.equals("콜키신")){
            myPDFViewer.fromAsset("콜키신.pdf").load();
        }

        if(getItem.equals("무좀약")){
            myPDFViewer.fromAsset("무좀약.pdf").load();
        }

        if(getItem.equals("포도씨건조엑스")){
            myPDFViewer.fromAsset("포도씨건조엑스.pdf").load();
        }

        if(getItem.equals("질염약")){
            myPDFViewer.fromAsset("질염약.pdf").load();
        }

        if(getItem.equals("테트라사이클린")){
            myPDFViewer.fromAsset("테트라사이클린.pdf").load();
        }

        if(getItem.equals("전립선비대증 치료제")){
            myPDFViewer.fromAsset("전립선비대증 치료제.pdf").load();
        }

        if(getItem.equals("공액리놀레산")){
            myPDFViewer.fromAsset("공액리놀레산.pdf").load();
        }

        if(getItem.equals("항암제")){
            myPDFViewer.fromAsset("항암제.pdf").load();
        }

        if(getItem.equals("독시라민")){
            myPDFViewer.fromAsset("독시라민.pdf").load();
        }

        if(getItem.equals("가정상비약")){
            myPDFViewer.fromAsset("가정상비약.pdf").load();
        }

        if(getItem.equals("트레티노인")){
            myPDFViewer.fromAsset("트레티노인.pdf").load();
        }

        if(getItem.equals("자궁경부암 백신")){
            myPDFViewer.fromAsset("자궁경부암 백신.pdf").load();
        }

        if(getItem.equals("덱시부프로펜")){
            myPDFViewer.fromAsset("덱시부프로펜.pdf").load();
        }

        if(getItem.equals("고혈압 치료제")){
            myPDFViewer.fromAsset("고혈압 치료제.pdf").load();
        }

        if(getItem.equals("바레니클린")){
            myPDFViewer.fromAsset("바레니클린.pdf").load();
        }

        if(getItem.equals("배란촉진제")){
            myPDFViewer.fromAsset("배란촉진제.pdf").load();
        }

        if(getItem.equals("로사르탄")){
            myPDFViewer.fromAsset("로사르탄.pdf").load();
        }

        if(getItem.equals("이명치료제")){
            myPDFViewer.fromAsset("이명치료제.pdf").load();
        }
    }
}