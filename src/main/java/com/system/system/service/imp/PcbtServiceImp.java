package com.system.system.service.imp;

import com.system.system.entiy.Pcb;

import java.util.ArrayList;

public class PcbtServiceImp extends Thread{
    public static ArrayList<Pcb> pcbst=new ArrayList<>();
    Pcb pcb;

    public PcbtServiceImp(Pcb pcb) {
        this.pcb=pcb;
    }

    @Override
    public void run() {
        try {
            System.out.println("进程t2等待了:"+Pcb.timePian);
            while(true){
                Pcb.exc--;
                Thread.sleep(Pcb.timePian);
                if(Pcb.timePian>pcb.excTimes){
                    Pcb.pcbs++;
                    Pcb.exc++;
                    pcbst.remove(0);
                    System.out.println("进程t1运行了："+Pcb.timePian);
                    System.out.println("进程t1运作完毕");
                    break;
                }else {
                    pcb.excTimes-=Pcb.timePian;
                    //System.out.println("进程只运行了："+Pcb.timePian);
                    Thread.sleep(Pcb.timePian);
                    Pcb.exc++;
                   // pcbst.remove(0);
                    pcbst.add(pcb);
                    Thread.sleep(Pcb.timePian);
                    //System.out.println("进程等待了："+Pcb.timePian);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
