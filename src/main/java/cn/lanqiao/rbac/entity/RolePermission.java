package cn.lanqiao.rbac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermission {
    Integer id;
    Integer roleId;
    Integer permissionId;
}
