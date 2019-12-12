package ncu.edu.cn.mall.user.service;

import ncu.edu.cn.mall.user.bean.UserInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> getAllUser();
    String getPasswordByID(String id);
    String login(String id, String password);
    String register(String id,String password,String birthday,String nickname,String name,String address,
                    String telephone);
}
