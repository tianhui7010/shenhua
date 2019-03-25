package com.nb.wukong.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * shiro Controller
 */
@Controller
public class ShiroController {

    @GetMapping({"/","index"})
    public String index(){
        return"index";
    }

    @GetMapping("403")
    public String unauthorizedRole(){
        return "403";
    }

    @GetMapping("delete")
    //@RequiresPermissions("delete")
    @RequiresRoles("admin")
    public String delete(){
        return "delete";
    }

    /**
     * @RequiresPermissions()相当于SecurityUtils.getSubject().isPermitted（）
     * 调用doGetAuthorizationInfo（）方法
     */
    @GetMapping("select")
    @RequiresPermissions("select")
    public String select(){
        return "select";
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        System.out.println("执行登陆");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        //根据异常判断错误类型
        if (exception != null) {
            System.out.println("exception is : "+exception);
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "密码不正确";
            } else {
                msg = "else >> "+exception;
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "login";
    }

    @GetMapping("logout")
    public String logout(){
        return "login";
    }
}
