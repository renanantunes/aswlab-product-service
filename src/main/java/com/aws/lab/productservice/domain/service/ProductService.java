package com.aws.lab.productservice.domain.service;

import com.aws.lab.productservice.repository.ProductRepository;
import com.aws.lab.productservice.domain.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository repository;

    public void createProduct(Product product){
        repository.save(product);
    }

    public List<Product> list(){
        return repository.findAll();
    }

    public Optional<Product> getById(Long id){
        return repository.findById(id);
    }

}
