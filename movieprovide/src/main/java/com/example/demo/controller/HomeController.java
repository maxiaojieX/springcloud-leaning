package com.example.demo.controller;

import com.example.demo.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xiaojie.Ma on 2018/2/12.
 */
@RestController
@RefreshScope
public class HomeController {

    @Autowired
    private DemoDao demoDao;

    @GetMapping("/test/{id:\\d+}")
    @ResponseBody
    public String test(@PathVariable Integer id,HttpServletRequest request) {
        request.getSession();
//        System.out.println(session.getClass().toString());
        return "get带参"+id;
    }

    @PostMapping("/post")
    @ResponseBody
    public String testPost(String abc) {
        return "POST TEST>>"+abc;
    }

    @GetMapping("/delete")
    @ResponseBody
    public String destroy(HttpServletRequest request) {
        HttpSession session = request.getSession();

        session.invalidate();

        return "Session 销毁";
    }
}
