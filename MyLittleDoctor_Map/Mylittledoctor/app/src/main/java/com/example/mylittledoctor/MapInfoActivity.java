package com.example.mylittledoctor;

import android.content.Intent;
import android.graphics.PointF;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapOptions;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.OverlayImage;
import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class MapInfoActivity extends AppCompatActivity implements OnMapReadyCallback {
    private MapView mapView;
    private static NaverMap naverMap;
    private static ArrayList<InfoResult.body_info.items_info.item_info> list = new ArrayList<>();
    private TextView hsptlName;
    private Intent intent;
    private String hpid;
    private double WGS84LAT;
    private double WGS84LON;
    private final String ServiceKey =
            "rGDxc3F8azkUy5D1UwkyiX6i9/cDIIRngyQTIXgSLau7d4UCkLckhb6TKkH+PlEVcN4S16gV3S+a9ierZRfa/g==";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_info);

        mapView = (MapView) findViewById(R.id.Info_map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        intent = getIntent();
        hpid = intent.getStringExtra("hpid");

        fetchHospital(hpid, ServiceKey);

        // 뒤로 가기 버튼 리스너
        Button BackButton = (Button) findViewById(R.id.Info_tab_btn1);
        BackButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
            }
        });
    }

    @Override
    public void onMapReady (@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;
        intent = getIntent();
        WGS84LAT = intent.getDoubleExtra("WGS84LAT", 0);
        WGS84LON = intent.getDoubleExtra("WGS84LON", 0);
        LatLng location = new LatLng(WGS84LAT, WGS84LON);
        CameraPosition cameraPosition = new CameraPosition(location, 16);
        naverMap.setCameraPosition(cameraPosition);

        Marker marker = new Marker();
        marker.setPosition(location);
        marker.setAnchor(new PointF(0.0f, 0.0f));
        marker.setWidth(128);
        marker.setHeight(128);
        marker.setIcon(OverlayImage.fromResource(R.drawable.hospital_marker));
        marker.setMap(naverMap);

        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setAllGesturesEnabled(false);
        uiSettings.setZoomControlEnabled(false);
    }

    private void fetchHospital(String hpid, String SERVICEKEY){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(httpLoggingInterceptor).build();

        TikXml tikXml = new TikXml.Builder().exceptionOnUnreadXml(false).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.data.go.kr")
                .client(client)
                .addConverterFactory(TikXmlConverterFactory.create(tikXml))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        hsptl_info_API HsptlAPI = retrofit.create(hsptl_info_API.class);
        HsptlAPI.getHsptlInfo(hpid, SERVICEKEY).enqueue(new Callback<InfoResult>() {
            @Override
            public void onResponse(Call<InfoResult> call, Response<InfoResult> response) {
                if(response.code() == 200){
                    InfoResult result = response.body();
                    updatelist(result);
                }

                else{
                    Log.e("MainActivityRepository", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<InfoResult> call, Throwable t) {

            }
        });
    }

    public void updatelist(InfoResult result) {

        if (list != null && list.size() > 0) {
            list.clear();
        }

        for (InfoResult.body_info.items_info.item_info newitem : result.body.items.item) {
            list.add(newitem);

            hsptlName = findViewById(R.id.Info_dutyName);
            hsptlName.setText(newitem.getDutyName());
        }

        RecyclerView recyclerView = findViewById(R.id.Info_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Info_Adapter adapter = new Info_Adapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
