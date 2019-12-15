package ncu.edu.cn.mall.stuff.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffMapper {
    @Insert("insert into stuff values(#{id},#{name},#{price},#{description},#{image},#{shopid})")
    int updatestuff(@Param("id") String id,@Param("name") String name,@Param("price") String price,
                    @Param("description") String description,@Param("shopid") String shopid);

}
