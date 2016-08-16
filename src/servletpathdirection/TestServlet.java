package servletpathdirection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tikt on 16-8-16.
 */
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求重定向方式跳转到test.jsp，当前路径是LearnServlet/servletpathdirection/,而test.jsp在根目录下
        //resp.sendRedirect("test.jsp");  所以这样写会404
        /*
        使用req.getContextPath()获取获取上下文对象，但是这里不行，可能是因为没有配置根目录，现在的根目录是localhose:8080,
        resp.sendRedirect(req.getContextPath()+"/test.jsp");
        所以使用/来指定根目录:
        resp.sendRedirect("/test.jsp");
         */
        //在Run/Debug configuration中选择项目运行配置中的Deployment,在右边的Applicaiton context中填写自定义的根目录地址,解决了上述问题
//        resp.sendRedirect(req.getContextPath() + "/test.jsp");
        //使用服务器内部跳转
//        req.getRequestDispatcher("test.jsp").forward(req, resp);  这样写仍然是跳转到当前目录下的test.jsp
        //这里的/表示项目的根目录
//        req.getRequestDispatcher("/test.jsp").forward(req, resp);
        //这里的..表示回到上一层,然后再寻找test.jsp
        req.getRequestDispatcher("../test.jsp").forward(req, resp);
    }
}
