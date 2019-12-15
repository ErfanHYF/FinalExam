package ncu.edu.cn.mall.shop.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopMapper {
    @Insert("insert into shop values(#{shopid},0,#{shopname},#{managername},#{category},#{identify},#{{id}})")
    int register(@Param("shopid") String shopid,@Param("shopname") String shopname,@Param("managername") String managername,
                 @Param("category") String category,@Param("identify") String identify,@Param("id") String id);
}
