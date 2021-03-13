package com.zfkj.baklib.services;

import com.zfkj.baklib.dao.UserDao;
import com.zfkj.baklib.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    Logger logger = LoggerFactory.getLogger(getClass());

    //注册用户
    @Override
    public int userRegister(User user) {
        User result = userDao.selectUserByAccount(user.getAccount());
        boolean empty = ObjectUtils.isEmpty(result);//判断对象是否为空
        if (empty) { //如果为空
            user.setRoles("user");//设置权限
            user.setAvailable("0"); //设置注册是为禁用用户
            int i = userDao.insertUser(user);//添加用户
            if (i > 0) { //添加成功
                logger.info("用户[{}]注册成功", user.getUsername());
                return 1;//注册成功
            }
        } else {
            return 0;//用户存在
        }
        return 2;//未知错误
    }

    @Override
    public User queryUserByAccount(String account) {
        User result = userDao.selectUserByAccount(account);
        boolean empty = ObjectUtils.isEmpty(result);
        if (!empty) {
            return result;
        }
        return null;
    }

    //通过用户名查询用户
    @Override
    public User queryUserByName(String username) {
        return null;
    }
}
