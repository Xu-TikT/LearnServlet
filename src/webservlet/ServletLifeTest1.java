package webservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tikt on 16-7-26.
 * 学习Servlet的生命周期
 */
@WebServlet(name = "ServletLifeTest1")
public class ServletLifeTest1 extends HttpServlet {


    public ServletLifeTest1(){
        System.out.println("ServletLifeTest1 的构造方法被执行");
    }
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("ServletLifeTest1 的销毁方法被执行");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("ServletLifeTest1 的初始化方法被执行");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletLifeTest1 收到doPost请求");

        doGet(request,response);//让doPost执行和doGet相同的操作


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletLifeTest1 收到doGet请求");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>ServletLifeTest1 的Get方法</h1>");



    }
}
