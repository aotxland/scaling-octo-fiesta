package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

/**
 * @author AoTxLand
 * @date 2020-06-12 11:07
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();


    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public User findPassword(String name,String email) {
        return null;
    }

    @Override
    public boolean existUsername(String name) {
        return userDao.queryUserByUsername(name) != null;
    }
}
