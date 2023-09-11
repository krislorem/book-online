package top.zjp.bookonline.controller;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import top.zjp.bookonline.entity.User;
import top.zjp.bookonline.service.UserService;
import top.zjp.bookonline.service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 拦截/login请求,获得表单传递的参数,进行登录功能验证
 *
 * @author zjp
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取得表单参数
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        //调用登录功能
        User user = userService.signIn(account, password);
        if (user != null) {
            //登录成功,将用户对象记入session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            //重定向到/index,进入IndexServlet
            resp.sendRedirect("/index");
        } else {
            //登录失败,设置好响应对象字符集和相应类型
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            //获得response对象的字符输出集
            PrintWriter out = resp.getWriter();
            //输出js脚本,弹出登陆失败的信息
            out.print("<script>alert('账号或密码错误');location.href='/';</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
