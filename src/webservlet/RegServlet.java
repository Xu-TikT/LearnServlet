package webservlet;

import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tikt on 16-8-16.
 * 用户注册
 */
public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");//避免中文乱码


        /**
         * 接收表单数据
         */
        Users users = new Users();
        String username;
        String password;
        String email;
        String gender;//性别
        Date birthday;
        String[] favorites;//爱好
        String introduce;//自我介绍
        String isAccept;//是否接收协议
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            username = req.getParameter("username");
            password = req.getParameter("mypassword");
            email = req.getParameter("email");
            gender = req.getParameter("gender");
            introduce = req.getParameter("introduce");
            if (null==req.getParameterValues("flag")) {
                isAccept = "false";
            } else {

                isAccept = req.getParameter("flag");
            }
            birthday = sdf.parse(req.getParameter("birthday"));
            //用来获取多个复选按钮的值
            favorites = req.getParameterValues("favorite");

            users.setUsername(username);
            users.setPassword(password);
            users.setEmail(email);
            users.setGender(gender);
            users.setFavorites(favorites);
            users.setIntroduce(introduce);
            users.setBirthday(birthday);

            users.setFlag(isAccept.equals("true") ? true : false);

            //把注册成功的用户对象保存到session中
            req.getSession().setAttribute("regUser", users);
            //使用内部的服务进行页面跳转
            req.getRequestDispatcher("../userinfo.jsp").forward(req, resp);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
