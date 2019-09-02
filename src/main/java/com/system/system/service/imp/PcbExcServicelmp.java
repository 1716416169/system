package com.system.system.service.imp;

import com.system.system.entiy.Pcb;
import com.system.system.service.PcbService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PcbExcServicelmp extends Thread{

    public static ArrayList<Pcb> pcbs=new ArrayList<>();

    Pcb pcb;

    public PcbExcServicelmp(Pcb pcb) {
        this.pcb=pcb;
    }

    @Override
    public void run() {
        try {
            //System.out.println("程序t1："+Pcb.exc);
            Pcb.exc--;
            //System.out.println("程序t1："+Pcb.exc);
            Thread.sleep(pcb.excTimes);
            System.out.println("进程1运行了："+pcb.excTimes);
            System.out.println("进程1运作完毕");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Pcb.pcbs++;
        Pcb.exc++;
        pcbs.remove(0);

    }
}
