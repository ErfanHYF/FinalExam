package ncu.edu.cn.mall.stuff.service.impl;


import ncu.edu.cn.mall.stuff.mapper.StuffMapper;
import ncu.edu.cn.mall.stuff.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuffServiceImpl implements StuffService {
    @Autowired
    public StuffMapper stuffMapper;

    @Override
    public int update(String id, String name, String price, String description, String shopid) {
        return stuffMapper.updatestuff(id,name,price,description,shopid);
    }
}
