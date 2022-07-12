package user.filter;



import user.bean.Manager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/index.jsp")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //判断是否登录：
        Manager manager = (Manager) request.getSession().getAttribute("loginUser");
        if (manager == null) {
            //未登录：跳转到login.jsp页面，给出提示信息 请先登录
            request.setAttribute("errorMsg","请求登录！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else{
            //放行：
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {
    }

}
