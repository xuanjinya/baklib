package com.zfkj.baklib.dao;

import com.zfkj.baklib.entity.User;

public interface UserDao {
    //根据account查询用户
    User selectUserByAccount(String account);

    //添加一个用户数据
    int insertUser(User user);
}
