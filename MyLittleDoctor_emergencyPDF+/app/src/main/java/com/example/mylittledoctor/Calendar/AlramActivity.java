package com.example.mylittledoctor.Calendar;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.example.mylittledoctor.R;

import java.util.ArrayList;
import java.util.Calendar;

public class AlramActivity extends AppCompatActivity {

    private LinearLayout dosing_list;

    int m_hour, m_hour_24, m_min;
    int l_hour, l_hour_24, l_min;
    int d_hour, d_hour_24, d_min;
    String m_am_pm, l_am_pm, d_am_pm;

    ArrayList<String> title = new ArrayList<String>();
    ArrayList<Integer> ar_dosage = new ArrayList<Integer>();
    ArrayList<Integer> ar_dosing_days = new ArrayList<Integer>();
    ArrayList<Integer> ar_dosing_number = new ArrayList<Integer>();

    DBHelper dbHelper;

    private int Year, Month, Day;

    private ListView listView;
    private ListViewAdapter_alram adapter;

    private TextView list_day;

    // notification channel에 대한 id 생성
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    // Channel을 생성 및 전달해 줄 수 있는 Manager 생성
    private NotificationManager mNotificationManager;
    // Notification에 대한 ID 생성
    private static final int NOTIFICATION_ID = 999;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alram);

        dosing_list = (LinearLayout) findViewById(R.id.dosing_list);
        listView = (ListView) findViewById(R.id.listview_item_dosing);

        adapter = new ListViewAdapter_alram(AlramActivity.this);
        listView.setAdapter(adapter);

        list_day = (TextView) findViewById(R.id.list_day);

        dbHelper = new DBHelper(getApplicationContext(), 1);

        Year = getIntent().getIntExtra("Year", 0000);
        Month = getIntent().getIntExtra("Month", 00);
        Day = getIntent().getIntExtra("Day", 00);

        list_day.setText(Year + " / " + Month + " / " + Day);

        //long millis = sharedPreferences.getLong("nextNotifyTime", Calendar.getInstance().getTimeInMillis());
        //Calendar nextNotifyTime = new GregorianCalendar();
        //nextNotifyTime.setTimeInMillis(millis);

        // 앞서 설정한 값으로 보여주기
        // 없으면 디폴트 값은 현재시간
        SharedPreferences sharedPreferences = getSharedPreferences("setting", MODE_PRIVATE);

        ImageButton finish = (ImageButton) findViewById(R.id.imageButton3);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_hour_24 = sharedPreferences.getInt("m_hour_24", 8);
                m_hour = sharedPreferences.getInt("m_hour", 8);
                m_min = sharedPreferences.getInt("m_min", 30);
                l_hour_24 = sharedPreferences.getInt("l_hour_24", 12);
                l_hour = sharedPreferences.getInt("l_hour", 12);
                l_min = sharedPreferences.getInt("l_min", 30);
                d_hour_24 = sharedPreferences.getInt("d_hour_24", 18);
                d_hour = sharedPreferences.getInt("d_hour", 6);
                d_min = sharedPreferences.getInt("d_min", 30);

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

                diaryNotification(mcalendar, "morning");
                diaryNotification(lcalendar, "lunch");
                diaryNotification(dcalendar, "dinner");

                Toast.makeText(getApplicationContext(),m_hour_24 + "시 " + m_min +  "분 " +"에 알람이 설정되었습니다!", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),l_hour_24 + "시 " + l_min +  "분 " +"에 알람이 설정되었습니다!", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),d_hour_24 + "시 " + d_min +  "분 " +"에 알람이 설정되었습니다!", Toast.LENGTH_SHORT).show();

                sendNotification();

                finish();
            }
        });

        createNotificationChannel();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Medicine", null);

        while(cursor.moveToNext()){
            if(Year == cursor.getInt(5)){
                if(Month == cursor.getInt(6)){
                    if(Day == cursor.getInt(7)){

                        String S_title = cursor.getString(0);
                        int dosage = cursor.getInt(2);
                        int dosing_number = cursor.getInt(4);
                        int dosing_days = cursor.getInt(3);
                        int status = cursor.getInt(8);

                        adapter.addItem(S_title,status, Year, Month, Day);
                    }
                }
            }
        }

        /*
        Intent intent = getIntent();
        title = intent.getStringArrayListExtra("title");
        ar_dosage = intent.getIntegerArrayListExtra("dosage");
        ar_dosing_days = intent.getIntegerArrayListExtra("dosing_days");
        ar_dosing_number = intent.getIntegerArrayListExtra("dosing_number");

        for(int i = 0 ; i < title.size() ; i ++){
            adapter.addItem(title.get(i),ar_dosing_number.get(i));
        }
         */

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
                intent.putExtra("Year", Year);
                intent.putExtra("Month", Month);
                intent.putExtra("Day", Day);
                startActivity(intent);

                finish();
            }
        });

    }

    void diaryNotification(Calendar calendar, String string)
    {
//        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
//        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
//        Boolean dailyNotify = sharedPref.getBoolean(SettingsActivity.KEY_PREF_DAILY_NOTIFICATION, true);
        Boolean dailyNotify = true; // 무조건 알람을 사용

        PackageManager pm = this.getPackageManager();
        ComponentName receiver = new ComponentName(this, DeviceBootReceiver.class);
        Intent alarmIntent = new Intent(this, AlramReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, HoUtils.createID(), alarmIntent, 0);

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

    //채널을 만드는 메소드
    public void createNotificationChannel()
    {
        //notification manager 생성
        mNotificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        // 기기(device)의 SDK 버전 확인 ( SDK 26 버전 이상인지 - VERSION_CODES.O = 26)
        if(Build.VERSION.SDK_INT
                >= Build.VERSION_CODES.O){
            //Channel 정의 생성자( construct 이용 )
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID
                    ,"Test Notification",mNotificationManager.IMPORTANCE_LOW);
            //Channel에 대한 기본 설정
            notificationChannel.setDescription("Notification");
            // Manager을 이용하여 Channel 생성
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }

    // Notification Builder를 만드는 메소드
    private NotificationCompat.Builder getNotificationBuilder() {
        SharedPreferences sharedPreferences = getSharedPreferences("setting", MODE_PRIVATE);
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle("알림 예정")
                .setContentText(" 아침 " + Integer.toString(sharedPreferences.getInt("m_hour", 8)) + " : " + Integer.toString(sharedPreferences.getInt("m_min", 30)) +
                                " 점심 " + Integer.toString(sharedPreferences.getInt("l_hour", 12)) + " : " + Integer.toString(sharedPreferences.getInt("l_min", 30)) +
                                " 저녁 " + Integer.toString(sharedPreferences.getInt("d_hour", 6)) + " : " + Integer.toString(sharedPreferences.getInt("d_min", 30)))
                .setAutoCancel(false)
                .setSmallIcon(R.drawable.ic_launcher_foreground);
        return notifyBuilder;
    }

    // Notification을 보내는 메소드
    public void sendNotification(){
        // Builder 생성
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        // Manager를 통해 notification 디바이스로 전달
        mNotificationManager.notify(NOTIFICATION_ID,notifyBuilder.build());
    }


}

