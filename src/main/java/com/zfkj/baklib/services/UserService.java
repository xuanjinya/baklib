package com.zfkj.baklib.services;


import com.zfkj.baklib.entity.User;

public interface UserService {
    //通过用户名查找用户
    User queryUserByName(String username);

    //通过账号查找用户
    User queryUserByAccount(String account);

    //用户注册
    int userRegister(User user);
}
