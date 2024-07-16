package cn.lanqiao.rbac.service.impl;

import cn.lanqiao.rbac.dao.UserDao;
import cn.lanqiao.rbac.entity.User;
import cn.lanqiao.rbac.entity.VO.QueryUserVO;
import cn.lanqiao.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDAO;
    public void insert(User user){
        userDAO.insert(user);
    };


    public void delete(String userId){
        userDAO.delete(userId);
    };

    public List<User> query(QueryUserVO queryUserVO){
        return userDAO.query(queryUserVO);
    };

    public void update(User user){
        userDAO.update(user);
    };

    public String login(User user){
        return userDAO.login(user);
    }
}
