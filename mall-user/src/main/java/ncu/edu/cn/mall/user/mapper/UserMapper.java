package ncu.edu.cn.mall.user.mapper;

import ncu.edu.cn.mall.user.bean.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<UserInfo> selectAllUser();
    String selectPasswordByID(String id);
    @Select("select id from userinfo where id=#{id} and password=#{password}")
    public String login(@Param("id") String id, @Param("password") String password);
    @Insert("insert into userinfo values(#{id},#{password},0,#{birthday},#{nickname},#{name},#{addrress},#{telephone})")
    public String register(@Param("id") String id,@Param("password") String password,@Param("birthday") String birthday,
                           @Param("nickname") String nickname,@Param("name") String name,@Param("address") String address,
                           @Param("telephone") String telephone);

}
