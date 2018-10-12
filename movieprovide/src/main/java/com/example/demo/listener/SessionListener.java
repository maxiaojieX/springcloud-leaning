package com.example.demo.listener;

import org.apache.catalina.SessionEvent;

/**
 * Created by xiaojie.Ma on 2018/5/10.
 */
public class SessionListener implements org.apache.catalina.SessionListener {
    @Override
    public void sessionEvent(SessionEvent sessionEvent) {
        System.out.println("SESSION!!!!!!!");
    }
}
