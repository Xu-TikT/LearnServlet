package servletlogin;

import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tikt on 16-8-16.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收表单数据
        Users u = new Users();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        u.setUsername(username);
        u.setPassword(password);
        //判断用户名和密码是否合法
        if (u.getUsername().equals("admin") && u.getPassword().equals("admin")) {
            resp.sendRedirect(req.getContextPath() + "/login_success.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login_failure.jsp");

        }

    }
}
