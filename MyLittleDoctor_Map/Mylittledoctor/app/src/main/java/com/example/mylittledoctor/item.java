package com.example.mylittledoctor;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name="item")
public class item {

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
}
