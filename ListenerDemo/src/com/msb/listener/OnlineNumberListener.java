package com.msb.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineNumberListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sssssssssssssssssssssss");
        HttpSession session = se.getSession();
        ServletContext application = session.getServletContext();
        //Object attribute = application.getAttribute("count");

        if(null == application.getAttribute("count")){
            application.setAttribute("count",1);
            System.out.println("count=111111111111111111111111");
        }else {
            int count = (int)application.getAttribute("count");
            System.out.println(count);
            application.setAttribute("count",++count);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext application = session.getServletContext();
        //Object attribute = application.getAttribute("count");

        int count = (int)application.getAttribute("count");
        application.setAttribute("count",--count);
    }
}
