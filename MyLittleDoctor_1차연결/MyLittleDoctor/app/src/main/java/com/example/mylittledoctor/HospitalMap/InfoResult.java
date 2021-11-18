package com.example.mylittledoctor.HospitalMap;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml
public class InfoResult {

    @Element
    public header_info header;

    @Element
    public body_info body;

    @Xml(name="header")
    public static class header_info {

        @PropertyElement
        public int resultCode;

        @PropertyElement
        public String resultMsg;
    }

    @Xml(name="body")
    public static class body_info {

        @Element
        public items_info items;

        @PropertyElement
        public int numOfRows;

        @PropertyElement
        public int pageNo;

        @PropertyElement
        public int totalCount;

        @Xml(name="items")
        public static class items_info {

            @Element
            public List<item_info> item;

            @Xml(name="item")
            public static class item_info {

                @PropertyElement
                public String dgidIdName;

                @PropertyElement
                public String dutyAddr;

                @PropertyElement
                public String dutyName;

                @PropertyElement
                public String dutyTel1;

                @PropertyElement
                public String dutyTime1c;

                @PropertyElement
                public String dutyTime1s;

                @PropertyElement
                public String dutyTime2c;

                @PropertyElement
                public String dutyTime2s;

                @PropertyElement
                public String dutyTime3c;

                @PropertyElement
                public String dutyTime3s;

                @PropertyElement
                public String dutyTime4c;

                @PropertyElement
                public String dutyTime4s;

                @PropertyElement
                public String dutyTime5c;

                @PropertyElement
                public String dutyTime5s;

                @PropertyElement
                public String dutyTime6c;

                @PropertyElement
                public String dutyTime6s;

                @PropertyElement
                public String dutyTime7c;

                @PropertyElement
                public String dutyTime7s;

                @PropertyElement
                public String dutyTime8c;

                @PropertyElement
                public String dutyTime8s;

                @PropertyElement
                public double wgs84Lat;

                @PropertyElement
                public double wgs85Lon;

                public String getDgidldName() {
                    return dgidIdName;
                }

                public void setDgidldName(String dgidldName) {
                    this.dgidIdName = dgidldName;
                }

                public String getDutyAddr() {
                    return dutyAddr;
                }

                public void setDutyAddr(String dutyAddr) {
                    this.dutyAddr = dutyAddr;
                }

                public String getDutyName() {
                    return dutyName;
                }

                public void setDutyName(String dutyName) {
                    this.dutyName = dutyName;
                }

                public String getDutyTel1() {
                    return dutyTel1;
                }

                public void setDutyTel1(String dutyTel1) {
                    this.dutyTel1 = dutyTel1;
                }

                public String getDutyTime1c() {
                    return dutyTime1c;
                }

                public void setDutyTime1c(String dutyTime1c) {
                    this.dutyTime1c = dutyTime1c;
                }

                public String getDutyTime1s() {
                    return dutyTime1s;
                }

                public void setDutyTime1s(String dutyTime1s) {
                    this.dutyTime1s = dutyTime1s;
                }

                public String getDutyTime2c() {
                    return dutyTime2c;
                }

                public void setDutyTime2c(String dutyTime2c) {
                    this.dutyTime2c = dutyTime2c;
                }

                public String getDutyTime2s() {
                    return dutyTime2s;
                }

                public void setDutyTime2s(String dutyTime2s) {
                    this.dutyTime2s = dutyTime2s;
                }

                public String getDutyTime3c() {
                    return dutyTime3c;
                }

                public void setDutyTime3c(String dutyTime3c) {
                    this.dutyTime3c = dutyTime3c;
                }

                public String getDutyTime3s() {
                    return dutyTime3s;
                }

                public void setDutyTime3s(String dutyTime3s) {
                    this.dutyTime3s = dutyTime3s;
                }

                public String getDutyTime4c() {
                    return dutyTime4c;
                }

                public void setDutyTime4c(String dutyTime4c) {
                    this.dutyTime4c = dutyTime4c;
                }

                public String getDutyTime4s() {
                    return dutyTime4s;
                }

                public void setDutyTime4s(String dutyTime4s) {
                    this.dutyTime4s = dutyTime4s;
                }

                public String getDutyTime5c() {
                    return dutyTime5c;
                }

                public void setDutyTime5c(String dutyTime5c) {
                    this.dutyTime5c = dutyTime5c;
                }

                public String getDutyTime5s() {
                    return dutyTime5s;
                }

                public void setDutyTime5s(String dutyTime5s) {
                    this.dutyTime5s = dutyTime5s;
                }

                public String getDutyTime6c() {
                    return dutyTime6c;
                }

                public void setDutyTime6c(String dutyTime6c) {
                    this.dutyTime6c = dutyTime6c;
                }

                public String getDutyTime6s() {
                    return dutyTime6s;
                }

                public void setDutyTime6s(String dutyTime6s) {
                    this.dutyTime6s = dutyTime6s;
                }

                public String getDutyTime7c() {
                    return dutyTime7c;
                }

                public void setDutyTime7c(String dutyTime7c) {
                    this.dutyTime7c = dutyTime7c;
                }

                public String getDutyTime7s() {
                    return dutyTime7s;
                }

                public void setDutyTime7s(String dutyTime7s) {
                    this.dutyTime7s = dutyTime7s;
                }

                public String getDutyTime8c() {
                    return dutyTime8c;
                }

                public void setDutyTime8c(String dutyTime8c) {
                    this.dutyTime8c = dutyTime8c;
                }

                public String getDutyTime8s() {
                    return dutyTime8s;
                }

                public void setDutyTime8s(String dutyTime8s) {
                    this.dutyTime8s = dutyTime8s;
                }
            }

        }

    }
}
