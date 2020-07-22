package test;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.Test;
import pojo.Book;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author AoTxLand
 * @date 2020-06-13 16:35
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new pojo.Book(null,"今天要下雨吗","Fang",new BigDecimal(132),13212,21,null));
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new pojo.Book(3,"今天要sunny了吗","Fang",new BigDecimal(132),212,21,null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for(Book book : bookDao.queryBooks()){
            System.out.println(book);
        }
    }
    @Test
    public void queryForItems() {
        List<Book> books = bookDao.queryForItems(1, 4);
        for(Book book : books){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        Integer count = bookDao.queryForPageTotalCount();
        System.out.println(count);
    }
}