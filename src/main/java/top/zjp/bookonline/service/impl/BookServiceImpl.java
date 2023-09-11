package top.zjp.bookonline.service.impl;

import top.zjp.bookonline.dao.BookDao;
import top.zjp.bookonline.dao.impl.BookDaoImpl;
import top.zjp.bookonline.entity.Book;
import top.zjp.bookonline.service.BookService;

import java.util.List;

/**
 * 图书业务逻辑类
 *
 * @author zjp
 */
public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> getBooks() {
        return bookDao.selectAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }
}
