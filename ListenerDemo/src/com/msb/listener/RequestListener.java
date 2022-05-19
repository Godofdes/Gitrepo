package com.msb.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebListener
public class RequestListener implements ServletRequestListener {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //获得请求发出的IP
        //获得请求的URL
        //获得请求产生的时间
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        String remoteHost = request.getRemoteHost();
        String requestURL = request.getRequestURI().toString();
        String requestDate = simpleDateFormat.format(new Date());

        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("g:/msb.txt"),true));
            pw.println(remoteHost+" "+requestURL+" "+requestDate);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
