package cn.lanqiao.rbac.DAO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PermissionDaoTest {
    @Autowired
    PermissionDAO permissionDAO;
    @Test
    public void select(){
        System.out.println(permissionDAO.selectById(1));
    }
}
