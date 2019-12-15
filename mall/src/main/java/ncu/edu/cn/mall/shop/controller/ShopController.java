package ncu.edu.cn.mall.shop.controller;


import ncu.edu.cn.mall.shop.bean.ShopInfo;
import ncu.edu.cn.mall.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class ShopController {
    @Autowired
    ShopService shopService;
    ShopInfo shopInfo = new ShopInfo();

    @RequestMapping(value = "/shopregister.html", method = {RequestMethod.POST, RequestMethod.GET})
    public String registerShop() {
        return "/login/shopregister";
    }

    @RequestMapping(value = "/shopregisterPage", method = {RequestMethod.POST, RequestMethod.GET})
    public String registerShop(HttpServletRequest request, HttpSession session){
        String shopid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        String shopname = request.getParameter("shopname");
        String managername = request.getParameter("managername");
        String identify = request.getParameter("identify");
        String category = request.getParameter("category");
        String id = request.getParameter("id");
        int result = shopService.register(shopid,shopname,managername,category,identify,id);
        session.setAttribute("result",result+" row affected");
        if(result == 1){
            System.out.println("success");
            return "/login/shoptest";
        }else{
            System.out.println("error");
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/index2", method = {RequestMethod.POST, RequestMethod.GET})
    public String registershopindex() {
        return "/login/shoptest";

    }
}
