package servletGetInitParameter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tikt on 16-8-16.
 * 获取初始化参数案例
 */
@WebServlet(name = "GetInitParameterServlet")
public class GetInitParameterServlet extends HttpServlet {

    String username;
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("用户名" + this.getUsername());
        out.println("密码" + this.getPassword());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    public void init() throws ServletException {
        this.setUsername(this.getInitParameter("username"));
        this.setPassword(this.getInitParameter("password"));
    }
}
