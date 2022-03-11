package com.istunittest.istunittest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.istunittest.istunittest.controller.ProductAPI;
import com.istunittest.istunittest.entity.ProductRequest;
import com.istunittest.istunittest.entity.ProductResponse;
import com.istunittest.istunittest.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = ProductAPI.class)
@ContextConfiguration(classes = ProductAPI.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getProduct_success() throws Exception{
        mockMvc.perform(
                post("/getProduct")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ProductRequest.builder()
                                .name("product Satu")
                                .description("ini product satu")
                                .price("Sepuluh ribu")
                                .build()))
        ).andExpect(status().isOk());
    }

    @Test
    public void posProduct_success() throws Exception{
        mockMvc.perform(
                post("/postProduct")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ProductRequest.builder()
                                .name("product Satu")
                                .description("ini product satu")
                                .price("Sepuluh ribu")
                                .build()))
        ).andExpect(status().isOk());
    }

}
