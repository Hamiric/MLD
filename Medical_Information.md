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

## 사용 기능
-JXL 
-BaseAdapter
-Serializable

## 주요 코드
### 건강상식
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
ListView에 약학정보원에서 가져온 정보를 추가한다. 의학 뉴스와 부작용 리포트도 이와 동일하다. 

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
리스트뷰 클릭시 발생하는 이벤트 부분이다. 리스트뷰를 클릭하면 각 리스트에 맞는 pdf파일을 실행시켜주는 역할을 수행한다.
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
ListView에 약학정보원에서 가져온 정보를 추가한다. 의학 뉴스와 부작용 리포트도 이와 동일하다. 

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
리스트뷰 클릭시 발생하는 이벤트 부분이다. 리스트뷰를 클릭하면 각 리스트에 맞는 pdf파일을 실행시켜주는 역할을 수행한다.
###의약품검색
>EncyclopediarActivity (JAVA)
```java
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);

        init();

        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
                edt2.setText("");
                edt3.setText("");
            }
        });
```

### 의약품 검색
>SearchingActivity
```java
        //검색버튼 클릭시 이벤트
        btn1.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                /*입력받은 텍스트를 토대로, 약학정보가 담긴 파일을 불러와서 일치하는 데이터들을 추출한다.*/
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
                   
                }
                
                //데이터추출이 끝나면, 해당 데이터들을 모두 다음 액티비티로 보낸다.
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
        img_btn=(ImageView) findViewById(R.id.img_btn);
    }
    
    //입력받은 데이터를 토대로 액셀 형식의 약학정보중에서 일치하는 데이터들을 추출해주는 함수이다. 
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

//찾은 데이터를 가공하기 위한 class
public class Medicine_Structure implements Serializable {
    String Code;
    String Name;
    String Ingredients;
    String e;
    String Image;
}
}
```
사용자가 알고자 하는 의약품에 대한 정보를 입력하면, 입력 정보를 기반으로 약품에 대한 정보를 찾습니다.
>List_adapter(JAVA)
```java
@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(medicine_list.get(position).e.length()==0){
                convertView = inflater.inflate(R.layout.searching_list_data_page1, parent, false);
            }else{
                convertView = inflater.inflate(R.layout.searching_list_data_page2, parent, false);
            }
        }

        ImageView img1=(ImageView)convertView.findViewById(R.id.img1);
        TextView tv1=(TextView)convertView.findViewById(R.id.tv1);
        TextView tv2=(TextView)convertView.findViewById(R.id.tv2);

        if(false){
        }
        tv1.setText(medicine_list.get(position).Name);
        tv2.setText(medicine_list.get(position).Ingredients);
        return convertView;
    }
```
사용자가 입력한 데이터 만큼 해당 함수를 호출하여 ListView에 뿌려줍니다.
>SearchedActivity(JAVA)
```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seached);

        init();
        Receive_Data();

        List_adpater adpater=new List_adpater(medicine_list);
        lv.setAdapter(adpater);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url="https://nedrug.mfds.go.kr/pbp/CCBBB01/getItemDetail?itemSeq="+medicine_list.get(position).Code;
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
    void init(){
        lv=(ListView)findViewById(R.id.lv);

    }
    void Receive_Data(){
        ArrayList<String> code=(ArrayList<String>)getIntent().getSerializableExtra("Code");
        ArrayList<String>name=(ArrayList<String>)getIntent().getSerializableExtra("Name");
        ArrayList<String>ingredients=(ArrayList<String>)getIntent().getSerializableExtra("Ingredients");
        ArrayList<String>e=(ArrayList<String>)getIntent().getSerializableExtra("E");
        ArrayList<String>image=(ArrayList<String>)getIntent().getSerializableExtra("Image");

        for(int i=0; i<code.size(); i++){
            medicine_list.add(new Medicine_Structure(code.get(i),name.get(i),ingredients.get(i),e.get(i)));
        }

    }
}
```
사용자가 입력한 정보와 일치하는 데이터가 리스트에 뜨게되고, list를 클릭하면 의약품 안전 나라에서 제공하는 해당 약품에 대한 정보를 바로 확인 할 수 있습니다.                                    
