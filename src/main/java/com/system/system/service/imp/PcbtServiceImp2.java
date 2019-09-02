package com.system.system.service.imp;
import com.system.system.entiy.Pcb;

import static com.system.system.service.imp.PcbtServiceImp.pcbst;


public class PcbtServiceImp2 extends Thread{
    public Integer time;
    public Pcb pcb;
    public PcbtServiceImp2(Integer time,Pcb exctime) {
        this.pcb=exctime;
        this.time=time;
    }

    @Override
    public void run() {
        try {
            Pcb.exc--;
               Thread.sleep(time);
               System.out.println("进程t2等待了:"+time);
               while(true) {
                   if (Pcb.timePian > pcb.excTimes) {
                       Thread.sleep(pcb.excTimes);
                       System.out.println("进程t2运行了：" + Pcb.timePian);
                       System.out.println("进程t2运作完毕");
                       Pcb.exc++;
                       Pcb.pcbs++;
                       pcbst.remove(0);
                       break;
                   } else {
                       pcb.excTimes -= Pcb.timePian;
                       Thread.sleep(Pcb.timePian);
                       Thread.sleep(Pcb.timePian);
                       //System.out.println("进程t2只运行了：" + Pcb.timePian);
                       Pcb.exc++;
                       //pcbst.remove(0);
                       pcbst.add(pcb);
                       Thread.sleep(Pcb.timePian);
                       //System.out.println("进程t2等待了："+Pcb.timePian);
                   }
               }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
