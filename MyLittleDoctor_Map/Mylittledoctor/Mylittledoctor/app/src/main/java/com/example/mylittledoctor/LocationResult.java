package com.example.mylittledoctor;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml
public class LocationResult {

    @Element
    public header header;

    @Element
    public body body;

    @Xml(name="header")
    public static class header {

        @PropertyElement
        public int resultCode;

        @PropertyElement
        public String resultMsg;
    }

    @Xml(name="body")
    public static class body {

        @Element
        public items items;

        @PropertyElement
        public int numOfRows;

        @PropertyElement
        public int pageNo;

        @PropertyElement
        public int totalCount;

        @Xml(name="items")
        public static class items {

            @Element
            public List<item> item;

            @Xml(name="item")
            public static class item {

                @PropertyElement
                public int cnt;

                @PropertyElement
                public double distance;

                @PropertyElement
                public String dutyAddr;

                @PropertyElement
                public String dutyDiv;

                @PropertyElement
                public String dutyDivName;

                @PropertyElement
                public String dutyEmcls;

                @PropertyElement
                public String dutyFax;

                @PropertyElement
                public int dutyLvkl;

                @PropertyElement
                public String dutyName;

                @PropertyElement
                public String dutyTel1;

                @PropertyElement
                public int endTime;

                @PropertyElement
                public String hpid;

                @PropertyElement
                public double latitude;

                @PropertyElement
                public double longitude;

                @PropertyElement
                public int rnum;

                @PropertyElement
                public int startTime;

                public double getDistance() {
                    return distance;
                }

                public void setDistance(double distance) {
                    this.distance = distance;
                }

                public String getDutyAddr() {
                    return dutyAddr;
                }

                public void setDutyAddr(String dutyAddr) {
                    this.dutyAddr = dutyAddr;
                }

                public String getdutyName() {
                    return dutyName;
                }

                public void setdutyName(String dutyName) {
                    this.dutyName = dutyName;
                }

                public String gethpid() {
                    return hpid;
                }

                public void sethpid(String hpid) {
                    this.hpid = hpid;
                }

                public double getLatitude() {
                    return latitude;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public double getLongitude() {
                    return longitude;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }
            }
        }
    }
}
