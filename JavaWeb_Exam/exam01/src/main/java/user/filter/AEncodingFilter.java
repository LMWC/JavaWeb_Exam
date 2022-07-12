package user.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AEncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //处理post请求乱码：
        String method = request.getMethod();
        if("POST".equalsIgnoreCase(method)){
            request.setCharacterEncoding("UTF-8");
        }

        //处理响应中文乱码问题：
        response.setContentType("text/html;charset=utf-8");

        //放行：
        chain.doFilter(request, response);


    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {
    }

}
