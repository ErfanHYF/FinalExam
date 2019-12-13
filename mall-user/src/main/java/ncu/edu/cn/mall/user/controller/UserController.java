package ncu.edu.cn.mall.user.controller;

import ncu.edu.cn.mall.user.bean.UserInfo;
import ncu.edu.cn.mall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    UserInfo userInfo = new UserInfo();

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UserInfo> getAllUser(){

        List<UserInfo> userInfo = userService.getAllUser();

        return userInfo;
    }

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String login() {
        return "/login/login";
    }

    @RequestMapping(value = "/register.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String register() {
        return "/login/register";
    }

    @RequestMapping(value = "/loginPage", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(HttpServletRequest request, HttpSession session) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        System.out.println("你输入的用户名为：" + id);
        System.out.println("你输入的密码为：" + password);
        String name = userService.login(id, password);
        session.setAttribute("name", name);
        if (name == null) {
            System.out.println("error");
            return "redirect:/";
        } else {
            System.out.println("success");
            return "/login/test";
        }
    }

    @RequestMapping(value = "/registerPage", method = {RequestMethod.POST, RequestMethod.GET})
    public String register(HttpServletRequest request, HttpSession session){
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String nickname = request.getParameter("nickname");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        int result = userService.register(id,password,birthday,nickname,name,address,telephone);
        session.setAttribute("result",result+" row affected");
        if(result == 1){
            System.out.println("success");
            return "/login/rtest";
        }else{
            System.out.println("error");
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/index", method = {RequestMethod.POST, RequestMethod.GET})
    public String loginindex() {
        return "/login/test";

    }
    @RequestMapping(value = "/index1", method = {RequestMethod.POST, RequestMethod.GET})
    public String registerindex() {
        return "/login/rtest";

    }
}
