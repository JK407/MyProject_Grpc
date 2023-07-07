package com.hlw.goods_service;

import com.hlw.goods_service.domain.Products;
import com.hlw.goods_service.mapper.ProductsMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
// 创建数据库访问对象
public class ProductsDAO {

    @Autowired
    private ProductsMapper productsMapper; // MyBatis 数据访问对象

    public ProductsDAO(ProductsMapper productsMapper) {
        this.productsMapper = productsMapper;
    }

    public Products getProductById(Long id) {
        return productsMapper.getProductById(id);
    }

    public Products getProductByName(String name) {
        return productsMapper.getProductByName(name);
    }


    public Products addProductNum(Long id) {
        productsMapper.addProductNum(id);
        return productsMapper.getProductById(id);
    }

    public Products reduceProduct(Long id) {
        productsMapper.reduceProductNum(id);
        return productsMapper.getProductById(id);
    }
}