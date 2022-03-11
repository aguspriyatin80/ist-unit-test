package com.istunittest.istunittest.repository;

import com.istunittest.istunittest.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRespository  extends JpaRepository<Product, Long> {

}
