package com.zmq.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

//定义监听类 extends SessionListenerAdapter
public class MySessionListener extends SessionListenerAdapter {
    //当有session创建时触发
    @Override
    public void onStart(Session session) {
        System.out.println("session 创建");
    }

    //当有session停止时触发
    @Override
    public void onStop(Session session) {
        System.out.println("session 停止");
    }

    //当有session过期时触发
    //但不会主动触发,需要再次访问的时候,既要使用session时才会发现session过期,并触发。
    @Override
    public void onExpiration(Session session) {
        System.out.println("session 过期");
    }
}
