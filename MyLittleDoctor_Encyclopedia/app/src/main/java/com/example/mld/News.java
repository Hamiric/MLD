package com.example.mld;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

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
import android.widget.Toast;

import java.util.ArrayList;

public class News extends AppCompatActivity {
    ListView pdfListView;
    ArrayList<String> stringArrayList = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ActionBar actionBar = getSupportActionBar();
        SearchView searchView = findViewById(R.id.search_view);


        pdfListView = findViewById(R.id.myPDFList);

        stringArrayList.add("2개의 일반적인 체중감량 수술을 비교한 연구");
        stringArrayList.add("40세 미만의 대상포진 환자에서 뇌졸중 발생 위험이 증가할 수 있다");
        stringArrayList.add("ADHD 의약품이 폐경기 여성에게도 도움이 될 수 있을까");
        stringArrayList.add("ADHD 치료제가 비만 위험의 증가와 관련이 있다");
        stringArrayList.add("ASHP 가이드라인 - 약사의 환자 교육과 상담 (1)");
        stringArrayList.add("ASHP 가이드라인 - 약사의 환자 교육과 상담 (2)");
        stringArrayList.add("C형 간염과 연관된 두경부암");
        stringArrayList.add("FDA에서는 암젠의 심부전 치료약을 승인한다");
        stringArrayList.add("가장 효과적인 모기 기피제 선택 방법");
        stringArrayList.add("가정보관의약품(family medication)을 안전하게 관리하는 간단한 3가지 방법");
        stringArrayList.add("가정에서 사용하는 살충제 스프레이의 어린이암 유발 가능성");
        stringArrayList.add("갑상선기능항진증-유방암 연관성");
        stringArrayList.add("갑작스런 혈압 강하, 치매 위험 높일 수 있어");
        stringArrayList.add("개국약국에서의 당뇨병 및 심혈관질환의 위험요인에 대한 스크리닝의 효과 (1)");
        stringArrayList.add("개국약국에서의 당뇨병 및 심혈관질환의 위험요인에 대한 스크리닝의 효과 (2)");
        stringArrayList.add("개정된 콜레스테롤 가이드라인은 심혈관질환 위험을 정확하게 확인한다");
        stringArrayList.add("건강상태를 추적하는 전자피부");
        stringArrayList.add("경도인지 장애 환자의 기억력 향상시킬 수 있는 게임 앱 개발");
        stringArrayList.add("고농도의 염이 포함된 발포정은 심장질환 환자에게 부담을 줄 수 있다");
        stringArrayList.add("고용량의 비타민 E 복용이 알츠하이머병의 진행 속도를 늦출 수 있다");
        stringArrayList.add("고지방 음식을 섭취하더라도 체중증가를 피할 수 있다면");
        stringArrayList.add("고지혈증 치료제가 잇몸염증을 감소시킨다");
        stringArrayList.add("고추 성분이 유방암 억제할 수 있다");
        stringArrayList.add("고칼로리 식이요법이 루게릭병의 진행속도를 늦출 수 있다");
        stringArrayList.add("공기오염이 제2형 당뇨병 위험 높일 수 있다");
        stringArrayList.add("과도한 녹차섭취는 건강에 해로운가");
        stringArrayList.add("과민성 대장증후군(IBS)과 연관된 비타민D 결핍");
        stringArrayList.add("궤양성 대장염, 식초로 치료할 수 있다");
        stringArrayList.add("규칙적으로 샤워하더라도 피부 미생물은 여전히 남아있다");
        stringArrayList.add("규칙적인 식습관, 심질환 예방에 도움 된다");
        stringArrayList.add("금연을 위한 지역약국 기반의 약물학적 중재와 방법에 대한 고찰 (1)");
        stringArrayList.add("금연을 위한 지역약국 기반의 약물학적 중재와 방법에 대한 고찰 (2)");
        stringArrayList.add("기존 항암치료 뛰어 넘는 새로운 암 세포 사멸 기술 발견");
        stringArrayList.add("남성 유방암 관련 단백질 발견, 새로운 치료의 길 열릴까");
        stringArrayList.add("낭포성 섬유증 치료제가 FDA 자문 패널의 승인을 받다");
        stringArrayList.add("낮은 수치의 비타민 D는 질병의 원인보다는 결과와 관련이 있다");
        stringArrayList.add("낮잠 1시간, 노인 기억력 향상에 도움 된다");
        stringArrayList.add("노인에게 독감 백신이 덜 효과적인 이유");
        stringArrayList.add("높은 에스트로겐 수치와 당뇨는 치매 위험을 증가시킨다");
        stringArrayList.add("높은 혈당은 알츠하이머 질병의 원인이 될 수 있을까");
        stringArrayList.add("뇌 MRI 촬영으로 자살 위험 예측할 수 있다");
        stringArrayList.add("뇌질환으로서의 비만, 새로운 치료법");
        stringArrayList.add("다발성 경화증이나 건선치료에 쓰이는 의약품의 성분이 두 개의 치명적 뇌 감염과 관련이 있다고 밝혀졌다. 하지만 전문가들은 이 합병증은 드문 것이고 약을 중단할 필요는 없다고 말한다");
        stringArrayList.add("당뇨병 약은 심부전 위험을 악화시키지 않는다");
        stringArrayList.add("당뇨병, 패취제로 인슐린 투여 가능해진다");
        stringArrayList.add("당뇨병성 신장 질환에서 ACE 억제제와 ARB 제제를 병용투여하면 신장에 손상을 줄 수 있다");
        stringArrayList.add("당뇨약 메트포르민은 일부 환자에게서 갑상선 기능에 영향을 미칠 수 있다");
        stringArrayList.add("대학생의 17% 가 ADHD 약물을 남용하고 있다");
        stringArrayList.add("류마티스 관절염 있으면 만성폐쇄성폐질환(COPD) 위험 높아질 수 있다");
        stringArrayList.add("마그네슘이 혈압을 조절할 수 있을까");
        stringArrayList.add("만성 신경통의 새로운 기전 밝혀져 - 새로운 치료법 개발 기대");
        stringArrayList.add("만성적인 수면 방해, 간암 위험 높일 수 있다");
        stringArrayList.add("매일 견과류 한 줌, 여러 질환 및 사망 위험 낮춘다");
        stringArrayList.add("매일 아스피린을 복용하는 것이 난소암의 위험을 20퍼센트 낮춘다");
        stringArrayList.add("메트포르민, 취약 X 증후군 치료제로서의 잠재적 가능성 보여");
        stringArrayList.add("면역억제제인 마이코페놀산은 유산이나 선척적 기형의 위험을 증가시킬 수 있다");
        stringArrayList.add("미국 FDA는 수면제인 루네스타(Lunesta)의 초기 복용량을 낮추라고 지시했다");
        stringArrayList.add("미국 질병통제예방센터, 지카 바이러스-소두증 연관성 보도");
        stringArrayList.add("반려동물이 신생아 장내세균 변화시켜 알레르기와 비만 위험 낮춘다");
        stringArrayList.add("배고픔 느끼는 정도, 칼로리 섭취량과 관련 없다");
        stringArrayList.add("벤조디아제핀 장기복용은 알츠하이머 위험을 증가시킨다");
        stringArrayList.add("변비, 신장질환의 위험인자일 수 있다");
        stringArrayList.add("변화하는 보건의료환경에서의 약사의 역할 (1)");
        stringArrayList.add("변화하는 보건의료환경에서의 약사의 역할 (2)");
        stringArrayList.add("비만 아동들에게 어떻게 약물을 투여해야 하는가");
        stringArrayList.add("비만인 사람들이 대장암에 잘 걸리는 이유");
        stringArrayList.add("비타민 B3, 유산 및 선천성 기형 예방에 도움 된다");
        stringArrayList.add("비타민 C는 운동 후 기도폐쇄 또는 호흡기 증상에 도움이 될 수 있다");
        stringArrayList.add("비타민 D만으로는 골 건강이 향상되지 않는다");
        stringArrayList.add("비타민 D의 수준이 낮으면 알츠하이머의 위험을 증가시킬 수 있다");
        stringArrayList.add("비타민 및 무기질 보충제가 ADHD 치료에 도움이 될까");
        stringArrayList.add("비타민D 저하는 비알코올성 지방간 질환 위험을 증가시킨다");
        stringArrayList.add("비타민D의 부족은 침습성 진행형 전립선암과 연관이 있다");
        stringArrayList.add("새로운 C형 간염 치료제로써 경구용 복합제가 연구 중에 있다");
        stringArrayList.add("새로운 뎅기열 바이러스 백신, 효과입증");
        stringArrayList.add("새로운 콜레스테롤 치료 가이드라인 약사에 대한 영향");
        stringArrayList.add("새로운 혈압 가이드라인은 약물 사용을 줄일 수 있다");
        stringArrayList.add("설탕이 정신건강에도 해로울 수 있다");
        stringArrayList.add("세균과 독소에 반응하는 물질을 이용한 의약외품 개발");
        stringArrayList.add("수면 부족한 어린이, 제2형 당뇨병 위험 높아진다");
        stringArrayList.add("수면을 유도하는 새로운 뇌세포 밝혀져");
        stringArrayList.add("스마트렌즈, 녹내장 진행 위험 예측할 수 있다");
        stringArrayList.add("스타틴계 약물은 전립선암 생존을 향상시키는데 도움이 될 수 있다");
        stringArrayList.add("스타틴은 수면무호흡중과 연관된 심장 위험을 줄인다");
        stringArrayList.add("스타틴이 당뇨와 관련된 신경손상을 예방하는데 도움이 될 수 있다");
        stringArrayList.add("스타틴이 심장 구조와 기능 향상시킬 수 있다");
        stringArrayList.add("식사에 집중하는 것이 체중 감량에 도움 될 수 있다");
        stringArrayList.add("식이단백질을 많이 섭취하는 것이 체중 조절에 도움이 된다는 주장을 뒷받침하는 새로운 연구 결과");
        stringArrayList.add("식품첨가제, 장내세균 변화시켜 대장암 발생 촉진할 수 있다");
        stringArrayList.add("신약은 편두통을 예방하는데 도움이 될 수 있다");
        stringArrayList.add("실험약물은 화학요법 없이 백혈병의 생존율을 높일 수 있다");
        stringArrayList.add("아기 성별이 엄마의 면역력에 영향을 줄 수 있다");
        stringArrayList.add("아세트아미노펜 중독, 약사가 알아야 할 것들");
        stringArrayList.add("아세트아미노펜의 위험은 과소평가되었을 수 있다");
        stringArrayList.add("아스피린은 자간전증의 위험이 있는 모든 산모들에게 도움이 된다");
        stringArrayList.add("아침 식사를 거르는 것이 대사에 미치는 영향, 체중에 따라 다르다");
        stringArrayList.add("알레르기성 비염과 비강내 코르티코스테로이드 스프레이(1)");
        stringArrayList.add("알레르기성 비염과 비강내 코르티코스테로이드 스프레이(2)");
        stringArrayList.add("알츠하이머병, 증상 나타나기 훨씬 전에 예측할 수 있다면");
        stringArrayList.add("약국에서 듣는 음악이 태도에 미치는 영향");
        stringArrayList.add("약국에서 유망한 Point-of-Care(POC) HIV 검사");
        stringArrayList.add("약물 상호 작용에 따른 위장 출혈");
        stringArrayList.add("약사 주도 사례관리가 뇌졸중 환자의 혈압 및 콜레스테롤 수치를 개선시킬 수 있다");
        stringArrayList.add("약사가 복약순응도를 향상시킬 수 있는 5가지 방법");
        stringArrayList.add("약사들이 슈퍼버그 확산을 막기 위한 3가지 방법");
        stringArrayList.add("약사들이 아세트아미노펜 과다복용을 예방하기 위한 방법");
        stringArrayList.add("약사를 위한 환자 복약지도 도구");
        stringArrayList.add("어린 시절 비타민D 부족이 나중에 심장 위험과 관련이 있다");
        stringArrayList.add("어린 시절 자주 이사하면 자살위험 증가");
        stringArrayList.add("어린이 약물 과다복용을 억제하기 위한 3단계 조치");
        stringArrayList.add("어린이의 에너지 음료 섭취 위험은 교육할 필요가 있다");
        stringArrayList.add("에너지 음료가 24시간 이내 체내에 미치는 영향");
        stringArrayList.add("에너지음료 소비증가가 국민건강을 위협할 수 있다");
        stringArrayList.add("에볼라 바이러스에 대한 환자 평가 의사들을 위한 CDC 권고사항");
        stringArrayList.add("여성들을 위한 유방암 예방에의 기여 약사들의 도전");
        stringArrayList.add("연구에서 확인된 신장질환에 대한 조기 경보 신호");
        stringArrayList.add("엽산보충제는 저체중아가 태어나는 위험을 감소시킨다");
        stringArrayList.add("영국 NICE 지질관리 가이드라인 개정");
        stringArrayList.add("오래 숙성된 치즈 속 성분이 간암을 예방하고 수명 연장할 수 있다");
        stringArrayList.add("오메가-3 지방산의 섭취는 뇌의 노화를 늦출 수 있다");
        stringArrayList.add("오메가3, 비타민, 미네랄 보충제가 아동의 공격성을 줄여준다");
        stringArrayList.add("오메가3지방산 보충제는 안구건조 증상을 개선할 수 있는가");
        stringArrayList.add("와파린 처방에는 다른 약물과의 심각한 상호작용이 잠재되어 있다");
        stringArrayList.add("왜 메르스 백신이 없는가 통찰력 부족은 과학자들에게 좌절감을 일으킨다");
        stringArrayList.add("운동이 금연에 도움 되는 것으로 밝혀져");
        stringArrayList.add("운동이 유방암 발병 위험을 감소시킬 수 있다");
        stringArrayList.add("운동이 일부 질환으로 인한 사망률을 낮추는데 약만큼 효과가 있다");
        stringArrayList.add("원인을 알 수 없는 기침을 치료하기 위한 6가지 가이드라인");
        stringArrayList.add("위산분비 억제제가 비타민 B12의 결핍을 초래할 수 있다");
        stringArrayList.add("유명한 속쓰림 약이 심장마비 위험을 높이는 것과 연관이 있다");
        stringArrayList.add("유방암 위험에 영향을 미치는 과일과 알코올");
        stringArrayList.add("유아기, 천식위험을 줄이기 위한 3가지 방법");
        stringArrayList.add("의료사고, 미국의 주요 사망원인 3위");
        stringArrayList.add("인슐린 저항성 개선에 도움이 되는 식이요법 팁");
        stringArrayList.add("인터페론을 포함하지 않는 애브비 요법이 유전자 1형 HCV 환자의 96 퍼센트를 치료하다");
        stringArrayList.add("일반적인 항생제 조합은 돌연사의 원인이 될 수 있다");
        stringArrayList.add("일반커피냐, 디카페인 커피냐 둘 다 간에 도움이 될 수 있다");
        stringArrayList.add("일부 OTC 국소 여드름 치료제는 심각한 유해반응을 야기할 수 있다");
        stringArrayList.add("임산부의 식습관이 질병유전에 미치는 영향");
        stringArrayList.add("임신 중 감초 섭취, 자녀의 ADHD와 관련 있나");
        stringArrayList.add("임신 중 아세트아미노펜 복용과 아이의 행동문제의 연관성");
        stringArrayList.add("임신 중 항우울제 복용은 신생아의 지속성 페동맥 고혈압의 위험성과 관련이 있다");
        stringArrayList.add("자기 전에 아스피린을 복용하는 것이 심장보호에 효과적이다");
        stringArrayList.add("자폐증 정확하게 진달할 수 있는 생화학적 방법 개발돼");
        stringArrayList.add("장내세균이 과민성대장증후군 환자의 뇌에도 영향 준다");
        stringArrayList.add("저열량 인공감미료, 오히려 지방 형성 높일 수 있다");
        stringArrayList.add("저지방 우유, 요거트 섭취가 우울증 위험 낮춘다");
        stringArrayList.add("저지방 유제품이 파킨슨병 위험 높이나");
        stringArrayList.add("저체중 노인, 알츠하이머 발병 위험 높다");
        stringArrayList.add("전자파는 치명적인 뇌종양 치료에 도움이 될 수 있다");
        stringArrayList.add("정신병, 뇌 염증과 관련있다고 밝혀져 - 항체 치료가 새로운 희망으로 부상");
        stringArrayList.add("정신적 스트레스가 어떻게 질병을 유발하는가");
        stringArrayList.add("제1형 당뇨병 환자 중 약 절반은 인슐린 생산 새로운 치료의 길 열릴까");
        stringArrayList.add("제2형 당뇨병 환자들의 혈압 및 콜레스테롤 수치를 집중 치료하는 것이 기억력 감소의 위험을 낮추는데 도움이 되지 않는다");
        stringArrayList.add("제네릭 의약품이 유방암 환자의 치료 지속에 도움이 될 수 있다");
        stringArrayList.add("줄기세포 이식으로 골다공증 쥐 완치");
        stringArrayList.add("줄기세포 치료가 심부전 환자의 심장 손상 악화시킬 수 있다");
        stringArrayList.add("중동호흡기증후군 코로나바이러스(MERS-CoV)의 정의와 증상");
        stringArrayList.add("지방세포 크기 줄이는 신약 개발되나");
        stringArrayList.add("지속적으로 삶을 즐기는 사람이 더 오래 산다");
        stringArrayList.add("지중해식단, 인지력 감퇴를 늦추고 알츠하이머 예방한다");
        stringArrayList.add("진드기와 라임 병 우리는 얼마나 걱정해야 하는가");
        stringArrayList.add("진통제 트라마돌은 저혈당과 관련이 있다.");
        stringArrayList.add("질병을 유발하는 유전자돌연변이에도 건강한 사람 발견");
        stringArrayList.add("책상에 앉아서 일하는 사람들을 위한 에너지 증진 방법");
        stringArrayList.add("처음으로 FDA 패널이 고가 바이오 의약품에 대한 제네릭 의약품을 승인한다");
        stringArrayList.add("철분 부족하면 심질환 위험 높아질 수 있다");
        stringArrayList.add("청소년들의 전자담배 흡연 증가가 일반담배 흡연의 증가와 관계가 있다");
        stringArrayList.add("체중 적으면 폐경 앞당겨질 수 있다");
        stringArrayList.add("체지방을 없애기 위해서는 칼로리가 지방이나 탄수화물보다 더 중요할 수 있다");
        stringArrayList.add("충분한 수분 섭취는 신장결석 위험을 감소시킬 수 있다");
        stringArrayList.add("치매 환자 중 20%, 초미세먼지 때문일 수 있다");
        stringArrayList.add("치즈 매일 섭취하면 심질환 예방에 도움 된다");
        stringArrayList.add("카페인은 ADHD 환자에게 어떤 효과가 있을까");
        stringArrayList.add("칼로리가 낮은 감미료는 유용한가 위험한가");
        stringArrayList.add("칼륨이 풍부한 식단은 당뇨환자의 신장을 보호할 수 있다");
        stringArrayList.add("칼슘채널차단제, 암 전이 억제에 효과적일 수 있다");
        stringArrayList.add("케일 속 루테인 성분, 인지기능에도 도움 된다");
        stringArrayList.add("코 분비물 검사(Nasal Swab)로 폐암 여부 알 수 있다");
        stringArrayList.add("코르티코스테로이드류가 중증 천식 환자를 완벽하게 치료하지 못하는 이유");
        stringArrayList.add("콜드 터키(Cold Turkey), 가장 효과적인 금연법");
        stringArrayList.add("콜레스테롤 약은 다발성경화증의 진행을 늦추는데 도움을 줄 수 있다");
        stringArrayList.add("콩, 채소 그리고 뇌를 위한 가장 좋은 음식");
        stringArrayList.add("크런치효과(Crunch effect) 어떻게 식욕을 억제할 수 있을까");
        stringArrayList.add("클로람부실과 오비누투주맙의 병용투여가 백혈병 노인 환자들의 삶을 연장시킬 수 있다는 연구결과가 나왔다");
        stringArrayList.add("탈모와 흰머리 원인 규명돼");
        stringArrayList.add("통조림 음식에 들어있는 비스페놀 A(BPA)가 혈압을 높일 수 있다");
        stringArrayList.add("편두통 약이 일부 청소년의 식이장애 위험을 높일 수 있다");
        stringArrayList.add("폐경 여성, 알츠하이머병에 더 취약할 수 있다");
        stringArrayList.add("피임주사는 HIV 위험성을 증가시킬 수 있다");
        stringArrayList.add("하루 8잔 물 섭취 목마를 때에만 마시는 것이 좋다");
        stringArrayList.add("항구토제인 메토클로프라미드는 임산부에게 사용할 수 있다");
        stringArrayList.add("항우울제 복용으로 사망 위험 높아질 수 있다");
        stringArrayList.add("항우울제 셀렉사(Celexa)가 알츠하이머 환자의 불안감을 완화하는데 도움이 된다");
        stringArrayList.add("항우울제로 파킨슨병 진행 늦출 수 있다");
        stringArrayList.add("항응고제 프라닥사(Pradaxa) 처방 시 주의가 필요하다고 연구(보고서)는 경고한다");
        stringArrayList.add("항체검사는 예방단계에서 알츠하이머를 발견할 수 있다");
        stringArrayList.add("항체를 생산하기 위해 개발된 혁신적인 기술");
        stringArrayList.add("항혈액응고제와 특정 진통제를 함께 복용하는 것은 출혈의 위험을 높일 수 있다");
        stringArrayList.add("헬리코박터 파일로리 치료를 위한 새로운 가이드라인");
        stringArrayList.add("혈당조절과 체중감소에 효과가 있는 당뇨병 신약이 개발 중에 있다");
        stringArrayList.add("호르몬 요법을 이용한 새로운 폐경기 가이드라인");
        stringArrayList.add("환자 순응도에 영향을 주는 약사");
        stringArrayList.add("환자들이 인지하지 못하는 일반의약품 과다복용의 위험");
        stringArrayList.add("휴대폰 장기 사용은 뇌종양 위험과 관련된다");
        stringArrayList.add("흡연은 만성 허리통증 증가와 관련이 있다");
        stringArrayList.add("흡연은 정신 분열증에 원인이 되는가");

        // 맨 밑에 있는 두개가 칸이 잘려서 안보이길래 공백으로 두칸 넣었음
        stringArrayList.add("");
        stringArrayList.add("");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(News.this,android.R.layout.simple_list_item_1,stringArrayList)
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
        menuInflater.inflate((R.menu.menu_search),menu);
        MenuItem menuItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        return super.onCreateOptionsMenu(menu);

    }


    public void GoNews(View view) {
    }

    public void GoSideEffect(View view) {
    }
}