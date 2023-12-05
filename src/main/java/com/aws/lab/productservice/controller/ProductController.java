package com.aws.lab.productservice.controller;

import com.aws.lab.productservice.domain.model.Product;
import com.aws.lab.productservice.domain.service.ProductService;
import com.aws.lab.productservice.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDTO request){
        service.createProduct(request.toProduct());
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> listProducts(){
        List<Product> products = service.list();

        return products.stream().map(ProductDTO::fromProduct).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") Long id){
        Optional<Product> product = service.getById(id);

        return product.map(value -> ResponseEntity.ok(ProductDTO.fromProduct(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
}
