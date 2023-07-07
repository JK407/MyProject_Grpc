package com.hlw.goods_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hlw.goods_service.domain.Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import product.ProductResponse;


/**
* @author 谷梁蔚竹
* @description 针对表【products】的数据库操作Mapper
* @createDate 2023-06-14 08:53:40
* @Entity generator.domain.Products
*/
@Mapper
public interface ProductsMapper extends BaseMapper<Products> {
    Products getProductById(@Param("id") long id);

    Products getProductByName(@Param("name") String name);

    void addProductNum(@Param("id") long id);


    void reduceProductNum(@Param("id") long id);

}
