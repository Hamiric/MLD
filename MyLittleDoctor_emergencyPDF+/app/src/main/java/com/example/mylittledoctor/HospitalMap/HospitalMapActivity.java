package com.example.mylittledoctor.HospitalMap;

import android.graphics.PointF;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylittledoctor.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.util.FusedLocationSource;
import com.naver.maps.map.widget.LocationButtonView;
import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class HospitalMapActivity extends AppCompatActivity implements Overlay.OnClickListener, OnMapReadyCallback {
    private static final int ACCESS_LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private FusedLocationSource locationSource;
    private MapView mapView;
    private static NaverMap naverMap;
    private InfoWindow infoWindow;
    private Geocoder geocoder;
    private final ArrayList<LocationResult.body.items.item> hsptl_list = new ArrayList<>();
    private final List<Marker> markerList = new ArrayList<Marker>();
    private final int num = 100;
    private final String ServiceKey =
            "rGDxc3F8azkUy5D1UwkyiX6i9/cDIIRngyQTIXgSLau7d4UCkLckhb6TKkH+PlEVcN4S16gV3S+a9ierZRfa/g==";
    Button h_tab_btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitalmap);
        h_tab_btn1=(Button)findViewById(R.id.h_tab_btn1);
        h_tab_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mapView = (MapView) findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        locationSource = new FusedLocationSource(this, ACCESS_LOCATION_PERMISSION_REQUEST_CODE);

        // bottom sheet ?????? ?????????
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheet));
        Button btnPersistent = (Button) findViewById(R.id.btnPersistent);
        btnPersistent.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                // bottomSheet??? ????????? ?????? ?????????
                if(bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                // bottomSheet??? ?????? ????????? ?????????
                else{
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });
    }

    @Override
    public boolean onClick(@NonNull Overlay overlay) {

        Marker marker = (Marker) overlay;
        infoWindow.open(marker);

        return false;
    }

    // ?????? ????????? ??????
    @Override
    public void onMapReady (@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;
        geocoder = new Geocoder(this);

        naverMap.setLocationSource(locationSource);
        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setLocationButtonEnabled(false);
        uiSettings.setZoomControlEnabled(false);
        LocationButtonView locationButtonView = findViewById(R.id.locationbutton);
        locationButtonView.setMap(naverMap);

        infoWindow = new InfoWindow();
        infoWindow.setAdapter(new InfoWindow.DefaultViewAdapter(this) {
            @NonNull
            @Override
            protected View getContentView(@NonNull InfoWindow infoWindow) {
                Marker marker = infoWindow.getMarker();
                LocationResult.body.items.item infoitem = (LocationResult.body.items.item) marker.getTag();
                View view = View.inflate(HospitalMapActivity.this, R.layout.item_hospitalmap_recycler, null);
                ((TextView) view.findViewById(R.id.dutyName)).setText(infoitem.dutyName);
                ((TextView) view.findViewById(R.id.distance)).setText(Double.toString(infoitem.distance) + "km");
                ((TextView) view.findViewById(R.id.dutyAddr)).setText(infoitem.dutyAddr);
                return view;
            }
        });

        // ????????? ??????????????? ????????? ?????? ?????? ??????
        LatLng mapCenter = naverMap.getCameraPosition().target;

        naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);

        NaverMap.OnCameraIdleListener onCameraIdleListener = new NaverMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                LatLng mapCenter = naverMap.getCameraPosition().target;
                fetchLocation(mapCenter.longitude, mapCenter.latitude, ServiceKey);
            }
        };

        // ?????? ???????????? ????????? ????????? ??????
        naverMap.addOnCameraIdleListener(onCameraIdleListener);

        // ?????? ????????? API ??????
        fetchLocation(mapCenter.longitude, mapCenter.latitude, ServiceKey);

        // ?????? ?????? ?????? ??????
        EditText searchBox = findViewById(R.id.edittext);
        Button searchButton = findViewById(R.id.Search_map);
        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String searchText = searchBox.getText().toString();
                Geocoder geocoder = new Geocoder(getBaseContext());
                List<Address> addresses = null;

                try{
                    addresses = geocoder.getFromLocationName(searchText, 3);
                    if(addresses != null && !addresses.equals(" ")) {
                        Address address = addresses.get(0);
                        LatLng point = new LatLng(address.getLatitude(), address.getLongitude());

                        String addressText = String.format("%s, %s", address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : " ", address.getFeatureName());

                        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(point);
                        naverMap.moveCamera(cameraUpdate);
                    }
                } catch (Exception e) {

                }
            }
        });
    }

    // ????????? ?????? ??????
    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case ACCESS_LOCATION_PERMISSION_REQUEST_CODE:
                locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults);
                return;
        }
    }

    private void fetchLocation(double LON, double LAT, String SERVICEKEY){

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
        hsptlAPI HsptAPI = retrofit.create(hsptlAPI.class);
        HsptAPI.getHsptlLc(LON, LAT, num, SERVICEKEY).enqueue(new Callback<LocationResult>() {
            @Override
            public void onResponse(Call<LocationResult> call, Response<LocationResult> response) {
                if(response.code() == 200){
                    LocationResult result = response.body();
                    updateMapMarkers(result);
                    updatedutyNamelist(result);
                }

                else{
                    Log.e("MainActivityRepository", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<LocationResult> call, Throwable t) {

            }
        });
    }

    private void updateMapMarkers(LocationResult result) {
        resetMarkerList();
        if (result.body.items.item != null && result.body.items.item.size() > 0) {
            for (LocationResult.body.items.item newitem : result.body.items.item) {
                if(newitem.distance <= 1.2 ) {

                    Marker marker = new Marker();
                    marker.setTag(newitem);
                    marker.setPosition(new LatLng(newitem.latitude, newitem.longitude));
                    marker.setAnchor(new PointF(0.0f, 0.0f));

                    marker.setWidth(80);
                    marker.setHeight(80);
                    marker.setIcon(OverlayImage.fromResource(R.drawable.hospitalmap_marker));

                    marker.setMap(naverMap);
                    marker.setOnClickListener(this);

                    markerList.add(marker);
                }
            }
        }
    }

    private void resetMarkerList() {
        if(markerList != null && markerList.size() > 0) {
            for (Marker marker : markerList) {
                marker.setMap(null);
            }
            markerList.clear();
        }
    }

    private void updatedutyNamelist(LocationResult result) {
        resetdutyNameList();

        if (result.body.items.item != null && result.body.items.item.size() > 0) {
            for (LocationResult.body.items.item newitem : result.body.items.item) {
                if(newitem.distance <= 1.2) {
                    hsptl_list.add(newitem);
                }
            }

            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            Adapter adapter = new Adapter(hsptl_list);
            recyclerView.setAdapter(adapter);
        }
    }

    private void resetdutyNameList() {
        if(hsptl_list != null && hsptl_list.size() > 0) {
            hsptl_list.clear();
        }
    }

    @Override
    public void onStart()
    {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop()
    {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory()
    {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
