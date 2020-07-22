package dao;

import pojo.User;

/**
 * @author AoTxLand
 * @date 2020-06-12 10:41
 */
public interface UserDao {
    /**
     * 使用用户名查询用户
     * @param name
     * @return 如果不存在则返回null
     */
    User queryUserByUsername(String name);

    /**
     * 保存用户
     * @param user
     * @return 如果用户存在返回null
     */
    int saveUser(User user);
    /**
     * 使用用户名查询用户
     * @param name
     * @param password
     * @return 如果不存在或不匹配则返回null
     */
    User queryUserByUsernameAndPassword(String name,String password);

}
