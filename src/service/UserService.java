package service;

import pojo.User;

/**
 * @author AoTxLand
 * @date 2020-06-12 11:03
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    void registerUser(User user);

    /**
     * 用户登录
     * @param user
     * @return 登录失败返回null
     */
    User login(User user);

    /**
     * 找回密码
     * @param name
     * @param email
     * @return 如果正确则返回用户
     */
    User findPassword(String name,String email);

    /**
     * 判断用户名是否存在
     * @param name
     * @return 存在返回true
     */
    boolean existUsername(String name);
}
