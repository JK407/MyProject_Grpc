package com.hlw.goods_service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import product.*;

import javax.annotation.PostConstruct;

@Service
public class ProductGrpcClient {
    private  ManagedChannel channel;
    private  ProductServiceGrpc.ProductServiceBlockingStub blockingStub;


    @Value("${grpc.server.port}")
    private int serverPort;

    @PostConstruct
    private void initializeGrpcClient() {
        channel = ManagedChannelBuilder.forAddress("localhost", serverPort)
                .usePlaintext()
                .build();

        blockingStub = ProductServiceGrpc.newBlockingStub(channel);
    }

    public ProductResponse getProductById(long id) {
        // 构建请求对象
        GetProductByIdRequest request = GetProductByIdRequest.newBuilder()
                .setId(id)
                .build();

        try {
            // 调用 gRPC 方法
            ProductResponse response = blockingStub.getProductById(request);

            // 处理响应
            System.out.println("Product ID: " + response.getId());
            System.out.println("Product Name: " + response.getName());
            System.out.println("Product Num: " + response.getNum());
            System.out.println("Product Style: " + response.getStyle());
            System.out.println("Product Provider: " + response.getProvider());

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ProductResponse getProductByName(String name) {
        // 构建请求对象
        GetProductByNameRequest request = GetProductByNameRequest.newBuilder()
                .setName(name)
                .build();

        try {
            // 调用 gRPC 方法
            ProductResponse response = blockingStub.getProductByName(request);

            // 处理响应
            System.out.println("Product ID: " + response.getId());
            System.out.println("Product Name: " + response.getName());
            System.out.println("Product Num: " + response.getNum());
            System.out.println("Product Style: " + response.getStyle());
            System.out.println("Product Provider: " + response.getProvider());

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ProductResponse addProductById(long id) {
        // 构建请求对象
        UpdateProductQuantityRequest request = UpdateProductQuantityRequest.newBuilder()
                .setId(id)
                .setOperation(QuantityOperation.INCREASE)
                .build();

        try {
            // 调用 gRPC 方法
            ProductResponse response = blockingStub.updateProductQuantity(request);

            // 处理响应
            System.out.println("Product ID: " + response.getId());
            System.out.println("Product Name: " + response.getName());
            System.out.println("Product Num: " + response.getNum());
            System.out.println("Product Style: " + response.getStyle());
            System.out.println("Product Provider: " + response.getProvider());

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ProductResponse reduceProductById(long id) {
        // 构建请求对象
        UpdateProductQuantityRequest request = UpdateProductQuantityRequest.newBuilder()
                .setId(id)
                .setOperation(QuantityOperation.DECREASE)
                .build();

        try {
            // 调用 gRPC 方法
            ProductResponse response = blockingStub.updateProductQuantity(request);

            // 处理响应
            System.out.println("Product ID: " + response.getId());
            System.out.println("Product Name: " + response.getName());
            System.out.println("Product Num: " + response.getNum());
            System.out.println("Product Style: " + response.getStyle());
            System.out.println("Product Provider: " + response.getProvider());

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}