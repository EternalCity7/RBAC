package cn.lanqiao.rbac.controler;


import cn.lanqiao.rbac.email.EmailSenderUtil;
import cn.lanqiao.rbac.entity.User;
import cn.lanqiao.rbac.entity.VO.QueryUserVO;
import cn.lanqiao.rbac.service.UserService;
import cn.lanqiao.rbac.util.DESUtils;
import cn.lanqiao.rbac.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static cn.lanqiao.rbac.util.Result.fail;
import static cn.lanqiao.rbac.util.Result.success;

@Log4j2
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    EmailSenderUtil emailSenderUtil;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/insert")
    public Result insert(@RequestBody User user) {
        userService.insert(user);
        return success();
    }

    ;

    @RequestMapping("/delete/{userId}")
    public Result delete(@PathVariable String userId) {
        userService.delete(userId);
        return success();
    }

    ;

    @PostMapping("/query")
    public Result query(@RequestBody QueryUserVO queryUserVO) {
        PageHelper.startPage(queryUserVO.pageNum, queryUserVO.pageSize);
        List<User> query = userService.query(queryUserVO);
        PageInfo<User> pageInfo = new PageInfo<>(query);
        return success(pageInfo);
    }

    ;

    @RequestMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return success();
    }

    ;

    @RequestMapping("/login")
    public Result login(@RequestBody User user) {
        String id = userService.login(user);
        if (id != null) {
            return success(id);
        } else {
            return fail(601, "登录失败");
        }
    }

    @Transactional
    @RequestMapping("/register")
    public Result register(@RequestBody User user) {
        if (userService.query(new QueryUserVO() {{
            setUserId(user.getUserId());
            setEmail(user.getEmail());
        }}).isEmpty()) {
            user.setCreatTime(new Date());
            userService.insert(user);
            rabbitTemplate.convertAndSend("directQueue", user.getEmail()+"-"+user.getCreatTime());
            return success();
        } else {
            return fail(602, "已注册过，请登录");
        }
    }

    @Transactional
    @RequestMapping("/activation/{encryptMailDate}")
    public Result activation(@PathVariable String encryptMailDate) {
        String decryptMailDate = DESUtils.decrypt(encryptMailDate);
        String eMail = decryptMailDate.split("-", 2)[0];
        String date = decryptMailDate.split("-", 2)[1];
        if (date.equals(userService.query(new QueryUserVO(){{
            setEmail(eMail);
        }}).get(0).getCreatTime().toString())) {//逆天级语法大师
            User user = new User();
            user.setUserId(userService.query(new QueryUserVO() {{
                setEmail(eMail);
            }}).get(0).getUserId());//顶级语法大师
            user.setActive(true);
            userService.update(user);
            return success("激活TMD成功！！！");
        } else {
            return fail(603, "无法激活");
        }
    }
}
