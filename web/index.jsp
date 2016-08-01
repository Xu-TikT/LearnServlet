<%--
  Created by IntelliJ IDEA.
  User: TikT
  Date: 2016/7/12
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First Servlet</title>
</head>
<body>
<h1>Hello Servlet</h1>
<hr>
<a href="webservlet/ServletTest">doGet方式</a>
<br>
<a href="webservlet/ServletTwo">doGet方式2</a>

<form action="webservlet/ServletTest" method="post">
    <input type="submit" value="doPost方式"/>
</form>
<h1>Servlet的生命周期</h1>
<hr>
<a href="webservlet/ServletLifeTest1">doGet方式测试ServletLifeTest1的生命周期</a>
</body>
</html>
