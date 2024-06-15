package cn.lanqiao.rbac.DAO;

import cn.lanqiao.rbac.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDAO userDAO;

    @Test
    void select() {
        System.out.println(userDAO.selectById(1));
    }

    @Test
    void insert() {
        userDAO.insert(new User(null,"可莉","KeLi","1@qq.com",Timestamp.valueOf("2020-09-08 00:00:00")));
    }

    @Test
    void selectAll() {
        System.out.println(userDAO.selectAll());

    }

    @Test
    void update() {
       userDAO.update(new User(null,"可莉","KeLi","1@qq.com",Timestamp.valueOf("2020-09-08 00:00:00")));
        System.out.println(userDAO.selectById(4));
    }
}
