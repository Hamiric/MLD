package com.example.mylittledoctor.Calendar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "dosing_list.db";

    // DB 생성자
    public DBHelper(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    // Person Tabel 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Medicine(name TEXT, indiredient TEXT, Dosage INT, Dosing_number INT, Dosing_days INT, Year INT, Month INT, Day INT, STATUS INT)");
    }

    // Person Table Upgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Medicine");
        onCreate(db);
    }

    // Person Table 입력
    public void insert(String name, String indiredient, int dosage, int dosing_number, int dosing_days, int year, int month, int day, int status) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO Medicine VALUES('" + name + "', '" + indiredient + "', " + dosage + ", " + dosing_number + ", " + dosing_days + ", " + year + ", " + month + ", " + day + ", " + status +")");
        db.close();
    }

    // Person Table 수정
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

    // Person Table 삭제
    public void Delete(String name, int year, int month, int day) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM Medicine WHERE NAME = '" + name + "' AND Year = " + year + " AND Month = " + month + " AND Day = " + day +"");
        db.close();
    }

    // Person Tabel 조회
    /*
    public void getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM Medicine", null);
        while (cursor.moveToNext()) {
            result += " 이름 : " + cursor.getString(0) + ", 나이 : " + cursor.getInt(1) + ", 주소 : " + cursor.getString(2) + "\n";
        }

    }
    */
}





