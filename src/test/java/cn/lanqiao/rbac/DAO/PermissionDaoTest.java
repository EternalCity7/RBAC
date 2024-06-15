package cn.lanqiao.rbac.DAO;

import cn.lanqiao.rbac.entity.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PermissionDaoTest {
    @Autowired
    PermissionDAO permissionDAO;

    @Test
    void select() {
        System.out.println(permissionDAO.selectById(1));
    }

    @Test
    void insert() {
        permissionDAO.insert(new Permission(null, "原神玩家", null, "玩原神玩的"));
    }

    @Test
    void selectAll() {
        System.out.println(permissionDAO.selectAll());

    }

    @Test
    void update() {
        permissionDAO.update(new Permission(6, "玩原神的权利", null, "不玩原神导致的"));
        System.out.println(permissionDAO.selectById(6));
    }
}
