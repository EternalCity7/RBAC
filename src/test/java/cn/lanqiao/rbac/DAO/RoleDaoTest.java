package cn.lanqiao.rbac.DAO;

import cn.lanqiao.rbac.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleDaoTest {
    @Autowired
    RoleDAO roleDAO;

    @Test
    void select() {
        System.out.println(roleDAO.selectById(1));
    }

    @Test
    void insert() {
        roleDAO.insert(new Role(null,"原神玩家","椅子能坐"));
    }

    @Test
    void selectAll() {
        System.out.println(roleDAO.selectAll());

    }

    @Test
    void update() {
       roleDAO.update(new Role(3,null,"你说的对，但是原神是一款"));
        System.out.println(roleDAO.selectById(3));
    }
}
