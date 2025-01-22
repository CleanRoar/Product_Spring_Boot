package org.example.product_spring_boot.Service.ProductServiseIml;

import lombok.RequiredArgsConstructor;
import org.example.product_spring_boot.Dao.Entity.ProductEntity;
import org.example.product_spring_boot.Dao.Repository.ProductRepository;
import org.example.product_spring_boot.Dto.RequestDto;
import org.example.product_spring_boot.Dto.ResponseDto;
import org.example.product_spring_boot.Mapper.ProductMapper;
import org.example.product_spring_boot.Service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiseIml implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public void addProduct(RequestDto dto) {
        ProductEntity entity =ProductEntity.builder()
                .productName(dto.getProductName())
                .stock(dto.getStock())
                .productPrice(dto.getProductPrice())
                .build();
        repository.save(entity);
    }

    @Override
    public List<ResponseDto > getProducts() {
        List<ProductEntity> entity =repository.findAll();
        return mapper.EntityToResponseDto(entity);
    }

    @Override
    public Long FindById( Long id) {
        Optional<ProductEntity> optionalProductEntity = repository.findById(id);
        if (optionalProductEntity.isPresent()){
            ResponseDto dto = ResponseDto.builder().build();
        }
        return 0L;
    }
}
