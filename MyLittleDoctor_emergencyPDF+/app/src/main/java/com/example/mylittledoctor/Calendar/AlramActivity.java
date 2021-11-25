package com.example.mylittledoctor.Calendar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TimePicker;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mylittledoctor.R;

public class AlramActivity extends AppCompatActivity {

    private LinearLayout dosing_list;

    int m_hour, m_hour_24, m_min;
    int l_hour, l_hour_24, l_min;
    int d_hour, d_hour_24, d_min;
    String m_am_pm, l_am_pm, d_am_pm;

    ArrayList<String> title = new ArrayList<String>();

    private ListView listView;
    private ListViewAdapter_alram adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alram);

        dosing_list = (LinearLayout) findViewById(R.id.alram_setting);
        listView = (ListView) findViewById(R.id.listview_item_dosing);

        adapter = new ListViewAdapter_alram(AlramActivity.this);
        listView.setAdapter(adapter);

        // 앞서 설정한 값으로 보여주기
        // 없으면 디폴트 값은 현재시간
        SharedPreferences sharedPreferences = getSharedPreferences("setting", MODE_PRIVATE);

        //long millis = sharedPreferences.getLong("nextNotifyTime", Calendar.getInstance().getTimeInMillis());
        //Calendar nextNotifyTime = new GregorianCalendar();
        //nextNotifyTime.setTimeInMillis(millis);

        m_hour_24 = sharedPreferences.getInt("m_hour_24", 8);
        m_hour = sharedPreferences.getInt("m_hour", 8);
        m_min = sharedPreferences.getInt("m_min", 30);
        l_hour_24 = sharedPreferences.getInt("m_hour_24", 12);
        l_hour = sharedPreferences.getInt("m_hour", 12);
        l_min = sharedPreferences.getInt("m_min", 30);
        d_hour_24 = sharedPreferences.getInt("m_hour_24", 18);
        d_hour = sharedPreferences.getInt("m_hour", 6);
        d_min = sharedPreferences.getInt("m_min", 30);

        ImageButton finish = (ImageButton) findViewById(R.id.imageButton3);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcalendar = Calendar.getInstance();
                mcalendar.setTimeInMillis(System.currentTimeMillis());
                mcalendar.set(Calendar.HOUR_OF_DAY, m_hour_24);
                mcalendar.set(Calendar.MINUTE, m_min);
                mcalendar.set(Calendar.SECOND, 0);

                // 이미 지난 시간을 지정했다면 다음날 같은 시간으로 설정
                if (mcalendar.before(Calendar.getInstance())) {
                    mcalendar.add(Calendar.DATE, 1);
                }

                Calendar lcalendar = Calendar.getInstance();
                lcalendar.setTimeInMillis(System.currentTimeMillis());
                lcalendar.set(Calendar.HOUR_OF_DAY, l_hour_24);
                lcalendar.set(Calendar.MINUTE, l_min);
                lcalendar.set(Calendar.SECOND, 0);

                // 이미 지난 시간을 지정했다면 다음날 같은 시간으로 설정
                if (lcalendar.before(Calendar.getInstance())) {
                    lcalendar.add(Calendar.DATE, 1);
                }

                Calendar dcalendar = Calendar.getInstance();
                dcalendar.setTimeInMillis(System.currentTimeMillis());
                dcalendar.set(Calendar.HOUR_OF_DAY, d_hour_24);
                dcalendar.set(Calendar.MINUTE, d_min);
                dcalendar.set(Calendar.SECOND, 0);

                // 이미 지난 시간을 지정했다면 다음날 같은 시간으로 설정
                if (dcalendar.before(Calendar.getInstance())) {
                    dcalendar.add(Calendar.DATE, 1);
                }

                /*
                Date currentDateTime = calendar.getTime();
                String date_text = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분 ", Locale.getDefault()).format(currentDateTime);
                Toast.makeText(getApplicationContext(),date_text + "으로 알람이 설정되었습니다!", Toast.LENGTH_SHORT).show();

                //  Preference에 설정한 값 저장
                SharedPreferences.Editor editor = getSharedPreferences("daily alarm", MODE_PRIVATE).edit();
                editor.putLong("nextNotifyTime", (long)calendar.getTimeInMillis());
                editor.apply();

                 */

                diaryNotification(mcalendar);
                //diaryNotification(lcalendar);
                //diaryNotification(dcalendar);

                Toast.makeText(getApplicationContext(),m_hour_24 + "시 " + m_min +  "분 " +"에 알람이 설정되었습니다!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });


        Intent intent = getIntent();
        title = intent.getStringArrayListExtra("title");

        for(int i = 0 ; i < title.size() ; i ++){
            adapter.addItem(title.get(i));
        }



        ImageButton option = (ImageButton) findViewById(R.id.option);
        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PopupAlramActivity.class);
                startActivityForResult(intent,2);
            }
        });


        dosing_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), add_dosing_list.class);
                startActivity(intent);
            }
        });

    }

    void diaryNotification(Calendar calendar)
    {
//        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
//        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
//        Boolean dailyNotify = sharedPref.getBoolean(SettingsActivity.KEY_PREF_DAILY_NOTIFICATION, true);
        Boolean dailyNotify = true; // 무조건 알람을 사용

        PackageManager pm = this.getPackageManager();
        ComponentName receiver = new ComponentName(this, DeviceBootReceiver.class);
        Intent alarmIntent = new Intent(this, AlramReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);


        // 사용자가 매일 알람을 허용했다면
        if (dailyNotify) {


            if (alarmManager != null) {

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                }
            }

            // 부팅 후 실행되는 리시버 사용가능하게 설정
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);

        }
//        else { //Disable Daily Notifications
//            if (PendingIntent.getBroadcast(this, 0, alarmIntent, 0) != null && alarmManager != null) {
//                alarmManager.cancel(pendingIntent);
//                //Toast.makeText(this,"Notifications were disabled",Toast.LENGTH_SHORT).show();
//            }
//            pm.setComponentEnabledSetting(receiver,
//                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
//                    PackageManager.DONT_KILL_APP);
//        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SharedPreferences sharedPreferences = getSharedPreferences("setting", MODE_PRIVATE);

        m_hour_24 = sharedPreferences.getInt("m_hour_24", 8);
        m_hour = sharedPreferences.getInt("m_hour", 8);
        m_min = sharedPreferences.getInt("m_min", 30);
        l_hour_24 = sharedPreferences.getInt("m_hour_24", 12);
        l_hour = sharedPreferences.getInt("m_hour", 12);
        l_min = sharedPreferences.getInt("m_min", 30);
        d_hour_24 = sharedPreferences.getInt("m_hour_24", 18);
        d_hour = sharedPreferences.getInt("m_hour", 6);
        d_min = sharedPreferences.getInt("m_min", 30);
    }

}