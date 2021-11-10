package com.example.mylittledoctor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface hsptl_info_API {
    @Headers("Accept: application/Xml")
    @GET("/B552657/HsptlAsembySearchService/getHsptlBassInfoInqire?")
    Call<InfoResult> getHsptlInfo
            (@Query("HPID") String Hpid,
             @Query("ServiceKey") String servicekey);
}
