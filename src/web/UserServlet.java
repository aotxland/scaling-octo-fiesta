package web;

import com.google.gson.Gson;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author AoTxLand
 * @date 2020-06-13 11:35
 */
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    /**
     * 登录模块程序
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
        User loginUser = userService.login(new User(null,user.getUsername(),user.getPassword(),null));
        if (loginUser == null){
            req.setAttribute("errMsg","用户名或密码错误");
            req.setAttribute("username",user.getUsername());
            System.out.println(user.getUsername() + "登录失败");
            req.getRequestDispatcher("/user/login.jsp").forward(req,resp);
        }
        else{
            System.out.println(user.getUsername() + "登录成功");

            req.getSession().setAttribute("user",loginUser);
//            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
            String loc = req.getParameter("loc");
            if(loc == null){
                resp.sendRedirect(req.getHeader("Referer"));
            }
            else {
                resp.sendRedirect(req.getContextPath());
            }

        }
    }

    /**
     * 登出模块程序
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());

    }
    /**
     * 注册模块程序
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
        String code = req.getParameter("code");
        //参数回显
        req.setAttribute("username", user.getUsername());
        req.setAttribute("email", user.getEmail());
        //校验验证码
        String correctCode = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
        correctCode = "abcde";
        if (code.equalsIgnoreCase(correctCode)) {
            if (userService.existUsername(user.getUsername())) {
                req.setAttribute("errMsg", "用户已存在");
                System.out.println("用户已存在");
                req.getRequestDispatcher("user/register.jsp").forward(req, resp);
            } else {
                userService.registerUser(new User(null, user.getUsername(), user.getPassword(), user.getEmail()));
                System.out.println("用户注册成功");
//                req.getRequestDispatcher("pages/user/register_success.jsp").forward(req, resp);
                resp.sendRedirect(req.getContextPath() + "/user/register_success.jsp");
            }
        } else {
            req.setAttribute("errMsg", "验证码错误");
            System.out.println("验证码错误");
            req.getRequestDispatcher("user/register.jsp").forward(req, resp);
        }
    }

    protected void existUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existUsername = userService.existUsername(username);
        Map<String,Object> map = new HashMap<>();
        map.put("existUsername",existUsername);
        String json = new Gson().toJson(map);
        resp.getWriter().write(json);

    }
}
