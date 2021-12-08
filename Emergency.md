#응급상식

응급상식             |  응급상식(심폐소생술)  | 
:-------------------------:|:-------------------------:
![](https://user-images.githubusercontent.com/58100710/145129311-e7361e16-c4ad-4890-88e8-34d6ad5a69e5.png)  |  ![](https://user-images.githubusercontent.com/58100710/145129318-b778e354-7e96-4575-9e41-b698d0acad36.png)

## 기능소개
응급상황시 사용할 수 있는 지식/상식 정보를 제공한다.
제공정보는 원주시청 홈페이지에서 제공하는 '상황별 응급처지 - 응급상식'에 있는 정보를 사용자에게 제공한다.

## 사용 웹페이지
-[원주시청(상황별응급처치)](https://www.wonju.go.kr/health/contents.do?key=1690&)

## 주요 코드
> Emergency (JAVA)
```java
public class Emergency extends AppCompatActivity {
    Button image_btn1, image_btn2, image_btn3, image_btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
    }

    public void menu(View view) {
    }
    
    // 심폐소생술 PDF 
    public static class CprPDF extends AppCompatActivity {

        private PDFView cpr;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cprpdf);

            // 각 pdf xml에 부여한 id 
            cpr = (PDFView) findViewById(R.id.buttonpdf1);
            cpr.fromAsset("응급상식/심폐소생술.pdf").load();
        }
    }

    // 소아 심폐소생술 PDF
    public static class ChildrenCprPDF extends AppCompatActivity {

        private PDFView childrencpr;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_childrencprpdf);

            childrencpr = (PDFView) findViewById(R.id.buttonpdf2);
            childrencpr.fromAsset("응급상식/소아 심폐소생술.pdf").load();
        }
    }
    
    // 기도폐쇄 PDF
    public static class AirwayObstructionPDF extends AppCompatActivity {

        private PDFView airwayobstruction;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_airway_obstruction_pdf);

            airwayobstruction = (PDFView) findViewById(R.id.buttonpdf3);
            airwayobstruction.fromAsset("응급상식/기도폐쇄.pdf").load();
        }
    }

  
    // 상황별 응급처치 PDF
    public static class FirstAidForEachSituationPDF extends AppCompatActivity {

        private PDFView firstaidforeachsituation;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_first_aid_for_each_situation_pdf);

            firstaidforeachsituation = (PDFView) findViewById(R.id.buttonpdf4);
            firstaidforeachsituation.fromAsset("응급상식/상황별 응급처치.pdf").load();
        }
    }
}
```
각 버튼을 클릭했을 때 설정해놓은 pdf가 실행되게 하는 파트이다.

> cprpdf (xml)
```xml
// pdf 실행 시켜주는 github
 <com.github.barteksc.pdfviewer.PDFView
        android:id="@+id/buttonpdf1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```
소아 심폐소생술, 기도폐쇄, 상황별 응급처치도 이와 동일하다.
