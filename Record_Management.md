# 기록관리

기록관리(달력)             |  기록상세(투약기록)
:-------------------------:|:-------------------------:
![](https://user-images.githubusercontent.com/58100710/144933761-023dfdb9-e652-4f28-88f1-9f92ca57da77.png)  |  ![](https://user-images.githubusercontent.com/58100710/144933778-2188b0ad-2e2e-49cf-8356-2a9ee60ad97f.png)
기록상세(약품추가) - 1       |  기록상세(약품추가) - 2
![](https://user-images.githubusercontent.com/58100710/144933796-e2b8b3b1-90f0-462c-95b9-f0df38835718.png)  |  ![](https://user-images.githubusercontent.com/58100710/144933801-4780c4cb-98cd-4982-98c3-94de12ad1b19.png)
기록상세(알람설정)           |  기록상세(알람시간설정)
![](https://user-images.githubusercontent.com/58100710/144933818-f09258b3-36dc-42fb-a0b8-60fdca0834f1.png)  |  ![](https://user-images.githubusercontent.com/58100710/144933827-3e0999d9-83b2-4eca-b058-e5e237908e9a.png)

## 기능 소개
자바가 제공하는 CalendarView를 이용해 해당 날짜에 사용자가 수기로 복약약품을 입력하면, 내부DB에 저장/관리한다. 또한 내부DB에 저장된 데이터를 읽어 사용자에게 유용한 알람기능까지 제공한다.
알람은 설정했을 당시 기준으로 처음 설정되며, 이후 00시 기준으로 다음날짜의 기록을 읽어 다시 재 세팅된다.

## 사용 기능(참고)
- [캘린터뷰(CalendarView)](https://developer.android.com/reference/android/widget/CalendarView)
- [DBHelper(android.database)](https://developer.android.com/reference/android/database/package-summary)
- [알람기능(Notification)](https://developer.android.com/reference/android/app/Notification)
- [알람기능(BroadcastReceiver)](https://developer.android.com/reference/android/content/BroadcastReceiver)

## 주요 코드
> CalendarView (XML)
```xml
<com.prolificinteractive.materialcalendarview.MaterialCalendarView
            android:id="@+id/calendarView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="56dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:mcv_tileWidth="50dp"
            app:mcv_tileHeight="40dp"
            app:mcv_selectionColor="#7FC4FD"
            app:mcv_showOtherDates="defaults" />
```
해당 코드를 이용해 달력의 UI를 구현한다. (자바에서 제공하는 CalendarView를 사용했다.)

>CalendarActivity (JAVA)
```java
// 달력 선언
MaterialCalendarView materialCalendarView;

protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);
//...

    // 달력 세팅
    materialCalendarView.state().edit()
            .setFirstDayOfWeek(Calendar.SUNDAY)
            .setMinimumDate(CalendarDay.from(2017, 0, 1))
            .setMaximumDate(CalendarDay.from(2040, 11, 31))
            .setCalendarDisplayMode(CalendarMode.MONTHS)
            .commit();

    materialCalendarView.addDecorators(
            new SaturdayDecorator(),
            new SundayDecorator(),
            new onDayDecorator()
    );
    
    // 달력 날짜 클릭 이벤트
    materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
           @Override
           public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
               Year = date.getYear();
               Month = date.getMonth() + 1;
               Day = date.getDay();

               SelectDay_textview.setVisibility(View.VISIBLE);
               SelectDay_textview.setText(String.format("%d" + "월 " + "%d" + "일", Month, Day));

               adapter.clear();

               SQLiteDatabase db = dbHelper.getReadableDatabase();
               Cursor cursor = db.rawQuery("SELECT * FROM Medicine", null);

               while(cursor.moveToNext()){
                   if(Year == cursor.getInt(5)){
                       if(Month == cursor.getInt(6)){
                           if(Day == cursor.getInt(7)){

                               String S_title = cursor.getString(0);
                               String indiredient = cursor.getString(1);
                               int dosage = cursor.getInt(2);
                               int dosing_number = cursor.getInt(4);
                               int dosing_days = cursor.getInt(3);
                               int stat = cursor.getInt(8);

                               //String indiredient = "주성분";
                               String s_sub2 = "투약량 : " + dosage;
                               String s_sub3 = "횟수 : " + dosing_number + "  /  일수 : " + dosing_days;

                               adapter.addItem(S_title, indiredient, s_sub2, s_sub3, stat);
                           }
                       }
                   }
               }

               adapter.notifyDataSetChanged();
           }
       });
       
       //...
}
```
달력 세팅부분과 달력 날짜 클릭시 발생하는 이벤트 부분이다.
날짜 클릭 이벤트부분은 클릭시 내부DB를 읽어 해당 날짜에 해당되는 데이터가 있을 경우 내부 데이터를 받아와 리스트의 형태로 가공하여 생성하는 역할을 수행한다.

>DBHelper (JAVA)
```java
public class DBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "dosing_list.db";

    // DB 생성자
    public DBHelper(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    // Tabel 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Medicine(name TEXT, indiredient TEXT, Dosage INT, Dosing_number INT, Dosing_days INT, Year INT, Month INT, Day INT, STATUS INT)");
    }

    // Table Upgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Medicine");
        onCreate(db);
    }

    // Table 입력
    public void insert(String name, String indiredient, int dosage, int dosing_number, int dosing_days, int year, int month, int day, int status) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO Medicine VALUES('" + name + "', '" + indiredient + "', " + dosage + ", " + dosing_number + ", " + dosing_days + ", " + year + ", " + month + ", " + day + ", " + status +")");
        db.close();
    }

    // Table 수정
    public void Update(String name, int dosage, int dosing_number, int dosing_days, int year, int month, int day) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE Medicine SET Dosage = " + dosage + ", Dosing_number = " + dosing_number + ", Dosing_days = " + dosing_days + "" + " WHERE NAME = '" + name + "' AND Year = " + year + " AND Month = " + month + " AND Day = " + day + "");
        db.close();
    }

    public void Update(String name, int year, int month, int day, int status) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE Medicine SET STATUS = " + status + "" + " WHERE NAME = '" + name + "' AND Year = " + year + " AND Month = " + month + " AND Day = " + day + "");
        db.close();
    }

    // Table 삭제
    public void Delete(String name, int year, int month, int day) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM Medicine WHERE NAME = '" + name + "' AND Year = " + year + " AND Month = " + month + " AND Day = " + day +"");
        db.close();
    }
    
}
```
내부 DB를 사용하기 위한 DBHelper 클래스. Medicine 테이블에 저장되는 데이터는 name(약품이름), indiredient(주성분), Dosage(투약량), Dosing_number(투약횟수), Dosing_days(투약일수), Year, Month, Day, STATUS(알람설정정보)이다.

## 주의사항
현재 약품추가 팝업에서 약품이름을 입력할때, 리스트에 띄워진 약품이름이 아닐경우 오류가 생기고 있습니다.
