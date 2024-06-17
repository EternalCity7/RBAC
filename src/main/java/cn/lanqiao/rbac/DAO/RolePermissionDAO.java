package cn.lanqiao.rbac.DAO;

import cn.lanqiao.rbac.entity.RolePermission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RolePermissionDAO {
    @Insert("insert into role_permission values (#{id},#{roleId},#{permissionId})")
    void insert(RolePermission rolePermission);

    @Delete("delete from role_permission where role_id=#{roleId} and permission_id=#{permissionId}")
    void delete(RolePermission rolePermission);

    @Delete("delete from role_permission where role_id=#{roleId}")
    void deleteByRole(int roleId);

    @Delete("delete from role_permission where permission_id=#{permissionId}")
    void deleteByPermission(int permissionId);

    @Select("select permission_id from role_permission where role_id=#{roleId}")
    List<String> selectByRole(int roleId);

    @Select("select role_id from role_permission where permission_id=#{permissionId}")
    List<String> selectByPermission(int permissionId);

    @Select("select * from role_permission")
    List<RolePermission> selectAll();

    @Update("update role_permission set role_id= #{roleId} and permission_id= #{permissionId} where id=#{id}")
    void update(RolePermission rolePermission);
}