package org.example.product_spring_boot.Service.ProductServiseIml;

import lombok.RequiredArgsConstructor;
import org.example.product_spring_boot.Dao.Entity.ProductEntity;
import org.example.product_spring_boot.Dao.Repository.ProductRepository;
import org.example.product_spring_boot.Dto.RequestDto;
import org.example.product_spring_boot.Service.ProductService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductServiseIml implements ProductService {

    private final ProductRepository repository;

    @Override
    public void addProduct(RequestDto dto) {
        ProductEntity entity =ProductEntity.builder()
                .productPrice(dto.getProductPrice())
                .stock(dto.getStock())
                .productName(dto.getProductName())
                .build();

        repository.save(entity);
    }
}
