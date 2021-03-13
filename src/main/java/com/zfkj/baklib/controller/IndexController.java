package com.zfkj.baklib.controller;

import com.zfkj.baklib.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/shouquan")
    public Result shouquan() {
        return new Result("202", "授权访问成功！");
    }

    @RequestMapping("/test")
    public Result test() {
        return new Result("202", "访问成功");
    }

    @RequestMapping("/toLogin")
    public Result toLogin() {
        return new Result("202", "请先登录");
    }

    @RequestMapping("/toRegister")
    public Result toRegister() {
        return new Result("202", "请先注册");
    }

    //未经授权的请求
    @RequestMapping("/notAuth")
    @ResponseBody
    public Result unauthorized() {
        return new Result("4040", "无权限访问！");
    }
}
