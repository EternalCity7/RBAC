package cn.lanqiao.rbac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private Integer permissionId;
    private String permissionName;
    private String permissionUrl;
    private String permissionType;
}
