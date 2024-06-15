package cn.lanqiao.rbac.DAO;

import cn.lanqiao.rbac.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserDAO {


    //插入对象
    @Insert("insert into user values (#{userId},#{userName},#{password},#{email},#{createTime})")
    void insert(User user);

    //按id删除
    @Delete("delete from user where user_id=#{userId}")
    void delete(int userId);

    //按id查找
    @Select("select * from user where user_id=#{userId}")
    User selectById(int userId);

    //查找所有
    @Select("select * from user")
    List<User> selectAll();

    //按id修改
    void update(User user);

}
