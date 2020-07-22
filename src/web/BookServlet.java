package web;

import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author AoTxLand
 * @date 2020-06-13 17:03
 */
public class BookServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        pageNo++;
        resp.sendRedirect(req.getContextPath() + "/admin/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        if(id != 0){
            book.setId(id);
            bookService.updateBook(book);
        }
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        resp.sendRedirect(req.getContextPath() + "/admin/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/admin/book_edit.jsp").forward(req,resp);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        bookService.deleteBookById(id);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        resp.sendRedirect(req.getContextPath() + "/admin/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/admin/book_manager.jsp").forward(req,resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("admin/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/admin/book_manager.jsp").forward(req,resp);
    }
}
