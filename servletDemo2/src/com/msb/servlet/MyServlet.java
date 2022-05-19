package com.msb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/MyServlet.do")
public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        boolean flag = false;

        if(null!=cookies){
            for(Cookie cookie : cookies){
                String cookiename = cookie.getName();
                if(cookiename.equals("MyServlet")){
                    Integer value = Integer.parseInt(cookie.getValue())+1;
                    Cookie c = new Cookie(cookiename, String.valueOf(value));
                    resp.addCookie(c);
                    System.out.println("welcome for your visit in the "+value+" times");
                    flag=true;
                }
            }
        }
        if(!flag){
            System.out.println("Welcome for your first visit");
            Cookie c = new Cookie("MyServlet","1");
            resp.addCookie(c);
        }
    }
}
