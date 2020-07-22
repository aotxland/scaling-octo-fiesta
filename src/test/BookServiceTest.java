package test;

import org.junit.Test;
import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author AoTxLand
 * @date 2020-06-13 18:01
 */
public class BookServiceTest {
    BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
    }

    @Test
    public void updateBook() {
        Book book = new Book();
        bookService.updateBook(book);
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void queryBookById() {
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for(Book book : books){
            System.out.println(book);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, 4));

    }
}