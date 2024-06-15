package cn.lanqiao.rbac.DAO;

import cn.lanqiao.rbac.entity.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PermissionDAO {
    //插入Permission对象
    @Insert("insert into permission values (#{permissionId},#{permissionName},#{permissionUrl},#{permissionType})")
    void insert(Permission permission);

    //按id删除
    @Delete("delete from permission where permission_id=#{permissionId}")
    void delete(int permissionId);

    //按id查找
    @Select("select * from permission where permission_id=#{permissionId}")
    Permission selectById(int permissionId);

    //查找所有permission
    @Select("select * from permission")
    List<Permission> selectAll();

    //按id修改
    void update(Permission permission);
}
