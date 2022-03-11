package com.istunittest.istunittest.controller;

import com.istunittest.istunittest.entity.Product;
import com.istunittest.istunittest.entity.ProductRequest;
import com.istunittest.istunittest.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("api/belajar")
public class ProductAPI {
    @Autowired
    private ProductService productService;

    @GetMapping("/getProduct")
    public void getProductController(@RequestBody ProductRequest productRequest) {
        productService.getProduct(productRequest);
    }

    @PostMapping("/postProduct")
    public void postProductController(@RequestBody ProductRequest productRequest) {
        productService.saveProduct(productRequest);
    }


}
