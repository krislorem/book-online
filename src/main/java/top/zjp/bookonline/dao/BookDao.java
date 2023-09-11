package top.zjp.bookonline.dao;


import top.zjp.bookonline.entity.Book;

import java.util.List;

/**
 * @author zjp
 * @Date 2023/9/10
 * @Description UserDao
 */
public interface BookDao {
    /**
     * 查询所有图书
     *
     * @return List<Book>
     */
    List<Book> selectAll();

    /**
     * 根据id查询图书
     *
     * @param id id
     * @return Book
     */
    Book getBookById(int id);
}
