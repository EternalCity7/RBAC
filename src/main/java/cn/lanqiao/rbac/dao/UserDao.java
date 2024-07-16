package cn.lanqiao.rbac.dao;

import cn.lanqiao.rbac.entity.User;
import cn.lanqiao.rbac.entity.VO.QueryUserVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserDao {
    @Insert("insert into user values (#{userId},#{userName},#{password})")
    void insert(User user);

    @Delete("delete from user where user_id=#{userId}")
    void delete(String userId);

    List<User> query(QueryUserVO queryUserVO);

    void update(User user);

    @Select("select user_id from user where user_name=#{userName} and password=#{password}")
    String login(User user);
}
