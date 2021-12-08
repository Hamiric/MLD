# 건강정보

약물백과             |  의학뉴스(해외의학뉴스) |  부작용리포트
:-------------------------:|:-------------------------:|:-------------------------:
![](https://user-images.githubusercontent.com/58100710/144931307-1b9e25a0-06da-4513-865c-3be591749891.png)  |  ![](https://user-images.githubusercontent.com/58100710/144931313-6ad750d8-0165-44bd-b3d2-1c07dadfcec9.png) | ![](https://user-images.githubusercontent.com/58100710/144931316-dbf02cd9-4e1e-466c-a134-8d0d12b3f377.png)
약품검색            |  약품검색("베실" 검색결과) | 약품검색(네오드로핀정)
![](https://user-images.githubusercontent.com/58100710/144931328-a4f63b25-9b96-41dd-88d3-bf70699351e5.png)  |  ![](https://user-images.githubusercontent.com/58100710/145131932-0113c74f-af75-4607-acd7-07bef2489320.png) | ![](https://user-images.githubusercontent.com/58100710/145132045-5c31fc00-a1ce-4209-9878-e75322e11f51.png)

## 기능 소개
의학상식, 의학뉴스와 같은 사용자에게 유용한 의학정보들과 의약품 검색기능을 통한 의약품 정보를 제공한다.
**약물백과**, **의학뉴스**, **부작용리포트** 의 내용은 '약학정보원'에서 제공하는 정보를 가져왔으며, **약품검색** 은 '의약품안전나라'에서 제공하는 의약품 데이터를 기반으로 정보를 제공한다.

## 관련 웹페이지
- [약학정보원](https://www.health.kr/)
- [의약품안전나라](https://nedrug.mfds.go.kr/index)

## 주요 코드
>EncyclopediarActivity (JAVA)
```java
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
        
        
        // ListView에 목록 추가
        stringArrayList.add("A형 간염 백신");
        //...
        
        
        
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
```
ListView에 약학정보원에서 가져온 약물의 정보를 입력한다. 

>PDFOpener (JAVA)
```java
public class PDFOpener extends AppCompatActivity {

    PDFView myPDFViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener);




        myPDFViewer = (PDFView) findViewById(R.id.pdfViewer);
        String getItem = getIntent().getStringExtra("pdfFileName");



        // 리스트 뷰를 클릭하면 설정해놓은 pdf파일  
        if(getItem.equals("알벤다졸")){
            myPDFViewer.fromAsset("약물백과/알벤다졸.pdf").load();
        //...
        }
```
리스트뷰를 클릭하면 각 리스트에 맞는 pdf파일을 실행시켜주는 파트이다.
