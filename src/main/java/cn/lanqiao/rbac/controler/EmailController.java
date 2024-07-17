package cn.lanqiao.rbac.controler;

import cn.lanqiao.rbac.email.EmailSender;
import cn.lanqiao.rbac.email.EmailSenderUtil;
import cn.lanqiao.rbac.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.lanqiao.rbac.util.Result.success;


@RestController
@RequestMapping("/email")
public class EmailController {


    @Autowired
    private EmailSender emailSender;
    @Autowired
    EmailSenderUtil emailSenderUtil;

    @RequestMapping("/send")
    public Result testTextMail() {
        emailSender.sendMessage("643359474@qq.com", "原神启动");
        return success();
    }

    @RequestMapping("/send2")
    public Result send2(){
        emailSenderUtil.sendEmail("643359474@qq.com");
        return success();
    }
}
