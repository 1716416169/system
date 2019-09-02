package com.system.system.service.imp;

import com.system.system.controller.docmentController;
import com.system.system.entiy.Pcb;
import com.system.system.service.apiService;
import java.text.SimpleDateFormat;
import java.util.*;


import static com.system.system.controller.docmentController.docments;
import static com.system.system.controller.docmentController.docmentsMap;
import static com.system.system.service.imp.PcbExcServicelmp.pcbs;
import static com.system.system.service.imp.PcbtServiceImp.pcbst;

public class  apiServiceImp implements apiService {
    static SimpleDateFormat df = new SimpleDateFormat("ss");
    static Pcb pcbflag;


    @Override
    public Object[] apiService(String flag) {
        if (docments.size() < 1) {
            docments.add(0);
        }
        System.out.println("输入的字符串为：" + flag);
        if (flag.equals("ls")) {
            if (docmentsMap.get(docmentController.root) == null) {
                return null;
            } else {
                return docmentsMap.get(docmentController.root).toArray();
            }
        } else if (flag.indexOf("touch") != -1) {
            //System.out.println("匹配的子字符位置：" + flag.indexOf("touch"));
            String substring = flag.substring(6);
            System.out.println("创建的文件夹：" + substring);
            if (docmentsMap.get(docmentController.root) == null) {
                LinkedList<Object> objects = new LinkedList<>();
                objects.add(substring);
                docmentsMap.put(docmentController.root, objects);//当前文件夹 包含文件夹
                System.out.println("此目录下文件数量为：" + docmentsMap.get(docmentController.root));
            } else {
                docmentsMap.get(docmentController.root).add(substring);
            }
            System.out.println(docmentsMap.get(docmentController.root));
           /* objects[0] = -1;
            objects[1] = "文件夹创建成功！！！";*/
            return docmentsMap.get(docmentController.root).toArray();
        } else if (flag.indexOf("cd") != -1) {
            if (flag.length() == 4) {
                System.out.println("输入的命令为：" + flag);
                flag.substring(3);
                System.out.println("截取的字符串为：" + flag.substring(3));
                docmentController.root = "/";
                return docmentsMap.get(docmentController.root).toArray();
            }
            System.out.println("当前命令为：" + flag);
            String[] split = flag.split("/");
            int flag2 = 1;
            Object[] objects = docmentsMap.get("/").toArray();
           /* for (Object o : objects) {
                System.out.println(o);
            }*/
            for (int i = split.length; i > 0; i--) {
                if (i != 1) {
                    if (flag2 == 1) { //只执行一次 与/匹配
                        int flag3 = 0;
                        flag2--;
                        //System.out.println("当前进行比较的文件名：" + split[split.length - i + 1]);
                        for (Object ob : objects) {
                            //System.out.println(ob + "         " + split[split.length - i + 1]);
                            if (ob.toString().equals(split[split.length - i + 1].toString())) {
                                flag3++;
                            } else {
                            }
                        }
                        if (flag3 != 0) {
                            System.out.println("文件存在1");
                        } else {
                            System.out.println("文件不存在1");
                            return null;
                        }
                    }
                    if (docmentsMap.get(split[split.length - i + 1]) == null) {
                        if (i != 2) {
                            System.out.println("文件不存在2");
                            return null;
                        } else {
                        }
                    } else {
                        if (split.length - i + 2 == split.length) {
                            System.out.println("文件存在666");
                        } else {
                            int flag4 = 0;
                            int flag5 = 1;
                            Object[] objects1 = docmentsMap.get(split[split.length - i + 1]).toArray();
                            System.out.println("当前文件目录下的文件：" + objects1);
                            for (Object ob : objects1) {
                                if (ob.toString().equals(split[split.length - i + 2].toString())) {
                                    flag4++;
                                }
                            }
                            if (flag4 != 0) {
                                System.out.println("文件存在2");
                            } else {
                                System.out.println("文件不存在3");
                                return null;
                            }
                        }
                    }
                    System.out.println("目录结构：" + split[split.length - i + 1]);
                } else {
                    docmentController.root = split[split.length - i];
                    System.out.println("当前目录更新为：" + docmentController.root);
                }
            }
            if (docmentsMap.get(docmentController.root) == null) {
                return null;
            } else {
                return docmentsMap.get(docmentController.root).toArray();
            }
        } else if (flag.indexOf("rm") != -1) {
            //System.out.println("匹配的子字符位置：" + flag.indexOf("touch"));
            String substring = flag.substring(3);
            System.out.println("删除的文件夹：" + substring);
            docmentsMap.keySet().iterator();
            docmentsMap.remove(substring);
            boolean remove = docmentsMap.get(docmentController.root).remove(substring);
            System.out.println(remove);
            return docmentsMap.get(docmentController.root).toArray();
        } else if (flag.indexOf("mv") != -1) {
            //System.out.println("匹配的子字符位置：" + flag.indexOf("mv"));
            String substring = flag.substring(3);
            String[] s = substring.split(" ");
            for (String st : s) {
                System.out.println("分割的文件名：" + st);
            }
            docmentsMap.remove(substring);
            docmentsMap.get(docmentController.root).remove(s[0]);
            boolean add = docmentsMap.get(docmentController.root).add(s[1]);
            System.out.println(add);
            return docmentsMap.get(docmentController.root).toArray();
        } else if (flag.indexOf("exc2") != -1) {
           // System.out.println("匹配的子字符位置：" + flag.indexOf("exc2"));
            Pcb pcb = new Pcb();
            String format = df.format(new Date());
            System.out.println("此进程到达时间：" + format);
            pcb.setComeTime(Integer.valueOf(format));
            double d = Math.random();
            int i = (int) (d * 10);
            pcb.setPid(String.valueOf(i));
            pcb.setUid("root");
            double d2 = Math.random();
            int i2 = (int) (d2 * 10000);
            pcb.setExcTimes(i2);
            if (Pcb.pcbs > 0) {
                pcbst.add(pcb);
                Pcb.pcbs--;
                if (Pcb.exc > 0) {
                    Thread thread =new PcbtServiceImp(pcb);
                    thread.start();
                    Object[] objects = new Object[2];
                    objects[0]=pcb.toString();
                    pcbflag=pcb;
                    return objects;
                    // new PcbExcServicelmp().ffPcbExc(pcb);
                } else {
                    Thread thread = new PcbtServiceImp2(pcbflag.comeTime + pcb.excTimes - Integer.valueOf(df.format(new Date())), pcb);
                    thread.start();
                    Object[] objects = new Object[2];
                    objects[0] = pcb.toString();
                    System.out.println("2t:" + pcb.toString());
                    return objects;
                }
            }
        } else if (flag.indexOf("load1")!=-1) {
            Object[] objects1 = new Object[100];
            int page=4; //页数为4
            double d2 = Math.random();
            int i2 = (int) (d2 * 100);
            ArrayList<Object> wenjain = new ArrayList<>();
            //假设要载入的文件
            LinkedList<Object> pages = new LinkedList<>();
           //内存
            for(int flag6=(int)Math.round(Math.random()*100/1);flag6>0;flag6--){
                wenjain.add(Math.round(Math.random()*100/1));//被分割的文件页 每一页有编号
            }
            System.out.println("生成的文件为："+wenjain.toArray());
            objects1[0]="生成的文件为："+wenjain.toString();
            for(int i=wenjain.size();i>0;i--){
                if(page>0){
                    pages.add(wenjain.get(wenjain.size()-i));
                    System.out.println("加载第"+wenjain.get(wenjain.size()-i)+"页");
                    objects1[wenjain.size()-i+1]="加载第" + wenjain.get(wenjain.size() - i) + "页";
                    page--;
                    if(i==1){
                        objects1[wenjain.size()-i+1]="加载第" + wenjain.get(wenjain.size() - i) + "页"+" 文件已经全部加载内存中";
                    }
                }else{
                    System.out.println("内存已满，置换出最先进入的页面："+pages.get(0));
                    pages.remove(0);
                    System.out.println("置换成功："+wenjain.get(wenjain.size()-i));
                    pages.add(wenjain.get(wenjain.size()-i));
                    objects1[wenjain.size()-i+1]="内存已满，弹出最先进入的页面：" + wenjain.get(0) + "，置换进第"+wenjain.get(wenjain.size() - i);
                    if(i==1){
                        objects1[wenjain.size()-i+1]="内存已满，弹出最先进入的页面：" + wenjain.get(0) + "，置换进第"+wenjain.get(wenjain.size() - i) + "页"+" 文件已经全部加载内存中";
                    }
                }
            }
            System.out.println("文件已经全部加载内存中");
            //Object[] objects = new Object[2];
            //objects[0]="文件已经全部加载内存中";
            return objects1;
        }else if (flag.indexOf("load2")!=-1) {
            Object[] objects1 = new Object[100];
            int page=4; //页数为4
            double d2 = Math.random();
            int i2 = (int) (d2 * 100);
            int max;
            LinkedList<Object> pages = new LinkedList<>();
            //内存
            ArrayList<Object> wenjain = new ArrayList<>();// //假设要载入的文件
            System.out.println(Math.round(Math.random()*100/1));
            for(int flag6=(int)Math.round(Math.random()*100/1);flag6>0;flag6--){
                System.out.println(flag6);
                wenjain.add((int)Math.round(Math.random()*100/1));//被分割的文件页 被调用的次数
            }
            System.out.println("大小："+wenjain.size());
            System.out.println("生成的文件为："+wenjain.toString());
            objects1[0]="生成的文件为："+wenjain;
            for(int i=wenjain.size();i>0;i--) {
                if (page > 0) {
                    pages.add(wenjain.get(wenjain.size() - i));
                    System.out.println("加载第" + wenjain.get(wenjain.size() - i) + "页");
                    objects1[wenjain.size()-i+1]="加载第" + wenjain.get(wenjain.size() - i) + "页";
                    page--;
                    if (i==1){
                        objects1[wenjain.size()-i+1]="加载第" + wenjain.get(wenjain.size() - i) + "页"+" 文件已经全部加载内存中";
                    }
                } else {
                    max=(int)pages.get(0);
                    for (int i3=pages.size();i3>0;i3--){
                        if((int)pages.get(pages.size()-i3)>=max){
                            max=(int)pages.get(pages.size()-i3);
                            pages.set(pages.size()-i3,wenjain.get(wenjain.size() - i));
                        }
                    }
                   // pages.remove(max);
                    objects1[wenjain.size()-i+1]="内存已满，弹出不常使用的页面：" + max + "，置换进第"+wenjain.get(wenjain.size() - i);
                    pages.add(wenjain.get(wenjain.size() - i));
                    if(i==1){
                        objects1[wenjain.size()-i+1]="内存已满，弹出不常使用的页面：" + max + "，置换进第"+wenjain.get(wenjain.size() - i)+" 文件已经全部加载内存中";
                    }
                }
            }
            System.out.println("文件已经全部加载内存中");
            //Object[] objects = new Object[2];
            //objects[0]="文件已经全部加载内存中";
            return objects1;
        } else if (flag.indexOf("exc1") != -1) {
            //System.out.println("匹配的子字符位置：" + flag.indexOf("exc1"));
            Pcb pcb = new Pcb();
            String format = df.format(new Date());
            System.out.println("此进程到达时间：" + format);
            pcb.setComeTime(Integer.valueOf(format));
            double d = Math.random();
            int i = (int) (d * 10);
            pcb.setPid(String.valueOf(i));
            pcb.setUid("root");
            double d2 = Math.random();
            int i2 = (int) (d2 * 10000);
            pcb.setExcTimes(i2);
            if (Pcb.pcbs > 0) {
                pcbs.add(pcb);
                Pcb.pcbs--;
                if (Pcb.exc > 0) {
                    Thread thread =new PcbExcServicelmp(pcb);
                    thread.start();
                    Object[] objects = new Object[2];
                    objects[0]=pcb.toString();
                    pcbflag=pcb;
                    return objects;
                    // new PcbExcServicelmp().ffPcbExc(pcb);
                } else {
                    Thread thread =new PcbExcServiceImp2(pcbflag.comeTime + pcbflag.excTimes - Integer.valueOf(df.format(new Date())),Integer.valueOf(pcb.excTimes));
                    thread.start();
                    Object[] objects = new Object[2];
                    objects[0]=pcb.toString();
                    System.out.println("2:"+pcb.toString());
                    return objects;
                }
            }
        } else {
            docmentController.objects[0] = -1;
            docmentController.objects[1] = "指令错误！！！！";
            return docmentController.objects;
        }
        Object[] objects = new Object[2];
        objects[0]="系统忙碌";
        return objects;
    }
}
