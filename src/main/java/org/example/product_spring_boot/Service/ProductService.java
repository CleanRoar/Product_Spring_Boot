package org.example.product_spring_boot.Service;


import org.example.product_spring_boot.Dao.Entity.ProductEntity;
import org.example.product_spring_boot.Dto.RequestDto;
import org.example.product_spring_boot.Dto.ResponseDto;

import java.util.List;

public interface ProductService {

    void addProduct(RequestDto dto);

    List<ResponseDto> getProducts();

    ResponseDto findById(Long id);

    Long uptadeProduct(RequestDto  dto , Long id);


}
