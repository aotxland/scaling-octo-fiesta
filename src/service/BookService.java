package service;

import pojo.Book;
import pojo.Page;

import java.util.List;

/**
 * @author AoTxLand
 * @date 2020-06-13 16:55
 */
public interface BookService {
    void addBook(Book book);

    void updateBook(Book book);

    void deleteBookById(Integer id);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
