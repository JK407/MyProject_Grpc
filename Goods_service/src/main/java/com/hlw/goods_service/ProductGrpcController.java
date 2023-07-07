package com.hlw.goods_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.servlet.ModelAndView;
import product.ProductResponse;

@RestController
@RequestMapping("/productsGrpc")
public class ProductGrpcController {
    @Autowired
    private final ProductGrpcClient productGrpcClient;



    @Autowired
    public ProductGrpcController(ProductGrpcClient productGrpcClient) {
        this.productGrpcClient = productGrpcClient;
    }


    @GetMapping("/{id}")
    public ModelAndView getProductById(@PathVariable("id") long id) {
        ProductResponse products = productGrpcClient.getProductById(id);

        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", products);

        return modelAndView;
    }

    @GetMapping
    public ModelAndView getProductByName(@RequestParam("name") String name) {
        ProductResponse products = productGrpcClient.getProductByName(name);

        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", products);

        return modelAndView;
    }


    @GetMapping("/add/{id}")
    public ModelAndView addProduct(@PathVariable("id") long id) {
        productGrpcClient.addProductById(id);
        ProductResponse products = productGrpcClient.getProductById(id);
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", products);

        return modelAndView;
    }

    @GetMapping("/reduce/{id}")
    public ModelAndView reduceProduct(@PathVariable("id") long id) {
        productGrpcClient.reduceProductById(id);
        ProductResponse products = productGrpcClient.getProductById(id);
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", products);

        return modelAndView;
    }



}
