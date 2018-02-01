package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.heitian.ssm.model.DBUser;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        return "showUser";
    }

    @RequestMapping("/getUserByPhoneOrEmeil")
    public String showUserByPhone(HttpServletRequest request, Model model){
        log.info(request.getParameter("phone"));
        Short s = 0;
        User user = userService.getUserByPhoneOrEmail(request.getParameter("phone"),s);
        model.addAttribute("user",user);
        return "showUser";
    }

    @ResponseBody
    @RequestMapping(value="/addUser",method= RequestMethod.POST)
    public void addUser(@RequestBody DBUser dbUser, HttpServletResponse response)throws IOException {
        log.info("sdwsadasdwdasddasd" + dbUser.toString());
        try {
            userService.createUser(dbUser);
            response.getWriter().print("true");
        } catch (Exception e) {
            log.error("系统异常",e);
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/getUserById")
    public String showUserById(HttpServletRequest request, Model model){
        log.info("request id " + request.getParameter("id"));
        DBUser user = userService.getAllDBUser(Long.valueOf(request.getParameter("id")));
        log.info("user info " + user.toString());
        model.addAttribute("user",user);
        return "showUser";
    }
}
