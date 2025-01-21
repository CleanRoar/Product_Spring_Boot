package org.example.product_spring_boot.Mapper;

import lombok.RequiredArgsConstructor;
import org.example.product_spring_boot.Dao.Entity.ProductEntity;
import org.example.product_spring_boot.Dao.Repository.ProductRepository;
import org.example.product_spring_boot.Dto.ResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final ProductRepository repository;

    public List<ResponseDto> EntityToDtoList(List<ProductEntity> productEntity){
        List<ResponseDto> dtos = new ArrayList<>();
        for (ProductEntity e : productEntity ){
            ResponseDto dto = ResponseDto.builder()
                    .productPrice(e.getProductPrice())
                    .productName(e.getProductName())
                    .stock(e.getStock()).build();
            dtos.add(dto);
        }
        return dtos;
    }


    public ResponseDto EntityToDto(ProductEntity entity){
        return ResponseDto.builder()
                .productName(entity.getProductName())
                .stock(entity.getStock())
                .productPrice(entity.getProductPrice())
                .build();
    }
}
