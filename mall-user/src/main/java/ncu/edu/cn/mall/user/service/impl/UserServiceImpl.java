package ncu.edu.cn.mall.user.service.impl;

import ncu.edu.cn.mall.user.bean.UserInfo;
import ncu.edu.cn.mall.user.mapper.UserMapper;
import ncu.edu.cn.mall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public List<UserInfo> getAllUser() {

        List<UserInfo> userInfoList = userMapper.selectAllUser();
        return userInfoList;
    }

    @Override
    public String getPasswordByID(String id) {
        String pwd = userMapper.selectPasswordByID(id);
        return pwd;
    }

    @Override
    public String login(String id, String password) {
        return userMapper.login(id,password);
    }

    @Override
    public int register(String id, String password, String birthday, String nickname, String name, String address, String telephone) {
        return userMapper.register(id,password,birthday,nickname,name,address,telephone);
    }
}
