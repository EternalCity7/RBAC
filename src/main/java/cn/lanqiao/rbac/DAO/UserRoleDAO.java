package cn.lanqiao.rbac.DAO;

import cn.lanqiao.rbac.entity.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserRoleDAO {
    @Insert("insert into user_role values (#{id},#{userId},#{roleId})")
    void insert(UserRole userRole);

    @Delete("delete from user_role where user_id=#{userId} and role_id=#{roleId}")
    void delete(UserRole userRole);

    @Delete("delete from user_role where user_id=#{userId}")
    void deleteByUser(int userId);

    @Delete("delete from user_role where role_id=#{roleId}")
    void deleteByRole(int roleId);

    @Select("select role_id from user_role where user_id=#{userId}")
    List<String> selectByUser(int userId);

    @Select("select user_id from user_role where role_id=#{roleId}")
    List<String> selectByRole(int roleId);

    @Select("select * from user_role")
    List<UserRole> selectAll();

    @Update("update user_role set user_id= #{userId} and role_id= #{roleId} where id=#{id}")
    void update(UserRole userRole);
}
