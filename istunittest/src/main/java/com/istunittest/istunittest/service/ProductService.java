package com.istunittest.istunittest.service;

import com.istunittest.istunittest.entity.Product;
import com.istunittest.istunittest.entity.ProductRequest;
import com.istunittest.istunittest.entity.ProductResponse;
import com.istunittest.istunittest.repository.ProductRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
@Slf4j
public class ProductService {
    @Autowired
     private ProductRespository productRespository;

    public List<Product> getProduct(ProductRequest productRequest) {
        log.info("Start Check Product Request");
        ProductRequest productRequest1 = ProductRequest.builder().build();
        if(productRequest1.getName() != null){
                       log.info(productRequest1.getName());

        }

        List<Product> productResponse1=  productRespository.findAll();
        return productResponse1;


    }

    public ProductResponse saveProduct(ProductRequest productRequest) {
        log.info("Start Check Product Request");
      Product product =Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

       productRespository.save(product);

        ProductResponse productResponses= ProductResponse.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .build();

        return productResponses;


    }



}
