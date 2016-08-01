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
 * 利用在web.xml中对Servlet配置<loadon-startup>1</loadon-startup>,数字越小优先级越高
 * Servlet容器启动时自动加载某些Servlet
 *
 * 当Servlet文件被重新编译后也会重新装载
 */
@WebServlet(name = "ServletLifeTest2")
public class ServletLifeTest2 extends HttpServlet {

    public ServletLifeTest2(){
        System.out.println("ServletLifeTest2 的构造方法被执行");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("ServletLifeTest2 的销毁方法被执行");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("ServletLifeTest2 的初始化方法被执行");
    }
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletLifeTest2 收到doPost请求");

        doGet(request,response);//让doPost执行和doGet相同的操作
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletLifeTest2 收到doGet请求");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>我是ServletLifeTest2 的Get方法</h1>");
    }
}
