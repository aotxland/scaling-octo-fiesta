package filter;

import pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author AoTxLand
 * @date 2020-06-18 17:50
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        User user = (User) req.getSession().getAttribute("user");
        if (user == null){
            req.getRequestDispatcher("/user/login.jsp").forward(request,response);
        } else if (user.getUsername().equals("admin")){
            chain.doFilter(request,response);
        } else {
            req.getRequestDispatcher("/user/login.jsp").forward(request,response);

        }
    }

    @Override
    public void destroy() {

    }
}
