# 병원지도

병원지도             |  병원지도(리스트확장)
:-------------------------:|:-------------------------:
![](https://user-images.githubusercontent.com/58100710/144922345-f37663cc-0a82-4df0-9a5b-3e78fb3cfa84.png)  |  ![](https://user-images.githubusercontent.com/58100710/144922370-a4720c5e-f0e9-4d67-b9c3-91fe183e393b.png)
병원지도(마크클릭)            |  리스트클릭(병원정보)
![](https://user-images.githubusercontent.com/58100710/144922377-58e668ca-d8ac-4e86-a7ea-5cd1af5da7b8.png)  |  ![](https://user-images.githubusercontent.com/58100710/144922401-759b48c3-d1a3-4fd1-ad88-43a14a17da46.png)

## 기능 소개
현재 공공데이터 포털에서 제공하고 있는 병원정보를 기반으로 네이버 지도 api를 사용해 사용자에게 병원의 세부 정보를 제공한다.
제공 정보로는 **병원 이름** , **병원 주소**, **병원 연락처**, **진료시간** , **진료과목** 등이다. 현재 사용자의 위치 정보를 액세스하면 사용자의 위치 정보를 받아 현재 위치에서 가까운 병원 정보부터 제공한다.

## 사용 API
- [네이버 지도 API](https://www.ncloud.com/product/applicationService/maps)
- [NIA-IFT-OpenAPI 국립중앙의료원-병의원찾기서비스](https://www.data.go.kr/data/15000736/openapi.do)

## 주요 코드
> MapView (XML)
```xml

<com.naver.maps.map.MapView
            android:id="@+id/map_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_marginBottom="187dp">
```
해당 코드를 이용하여 네이버 지도를 보여준다.

>HospitalMapActivity (JAVA)
```java

@Override
protected void onCreate(Bundle savedInstanceState) {
    //...
    
    // 네이버 지도 불러오기
    mapView = (MapView) findViewById(R.id.map_view);
    mapView.onCreate(savedInstanceState);
    mapView.getMapAsync(this); 
    
    // 지도의 마커를 클릭하면 병원 정보를 infowindow로 보여줌.
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
    //...
    
    // 지도 위치 검색 기능
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
            } catch (Exception e){
            }
        }
    });
}
    
// 네이버 지도가 불러오면 실행되는 메서드
@Override
public void onMapReady (@NonNull NaverMap naverMap) {
    
    // 네이버 지도 세팅
    this.naverMap = naverMap;
    naverMap.setLocationSource(locationSource);
    UiSettings uiSettings = naverMap.getUiSettings();
    uiSettings.setLocationButtonEnabled(false);
    uiSettings.setZoomControlEnabled(false);
    LocationButtonView locationButtonView = findViewById(R.id.locationbutton);
    locationButtonView.setMap(naverMap);
    //...
}
        
// 위치좌표를 받으면 근처 병원의 정보를 알려주는 API를 호출하는 메서드
private void fetchLocation(double LON, double LAT, String SERVICEKEY){
    //...
    
    // Retrofit을 이용하여 API에 연결하고 TikXml을 이용하여 API로부터 받은 XML을 java 클래스로 변환
    TikXml tikXml = new TikXml.Builder().exceptionOnUnreadXml(false).build();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://apis.data.go.kr")
            .client(client)
            .addConverterFactory(TikXmlConverterFactory.create(tikXml))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    hsptlAPI HsptAPI = retrofit.create(hsptlAPI.class);
        
    // 연결에 성공하면 result에 결과물을 받음
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
    //...
            
// API에서 받은 좌표들을 지도에 마커로 표시하는 메서드
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
```
위 코드를 이용하여 병원지도 초기 화면을 구현한다.  
병원위치에 대한 XML 데이터는 LocationResult.class로 받는다.
       
>HospitalInfoActivity (JAVA)
```java

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    //...
    // 네이버 지도 불러오기
    mapView = (MapView) findViewById(R.id.Info_map);
    mapView.onCreate(savedInstanceState);
    mapView.getMapAsync(this);
    //...
}

// 네이버 지도가 불러오면 실행되는 메서드
@Override
    public void onMapReady (@NonNull NaverMap naverMap) {
    //...
    
    //이전 Activity에서 병원 하나의 좌표를 받아서 지도의 위치를 고정시킨다.
    intent = getIntent();
    WGS84LAT = intent.getDoubleExtra("WGS84LAT", 0);
    WGS84LON = intent.getDoubleExtra("WGS84LON", 0);
    LatLng location = new LatLng(WGS84LAT, WGS84LON);
    CameraPosition cameraPosition = new CameraPosition(location, 16);
    naverMap.setCameraPosition(cameraPosition);
    //...
    
    //네이버 지도에서 기본적으로 제공하는 UI와 지도 움직임을 모두 비활성화한다.
    UiSettings uiSettings = naverMap.getUiSettings();
    uiSettings.setAllGesturesEnabled(false);
    uiSettings.setZoomControlEnabled(false);
}

// 병원의 위치좌표를 받으면 해당 병원의 정보를 알려주는 API를 호출하는 메서드
private void fetchHospital(String hpid, String SERVICEKEY){
    // HospitalMapActivity의 fetchLocation과 동일
}
//...
    
//병원에 대한 정보를 지도 아래의 리사이클 뷰에 출력하는 메서드
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
//...

```
위 코드를 이용하여 병원 리스트에서 선택한 병원의 정보를 출력하는 화면을 구성한다.  
병원 정보에 대한 XML 데이터는 InfoResult.class로 받는다.
    
    

## 주의사항
현재 적용된 'NIA-IFT-OpenAPI 국립중앙의료원-병의원찾기서비스' api가 새벽시간엔 연결이 잘안되는 오류가 있습니다.  
위치 정보를 가져오는데 3 ~ 4초가량의 시간이 소요됩니다. 지도의 중앙부분을 기준으로 병원 리스트가 출력되기 때문에, 지도를 움직이면 다시 리스트를 불러오는 작업이 실행되므로, 막 움직이지 마시고 진득하게 기다려주세요.
