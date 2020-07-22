package dao;

import pojo.Book;

import java.util.List;

/**
 * @author AoTxLand
 * @date 2020-06-13 16:09
 */
public interface BookDao {
    /**
     *
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     *
     * @param id
     * @return
     */
    int deleteBookById(Integer id);

    /**
     *
     * @param book
     * @return
     */
    int updateBook(Book book);

    /**
     *
     * @param id
     * @return
     */
    Book queryBookById(Integer id);

    /**
     *
     * @return
     */
    List<Book> queryBooks();

    /**
     *
     * @param begin
     * @param pageSize
     * @return
     */
    List<Book> queryForItems(Integer begin,Integer pageSize);

    /**
     *
     * @return
     */
    Integer queryForPageTotalCount();

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForItemsByPrice(int i, int pageSize, int min, int max);
}
