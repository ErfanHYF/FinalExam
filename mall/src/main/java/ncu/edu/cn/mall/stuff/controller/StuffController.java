package ncu.edu.cn.mall.stuff.controller;

import ncu.edu.cn.mall.stuff.bean.StuffInfo;
import ncu.edu.cn.mall.stuff.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class StuffController {
    @Autowired
    StuffService stuffService;
    StuffInfo stuffInfo = new StuffInfo();

    @RequestMapping(value = "/uploadStuffInfoPage",method = {RequestMethod.POST, RequestMethod.GET})
    public String uploadStuff(HttpServletRequest request, HttpSession session){
        String id = UUID.randomUUID().toString().trim().replaceAll("-", "");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String shopid = request.getParameter("shopid");
        int result = stuffService.update(id,name,price,description,shopid);
        session.setAttribute("result",result+" row affected");
        if(result == 1){
            System.out.println("success");
            return "/login/stufftest";
        }else{
            System.out.println("error");
            return "redirect:/";
        }
    }
}
