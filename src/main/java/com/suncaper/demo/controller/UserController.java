package com.suncaper.demo.controller;

import com.suncaper.demo.common.Constant;
import com.suncaper.demo.common.SecurityUtils;
import com.suncaper.demo.common.SessionUtils;
import com.suncaper.demo.entity.Knrd;
import com.suncaper.demo.entity.Student;
import com.suncaper.demo.entity.User;
import com.suncaper.demo.service.KnrdService;
import com.suncaper.demo.service.StudentService;
import com.suncaper.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private KnrdService knrdService;
    /**
     * 用户登录
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("login")
    public String login(User user, Model model){
       User loginUser=userService.login(user);
//        User curUser = SecurityUtils.getCurUser();//获取当前用户信息
        if(loginUser!=null){
            SessionUtils.saveCurUser(loginUser);
            model.addAttribute("msg","用户不存在");
            return "main";
        }

        Student student = studentService.selectByUser(user);
        if(student!=null){
            //用户存在库中
            Knrd knrd = knrdService.selectByUsert(user);
            if(knrd != null){
                //判断用户的困难等级是否符合批次的困难等级（三级审核）
                boolean flag = userService.conformKnrd(knrd);
                if(!flag){
                    model.addAttribute("msg","该用户不符合困难认定级别");
                    return "login";
                }
                User u = new User();
                u.setSn(knrd.getStudentId());
                u.setName(knrd.getName());
                u.setRoleId(Constant.ROLE_ID_SUTDENT);
                userService.insert(u);
                SessionUtils.saveCurUser(u);
                return "main";
            }
        }

        return "login";
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping("quit")
    public String quit(){
        SessionUtils.clearCurUser();
        return "login";
    }
    @RequestMapping("main")
    public String main() {
            return "main";
    }

}
