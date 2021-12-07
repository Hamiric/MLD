package com.example.mylittledoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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

        // FirebaseAuth.getInstance().signOut();
        mAuth = FirebaseAuth.getInstance();
        VIEW_INIT();

        SharedPreferences sp=getSharedPreferences("state_login", Activity.MODE_PRIVATE);
        int state=sp.getInt("state",0);
        Log.d("확인","저장된 값:"+state);
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
    void VIEW_INIT(){
        edt1=(EditText) findViewById(R.id.edt1);
        edt2=(EditText) findViewById(R.id.edt2);
        radio_group=(RadioGroup)findViewById(R.id.radio_group);
    }
    public void click(View view){
        switch (view.getId()){
            case R.id.login_btn:
                //계정접속(로그인)
                try {
                    mAuth.signInWithEmailAndPassword(edt1.getText().toString(), edt2.getText().toString())
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        SharedPreferences sp = getSharedPreferences("state_login", Activity.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sp.edit();
                                        Log.d("확인", "저장할 값:" + state_login);
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
                Intent intent=new Intent(LoginActivity.this,JoinActivity.class);
                startActivity(intent);
                finish();
            default:
        }
    }
}