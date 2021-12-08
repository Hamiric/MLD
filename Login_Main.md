# 로그인 / 메인

로그인       |  회원가입    
:-------------------------:|:-------------------------:
![](https://user-images.githubusercontent.com/58100710/144952974-d2fb44c4-5eda-4a4d-a96e-d1ee2e3ac51f.png)  |  ![](https://user-images.githubusercontent.com/58100710/144952979-a181cb79-97d5-4ab1-9e82-25ded53d7057.png)
메인       |  메인(네비게이션바)    |
![](https://user-images.githubusercontent.com/58100710/144952786-12775f8c-56da-4fd2-bbe2-ac0fb609bd9d.png)  | ![](https://user-images.githubusercontent.com/58100710/145129010-f2dc4c2c-1d79-4d4a-ab2e-e314062a0cf5.png)



## 기능 소개
사용자 인증을 통해 어플에서 사용자의 정보를 확인하고, 파이어베이스에 입력되어있는 사용자 정보를 어플에 반영시켜주는 역할을 수행한다. 또한 사용자의 기록등을 웹DB에 기록함으로써 사용자 개인 기록이 도용되지 않도록 하는 것을 목표로 합니다. 자동 로그인 기능이 구현되어 있어, 한번 로그인시 로그아웃하기 전까진 해당 단말기에서는 자동으로 로그인이 됩니다.

## 사용 기능 (참고)
### 로그인
- [FireBase(Google)](https://firebase.google.com/?hl=ko)
- [SharedPrefernece]

### 메인화면
-[DrawerLayout]
-[PagerAdapter]

## 주요 코드
### 로그인 관련 코드
>LoginActivity
```
public class LoginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText edt1;
    EditText edt2;
    int state_login=0;
    RadioGroup radio_group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        VIEW_INIT();
        
        //뷰 바인드 후 가장 먼저 실행되는 기능으로, 이전에 로그인 접속 방식을 불러온다. (초기상태, 아이디 저장, 자동 로그인)  
        SharedPreferences sp=getSharedPreferences("state_login", Activity.MODE_PRIVATE);
        int state=sp.getInt("state",0);

        if(state==0){
            try{
                FirebaseAuth.getInstance().signOut();
            }catch (Exception e){

            }

        }else if(state==1){
            edt1.setText(sp.getString("id",""));
            try{
                FirebaseAuth.getInstance().signOut();
            }catch(Exception e){

            }
        }else{
            if(FirebaseAuth.getInstance()!=null){
                Intent intent=new Intent(LoginActivity.this, com.example.mylittledoctor.MainUI.MainActivity.class);
                startActivity(intent);
                finish();
            }
        }


        //id만 저장, 자동 로그인 중 한가지를 선택했을 때 마다 변수값을 달리한다. (로그인 시, 최종적으로 데이터 저장)
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radio_btn1){
                    state_login=1;
                }else{
                    state_login=2;
                }
            }
        });

    }
    
    //Activity에서 쓰이는 view들을 바인드한다.
    void VIEW_INIT(){
        edt1=(EditText) findViewById(R.id.edt1);
        edt2=(EditText) findViewById(R.id.edt2);
        radio_group=(RadioGroup)findViewById(R.id.radio_group);
    }
    
    //로그인 버튼 혹은 회원가입 버튼을 눌렀을 때의 이벤트 처리함수이다.
    public void click(View view){
        switch (view.getId()){
            case R.id.login_btn:
                /*로그인 버튼을 눌렀을 경우: text에서 입력받은 받은 아이디와 비밀번호가 올바른 것이라면, 메인화면으로 넘어가도록 한다. 그 과정에서 라디오 버튼을 통해, 
                이후에 접속방식을 선택했다면 해당 데이터를 내부 db에 저장하여, 다음 접속시 반영한다*/
                try {
                    mAuth.signInWithEmailAndPassword(edt1.getText().toString(), edt2.getText().toString())
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        SharedPreferences sp = getSharedPreferences("state_login", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();

                                        if (state_login != 1) {
                                            editor.putInt("state", state_login);
                                        } else {
                                            editor.putInt("state", state_login);
                                            editor.putString("id", edt1.getText().toString());
                                        }
                                        editor.commit();

                                        Intent intent = new Intent(LoginActivity.this, com.example.mylittledoctor.MainUI.MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(LoginActivity.this, "비밀번호를 확인해주세요.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, "아이디와 비밀번호를 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
                break;

                
            case R.id.join_btn:
                //회원가입 버튼을 눌렀을 경우: 회원 가입창으로 이동하고, 현재 activity는 종료한다.
                Intent intent=new Intent(LoginActivity.this,JoinActivity.class);
                startActivity(intent);
                finish();
            default:
        }
    }
}
```
앱 실행시, 가장 먼저 나타나는 Activity로 아이디와 비밀번호를 입력해 사용자의 신원을 확인한다. 다른 앱들과 동일하게 처음 로그인 접속할 때를 제외하고는 자동 로그인과 같이 접속방식을 사용자가 제어 할 수 있다.

>JoinActivity
```java
 public void click(View view){
        switch (view.getId()){
            case R.id.join_btn:
                //계정을 생성한다.
                mAuth.createUserWithEmailAndPassword(edt2.getText().toString(), edt3.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                   
                                }else {
                                    Toast.makeText(getApplicationContext(),"올바르지 않은 이메일 형식입니다.",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                
                //계정이 만들어졌다면, 계정에 접속을 확인하고 해당 id값을 key로 갖고 이름을 value로 받는 Map형식의 data를 만들고 내부 db에 저장한다.
                mAuth.signInWithEmailAndPassword(edt2.getText().toString(), edt3.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    user = mAuth.getCurrentUser();
                                    uid=user.getUid();
                                  
                                    SharedPreferences sp=getSharedPreferences("user_id", Activity.MODE_PRIVATE);
                                    SharedPreferences.Editor editor=sp.edit();
                                    editor.putString(uid,edt1.getText().toString());
                                    editor.commit();
                                    
                                    Intent intent=new Intent(JoinActivity.this,LoginActivity.class);
                                    startActivity(intent);

                                    mAuth.signOut();
                                    Toast.makeText(getApplicationContext(),"계정생성 완료!",Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(getApplicationContext(),"접속실패",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                //이전 방식으로 외부 db인 FirebaseStore에 사용자 정보를 저장하는 방식.
               /* new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        user_data.put("name",edt1.getText().toString());
                        try{
                            db=FirebaseFirestore.getInstance();
                            Log.d("확인","uid:"+uid+"정보:"+user_data.get("name"));
                            db.collection(uid).document("user_info").set(user_data).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(),"계정생성완료!",Toast.LENGTH_LONG).show();
                                    FirebaseAuth.getInstance().signOut();
                                    Intent intent=new Intent(JoinActivity.this,LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(),"계정생성실패",Toast.LENGTH_SHORT).show();
                                }
                            });



                        }catch (NullPointerException e){

                        }

                    }
                },3000);*/
                break;
            case R.id.back_btn:
                finish();
                break;
            default:
        }
    }
}
```
FireBase Authentication을 통해서 사용자의 인증정보를 저장합니다. 이전에는 FirebaseStore를 통해 사용자의 정보(이름, 이메일, 나이등..)을 받고 사용자별 데이터를 갱신하려했으나 쓰이지 않게 되었습니다. 그래서 사용자의 정보를 임시로 내부DB에 저장하여 간단한 정보들만 불러올 수 있도록 진행하였습니다. 다른 앱들과 동일하게 인증절차를 담당하고 있는 부분다.

### 메인화면 관련 코드
>MainActivity (JAVA)
```java
//Main Activity의 가장 상위의 Layout. Drawerlayout을 통해 Navigation Bar를 구현
<androidx.drawerlayout.widget.DrawerLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainUI.MainActivity"
    android:id="@+id/drawer"
    android:background="@drawable/main_background">
    
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_init();
        firebase_init();
        page_view();

        Drawer_and_Navigation_init();
        Nav_init();
        tab_click_event();
    }

    void view_init(){
        tab_btn1=(Button)findViewById(R.id.tab_btn1);
        tab_btn2= (ImageButton) findViewById(R.id.tab_btn2);
        icon_btn1=(Button)findViewById(R.id.icon_btn1);
        icon_btn2=(Button)findViewById(R.id.icon_btn2);
        icon_btn3=(Button)findViewById(R.id.icon_btn3);
        vp=(ViewPager) findViewById(R.id.vp);
        img_cicle1=(ImageView)findViewById(R.id.circle1);
        img_cicle2=(ImageView)findViewById(R.id.circle2);
        img_cicle3=(ImageView)findViewById(R.id.circle3);
        img_cicle4=(ImageView)findViewById(R.id.circle4);

    }
    
    //인증된 사용자인지 확인하는 함수.
    void firebase_init(){
        try {
            mAuth = FirebaseAuth.getInstance();
            user = mAuth.getCurrentUser();
        }catch (Exception e){
            Intent intent=new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
    
    //NavigationBar의 이벤트 리스너 
    void Drawer_and_Navigation_init(){
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        nv=(NavigationView) findViewById(R.id.nav_view);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();

                int id=item.getItemId();
                Intent intent;
                if(id==R.id.menu1){
                    intent = new Intent(MainActivity.this, CalendarActivity.class);
                    startActivity(intent);
                }else if(id==R.id.menu2){
                    intent = new Intent(MainActivity.this, CalendarActivity.class);
                    startActivity(intent);
                }else if(id==R.id.menu3){
                    intent = new Intent(MainActivity.this, HospitalMapActivity.class);
                    startActivity(intent);
                }else if(id==R.id.menu4){
                    intent = new Intent(MainActivity.this, SearchingActivity.class);
                    startActivity(intent);
                }else if(id==R.id.menu5){
                    intent = new Intent(MainActivity.this, Emergency.class);
                    startActivity(intent);
                }else if(id==R.id.menu6){

                }else if(id==R.id.menu7){
                    SharedPreferences sp=getSharedPreferences("state_login", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putInt("state",1);
                    editor.commit();

                    mAuth.signOut();

                    intent=new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(getApplicationContext(),"로그아웃하였습니다.", Toast.LENGTH_SHORT).show();

                }else{

                }
                return true;
            }
        });
    }
    void Nav_init(){
        nav_name=(TextView)findViewById(R.id.nav_name1);
        nav_email=(TextView)findViewById(R.id.nav_email1);
        
    }

    void tab_click_event(){
        tab_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });
    }
    
    
    //Activity중아에 위치한 pageview를 구현하기 위한 코드
    void page_view(){
        vp=(ViewPager) findViewById(R.id.vp);
        ArrayList<Drawable> drawer=new ArrayList<>();
        drawer.add(getResources().getDrawable(R.drawable.main_page_img1));
        drawer.add(getResources().getDrawable(R.drawable.main_page_img2));
        drawer.add(getResources().getDrawable(R.drawable.main_page_img3));
        drawer.add(getResources().getDrawable(R.drawable.main_page_img4));
        ImagePagerAdapter adapter=new ImagePagerAdapter(getApplicationContext(),drawer);
        vp.setAdapter(adapter);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }


            @Override
            public void onPageSelected(int position) {
                img_cicle1.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle1));
                img_cicle2.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle1));
                img_cicle3.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle1));
                img_cicle4.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle1));
                switch (position){
                    case 0:
                        img_cicle1.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle2));
                        break;
                    case 1:
                        img_cicle2.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle2));
                        break;
                    case 2:
                        img_cicle3.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle2));
                        break;
                    case 3:
                        img_cicle4.setImageDrawable(getResources().getDrawable(R.drawable.main_shape_circle2));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    
    //버튼별 이벤트 리스너
    public void click(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.icon_btn1:
                intent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent);
                break;
            case R.id.icon_btn2:
                intent = new Intent(MainActivity.this, SearchingActivity.class);
                startActivity(intent);
                break;
            case R.id.icon_btn3:
                intent = new Intent(MainActivity.this, HospitalMapActivity.class);
                startActivity(intent);
                break;
            case R.id.tab_btn1:
                intent = new Intent(MainActivity.this, Emergency.class);
                startActivity(intent);
                break;
        }
    }
}
```
MainActivity는 사용자가 사용할 첫 화면이기에 많은 뷰들에 대한 이벤트처리를 담당하고 있습니다. 여러 기능들이 분산되어 있기에, Navigation Bar를 통해 모든 기능을 한눈에 파악 할 수 있도록 해놓았습니다.
    

## 주의사항
원래는 내부DB에 저장된 투약기록같은 개인 기록들을 웹DB에 올려서 관리하는 방식을 하려 했으나... 개발시간 부족 및 DB오류로 인해 현재 해당 기능은 적용되지 않은 상태입니다.
현재 로그인 기능은 단지 어플 접속하는데 통행문 역할만 수행하고 있으므로 참고바랍니다.
**비밀번호재설정**, **설정/옵션**기능은 구현되지 않았음.
