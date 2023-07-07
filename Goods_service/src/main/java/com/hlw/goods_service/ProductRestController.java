package com.hlw.goods_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import product.ProductResponse;

@RestController
@RequestMapping("/productsRest")
public class ProductRestController {

    @Autowired
    ProductServiceRestImpl productServiceRest;

    @Autowired
    public ProductRestController(ProductServiceRestImpl productServiceRest) {
        this.productServiceRest = productServiceRest;
    }

    @GetMapping("/{id}")
    public ModelAndView getSearchById(@PathVariable("id") long id) {
        ProductResponse products = productServiceRest.getProductById(id);


        System.out.println("Product ID: " + products.getId());
        System.out.println("Product Name: " + products.getName());
        System.out.println("Product Num: " + products.getNum());
        System.out.println("Product Style: " + products.getStyle());
        System.out.println("Product Provider: " + products.getProvider());


        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", products);

        return modelAndView;
    }




    @GetMapping
    public ModelAndView getProductByName(@RequestParam("name") String name) {
        ProductResponse products = productServiceRest.getProductByName(name);

        System.out.println("Product ID: " + products.getId());
        System.out.println("Product Name: " + products.getName());
        System.out.println("Product Num: " + products.getNum());
        System.out.println("Product Style: " + products.getStyle());
        System.out.println("Product Provider: " + products.getProvider());

        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", products);

        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public ModelAndView addProduct(@PathVariable("id") long id) {
        ProductResponse products = productServiceRest.addProduct(id);

        System.out.println("Product ID: " + products.getId());
        System.out.println("Product Name: " + products.getName());
        System.out.println("Product Num: " + products.getNum());
        System.out.println("Product Style: " + products.getStyle());
        System.out.println("Product Provider: " + products.getProvider());

        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", products);

        return modelAndView;
    }

    @GetMapping("/reduce/{id}")
    public ModelAndView reduceProduct(@PathVariable("id") long id) {
        ProductResponse products = productServiceRest.reduceProduct(id);

        System.out.println("Product ID: " + products.getId());
        System.out.println("Product Name: " + products.getName());
        System.out.println("Product Num: " + products.getNum());
        System.out.println("Product Style: " + products.getStyle());
        System.out.println("Product Provider: " + products.getProvider());

        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", products);

        return modelAndView;
    }

}
