package dao.impl;

import dao.UserDao;
import pojo.User;

/**
 * @author AoTxLand
 * @date 2020-06-12 10:45
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String name) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where `username` = ?";
        return queryForOne(User.class, sql, name);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values (?, ?, ?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUsernameAndPassword(String name, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where `username` = ? and `password` = ?";
        return queryForOne(User.class, sql, name, password);
    }
}
