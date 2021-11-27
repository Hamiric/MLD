package com.example.mylittledoctor.Calendar;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.mylittledoctor.R;


public class PopupAlramActivity extends Activity {

    Button morning, lunch, dinner, setting;
    TimePicker picker;

    boolean mor, lun, din;
    int m_hour, m_hour_24, m_min;
    int l_hour, l_hour_24, l_min;
    int d_hour, d_hour_24, d_min;
    String m_am_pm, l_am_pm, d_am_pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_alram_setting);

        picker=(TimePicker)findViewById(R.id.timePicker);
        picker.setIs24HourView(true);

        //UI 객체생성
        morning = (Button) findViewById(R.id.morning);
        lunch = (Button) findViewById(R.id.lunch);
        dinner = (Button) findViewById(R.id.dinner);
        setting = (Button) findViewById(R.id.setting_button);

        mor = true;
        lun = false;
        din = false;

        SharedPreferences sharedPreferences = getSharedPreferences("setting", MODE_PRIVATE);

        m_hour_24 = sharedPreferences.getInt("m_hour_24", 8);
        m_hour = sharedPreferences.getInt("m_hour", 8);
        m_min = sharedPreferences.getInt("m_min", 30);

        int pre_hour = m_hour_24;
        int pre_minute = m_min;

        if (Build.VERSION.SDK_INT >= 23 ){
            picker.setHour(pre_hour);
            picker.setMinute(pre_minute);
        }
        else{
            picker.setCurrentHour(pre_hour);
            picker.setCurrentMinute(pre_minute);
        }

        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                morning.setText("선택됨");
                if(lun){
                    lunch.setText("점심");
                }
                if(din){
                    dinner.setText("저녁");
                }

                mor = true;
                lun = false;
                din = false;
            }
        });

        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lunch.setText("선택됨");
                if(mor){
                    morning.setText("아침");
                }
                if(din){
                    dinner.setText("저녁");
                }

                mor = false;
                lun = true;
                din = false;
            }
        });

        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dinner.setText("선택됨");
                if(mor){
                    morning.setText("아침");
                }
                if(lun){
                    lunch.setText("점심");
                }

                mor = false;
                lun = false;
                din = true;
            }
        });


        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                if(mor){
                    if (Build.VERSION.SDK_INT >= 23) {
                        m_hour_24 = picker.getHour();
                        m_min = picker.getMinute();
                    } else {
                        m_hour_24 = picker.getCurrentHour();
                        m_min = picker.getCurrentMinute();
                    }
                    if (m_hour_24 > 12) {
                        m_am_pm = "PM";
                        m_hour = m_hour_24 - 12;
                    } else {
                        m_hour = m_hour_24;
                        m_am_pm = "AM";
                    }

                    Toast.makeText(getApplicationContext(),"아침 알람은 " + m_hour_24 + "시 " + m_min + "분 으로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                }

                if(lun){
                    if (Build.VERSION.SDK_INT >= 23) {
                        l_hour_24 = picker.getHour();
                        l_min = picker.getMinute();
                    } else {
                        l_hour_24 = picker.getCurrentHour();
                        l_min = picker.getCurrentMinute();
                    }
                    if (l_hour_24 > 12) {
                        l_am_pm = "PM";
                        l_hour = l_hour_24 - 12;
                    } else {
                        l_hour = l_hour_24;
                        l_am_pm = "AM";
                    }

                    Toast.makeText(getApplicationContext(),"점심 알람은 " + l_hour_24 + "시 " + l_min + "분 으로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                }

                if(din){
                    if (Build.VERSION.SDK_INT >= 23) {
                        d_hour_24 = picker.getHour();
                        d_min = picker.getMinute();
                    } else {
                        d_hour_24 = picker.getCurrentHour();
                        d_min = picker.getCurrentMinute();
                    }
                    if (d_hour_24 > 12) {
                        d_am_pm = "PM";
                        d_hour = d_hour_24 - 12;
                    } else {
                        d_hour = d_hour_24;
                        d_am_pm = "AM";
                    }

                    Toast.makeText(getApplicationContext(),"저녁 알람은 " + d_hour_24 + "시 " + d_min + "분 으로 설정되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    //확인 버튼 클릭
    public void mOnClose(View v){
        //  Preference에 설정한 값 저장
        SharedPreferences.Editor editor = getSharedPreferences("setting", MODE_PRIVATE).edit();
        editor.putInt("m_hour_24", m_hour_24);
        editor.putInt("m_hour", m_hour);
        editor.putInt("m_min", m_min);
        editor.putInt("l_hour_24", l_hour_24);
        editor.putInt("l_hour", l_hour);
        editor.putInt("l_min", l_min);
        editor.putInt("d_hour_24", d_hour_24);
        editor.putInt("d_hour", d_hour);
        editor.putInt("d_min", d_min);
        editor.apply();

        //액티비티(팝업) 닫기
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    /*
    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
     */

}
