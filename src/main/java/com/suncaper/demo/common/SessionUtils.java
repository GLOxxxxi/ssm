package com.suncaper.demo.common;

import com.suncaper.demo.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    private static final String LOGINUSER="loginUser";
    /*保存当前登录用户 */
    public static void saveCurUser(User curUser){
        getSession().setAttribute(LOGINUSER,curUser);
    }
    /*获取当前session ---获取一个request*/
    public  static HttpSession getSession(){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request =attr.getRequest();
        return  request.getSession();
    }
    /*获取当前用户*/
    public static User getCurUser(){
        return (User)(getSession().getAttribute(LOGINUSER));
    }
    /*
    移除session
     */
    public  static void clearCurUser(){
        //getSession().invalidate();//删除session
        getSession().removeAttribute(LOGINUSER);
    }
}
