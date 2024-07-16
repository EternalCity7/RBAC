package cn.lanqiao.rbac.controler;


import cn.lanqiao.rbac.entity.User;
import cn.lanqiao.rbac.entity.VO.QueryUserVO;
import cn.lanqiao.rbac.service.UserService;
import cn.lanqiao.rbac.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.lanqiao.rbac.util.Result.success;

@Log4j2
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/insert")
    Result insert(@RequestBody User user){
        userService.insert(user);
        return success();
    };

    @RequestMapping("/delete/{userId}")
    Result delete(@PathVariable String userId){
        userService.delete(userId);
        return success();
    };

    @PostMapping("/query")
    public Result query(@RequestBody QueryUserVO queryUserVO){
        PageHelper.startPage(queryUserVO.pageNum,queryUserVO.pageSize);
        List<User> query = userService.query(queryUserVO);
        PageInfo<User> pageInfo=new PageInfo<>(query);
        return success(pageInfo);
    };

    @RequestMapping("/update")
    Result update(@RequestBody User user){
        userService.update(user);
        return success();
    };
    @RequestMapping("/login")
    Result login(User user){
        String id=userService.login(user);
        if (id!=null){
            return success(id);
        }else {
            return success("登录失败");
        }
    }
}
