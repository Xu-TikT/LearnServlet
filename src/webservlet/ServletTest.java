package webservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by TikT on 2016/7/18.
 */
@WebServlet(name = "ServletTest")
public class ServletTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletTest收到doPost请求");
        //向网页发送
        response.setContentType("text/html;charset=utf-8");//使其输出支持html标签
        PrintWriter out = response.getWriter();
        out.print("<strong>Hello I am CartServlet Post</strong>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletTest收到doGet请求");
        System.out.println("ServletTest收到doGet请求传来的参数"+request.getParameter("par"));

        //向网页发送
//        response.setContentType("text/html;charset=utf-8");//使其输出支持html标签,必须在PrintWriter对象创建之前
        response.setContentType("charset=utf-8");//使其输出支持html标签,必须在PrintWriter对象创建之前
        PrintWriter out = response.getWriter();
//        out.print("<strong>Hello I am CartServlet Get</strong>");
        out.print("{\"response\":\"I get your request\"}");
    }
}
