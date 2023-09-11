package top.zjp.bookonline.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.zjp.bookonline.dao.UserDao;
import top.zjp.bookonline.entity.User;
import top.zjp.bookonline.util.JdbcUtil;
import top.zjp.bookonline.util.Md5Util;

/**
 * @author zjp
 * @Description: 操作数据库中user表的类
 */
public class UserDaoImpl implements UserDao {
    /**
     * 声明JDBCTemplate对象
     */
    private final JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());

    @Override
    public int insertUser(User user) {
        try {
            //1.编写sql
            String sql = "INSERT INTO t_user (account,password, nickname,,avatar) VALUES (?,?,?,?)";
            //2.调用query方法
            return template.update(sql, user.getAccount(), user.getPassword(), user.getNickname(), user.getAvatar());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public User findUser(User userDto) {
        try {
            //1.编写sql
            String sql = "SELECT * FROM t_user WHERE account = ? AND password = ?";
            //2.调用query方法,对比账号和加密后的密码
            return template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    userDto.getAccount(), Md5Util.crypt(userDto.getPassword()));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
