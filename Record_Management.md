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
```c
#include <stdio.h>

int main(void) {
  printf("Hello World!");
  return 0;
}
```
