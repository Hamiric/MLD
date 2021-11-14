package com.example.mylittledoctor;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button tab_btn1,tab_btn2;
    Button icon_btn1,icon_btn2,icon_btn3;
    DrawerLayout drawerLayout;
    NavigationView nv;
    FirebaseAuth mAuth;
    FirebaseFirestore db;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_init();
        Drawer_and_Navigation_init();
        tab_click_event();
        Firebase_init();
        Nav_init();

    }

    void Firebase_init(){
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        db=FirebaseFirestore.getInstance();
    }
    void Drawer_and_Navigation_init(){
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        nv=(NavigationView) findViewById(R.id.nav_view);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();

                int id=item.getItemId();
                if(id==R.id.logout){
                    Toast.makeText(getApplicationContext(),"로그아웃하였습니다.",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }


    void view_init(){
        tab_btn1=(Button)findViewById(R.id.tab_btn1);
        tab_btn2=(Button)findViewById(R.id.tab_btn2);
        icon_btn1=(Button)findViewById(R.id.icon_btn1);
        icon_btn2=(Button)findViewById(R.id.icon_btn2);
        icon_btn3=(Button)findViewById(R.id.icon_btn3);
    }

    void Nav_init(){
        String uid=user.getUid();
        DocumentReference docRef = db.collection(uid).document("user_info");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        TextView nav_name=(TextView)findViewById(R.id.nav_name);
                        TextView nav_email=(TextView)findViewById(R.id.nav_email);

                        //getString(필드값)을 통해 해당 필드에 대응하는 value값을 가져온다.
                       nav_name.setText(document.getString("name").toString());
                        nav_email.setText(user.getEmail());
                    } else {

                    }
                } else {

                }
            }
        });


    }
    public void click(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.icon_btn1:
                intent=new Intent(MainActivity.this,Diagnosis.class);
                startActivity(intent);
                break;
            case R.id.icon_btn2:
                intent=new Intent(MainActivity.this,Emergency.class);
                startActivity(intent);
                break;
            case R.id.icon_btn3:
                intent=new Intent(MainActivity.this,HospitalMap.class);
                startActivity(intent);
                break;
        }
    }

    void tab_click_event(){
        tab_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });
    }
}