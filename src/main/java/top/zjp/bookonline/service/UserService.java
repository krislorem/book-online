package top.zjp.bookonline.service;

import top.zjp.bookonline.entity.User;

/**
 * 用户业务逻辑类
 *
 * @author zjp
 */
public interface UserService {
    /**
     * 用户登录功能
     *
     * @param account  账号
     * @param password 密码
     * @return user
     */
    User signIn(String account, String password);
}
