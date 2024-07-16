package cn.lanqiao.rbac.service;

import cn.lanqiao.rbac.entity.User;
import cn.lanqiao.rbac.entity.VO.QueryUserVO;

import java.util.List;

public interface UserService {
    void insert(User user);

    void delete(String userId);

    List<User> query(QueryUserVO queryUserVO);

    void update(User user);

    String login(User user);
}
