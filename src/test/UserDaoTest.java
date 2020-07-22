package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.User;

import static org.junit.Assert.*;

/**
 * @author AoTxLand
 * @date 2020-06-12 10:54
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        System.out.println(userDao.queryUserByUsername("admin"));
    }

    @Test
    public void saveUser() {
        userDao.saveUser(new User(null,"lili","lili2","lili@qq.com"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userDao.queryUserByUsernameAndPassword("admin","admin1"));
    }
}