package com.zfkj.baklib.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zfkj.baklib.entity.User;
import com.zfkj.baklib.services.UserService;
import com.zfkj.baklib.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //注册，新增用户
    @RequestMapping("/register")
    public Result register(String account, String password, String username) {
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password) || StringUtils.isBlank(username)) {
            //3个参数中存在空值
            return new Result("4001", "请填写完整注册信息，再注册！", null);
        }
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setUsername(username);
        int i = userService.userRegister(user);
        if (i == 1) {
            return new Result("200", "注册成功，请登录！", null);
        } else if (i == 0) {
            return new Result("4002", "注册失败，账号已存在！", null);
        }
        return new Result("4003", "注册失败，未知错误！", null);
    }

    //登录
    @RequestMapping("/login")
    public Result login(String account, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(account, password);
        try {
            subject.login(usernamePasswordToken);
            Session session = subject.getSession();
            session.setAttribute("loginUser", account);
            return new Result("200", "登录成功", null);
        } catch (UnknownAccountException e) {
            return new Result("4004", "用户不存在", null);
        } catch (IncorrectCredentialsException e) {
            return new Result("4005", "登录密码错误", null);
        }
    }
}
