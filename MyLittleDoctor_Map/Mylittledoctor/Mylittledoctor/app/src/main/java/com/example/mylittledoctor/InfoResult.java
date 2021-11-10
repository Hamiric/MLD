package com.example.mylittledoctor;

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
                public int dutyTime1c;

                @PropertyElement
                public int dutyTime1s;

                @PropertyElement
                public int dutyTime2c;

                @PropertyElement
                public int dutyTime2s;

                @PropertyElement
                public int dutyTime3c;

                @PropertyElement
                public int dutyTime3s;

                @PropertyElement
                public int dutyTime4c;

                @PropertyElement
                public int dutyTime4s;

                @PropertyElement
                public int dutyTime5c;

                @PropertyElement
                public int dutyTime5s;

                @PropertyElement
                public int dutyTime6c;

                @PropertyElement
                public int dutyTime6s;

                @PropertyElement
                public int dutyTime7c;

                @PropertyElement
                public int dutyTime7s;

                @PropertyElement
                public int dutyTime8c;

                @PropertyElement
                public int dutyTime8s;

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

                public int getDutyTime1c() {
                    return dutyTime1c;
                }

                public void setDutyTime1c(int dutyTime1c) {
                    this.dutyTime1c = dutyTime1c;
                }

                public int getDutyTime1s() {
                    return dutyTime1s;
                }

                public void setDutyTime1s(int dutyTime1s) {
                    this.dutyTime1s = dutyTime1s;
                }

                public int getDutyTime2c() {
                    return dutyTime2c;
                }

                public void setDutyTime2c(int dutyTime2c) {
                    this.dutyTime2c = dutyTime2c;
                }

                public int getDutyTime2s() {
                    return dutyTime2s;
                }

                public void setDutyTime2s(int dutyTime2s) {
                    this.dutyTime2s = dutyTime2s;
                }

                public int getDutyTime3c() {
                    return dutyTime3c;
                }

                public void setDutyTime3c(int dutyTime3c) {
                    this.dutyTime3c = dutyTime3c;
                }

                public int getDutyTime3s() {
                    return dutyTime3s;
                }

                public void setDutyTime3s(int dutyTime3s) {
                    this.dutyTime3s = dutyTime3s;
                }

                public int getDutyTime4c() {
                    return dutyTime4c;
                }

                public void setDutyTime4c(int dutyTime4c) {
                    this.dutyTime4c = dutyTime4c;
                }

                public int getDutyTime4s() {
                    return dutyTime4s;
                }

                public void setDutyTime4s(int dutyTime4s) {
                    this.dutyTime4s = dutyTime4s;
                }

                public int getDutyTime5c() {
                    return dutyTime5c;
                }

                public void setDutyTime5c(int dutyTime5c) {
                    this.dutyTime5c = dutyTime5c;
                }

                public int getDutyTime5s() {
                    return dutyTime5s;
                }

                public void setDutyTime5s(int dutyTime5s) {
                    this.dutyTime5s = dutyTime5s;
                }

                public int getDutyTime6c() {
                    return dutyTime6c;
                }

                public void setDutyTime6c(int dutyTime6c) {
                    this.dutyTime6c = dutyTime6c;
                }

                public int getDutyTime6s() {
                    return dutyTime6s;
                }

                public void setDutyTime6s(int dutyTime6s) {
                    this.dutyTime6s = dutyTime6s;
                }

                public int getDutyTime7c() {
                    return dutyTime7c;
                }

                public void setDutyTime7c(int dutyTime7c) {
                    this.dutyTime7c = dutyTime7c;
                }

                public int getDutyTime7s() {
                    return dutyTime7s;
                }

                public void setDutyTime7s(int dutyTime7s) {
                    this.dutyTime7s = dutyTime7s;
                }

                public int getDutyTime8c() {
                    return dutyTime8c;
                }

                public void setDutyTime8c(int dutyTime8c) {
                    this.dutyTime8c = dutyTime8c;
                }

                public int getDutyTime8s() {
                    return dutyTime8s;
                }

                public void setDutyTime8s(int dutyTime8s) {
                    this.dutyTime8s = dutyTime8s;
                }
            }

        }

    }
}
