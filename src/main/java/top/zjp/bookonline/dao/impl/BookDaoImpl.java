package top.zjp.bookonline.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.zjp.bookonline.dao.BookDao;
import top.zjp.bookonline.entity.Book;
import top.zjp.bookonline.util.JdbcUtil;

import java.util.List;

/**
 * @Description: 操作数据库中book表的类
 * @author: zjp
 */
public class BookDaoImpl implements BookDao {
    /**
     * 声明JDBCTemplate对象
     */
    private final JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());

    /**
     * 获取所有图书
     *
     * @return List<Book>
     */
    @Override
    public List<Book> selectAll() {
        try {
            String sql = "SELECT * FROM t_book ORDER BY id DESC";
            return  template.query(sql,new BeanPropertyRowMapper<>(Book.class));
        }catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Book getBookById(int id) {
        try {
            String sql = "SELECT * FROM t_book WHERE id = ?";
            return template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(Book.class),id);
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
