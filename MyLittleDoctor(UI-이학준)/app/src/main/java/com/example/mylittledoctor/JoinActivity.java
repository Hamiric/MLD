package com.example.mylittledoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class JoinActivity extends AppCompatActivity {
     FirebaseAuth mAuth;
     FirebaseFirestore db;
     FirebaseUser user;
     EditText edt1;
     EditText edt2;
     EditText edt3;
     Button join_btn,back_btn;
     String uid;
     Map<String,String>user_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        VIEW_INIT();

        mAuth = FirebaseAuth.getInstance();

        user_data=new HashMap<>();
    }
    void VIEW_INIT(){
        edt1=(EditText)findViewById(R.id.edt1);
        edt2=(EditText)findViewById(R.id.edt2);
        edt3=(EditText)findViewById(R.id.edt3);
        join_btn=(Button) findViewById(R.id.join_btn);
        back_btn=(Button)findViewById(R.id.back_btn);
    }

    public void click(View view){
        switch (view.getId()){
            case R.id.join_btn:
                //계정 생성
                mAuth.createUserWithEmailAndPassword(edt2.getText().toString(), edt3.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    //Intent intent=new Intent(JoinActivity.this,LoginActivity.class);
                                    //startActivity(intent);
                                    //finish();
                                }else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(getApplicationContext(),"실패",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                //계정접속(로그인)
                mAuth.signInWithEmailAndPassword(edt2.getText().toString(), edt3.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    user = mAuth.getCurrentUser();
                                    uid=user.getUid();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(getApplicationContext(),"접속실패",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                //계정생성후 접속까지의 과정이 실행되기 전에, 밑에 코드가 실행되는 것을 방지하기 위해 의도적으로 실행을 지연.
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        user_data.put("name",edt1.getText().toString());
                        try{
                            db=FirebaseFirestore.getInstance();
                            db.collection(uid).document("user_info").set(user_data).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(),"계정생성완료!",Toast.LENGTH_LONG).show();
                                    FirebaseAuth.getInstance().signOut();
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(),"계정생성실패",Toast.LENGTH_SHORT).show();
                                }
                            });}catch (NullPointerException e){

                        }

                    }
                },3000);


                break;
            case R.id.back_btn:
                    finish();
                    break;
            default:
        }
    }
}
