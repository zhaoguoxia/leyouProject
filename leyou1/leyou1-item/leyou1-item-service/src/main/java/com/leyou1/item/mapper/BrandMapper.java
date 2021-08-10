package com.leyou1.item.mapper;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BrandMapper extends Mapper<Brand> {
    /**
     * 新增商品分类和品牌中间表数据
     * @param cid 商品分类id
     * @param bid 品牌id
     * @return
     */
    @Insert("INSERT INTO tb_category_brand(category_id,brand_id) VALUES (#{cid},#{bid})")
    int insertBrandAndCategory(@Param("cid") Long cid, @Param("bid") Long bid);
    @Update("update tb_category_brand set category_id=#{cid} where brand_id=#{bid}")
    int updateBrandAndCategory(@Param("cid") Long cid, @Param("bid") Long bid);
    @Delete("delete from tb_category_brand where brand_id=#{id}")
    int deleteBrandAndCategory( @Param("id") Long id);
    //根据分类查询品牌
    @Select("SELECT b.* from tb_brand b INNER JOIN tb_category_brand cb on b.id=cb.brand_id where cb.category_id=#{cid}")
    List<Brand> selectBrandByCid(Long cid);
}
