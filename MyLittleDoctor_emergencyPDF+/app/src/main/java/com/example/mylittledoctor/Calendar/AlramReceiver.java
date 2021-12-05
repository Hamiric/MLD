package com.example.mylittledoctor.Calendar;

import static android.content.Context.MODE_PRIVATE;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.example.mylittledoctor.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AlramReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        DBHelper dbHelper;
        int Year, Month, Day, status;
        int m_hour_24, m_min;
        int l_hour_24, l_min;
        int d_hour_24, d_min;

        ArrayList<String> mtitle = new ArrayList<String>();
        ArrayList<String> ltitle = new ArrayList<String>();
        ArrayList<String> dtitle = new ArrayList<String>();

        SharedPreferences sharedPreferences = context.getSharedPreferences("setting", MODE_PRIVATE);

        // 알람시간 확인
        m_hour_24 = sharedPreferences.getInt("m_hour_24", 8);
        m_min = sharedPreferences.getInt("m_min", 30);
        l_hour_24 = sharedPreferences.getInt("l_hour_24", 12);
        l_min = sharedPreferences.getInt("l_min", 30);
        d_hour_24 = sharedPreferences.getInt("d_hour_24", 18);
        d_min = sharedPreferences.getInt("d_min", 30);

        // 현재 시간 확인
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        Year = Calendar.getInstance().get(Calendar.YEAR);
        Month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        Day = Calendar.getInstance().get(Calendar.DATE);

        // db 읽기
        dbHelper = new DBHelper(context, 1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Medicine", null);

        while (cursor.moveToNext()) {
            if (Year == cursor.getInt(5)) {
                if (Month == cursor.getInt(6)) {
                    if (Day == cursor.getInt(7)) {

                        status = cursor.getInt(8);
                        String drag_title = cursor.getString(0);

                        if(status == 2 | status == 3 | status == 5 | status == 7){
                            mtitle.add(drag_title);
                        }

                        if(status == 1 | status == 3 | status == 4 | status == 5){
                            ltitle.add(drag_title);
                        }

                        if(status == 2 | status == 3 | status == 4 | status == 6){
                            dtitle.add(drag_title);
                        }

                    }
                }
            }
        }

        // 알람
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent notificationIntent = new Intent(context, CalendarActivity.class);

        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent pendingI = PendingIntent.getActivity(context, 0,
                notificationIntent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "default");

        //OREO API 26 이상에서는 채널 필요
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            builder.setSmallIcon(R.drawable.ic_launcher_foreground); //mipmap 사용시 Oreo 이상에서 시스템 UI 에러남

            String channelName = "매일 알람 채널";
            String description = "매일 정해진 시간에 알람합니다.";
            int importance = NotificationManager.IMPORTANCE_HIGH; //소리와 알림메시지를 같이 보여줌

            NotificationChannel channel = new NotificationChannel("default", channelName, importance);
            channel.setDescription(description);

            if (notificationManager != null) {
                // 노티피케이션 채널을 시스템에 등록
                notificationManager.createNotificationChannel(channel);
            }
        }
        else builder.setSmallIcon(R.mipmap.ic_launcher); // Oreo 이하에서 mipmap 사용하지 않으면 Couldn't create icon: StatusBarIcon 에러남

        if(calendar.get(Calendar.HOUR_OF_DAY) == m_hour_24 && calendar.get(Calendar.MINUTE) == m_min){
            String sub = "";
            String t, r;
            String spa = "\n";

            for(int i = 0 ; i < mtitle.size() ; i ++) {
                r = sub;
                t = mtitle.get(i);

                if(i == 0)
                    sub = r + t;
                else
                    sub = spa + r + t;
            }

            builder.setAutoCancel(true)
                    .setDefaults(NotificationCompat.DEFAULT_ALL)
                    .setWhen(System.currentTimeMillis())
                    .setTicker("{Time to watch some cool stuff!}")

                    .setContentTitle("아침 알람입니다.")
                    .setContentText(sub)
                    .setContentInfo("INFO")
                    .setContentIntent(pendingI)
                    .setFullScreenIntent(pendingI, true);
        }

        if(calendar.get(Calendar.HOUR_OF_DAY) == l_hour_24 && calendar.get(Calendar.MINUTE) == l_min){
            String sub = "";
            String t, r;
            String spa = "\n";

            for(int i = 0 ; i < ltitle.size() ; i ++) {
                r = sub;
                t = ltitle.get(i);

                if(i == 0)
                    sub = r + t;
                else
                    sub = spa + r + t;
            }

            builder.setAutoCancel(true)
                    .setDefaults(NotificationCompat.DEFAULT_ALL)
                    .setWhen(System.currentTimeMillis())
                    .setTicker("{Time to watch some cool stuff!}")

                    .setContentTitle("점심 알람입니다.")
                    .setContentText(sub)
                    .setContentInfo("INFO")
                    .setContentIntent(pendingI)
                    .setFullScreenIntent(pendingI, true);
        }

        if(calendar.get(Calendar.HOUR_OF_DAY) == d_hour_24 && calendar.get(Calendar.MINUTE) == d_min){
            String sub = "";
            String t, r;
            String spa = "\n";

            for(int i = 0 ; i < dtitle.size() ; i ++) {
                r = sub;
                t = dtitle.get(i);

                if(i == 0)
                    sub = r + t;
                else
                    sub = spa + r + t;
            }

            builder.setAutoCancel(true)
                    .setDefaults(NotificationCompat.DEFAULT_ALL)
                    .setWhen(System.currentTimeMillis())
                    .setTicker("{Time to watch some cool stuff!}")

                    .setContentTitle("저녁 알람입니다.")
                    .setContentText(sub)
                    .setContentInfo("INFO")
                    .setContentIntent(pendingI)
                    .setFullScreenIntent(pendingI, true);
        }

        /*
        builder.setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setTicker("{Time to watch some cool stuff!}")

                .setContentTitle("상태바 드래그시 보이는 타이틀")
                .setContentText("상태바 드래그시 보이는 서브타이틀")
                .setContentInfo("INFO")
                .setContentIntent(pendingI)
                .setFullScreenIntent(pendingI, true);
         */

        if (notificationManager != null) {

            // 노티피케이션 동작시킴
            notificationManager.notify(1234, builder.build());
        }
    }
}