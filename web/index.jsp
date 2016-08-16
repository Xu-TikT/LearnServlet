<%--
  Created by IntelliJ IDEA.
  User: TikT
  Date: 2016/7/12
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
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

<h1>Servlet路径跳转</h1>
<hr>
<%--使用相对路径访问HelloServlet--%>
<%--/servletpathdirection/HelloServlet 第一个/表示服务器的根目录,但是idea本身设置了根目录就是项目路径，所以不会出现404,但eclipse上会报404，
也许项目正式发布也会有这个问题--%>
<a href="servletpathdirection/HelloServlet">相对路径访问HelloServlet!</a><br>
<%--使用绝对路径访问HelloServlet，可以使用path变量:path表示项目的根目录--%>
<a href="<%=path%>/servletpathdirection/HelloServlet">绝对路径访问HelloServlet!</a><br>
<%--表单中action的Url地址写法与超链接方式完全相同--%>
<a href="servletpathdirection/TestServlet">访问TestServlet,跳转到test.jsp</a>

<h1>登陆Demo</h1>
<hr>
<a href="login.jsp">跳转到登陆界面</a>
</body>
</html>
