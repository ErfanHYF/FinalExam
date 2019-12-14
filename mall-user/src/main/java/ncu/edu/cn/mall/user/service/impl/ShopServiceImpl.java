package ncu.edu.cn.mall.user.service.impl;

import ncu.edu.cn.mall.user.mapper.ShopMapper;
import ncu.edu.cn.mall.user.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    public ShopMapper shopMapper;

    @Override
    public int register(String shopid,String shopname, String managername, String category,String identify) {
        return shopMapper.register(shopid,shopname,managername,category,identify);
    }
}
