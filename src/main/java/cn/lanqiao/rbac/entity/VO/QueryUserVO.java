package cn.lanqiao.rbac.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryUserVO extends PageVO{
    private String userId;
    private String userName;
    private String password;
}
