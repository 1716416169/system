package com.system.system.service.imp;

import com.system.system.entiy.Pcb;
import io.swagger.models.auth.In;

import static com.system.system.service.imp.PcbExcServicelmp.pcbs;

public class PcbExcServiceImp2 extends Thread {

    public Integer time;
    public Integer exctime;
    public PcbExcServiceImp2(Integer time,Integer exctime) {
        this.time=time;
        this.exctime=exctime;
    }

    @Override
    public void run() {
        try {
            Pcb.exc--;
            Thread.sleep(time);
            System.out.println("进程2等待了："+time);;
            Thread.sleep(exctime);
            System.out.println("进程2运行了："+exctime);
            System.out.println("进程2运作完毕");
            Pcb.exc++;
            Pcb.pcbs++;
            pcbs.remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
