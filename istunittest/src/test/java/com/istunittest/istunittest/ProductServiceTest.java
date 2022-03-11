package com.istunittest.istunittest;

import com.istunittest.istunittest.entity.Product;
import com.istunittest.istunittest.entity.ProductRequest;
import com.istunittest.istunittest.entity.ProductResponse;
import com.istunittest.istunittest.repository.ProductRespository;
import com.istunittest.istunittest.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProductService.class)
@Slf4j
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRespository productRespository;


    private final Product productDummy = Product.builder()
            .name("name")
            .description("description")
            .price("price")
            .build();

    @Test
    public void getAllProductSuccess() {
        ProductRequest productRequest = ProductRequest.builder().build();

        when(productRespository.findAll())
                .thenReturn(List.of(productDummy));
        var response = productService.getProduct(productRequest);
        assertNotNull(response);
    }

    @Test
    public void addProduct_success() {
        var request = new ProductRequest();
        when(productRespository.save(any(Product.class))).thenReturn(Product.builder().build());

        var response = productService.saveProduct(request);
        Assert.assertNotNull(response);
    }
}
