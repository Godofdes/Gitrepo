package com.msb.Servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.msb.DAO.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

@WebServlet("/jsonservlettest.do")
public class JsonServletTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        Student stu1=new Student("小黑","男",10,new Date());
        Student stu2=new Student("小白","男",10,new Date());
        Student stu3=new Student("小黄","男",10,new Date());
        Student stu4=new Student("小花","男",10,new Date());
        ArrayList<Student> list =new ArrayList<>();
        Collections.addAll(list,stu1,stu2,stu3,stu4);
        GsonBuilder gb =new GsonBuilder();
        gb.setDateFormat("yyyy-MM-dd");
        Gson gson = gb.create();
        String json = gson.toJson(list);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(json);


    }
}
