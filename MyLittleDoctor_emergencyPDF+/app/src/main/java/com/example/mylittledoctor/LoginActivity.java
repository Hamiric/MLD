package com.example.mylittledoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // FirebaseAuth.getInstance().signOut();
        mAuth = FirebaseAuth.getInstance();




        VIEW_INIT();
    }
    void VIEW_INIT(){
        edt1=(EditText) findViewById(R.id.edt1);
        edt2=(EditText) findViewById(R.id.edt2);
    }
    public void click(View view){
        switch (view.getId()){
            case R.id.login_btn:
                //계정접속(로그인)
                mAuth.signInWithEmailAndPassword(edt1.getText().toString(), edt2.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent=new Intent(LoginActivity.this, com.example.mylittledoctor.MainUI.MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, "비밀번호를 확인해주세요.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                break;

            case R.id.join_btn:
                Intent intent=new Intent(LoginActivity.this,JoinActivity.class);
                startActivity(intent);
            default:
        }
    }
}