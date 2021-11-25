package com.example.mylittledoctor.Calendar;

public class HoUtils {
    public static int requestcode = 0;

    public static int createID(){
        return requestcode++;
    }
}
