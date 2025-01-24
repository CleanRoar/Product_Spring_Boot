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

    public List<ResponseDto> EntityToResponseDto(List<ProductEntity> entities){

        List<ResponseDto> dtos = new ArrayList<>();

        for(ProductEntity e:entities){
            ResponseDto dto = ResponseDto.builder()
                    .productName(e.getProductName())
                    .stock(e.getStock())
                    .productPrice(e.getProductPrice()).build();
            dtos.add(dto);
        }
        return dtos;
    }



    public ResponseDto entityResponseById(ProductEntity entity){
        return ResponseDto.builder()
                .productPrice(entity.getProductPrice())
                .productName(entity.getProductName())
                .stock(entity.getStock())
                .build();
    }
}
