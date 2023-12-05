package com.aws.lab.productservice.dto;

import com.aws.lab.productservice.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product toProduct(){
        return Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .price(price)
                .build();
    }

    public static ProductDTO fromProduct(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
