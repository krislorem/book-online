package top.zjp.bookonline.service.impl;

import top.zjp.bookonline.dao.UserDao;
import top.zjp.bookonline.dao.impl.UserDaoImpl;
import top.zjp.bookonline.entity.User;
import top.zjp.bookonline.service.UserService;

/**
 * 用户业务逻辑类
 *
 * @author zjp
 */
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    /**
     * 用户登录功能
     *
     * @param account  账号
     * @param password 密码
     * @return user
     */
    @Override
    public User signIn(String account, String password) {
        User user = User.builder().account(account).password(password).build();
        return userDao.findUser(user);
    }
}
