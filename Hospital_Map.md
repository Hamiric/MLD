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
```c
#include <stdio.h>

int main(void) {
  printf("Hello World!");
  return 0;
}
```
