package user.web;


import user.bean.Manager;
import user.service.ManagerService;
import user.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version V1.0
 * @author: buguniao
 * @date: 2019/6/2 22:06
 * @description:
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、接收请求数据
        String name = request.getParameter("name");
        String password = request.getParameter("password");


        //2、处理数据：调用service处理登录业务
        ManagerService managerService = new ManagerServiceImpl();
        Manager manager = new Manager();
        manager.setUsername(name);
        manager.setPassword(password);
        Manager loginUser =  managerService.login(manager);

        //3、响应数据
        if (null != loginUser) {
            //登录成功：1、把用户信息存储在session中；2、重定向到首页；
            request.getSession().setAttribute("loginUser", loginUser);
            response.sendRedirect("/index.jsp");
        }else {
            //登录失败：跳转到登录页面 回显错误信息
            System.out.println("------------");
            request.setAttribute("errorMsg", "用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }
}
