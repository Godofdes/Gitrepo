<%--
  Created by IntelliJ IDEA.
  User: txy
  Date: 2022/5/13
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title%sSourceCode%lt</title>
    <script>
      var xhr ;
      function checkUname(){
        // 获取输入框中的内容
        var unameDOM=document.getElementById("unameI");
        var unameText =unameDOM.value;
        var unameInfoDom =document.getElementById("unameInfo");
        if(null == unameText || unameText == ''){
          unameInfoDom.innerText="用户名不能为空";
          return;
        }
        unameInfoDom.innerText="";
        // 发送异步请求
        // 获取一个 XMLHttpRequest对象 ,对象可以帮助我们发送异步请求
        xhr =new XMLHttpRequest();
        // 使用xhr对象设置打开链接,设置请求方式和参数xhr.open("请求方式","请求的URL",是否使用异步方式);
        xhr.open("GET","unameCheckServlet.do?uname="+unameText,true);
        // 设置回调函数
        xhr.onreadystatechange=showReturnInfo;
        // 正式发送请求
        xhr.send(null);
      }
      function showReturnInfo(){
        if(xhr.readyState==4 && xhr.status==200){
          var returnInfo =xhr.responseText;
          var unameInfoDom =document.getElementById("unameInfo");
          unameInfoDom.innerText=returnInfo;
        }
      }
    </script>
    </head>
<body>
<form action="myServlet1.do" >
  用户名:<input id="unameI" type="text" name="uname" onblur="checkUname()"><span id="unameInfo" style="color: red"></span><br/>
  密码:<input type="password" name="pwd"><br/>
  <input type="submit">
</form>
</body>
</html>