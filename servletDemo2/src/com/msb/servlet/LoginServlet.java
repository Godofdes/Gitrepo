package com.msb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");

        String message = null;

        if(username.equals("msb")&&pwd.equals("123456")){
            message="Log in successfully!";
        }
        else{
            message = "Fail to log in.";
        }
        resp.getWriter().write(message);
    }
}
