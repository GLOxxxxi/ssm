package com.suncaper.demo.common;

import com.suncaper.demo.entity.User;

public class SecurityUtils {
    /*
    获取当前用户登录信息
     */
    public static User getCurUser(){

        User user = SessionUtils.getCurUser();//user可能为null
        /*模拟登录*/
        if(user == null){
            User curUser=new User();
            curUser.setRoleId(2L);
        }
        return user;
    }
}
