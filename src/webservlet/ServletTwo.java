package webservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by TikT on 2016/7/20.
 */
@WebServlet(name = "ServletTwo")
public class ServletTwo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletTwo收到doPost请求");
        //向网页发送
        response.setContentType("text/html;charset=utf-8");//使其输出支持html标签
        PrintWriter out = response.getWriter();
        out.print("<strong>Hello I am Servlet Post</strong>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("ServletTwo收到doGet请求传来的参数"+request.getParameter("par"));
        System.out.println("ServletTwo收到doGet请求传来的参数"+request.getParameterMap());
        response.setContentType("charset=utf-8");//使其输出支持html标签,必须在PrintWriter对象创建之前
        PrintWriter out = response.getWriter();
        out.print("{\"response\":\"I get your request\"}");

    }
}
