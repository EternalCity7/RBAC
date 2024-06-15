package cn.lanqiao.rbac.DAO;

import cn.lanqiao.rbac.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface RoleDAO {


        //插入对象
        @Insert("insert into role values (#{roleId},#{roleName},#{remark})")
        void insert(Role role);

        //按id删除
        @Delete("delete from role where role_id=#{roldId}")
        void delete(int roleId);

        //按id查找
        @Select("select * from role where role_id=#{roleId}")
        Role selectById(int roleId);

        //查找所有
        @Select("select * from role")
        List<Role> selectAll();

        //按id修改
        void update(Role role);

}
