package web;

import com.google.gson.Gson;
import pojo.Book;
import pojo.Cart;
import pojo.CartItem;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author AoTxLand
 * @date 2020-06-16 14:55
 */
public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Book book = bookService.queryBookById(id);
        if(book != null){
            CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            if(cart == null){
                cart = new Cart();
            }
            cart.addItem(cartItem);
            System.out.println("购物车添加成功");
            req.getSession().setAttribute("cart",cart);
//            req.getSession().setAttribute("recentBook",book.getName());
            Map<String,Object> map = new HashMap<>();
            map.put("totalCount",cart.getTotalCount());
            map.put("recentBook",book.getName());
            String json = new Gson().toJson(map);
            resp.getWriter().write(json);
        }
        else {
            System.out.println("购物车添加失败");
        }
//        resp.sendRedirect(req.getHeader("Referer"));

    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.deleteItem(id);
        req.getSession().setAttribute("cart",cart);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clear();
        req.getSession().setAttribute("cart",cart);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void updateItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"),1);
        Book book = bookService.queryBookById(id);
        if(book != null){
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            if(cart == null){
                cart = new Cart();
            }
            cart.updateCount(id, count);
            System.out.println("购物车修改成功");
            req.getSession().setAttribute("cart",cart);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
