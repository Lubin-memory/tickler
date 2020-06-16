package com.example.tickler;

public class Heat_History {
    private int id;
    private String curTime;
    private Float curHeat;

    public Heat_History() {
        super();
        curTime = "";
        curHeat = 0f;
    }
    public Heat_History(String curTime, Float curHeat) {
        super();
        this.curTime = curTime;
        this.curHeat = curHeat;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCurTime() {
        return curTime;
    }
    public void setCurTime(String curTime) {
        this.curTime = curTime;
    }
    public Float getCurHeat() {
        return curHeat;
    }
    public void setCurHeat(Float curHeat) {
        this.curHeat = curHeat;
    }
}
