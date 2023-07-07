package com.hlw.goods_service;

import com.hlw.goods_service.domain.Products;
import org.springframework.stereotype.Service;
import product.ProductResponse;

@Service
public class ProductServiceRestImpl {
    private ProductsDAO productsDAO; // 数据库访问对象

    public ProductServiceRestImpl(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    public ProductResponse getProductById(Long id) {
        // 从数据库获取产品数据
        Products product = productsDAO.getProductById(id);

        // 将数据库查询结果转换为 ProductResponse 对象
        ProductResponse response = ProductResponse.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setNum(product.getNum())
                .setStyle(product.getStyle())
                .setProvider(product.getProvider())
                .build();


        return response;
    }


    public ProductResponse getProductByName(String name) {
        // 从数据库获取产品数据
        Products product = productsDAO.getProductByName(name);

        // 将数据库查询结果转换为 ProductResponse 对象
        ProductResponse response = ProductResponse.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setNum(product.getNum())
                .setStyle(product.getStyle())
                .setProvider(product.getProvider())
                .build();


        return response;
    }

    public ProductResponse addProduct(Long id) {
        // 从数据库获取产品数据
        Products product = productsDAO.addProductNum(id);

        // 将数据库查询结果转换为 ProductResponse 对象
        ProductResponse response = ProductResponse.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setNum(product.getNum())
                .setStyle(product.getStyle())
                .setProvider(product.getProvider())
                .build();


        return response;
    }

    public ProductResponse reduceProduct(Long id) {
        // 从数据库获取产品数据
        Products product = productsDAO.reduceProduct(id);

        // 将数据库查询结果转换为 ProductResponse 对象
        ProductResponse response = ProductResponse.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setNum(product.getNum())
                .setStyle(product.getStyle())
                .setProvider(product.getProvider())
                .build();


        return response;
    }
}