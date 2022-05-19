package com.msb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class MyServlet extends HttpServlet {
    /*
    * 接收请求，做出响应
    * service Servlet服务方法
    *
    */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = new Random().nextInt();
        String message = num%2==0?"oushu":"jishu";

        PrintWriter writer = resp.getWriter();
        writer.write(message);
    }
}
