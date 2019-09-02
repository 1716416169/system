package com.system.system.entiy;
public class Pcb{
    public static Integer timePian=3;  //时间片
    public static Integer pcbs=2;  //控制块可用数量
    public static Integer exc=1;      //可执行的程序数量
    public String pid;
    public String uid;
    public Integer comeTime;
    public Integer excTimes;

    public static Integer getTimePian() {
        return timePian;
    }

    public static void setTimePian(Integer timePian) {
        Pcb.timePian = timePian;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getComeTime() {
        return comeTime;
    }

    public void setComeTime(Integer comeTime) {
        this.comeTime = comeTime;
    }

    public Integer getExcTimes() {
        return excTimes;
    }

    public void setExcTimes(Integer excTimes) {
        this.excTimes = excTimes;
    }


    @Override
    public String toString() {
        return "Pcb{" +
                "pid='" + pid + '\'' +
                ", uid='" + uid + '\'' +
                ", comeTime=" + comeTime +
                ", excTimes=" + excTimes +
                '}';
    }
}
