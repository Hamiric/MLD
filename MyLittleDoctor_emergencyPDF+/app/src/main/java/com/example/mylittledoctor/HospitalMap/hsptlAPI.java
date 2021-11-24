package com.example.mylittledoctor.HospitalMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface hsptlAPI {
    @Headers("Accept: application/Xml")
    @GET("/B552657/HsptlAsembySearchService/getHsptlMdcncLcinfoInqire?")
    Call<LocationResult> getHsptlLc
            (@Query("WGS84_LON") double LON,
            @Query("WGS84_LAT") double LAT,
             @Query("numOfRows") int num,
             @Query("ServiceKey") String servicekey);
}
