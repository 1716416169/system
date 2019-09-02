package com.system.system.controller;

import com.system.system.entiy.Docment;
import com.system.system.entiy.Pcb;
import com.system.system.service.imp.apiServiceImp;
import jdk.internal.org.objectweb.asm.tree.LdcInsnNode;
import org.springframework.web.bind.annotation.*;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/docment")
public class docmentController {
    public static ArrayList<Object> docments = new ArrayList<>();
    public static HashMap<String, LinkedList<Object>> docmentsMap = new HashMap<>();
    public static Object[] objects = new Object[2];
    public static String root = "/"; //当前目录

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/creat")
    public String creatDocment(String flag) {
        return null;
    }

    @GetMapping("/nowroot")
    public String nowRoot() {
        return root;
    }

    @PostMapping("/api")
    public Object api(String flag) {
        apiServiceImp apiServiceImp = new apiServiceImp();
        Object objects = apiServiceImp.apiService(flag);
        return objects;
}
}
