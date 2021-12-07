package com.example.mylittledoctor.Calendar;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ResetAlarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        DBHelper dbHelper;
        int Year, Month, Day, status;
        int m_hour_24, m_min;
        int l_hour_24, l_min;
        int d_hour_24, d_min;

        int morning = 830;
        int lunch = 1230;
        int dinner = 1830;

        boolean is_morning_setting = false;
        boolean is_lunch_setting = false;
        boolean is_dinner_setting = false;

        SharedPreferences sharedPreferences = context.getSharedPreferences("setting", MODE_PRIVATE);
        m_hour_24 = sharedPreferences.getInt("m_hour_24", 8);
        m_min = sharedPreferences.getInt("m_min", 30);
        l_hour_24 = sharedPreferences.getInt("l_hour_24", 12);
        l_min = sharedPreferences.getInt("l_min", 30);
        d_hour_24 = sharedPreferences.getInt("d_hour_24", 18);
        d_min = sharedPreferences.getInt("d_min", 30);

        Year = Calendar.getInstance().get(Calendar.YEAR);
        Month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        Day = Calendar.getInstance().get(Calendar.DATE);

        dbHelper = new DBHelper(context, 1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Medicine", null);

        while (cursor.moveToNext()) {
            if (Year == cursor.getInt(5)) {
                if (Month == cursor.getInt(6)) {
                    if (Day == cursor.getInt(7)) {

                        status = cursor.getInt(8);

                        if(status == 2 | status == 3 | status == 5 | status == 7){
                            Calendar mcalendar = Calendar.getInstance();
                            mcalendar.setTimeInMillis(System.currentTimeMillis());
                            mcalendar.set(Calendar.HOUR_OF_DAY, m_hour_24);
                            mcalendar.set(Calendar.MINUTE, m_min);
                            mcalendar.set(Calendar.SECOND, 0);
                            diaryNotification(mcalendar, context, morning);
                            is_morning_setting = true;
                        }

                        if(status == 1 | status == 3 | status == 4 | status == 5){
                            Calendar lcalendar = Calendar.getInstance();
                            lcalendar.setTimeInMillis(System.currentTimeMillis());
                            lcalendar.set(Calendar.HOUR_OF_DAY, l_hour_24);
                            lcalendar.set(Calendar.MINUTE, l_min);
                            lcalendar.set(Calendar.SECOND, 0);
                            diaryNotification(lcalendar, context, lunch);
                            is_lunch_setting = true;
                        }

                        if(status == 2 | status == 3 | status == 4 | status == 6){
                            Calendar dcalendar = Calendar.getInstance();
                            dcalendar.setTimeInMillis(System.currentTimeMillis());
                            dcalendar.set(Calendar.HOUR_OF_DAY, d_hour_24);
                            dcalendar.set(Calendar.MINUTE, d_min);
                            dcalendar.set(Calendar.SECOND, 0);
                            diaryNotification(dcalendar, context, dinner);
                            is_dinner_setting = true;
                        }
                    }
                }
            }
        }

        // 알람 설정 Toast (한번만 울리도록)
        if(is_morning_setting){
            Calendar mcalendar = Calendar.getInstance();
            mcalendar.setTimeInMillis(System.currentTimeMillis());
            mcalendar.set(Calendar.HOUR_OF_DAY, m_hour_24);
            mcalendar.set(Calendar.MINUTE, m_min);
            mcalendar.set(Calendar.SECOND, 0);
            Date currentDateTime = mcalendar.getTime();
            String date_text = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분", Locale.getDefault()).format(currentDateTime);
            Toast.makeText(context.getApplicationContext(), "다음 알람은" + date_text + "으로 알람이 설정되었습니다!", Toast.LENGTH_SHORT).show();
        }

        if (is_lunch_setting){
            Calendar lcalendar = Calendar.getInstance();
            lcalendar.setTimeInMillis(System.currentTimeMillis());
            lcalendar.set(Calendar.HOUR_OF_DAY, l_hour_24);
            lcalendar.set(Calendar.MINUTE, l_min);
            lcalendar.set(Calendar.SECOND, 0);
            Date currentDateTime = lcalendar.getTime();
            String date_text = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분", Locale.getDefault()).format(currentDateTime);
            Toast.makeText(context.getApplicationContext(), "다음 알람은" + date_text + "으로 알람이 설정되었습니다!", Toast.LENGTH_SHORT).show();
        }

        if(is_dinner_setting){
            Calendar dcalendar = Calendar.getInstance();
            dcalendar.setTimeInMillis(System.currentTimeMillis());
            dcalendar.set(Calendar.HOUR_OF_DAY, d_hour_24);
            dcalendar.set(Calendar.MINUTE, d_min);
            dcalendar.set(Calendar.SECOND, 0);
            Date currentDateTime = dcalendar.getTime();
            String date_text = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분", Locale.getDefault()).format(currentDateTime);
            Toast.makeText(context.getApplicationContext(), "다음 알람은" + date_text + "으로 알람이 설정되었습니다!", Toast.LENGTH_SHORT).show();
        }

    }

    void diaryNotification(Calendar calendar, Context context, int channel){

        Intent alarmIntent = new Intent(context, AlramReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, channel, alarmIntent, 0);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (alarmManager != null) {

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY, pendingIntent);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        }
    }
}
