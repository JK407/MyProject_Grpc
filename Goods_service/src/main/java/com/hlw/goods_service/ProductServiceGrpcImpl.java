package com.hlw.goods_service;

import com.hlw.goods_service.domain.Products;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import product.*;

@GrpcService
public class ProductServiceGrpcImpl extends ProductServiceGrpc.ProductServiceImplBase {
    private ProductsDAO productsDAO; // 数据库访问对象

    public ProductServiceGrpcImpl(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    @Override
    public void getProductById(GetProductByIdRequest request, StreamObserver<ProductResponse> responseObserver) {
        // 从数据库获取产品数据
        Products product = productsDAO.getProductById(request.getId());

        // 将数据库查询结果转换为 ProductResponse 对象
        ProductResponse response = ProductResponse.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setNum(product.getNum())
                .setStyle(product.getStyle())
                .setProvider(product.getProvider())
                .build();

        // 返回 gRPC 响应
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getProductByName(GetProductByNameRequest request, StreamObserver<ProductResponse> responseObserver) {
        // 从数据库获取产品数据
        Products product = productsDAO.getProductByName(request.getName());
        System.out.println(product);
        // 将数据库查询结果转换为 ProductResponse 对象
        ProductResponse response = ProductResponse.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setNum(product.getNum())
                .setStyle(product.getStyle())
                .setProvider(product.getProvider())
                .build();

        // 返回 gRPC 响应
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateProductQuantity(UpdateProductQuantityRequest request, StreamObserver<ProductResponse> responseObserver) {
        // 从数据库获取产品数据
        Products product = productsDAO.getProductById(request.getId());

        // 根据操作类型进行不同的操作
        if (request.getOperation() == QuantityOperation.INCREASE) {
            // 增加数量
            productsDAO.addProductNum(product.getId());
        } else if (request.getOperation() == QuantityOperation.DECREASE) {
            // 减少数量
            productsDAO.reduceProduct(product.getId());
        } else {
            // 未知的操作类型
            throw new IllegalArgumentException("未知的操作类型");
        }

        // 将数据库更新结果转换为 ProductResponse 对象
        ProductResponse response = ProductResponse.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setNum(product.getNum())
                .setStyle(product.getStyle())
                .setProvider(product.getProvider())
                .build();

        // 返回 gRPC 响应
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


}