package test;

import org.junit.Test;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import static org.junit.Assert.*;

/**
 * @author AoTxLand
 * @date 2020-06-12 11:19
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"lilili","lililili","lili@163.com"));
    }

    @Test
    public void login() {
    }

    @Test
    public void findPassword() {
    }

    @Test
    public void existUsername() {
        System.out.println(userService.existUsername("lilili2"));
    }
}