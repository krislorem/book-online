package top.zjp.bookonline.service;


import top.zjp.bookonline.entity.Book;

import java.util.List;

/**
 * @author zjp
 * @Date 2023/9/10
 * @Description TODO
 */
public interface BookService {
    /**
     * 查询所有图书
     *
     * @return List<Book>
     */
    List<Book> getBooks();

    /**
     * 根据id查询图书
     *
     * @param id id
     * @return 图书信息
     */
    Book getBookById(int id);
}
